package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiConsumer;

@Mapper
public interface AiConsumerDao {

    @Select("select * from ai_consumer t where t.id = #{id}")
    AiConsumer getById(Long id);

    @Delete("delete from ai_consumer where id = #{id}")
    int delete(Long id);

    int update(AiConsumer aiConsumer);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_consumer(name, telphone, type, starcode, source, descinfo, state, boxidreg, ext1, ext2, ext3) values(#{name}, #{telphone}, #{type}, #{starcode}, #{source}, #{descinfo}, #{state}, #{boxidreg}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiConsumer aiConsumer);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiConsumer> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}