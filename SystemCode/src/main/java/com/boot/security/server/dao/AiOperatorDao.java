package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import com.boot.security.server.model.AiOperator;

@Mapper
public interface AiOperatorDao {

    @Select("select * from ai_operator t where t.id = #{id}")
    AiOperator getById(Long id);

    @Delete("delete from ai_operator where id = #{id}")
    int delete(Long id);

    int update(AiOperator aiOperator);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into ai_operator(name, description, level, ext4, ext5, ext6, ext1, ext2, owernum) values(#{name}, #{description}, #{level}, #{ext4}, #{ext5}, #{ext6}, #{ext1}, #{ext2}, #{owernum})")
    int save(AiOperator aiOperator);
    
    int count(@Param("params") Map<String, Object> params);

    List<AiOperator> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);

    @Select("select * from ai_operator t where t.userid = #{id}")
    AiOperator getAiOperatorByUserId(@Param("id") Long userId);

    @Select("select id ,name from ai_operator")
    List<Map<String, Object>> getIdAndName();

    boolean updateOperatorOwnNum();

    @Update("update ai_operator o set o.owernum = o.owernum+1 where o.id=#{id}")
    boolean incrOwnNum(@Param("id") Long operatorId);

    @Update("update ai_operator o set o.owernum = o.owernum-1 where o.id=#{id}")
    boolean descOwnNum(@Param("id") Long operatorId);
}
