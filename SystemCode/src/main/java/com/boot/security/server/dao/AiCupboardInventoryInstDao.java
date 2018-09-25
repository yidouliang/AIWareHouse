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
    @Insert("insert into ai_cupboard_inventory_inst(ID, PROD_INST_ID, PRODUCT_NAME, SERIAL_NO, ALL_NUM, REMAIND_NUM, USER_ID, OLD_PRICE, NOW_PRICE, BOX_ID, DISCOUNT, BATCH_ID, SUPPLIER, FACTORY_DATE, VALID_MONTHS, STORE_STATUS, STATUS_STATE_REASON, CREATE_OPER_ID, CREATE_ORG_ID, CREATE_DATE, MODIFY_DATE, DATA_STATE, EXT1, EXT2, EXT3, AI_CODE) values(#{ID}, #{PRODINSTID}, #{PRODUCTNAME}, #{SERIALNO}, #{ALLNUM}, #{REMAINDNUM}, #{USERID}, #{OLDPRICE}, #{NOWPRICE}, #{BOXID}, #{DISCOUNT}, #{BATCHID}, #{SUPPLIER}, #{FACTORYDATE}, #{VALIDMONTHS}, #{STORESTATUS}, #{STATUSSTATEREASON}, #{CREATEOPERID}, #{CREATEORGID}, #{CREATEDATE}, #{MODIFYDATE}, #{DATASTATE}, #{EXT1}, #{EXT2}, #{EXT3}, #{AICODE})")
    int save(AiCupboardInventoryInst aiCupboardInventoryInst);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiCupboardInventoryInst> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
