package com.shivbhakt.shivbhakt.serviceImpl;

import com.shivbhakt.shivbhakt.entity.Category;
import com.shivbhakt.shivbhakt.entity.Product;
import com.shivbhakt.shivbhakt.payload.ProductDto;
import com.shivbhakt.shivbhakt.repository.CategoryRepository;
import com.shivbhakt.shivbhakt.repository.ProductRepository;
import com.shivbhakt.shivbhakt.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto,Integer categoryId) {
        Category  category=this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("category not found with id "));
        Product product=this.modelMapper.map(productDto, Product.class);
        product.setCategory(category);
        Product savedProduct=this.productRepository.save(product);
        ProductDto productDto1=this.modelMapper.map(savedProduct,ProductDto.class);
        return productDto1;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto,Integer productId ,Integer categoryId) {
        Product product = this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found with id"+productId));
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("category not found with id"+categoryId));
        product.setCategory(category);
        product.setView(productDto.getView());
        product.setCaption(productDto.getCaption());
        product.setImage(productDto.getImage());
        product.setTitle(productDto.getTitle());
        Product updatedProduct=this.productRepository.save(product);
        ProductDto productDto1=this.modelMapper.map(updatedProduct,ProductDto.class);

        return productDto1;
    }

    @Override
    public void deleteProduct(Integer productId) {
       Product product =this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found with id"+productId));
        this.productRepository.delete(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
      List<Product> products= this.productRepository.findAll();
    List<ProductDto> productDtos=products.stream().map((product) ->this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ProductDto getSingleProduct(Integer productId) {
        Product product=this.productRepository.findById(productId).orElseThrow(()->new RuntimeException("product not found with Id"+productId));
        ProductDto productDto = this.modelMapper.map(product,ProductDto.class);
        return productDto;
    }

    @Override
    public List<ProductDto> getProductByCategory(Integer categoryId) {
        Category category= this.categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("category not Found with Id" +categoryId));
        List<Product> products=this.productRepository.findByCategory(category);
        List<ProductDto> productDtos=products.stream().map((product -> this.modelMapper.map(product,ProductDto.class))).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public List<ProductDto> searchProduct(String title) {
        List<Product> products=this.productRepository.findByTitleContaining(title);
        List<ProductDto> productDtos=products.stream().map(product -> this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public List<ProductDto> findPaginated(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> page= this.productRepository.findAll(paging);
        List<Product> products=page.getContent();
        List<ProductDto> productDtos=products.stream().map(product -> this.modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
        return  productDtos;
    }


}
