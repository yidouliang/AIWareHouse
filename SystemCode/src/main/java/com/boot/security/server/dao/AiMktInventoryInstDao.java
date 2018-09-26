package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiMktInventoryInst;

@Mapper
public interface AiMktInventoryInstDao {

    @Select("select * from ai_mkt_inventory_inst t where t.id = #{id}")
    AiMktInventoryInst getById(Long id);

    @Delete("delete from ai_mkt_inventory_inst where id = #{id}")
    int delete(Long id);

    int update(AiMktInventoryInst aiMktInventoryInst);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_mkt_inventory_inst(prodinstid, productcode, productname, serialno, userid, originprice, saleprice, boxid, discount, batchid, supplier, factorydate, validmonths, storestatus, statusstatereason, createoperid, createorgid, createdate, modifydate, datastate, ext1, ext2, ext3) values(#{prodinstid}, #{productcode}, #{productname}, #{serialno}, #{userid}, #{originprice}, #{saleprice}, #{boxid}, #{discount}, #{batchid}, #{supplier}, #{factorydate}, #{validmonths}, #{storestatus}, #{statusstatereason}, #{createoperid}, #{createorgid}, #{createdate}, #{modifydate}, #{datastate}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiMktInventoryInst aiMktInventoryInst);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiMktInventoryInst> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
