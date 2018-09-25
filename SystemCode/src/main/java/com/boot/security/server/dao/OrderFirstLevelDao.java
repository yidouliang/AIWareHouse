package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.OrderFirstLevel;

@Mapper
public interface OrderFirstLevelDao {

    @Select("select * from order_first_level t where t.id = #{id}")
    OrderFirstLevel getById(Long id);

    @Delete("delete from order_first_level where id = #{id}")
    int delete(Long id);

    int update(OrderFirstLevel orderFirstLevel);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into order_first_level(serialnumber, usercode, createtime, telephone, paytime, sendtime, replytime, orderpreprice, orderrealprice, orderno, paystatus, failreason, paytype, payurl, ordercomment, datastate) values(#{serialnumber}, #{usercode}, #{createtime}, #{telephone}, #{paytime}, #{sendtime}, #{replytime}, #{orderpreprice}, #{orderrealprice}, #{orderno}, #{paystatus}, #{failreason}, #{paytype}, #{payurl}, #{ordercomment}, #{datastate})")
    int save(OrderFirstLevel orderFirstLevel);


    int count(@Param("params") Map<String, Object> params);

    List<OrderFirstLevel> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
