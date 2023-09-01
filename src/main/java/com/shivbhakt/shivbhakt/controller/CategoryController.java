package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.entity.Category;
import com.shivbhakt.shivbhakt.payload.CategoryDto;
import com.shivbhakt.shivbhakt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1= this.categoryService.createCategory(categoryDto);
        return  new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
        CategoryDto categoryDto1= this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto>  categoryDtoList =this.categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }
}
