package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiWarehouseStock;

@Mapper
public interface AiWarehouseStockDao {

    @Select("select * from ai_warehouse_stock t where t.id = #{id}")
    AiWarehouseStock getById(Long id);

    @Delete("delete from ai_warehouse_stock where id = #{id}")
    int delete(Long id);

    int update(AiWarehouseStock aiWarehouseStock);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_warehouse_stock(prodinstid, productname, serialno, allnum, remaindnum, aicode, userid, oldprice, nowprice, warehouseid, discount, batchid, supplier, factorydate, validmonths, storestatus, statusstatereason, createoperid, createorgid, createdate, modifydate, datastate, ext1, ext2, ext3) values(#{prodinstid}, #{productname}, #{serialno}, #{allnum}, #{remaindnum}, #{aicode}, #{userid}, #{oldprice}, #{nowprice}, #{warehouseid}, #{discount}, #{batchid}, #{supplier}, #{factorydate}, #{validmonths}, #{storestatus}, #{statusstatereason}, #{createoperid}, #{createorgid}, #{createdate}, #{modifydate}, #{datastate}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiWarehouseStock aiWarehouseStock);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiWarehouseStock> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
