package com.boot.security.server.service.impl;

import com.boot.security.server.dao.CategoryDao;
import com.boot.security.server.dto.CategoryDto;
import com.boot.security.server.dto.Param;
import com.boot.security.server.model.Category;
import com.boot.security.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryDao categoryDao;

    /**
     * 添加节点
     * @param param
     * @return
     */
    @Override
    @Transactional
    public CategoryDto createCategory(Param param) {
        //添加分类
        if(param == null){
            return null;
        }
        //判断父分类Id是否为空
        if(param.getValue() == null){
            return null;
        }
        //获取父分类，修改其isleaf为false
        Category pCategory = categoryDao.getById(param.getpId());
        //如果父节点为叶子结点
        if(pCategory.getIsleaf()==1){
            pCategory.setIsleaf(0);
            categoryDao.update(pCategory);
        }
        //添加
        Category category = new Category();
        category.setCategoryname(param.getValue());
        category.setCreatetime(new Date());
        category.setUpdatetime(new Date());
        category.setParentid(param.getpId());
        category.setStatus(1);
        category.setIsleaf(1);
        categoryDao.save(category);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setPid(category.getParentid());
        categoryDto.setTitle(category.getCategoryname());
        return categoryDto;
    }

    /**
     * 删除节点以及其所有子节点
     * @return
     */
    @Override
    @Transactional
    public boolean deleteCategory(Long id) {
        if(id==null){
            return false;
        }
        //先获取当前节点，通过isLeaf判断是否为叶子结点
        Category category = categoryDao.getById(id);
        if(category==null){
            return false;
        }

        //如果有子节点就递归删除
        if(category.getIsleaf()!=1||!category.getIsleaf().equals(1)){
            //获取子节点
            List<Category> childCategories = categoryDao.getChild(id);
            for (Category c :
                    childCategories) {
                deleteCategory(c.getId());
            }
        }
        //如果是叶子结点直接删除
        categoryDao.deleteCategory(id);

        return true;
    }

}
