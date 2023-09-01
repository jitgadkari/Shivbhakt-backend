package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.Category;
import com.shivbhakt.shivbhakt.payload.CategoryDto;
import com.shivbhakt.shivbhakt.repository.CategoryRepository;
import com.shivbhakt.shivbhakt.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category= this.modelMapper.map(categoryDto, Category.class);
        Category category1= this.categoryRepository.save(category);
        CategoryDto categoryDto1=this.modelMapper.map(category1,CategoryDto.class);

        return categoryDto1;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
      Category category=  this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("category not found with this id"+categoryId));
      category.setTitle(categoryDto.getTitle());
      category.setCatDescription(categoryDto.getCatDescription());
      CategoryDto categoryDto1=this.modelMapper.map(category,CategoryDto.class);
        return categoryDto1;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
     Category category=   this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("category mot found with this id"));
     this.categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories=this.categoryRepository.findAll();
        List<CategoryDto> categoryDtoList =categories.stream().map((category -> this.modelMapper.map(category,CategoryDto.class))).collect(Collectors.toList());
        return categoryDtoList;
    }
}
