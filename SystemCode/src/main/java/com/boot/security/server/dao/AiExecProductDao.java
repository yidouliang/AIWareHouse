package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiExecProduct;

@Mapper
public interface AiExecProductDao {

    @Select("select * from ai_exec_product t where t.id = #{id}")
    AiExecProduct getById(Long id);

    @Delete("delete from ai_exec_product where id = #{id}")
    int delete(Long id);

    int update(AiExecProduct aiExecProduct);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_exec_product(productcode, aicode, productname, productdesc, producttypeid, productoriprice, productstatus, productpicpath, producturl, creator, createdate, modifydate, datastate, productsource, ext1, ext2, ext3) values(#{productcode}, #{aicode}, #{productname}, #{productdesc}, #{producttypeid}, #{productoriprice}, #{productstatus}, #{productpicpath}, #{producturl}, #{creator}, #{createdate}, #{modifydate}, #{datastate}, #{productsource}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiExecProduct aiExecProduct);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiExecProduct> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
