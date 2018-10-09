package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.boot.security.server.model.Category;

@Mapper
public interface CategoryDao {

    @Select("select * from category t where t.id = #{id}")
    Category getById(Long id);

    @Delete("delete from category where id = #{id}")
    int delete(Long id);

    int update(Category category);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into category(categoryname, parentid, status, createtime, updatetime, isleaf) values(#{categoryname}, #{parentid}, #{status}, #{createtime}, #{updatetime}, #{isleaf})")
    int save(Category category);
    
    int count(@Param("params") Map<String, Object> params);

    List<Category> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
