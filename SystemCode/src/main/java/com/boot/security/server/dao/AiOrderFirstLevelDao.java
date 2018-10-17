package com.boot.security.server.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.AiOrderFirstLevelDto;
import com.boot.security.server.model.AiMktBox;
import com.boot.security.server.result.MonthSum;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiOrderFirstLevel;

@Mapper
public interface AiOrderFirstLevelDao {

    @Select("select * from ai_order_first_level t where t.id = #{id}")
    AiOrderFirstLevel getById(Long id);

    @Delete("delete from ai_order_first_level where id = #{id}")
    int delete(Long id);

    int update(AiOrderFirstLevel aiOrderFirstLevel);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_order_first_level(serialnumber, consumerid, createtime, telephone, boxcode, paytime, sendtime, replytime, orderpreprice, orderrealprice, orderno, paystatus, failreason, paytype, payurl, ordercomment, datastate, ext1, ext2, ext3) values(#{serialnumber}, #{consumerid}, #{createtime}, #{telephone}, #{boxcode}, #{paytime}, #{sendtime}, #{replytime}, #{orderpreprice}, #{orderrealprice}, #{orderno}, #{paystatus}, #{failreason}, #{paytype}, #{payurl}, #{ordercomment}, #{datastate}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiOrderFirstLevel aiOrderFirstLevel);
    
    int count(@Param("params") Map<String, Object> params,@Param("boxperson") Long boxperson);

    List<AiOrderFirstLevelDto> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit, @Param("boxperson") Long boxperson);

    @Select("SELECT count(1) FROM ai_order_first_level a WHERE a.paytype = #{paytype}")
    int getPayTypeCount(@Param("paytype") Integer payType);

    @Select("SELECT count(1) FROM ai_order_first_level a WHERE a.paytype = #{paytype} AND a.boxcode = #{boxcode}")
    int getPayTypeCountWithBoxCode(@Param("paytype") Integer payType,@Param("boxcode") String boxCode);

    List<MonthSum> getMounthTurnover(@Param("beginDay") Integer beginDay,@Param("endDay")Integer endDay);

    List<MonthSum> getMounthTurnoverWithBoxCode(@Param("beginDay")Integer beginDay,@Param("endDay") Integer endDay,@Param("boxCodeList") List<String> boxCodeList);
}
