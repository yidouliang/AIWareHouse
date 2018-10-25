package com.boot.security.server.dao;

import java.util.List;
import java.util.Map;

import com.boot.security.server.dto.CategoryDto;
import com.boot.security.server.dto.LinkageDto;
import org.apache.ibatis.annotations.*;

import com.boot.security.server.model.Category;

@Mapper
public interface CategoryDao {

    @Select("select * from category t where t.id = #{id}")
    Category getById(Long id);

    @Delete("delete from category where id = #{id}")
    int delete(Long id);

    int update(Category category);
    
    @Options(useGeneratedKeys = true, keyProperty = "id")
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

    /**
     * 查询分类个数
     * @return
     */
    @Select("select count(1) from category")
    int getCount();

    @Select("select categoryname from category where id = #{id}")
    String getCategoryNameById(Long id);

    /**
     * 删除指定id的分类
     * @return
     */
    @Update("update category c set status = 0 where c.id = #{id}")
    int deleteCategory(@Param("id") Long id);

    /**
     * 根据Id获取子分类Id
     * @return
     */
    @Select("select * from category c where c.parentid = #{id}")
    List<Category> getChild(@Param("id") Long id);

    /**
     * 获取该分类下子分类的个数
     */
    @Select("select count(1) from category c where c.parentid = #{parentid}")
    int countChild(@Param("parentid") Long parentid);

    /**
     * 修改叶子状态
     */
    @Update("update category c set c.isleaf = #{isleaf} where c.id = #{id}")
    void changeLeaf(@Param("id") Long id,@Param("isleaf") Integer isleaf);
}
