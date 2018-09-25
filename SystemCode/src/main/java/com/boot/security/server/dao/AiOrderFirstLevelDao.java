package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

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
    
    int count(@Param("params") Map<String, Object> params);

    List<AiOrderFirstLevel> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
