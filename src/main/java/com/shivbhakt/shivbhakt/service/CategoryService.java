package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    void deleteCategory(Integer categoryId);
    List<CategoryDto> getAllCategories();
}
