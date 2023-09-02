package com.shivbhakt.shivbhakt.service;

import com.shivbhakt.shivbhakt.entity.Category;
import com.shivbhakt.shivbhakt.entity.Product;
import com.shivbhakt.shivbhakt.payload.ProductDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto,Integer categoryId);

    ProductDto updateProduct(ProductDto productDto,Integer productId,Integer categoryId);

    void deleteProduct(Integer productId);

    List<ProductDto> getAllProducts();

    ProductDto getSingleProduct(Integer productId);

    List<ProductDto> getProductByCategory(Integer categoryId);

    List<ProductDto> searchProduct(String title);

    List<ProductDto> findPaginated(Integer pageNo, Integer pageSize);

}
