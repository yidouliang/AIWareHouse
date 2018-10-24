package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.CategoryDto;
import com.boot.security.server.dto.LinkageDto;
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

    /**
     * 获得二级分类数据
     * @return
     */
    @Select("select id, categoryname, parentid from category where status = 1 and isleaf = 0")
    List<LinkageDto> twoLinkage();

    /**
     * 获得三级分类数据
     * @return
     */
    @Select("select id, categoryname, parentid from category where status = 1")
    List<LinkageDto> threeLinkage();

    /**
     * 获取所有的分类信息
     * @return
     */
    @Select("select id, categoryname title, parentid pid from category where status=1")
    List<CategoryDto> categories();

    @Select("select categoryname from category where id = #{id}")
    String getCategoryNameById(Long id);
}
