package com.boot.security.server.controller;

import com.boot.security.server.convert.AiExecProduct2AiExecProductDto;
import com.boot.security.server.dao.AiExecProductDao;
import com.boot.security.server.dto.AiExecProductDto;
import com.boot.security.server.dto.ResponseInfo;
import com.boot.security.server.enums.ProductStatusEnum;
import com.boot.security.server.model.AiExecProduct;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.page.table.PageTableHandler;
import com.boot.security.server.page.table.PageTableHandler.CountHandler;
import com.boot.security.server.page.table.PageTableHandler.ListHandler;
import com.boot.security.server.page.table.PageTableRequest;
import com.boot.security.server.page.table.PageTableResponse;
import com.boot.security.server.service.AiExecProductService;
import com.boot.security.server.service.FileService;
import com.boot.security.server.service.UserService;
import com.boot.security.server.utils.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/aiExecProducts")
public class AiExecProductController {

    @Value("${files.path}")
    private String filesPath;

    @Autowired
    private AiExecProductDao aiExecProductDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AiExecProductService aiExecProductService;

    @Autowired
    private AiExecProduct2AiExecProductDto aiExecProduct2AiExecProductDto;

    @PostMapping
    @ApiOperation(value = "保存")
    public AiExecProduct save(@RequestBody AiExecProduct aiExecProduct,
                              HttpServletRequest request) {
        SysUser user = userService.getTokenUser(request);
        aiExecProduct.setCreatorid(user.getId());
        aiExecProductDao.save(aiExecProduct);

        return aiExecProduct;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取")
    public AiExecProduct get(@PathVariable Long id) {
        return aiExecProductDao.getById(id);
    }

    @PutMapping
    @ApiOperation(value = "修改")
    public AiExecProduct update(@RequestBody AiExecProduct aiExecProduct,
                                HttpServletRequest request) {
        SysUser user = userService.getTokenUser(request);
        aiExecProduct.setCreatorid(user.getId());
        aiExecProductDao.update(aiExecProduct);

        return aiExecProduct;
    }
    @PostMapping("/changeStatus/{id}/{status}")
    @ApiOperation(value = "商品上下架")
    public String changeProductStatus(@PathVariable("id") Long id,
                                      @PathVariable("status") String productstatus){
        if(Integer.valueOf(productstatus)== 0 ){
            aiExecProductDao.changeProductStatus(id, ProductStatusEnum.IN_STOCK.getCode());
            return "在售";
        }else{
            aiExecProductDao.changeProductStatus(id,ProductStatusEnum.OBTAINED.getCode());
            return "下架";
        }
    }

    @GetMapping
    @ApiOperation(value = "列表")
    public PageTableResponse list(PageTableRequest request) {
        System.out.println(FileUtil.getPath());
        return new PageTableHandler(new CountHandler() {

            @Override
            public int count(PageTableRequest request) {
                return aiExecProductDao.count(request.getParams());
            }
        }, new ListHandler() {

            @Override
            public List<AiExecProductDto> list(PageTableRequest request) {
                List<AiExecProduct> aiExecProductList = aiExecProductDao.list(request.getParams(), request.getOffset(), request.getLimit());
                return aiExecProduct2AiExecProductDto.convert(aiExecProductList);
            }
        }).handle(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable Long id) {
        aiExecProductDao.delete(id);
    }

    @PostMapping("/import")
    @ApiOperation(value = "从Excel中导入产品数据")
    public ResponseInfo importProduct(MultipartFile file,
                                      HttpServletRequest request) throws IOException {
        Long creatorId = userService.getTokenUser(request).getId();
        return aiExecProductService.importProduct(file, creatorId);
    }

    @GetMapping("/downloadTemplate")
    @ApiOperation(value = "下载Excel模板")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding(request.getCharacterEncoding());
        File file = new File("D:/files/templates/Excel模板.xlsx");
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode("test.xlsx", "UTF-8"));

        byte[] bytes = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        OutputStream outputStream = response.getOutputStream();
        int i = bufferedInputStream.read(bytes);
        while(i != -1) {
            outputStream.write(bytes, 0, i);
            i = bufferedInputStream.read(bytes);
        }

        fileInputStream.close();
        bufferedInputStream.close();
    }
}
