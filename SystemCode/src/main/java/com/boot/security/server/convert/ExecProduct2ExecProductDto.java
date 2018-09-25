package com.boot.security.server.convert;

import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.ExecProductDto;
import com.boot.security.server.model.Dict;
import com.boot.security.server.model.ExecProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Seven.wk
 * Description: 将ExecProduct模型转换为ExecProductDto模型，将部分数据更加可视化
 * Created At 2018/09/21
 */
@Component
public class ExecProduct2ExecProductDto {

    @Autowired
    private DictDao dictDao;

    /**
     * 将ExecProduct转换成ExecProductDto
     * @param execProduct
     * @return
     */
    public ExecProductDto convert(ExecProduct execProduct) {
        ExecProductDto execProductDto = new ExecProductDto();
        BeanUtils.copyProperties(execProduct, execProductDto);
        Dict productTypeId = dictDao.getByTypeAndK("productTypeId", execProduct.getProductTypeId().toString());
        Dict productStatus = dictDao.getByTypeAndK("productStatus", execProduct.getProductStatus().toString());
        String type = "暂无分类";
        String status = "暂无状态";
        if(productTypeId != null)
            type = productTypeId.getVal();
        if(productStatus != null)
            status = productStatus.getVal();
        execProductDto.setProductTypeId(type);
        execProductDto.setProductStatus(status);
        return execProductDto;
    }

    /**
     * 两个列表进行转换
     * @param execProductList
     * @return
     */
    public List<ExecProductDto> convert(List<ExecProduct> execProductList) {
        List<ExecProductDto> execProductDtoList = new ArrayList<>();
        for(ExecProduct execProduct : execProductList) {
            ExecProductDto execProductDto = convert(execProduct);
            execProductDtoList.add(execProductDto);
        }
        return execProductDtoList;
    }

}
