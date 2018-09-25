package com.boot.security.server.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.boot.security.server.convert.ExecProduct2ExecProductDto;
import com.boot.security.server.dto.ExecProductDto;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.model.FileInfo;
import com.boot.security.server.service.FileService;
import com.boot.security.server.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.dao.ExecProductDao;
import com.boot.security.server.model.ExecProduct;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/execProducts")
public class ExecProductController {

    @Autowired
    private ExecProductDao execProductDao;

    @Autowired
    private FileService fileService;

    @Autowired
    private ExecProduct2ExecProductDto convert;

    /**
     * 新建一个商品对象
     * @param execProduct       从前端传递过来的商品对象
     * @return
     */
    @PostMapping
    @ApiOperation(value = "保存")
    public ExecProduct save(@RequestBody ExecProduct execProduct) {
        execProductDao.save(execProduct);

        return execProduct;
    }

    /**
     * 根据id值查询一个商品
     * @param id        商品id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public ExecProduct get(@PathVariable Long id) {
        return execProductDao.getById(id);
    }

    /**
     * 更新一个商品信息
     * @param execProduct       前端传递的商品信息
     * @return
     */
    @PutMapping
    @ApiOperation(value = "修改")
    public ExecProduct update(@RequestBody ExecProduct execProduct) {
        execProductDao.update(execProduct);

        return execProduct;
    }

    /**
     * 获取所有的商品列表
     * @param request       分页请求
     * @return
     */
    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return execProductDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<ExecProductDto> list(PageTableRequest request) {
                List<ExecProduct> execProductList = execProductDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return convert.convert(execProductList);
            }
        }).handle(request);
    }

    /**
     * 根据商品的id值删除一个商品
     * @param id        商品id值
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        execProductDao.delete(id);
    }


    /**
     * 从Excel中导入产品信息
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/excel")
    @ApiOperation(value = "从Excel中导入产品数据")
    public ResponseInfo importExcel(MultipartFile file) throws IOException {
        FileInfo fileInfo = fileService.save(file);
        File excel = new File(fileInfo.getPath());
        if(!ExcelUtil.isExcel(excel)) {
            excel.delete();
            return new ResponseInfo("500", "Excel格式错误");
        }
        List<ExecProduct> execProductList = ExcelUtil.ExcelImport(excel);
        for(ExecProduct product : execProductList) {
            execProductDao.save(product);
        }
        excel.delete();     //删除该Excel文件
        return new ResponseInfo("200", "导入成功！共导入" + execProductList.size() + "条数据");
    }
}
