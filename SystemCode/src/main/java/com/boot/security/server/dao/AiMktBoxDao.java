package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.AiMktBox;

@Mapper
public interface AiMktBoxDao {

    @Select("select * from ai_mkt_box t where t.id = #{id}")
    AiMktBox getById(Long id);

    @Delete("delete from ai_mkt_box where id = #{id}")
    int delete(Long id);

    int update(AiMktBox aiMktBox);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_mkt_box(boxName, boxCode, boxType, boxPerson, address, status, FACTORY_DATE, PAY_STATE, BOX_WAREHOUSE_ID, END_DATE, personTelphone, longitude, latitude, EXT1, EXT2, EXT3) values(#{boxName}, #{boxCode}, #{boxType}, #{boxPerson}, #{address}, #{status}, #{FACTORYDATE}, #{PAYSTATE}, #{BOXWAREHOUSEID}, #{ENDDATE}, #{personTelphone}, #{longitude}, #{latitude}, #{EXT1}, #{EXT2}, #{EXT3})")
    int save(AiMktBox aiMktBox);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiMktBox> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
