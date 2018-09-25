package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.ExecProduct;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ExecProductDao {

    @Select("select * from exec_product t where t.id = #{id}")
    ExecProduct getById(Long id);

    @Select("select * from exec_product t where t.productCode = #{productCode}")
    ExecProduct getByCode(String productCode);

    @Delete("delete from exec_product where id = #{id}")
    int delete(Long id);

    int update(ExecProduct execProduct);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into exec_product(productCode, productName, productDesc, productTypeId, productStartTime, productEndTime, productPrice, productOriPrice, productStatus, productPicPath, kindCode, rootKindCode, productUrl, creator, creatDate, modeifier, modifyDate, dataState, isLock, srcCode, productSource, company, limitNum, productSaleTime, belongAlbum, ext1, ext2, EXT3, IS_NEED_INV_INST) values(#{productCode}, #{productName}, #{productDesc}, #{productTypeId}, #{productStartTime}, #{productEndTime}, #{productPrice}, #{productOriPrice}, #{productStatus}, #{productPicPath}, #{kindCode}, #{rootKindCode}, #{productUrl}, #{creator}, #{creatDate}, #{modeifier}, #{modifyDate}, #{dataState}, #{isLock}, #{srcCode}, #{productSource}, #{company}, #{limitNum}, #{productSaleTime}, #{belongAlbum}, #{ext1}, #{ext2}, #{EXT3}, #{ISNEEDINVINST})")
    int save(ExecProduct execProduct);
    
    int count(@Param("params") Map<String, Object> params);

    List<ExecProduct> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
