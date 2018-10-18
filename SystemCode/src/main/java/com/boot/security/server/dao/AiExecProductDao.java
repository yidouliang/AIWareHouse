package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.AiExecProductDto;
import org.apache.ibatis.annotations.*;

import com.boot.security.server.model.AiExecProduct;

@Mapper
public interface AiExecProductDao {

    @Select("select * from ai_exec_product t where t.id = #{id}")
    AiExecProduct getById(Long id);

    @Delete("delete from ai_exec_product where id = #{id}")
    int delete(Long id);

    int update(AiExecProduct aiExecProduct);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_exec_product(productcode, aicode, productname, productdesc, producttypeid, productoriprice, productstatus, productpicpath, producturl, creatorid, createdate, modifydate, datastate, productsource, ext1, ext2, ext3) values(#{productcode}, #{aicode}, #{productname}, #{productdesc}, #{producttypeid}, #{productoriprice}, #{productstatus}, #{productpicpath}, #{producturl}, #{creatorid}, #{createdate}, #{modifydate}, #{datastate}, #{productsource}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiExecProduct aiExecProduct);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiExecProductDto> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select id, productname from ai_exec_product t where t.productstatus = 1 and t.producttypeid = #{productTypeId}")
    List<Map<String, Object>> getIdAndName(Long productTypeId);

    @Update("update ai_exec_product a set a.productstatus = #{productstatus} where a.id = #{id}")
    int changeProductStatus(@Param("id") Long id, @Param("productstatus") Integer productstatus);

    /**
     * 批量插入产品信息
     * @param aiExecProducts
     * @return
     */
    int bulkInsert(List<AiExecProduct> aiExecProducts);

}
