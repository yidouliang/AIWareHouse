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
    @Insert("insert into ai_mkt_inventory_inst(ID, PROD_INST_ID, PRODUCT_CODE, PRODUCT_NAME, SERIAL_NO, USER_ID, 原价格, 现在价格, BOX_ID, 折扣率, BATCH_ID, SUPPLIER, FACTORY_DATE, VALID_MONTHS, STORE_STATUS, STATUS_STATE_REASON, CREATE_OPER_ID, CREATE_ORG_ID, CREATE_DATE, MODIFY_DATE, DATA_STATE, EXT1, EXT2, EXT3) values(#{ID}, #{PRODINSTID}, #{PRODUCTCODE}, #{PRODUCTNAME}, #{SERIALNO}, #{USERID}, #{原价格}, #{现在价格}, #{BOXID}, #{折扣率}, #{BATCHID}, #{SUPPLIER}, #{FACTORYDATE}, #{VALIDMONTHS}, #{STORESTATUS}, #{STATUSSTATEREASON}, #{CREATEOPERID}, #{CREATEORGID}, #{CREATEDATE}, #{MODIFYDATE}, #{DATASTATE}, #{EXT1}, #{EXT2}, #{EXT3})")
    int save(AiMktInventoryInst aiMktInventoryInst);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiMktInventoryInst> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
