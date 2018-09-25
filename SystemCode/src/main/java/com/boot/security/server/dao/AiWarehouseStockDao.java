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
    @Insert("insert into ai_warehouse_stock(ID, PROD_INST_ID, PRODUCT_NAME, SERIAL_NO, ALL_NUM, REMAIND_NUM, AI_CODE, USER_ID, OLD_PRICE, NOW_PRICE, WAREHOUSE_ID, DISCOUNT, BATCH_ID, SUPPLIER, FACTORY_DATE, VALID_MONTHS, STORE_STATUS, STATUS_STATE_REASON, CREATE_OPER_ID, CREATE_ORG_ID, CREATE_DATE, MODIFY_DATE, DATA_STATE, EXT1, EXT2, EXT3) values(#{ID}, #{PRODINSTID}, #{PRODUCTNAME}, #{SERIALNO}, #{ALLNUM}, #{REMAINDNUM}, #{AICODE}, #{USERID}, #{OLDPRICE}, #{NOWPRICE}, #{WAREHOUSEID}, #{DISCOUNT}, #{BATCHID}, #{SUPPLIER}, #{FACTORYDATE}, #{VALIDMONTHS}, #{STORESTATUS}, #{STATUSSTATEREASON}, #{CREATEOPERID}, #{CREATEORGID}, #{CREATEDATE}, #{MODIFYDATE}, #{DATASTATE}, #{EXT1}, #{EXT2}, #{EXT3})")
    int save(AiWarehouseStock aiWarehouseStock);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiWarehouseStock> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
