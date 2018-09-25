package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.MktBox;

@Mapper
public interface MktBoxDao {

    @Select("select * from mkt_box t where t.id = #{id}")
    MktBox getById(Long id);

    @Delete("delete from mkt_box where id = #{id}")
    int delete(Long id);

    int update(MktBox mktBox);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into mkt_box(boxName, boxCode, boxType, boxPerson, address, status, personTelphone) values(#{boxName}, #{boxCode}, #{boxType}, #{boxPerson}, #{address}, #{status}, #{personTelphone})")
    int save(MktBox mktBox);
    
    int count(@Param("params") Map<String, Object> params);

    List<MktBox> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
