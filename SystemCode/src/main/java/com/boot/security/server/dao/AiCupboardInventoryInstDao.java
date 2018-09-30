package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiCupboardInventoryInst;

@Mapper
public interface AiCupboardInventoryInstDao {

    @Select("select * from ai_cupboard_inventory_inst t where t.id = #{id}")
    AiCupboardInventoryInst getById(Long id);

    @Delete("delete from ai_cupboard_inventory_inst where id = #{id}")
    int delete(Long id);

    int update(AiCupboardInventoryInst aiCupboardInventoryInst);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_cupboard_inventory_inst(prodinstid, productname, productcode, allnum, remindnum, userid, originprice, saleprice, boxid, discount, batchid, warehouseid, factorydate, validmonths, storestatus, statusstatereason, createoperid, createorgid, createdate, modifydate, datastate, ext1, ext2, ext3, aicode) values(#{prodinstid}, #{productname}, #{productcode}, #{allnum}, #{remindnum}, #{userid}, #{originprice}, #{saleprice}, #{boxid}, #{discount}, #{batchid}, #{warehouseid}, #{factorydate}, #{validmonths}, #{storestatus}, #{statusstatereason}, #{createoperid}, #{createorgid}, #{createdate}, #{modifydate}, #{datastate}, #{ext1}, #{ext2}, #{ext3}, #{aicode})")
    int save(AiCupboardInventoryInst aiCupboardInventoryInst);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiCupboardInventoryInst> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
