package com.boot.security.server.service;

import com.boot.security.server.dto.CategoryDto;
import com.boot.security.server.dto.Param;
import com.boot.security.server.model.Category;

public interface CategoryService {

    CategoryDto createCategory(Param param);
    boolean deleteCategory(Long id);
}
