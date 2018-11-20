package com.boot.security.server.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.AiCupboardInventoryInstDto;
import org.apache.ibatis.annotations.*;

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

    List<AiCupboardInventoryInstDto> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select originprice from ai_cupboard_inventory_inst where id = #{id}")
    BigDecimal getOriginPrice(Long id);

    @Select("select saleprice from ai_cupboard_inventory_inst where productcode = #{productCode} and boxid=#{boxId}")
    BigDecimal getSalePrice(@Param("productCode") String productCode,
                            @Param("boxId") Long boxId);

    @Select("select originprice from ai_cupboard_inventory_inst where productcode = #{productCode}  and boxid=#{boxId}")
    BigDecimal getOriginPriceByProduct(@Param("productCode") String productCode,
                                       @Param("boxId") Long boxId);

    @Select("select * from ai_cupboard_inventory_inst where productcode = #{productCode} and boxid = #{boxId}")
    AiCupboardInventoryInst selectedByProductCodeAndBoxId(@Param("productCode") String productCode,
                                                          @Param("boxId") Long boxId);

    @Update("update ai_cupboard_inventory_inst set remindnum = #{quantity} where id = #{id}")
    void reduceInventory(@Param("id") Long id,
                         @Param("quantity") Integer quantity);

}
