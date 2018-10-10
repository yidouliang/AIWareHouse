package com.boot.security.server.convert;

import com.boot.security.server.dao.CategoryDao;
import com.boot.security.server.dao.DictDao;
import com.boot.security.server.dto.AiExecProductDto;
import com.boot.security.server.enums.DataStatusEnum;
import com.boot.security.server.enums.ProductStatusEnum;
import com.boot.security.server.model.AiExecProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Seven.wk
 * Description: 模型转换
 * Created At 2018/09/27
 */

@Component
public class AiExecProduct2AiExecProductDto {

    @Autowired
    private DictDao dictDao;

    @Autowired
    private CategoryDao categoryDao;


    public AiExecProductDto convert(AiExecProduct aiExecProduct) {
        AiExecProductDto aiExecProductDto = new AiExecProductDto();
        BeanUtils.copyProperties(aiExecProduct, aiExecProductDto);

//        String productTypeId = dictDao.getByTypeAndK("productTypeId", aiExecProduct.getProducttypeid().toString()).getVal();
        String productTypeId = categoryDao.getCategoryNameById(aiExecProduct.getProducttypeid());
        if(productTypeId == null)
            productTypeId = "暂无分类";

        String productStatus = ProductStatusEnum.getMessage(aiExecProduct.getProductstatus());
        if(productStatus.equals(""))
            productStatus = dictDao.getByTypeAndK("productstatus", aiExecProduct.getProductstatus().toString()).getVal();

        String dataStatus = DataStatusEnum.getMessage(aiExecProduct.getDatastate());
        if(productStatus.equals(""))
            dataStatus = dictDao.getByTypeAndK("datastate", aiExecProduct.getDatastate().toString()).getVal();

        aiExecProductDto.setProducttypeid(productTypeId);
        aiExecProductDto.setProductstatus(productStatus);
        aiExecProductDto.setDatastate(dataStatus);

        return aiExecProductDto;
    }

    public List<AiExecProductDto> convert(List<AiExecProduct> aiExecProductList) {
        List<AiExecProductDto> aiExecProductDtoList = new ArrayList<>();
        aiExecProductDtoList = aiExecProductList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return aiExecProductDtoList;
    }

}
