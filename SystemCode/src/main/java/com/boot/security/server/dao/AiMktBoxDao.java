package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.AiMktBoxDto;
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
    @Insert("insert into ai_mkt_box(boxname, boxcode, boxtype, boxperson, address, status, factorydate, paystate, boxwarehouseid, enddate, persontelphone, longitude, latitude, ext1, ext2, ext3) values(#{boxname}, #{boxcode}, #{boxtype}, #{boxperson}, #{address}, #{status}, #{factorydate}, #{paystate}, #{boxwarehouseid}, #{enddate}, #{persontelphone}, #{longitude}, #{latitude}, #{ext1}, #{ext2}, #{ext3})")
    int save(AiMktBox aiMktBox);

    int count(@Param("params") Map<String, Object> params,@Param("boxperson") Long boxPerson);

    List<AiMktBoxDto> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit, @Param("boxperson") Long boxPerson);

    @Select("select count(1) from ai_mkt_box where boxperson = #{boxperson}")
    int getBoxCountByOperatorId(@Param("boxperson") Long operatorId);

    @Select("select id, boxname from ai_mkt_box t where t.status = 1 and boxperson = #{boxperson}")
    List<Map<String, Object>> getIdAndName(@Param("boxperson") Long operatorId);

    @Select("select * from ai_mkt_box where boxperson = #{boxperson}")
    List<AiMktBox> getBoxListByOperatorId(@Param("boxperson") Long operatorId);

    @Select("select a.id from ai_mkt_box a where unix_timestamp(NOW())-unix_timestamp(a.enddate) > 0 and a.paystate = 1")
    List<Long> getExpireAiMktBoxList();

    boolean changePayStateByScheduled(@Param("list") List<Long> boxIdList);

}
