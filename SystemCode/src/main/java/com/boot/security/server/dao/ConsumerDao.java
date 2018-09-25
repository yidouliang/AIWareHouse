package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Consumer;

@Mapper
public interface ConsumerDao {

    @Select("select * from consumer t where t.consumerid = #{id}")
    Consumer getById(Long id);

    @Delete("delete from consumer where consumerid = #{id}")
    int delete(Long id);

    int update(Consumer consumer);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into consumer(consumerid, name, telphone, type, starcode, source, descinfo, state, boxidreg, ext1, ext2, ext3) values(#{consumerid}, #{name}, #{telphone}, #{type}, #{starcode}, #{source}, #{descinfo}, #{state}, #{boxidreg}, #{ext1}, #{ext2}, #{ext3})")
    int save(Consumer consumer);
    
    int count(@Param("params") Map<String, Object> params);

    List<Consumer> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
