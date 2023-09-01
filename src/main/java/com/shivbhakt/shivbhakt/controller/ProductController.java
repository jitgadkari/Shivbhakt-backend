package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.entity.Category;
import com.shivbhakt.shivbhakt.entity.Product;
import com.shivbhakt.shivbhakt.payload.CategoryDto;
import com.shivbhakt.shivbhakt.payload.ProductDto;
import com.shivbhakt.shivbhakt.service.FileService;
import com.shivbhakt.shivbhakt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Value("${project.image}")
    String path;
    @Autowired
    private ProductService productService;
    @Autowired
    private FileService fileService;

    @PostMapping("/product/{catId}")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable Integer catId){
        ProductDto productDto1=this.productService.createProduct(productDto,catId);
        return  new ResponseEntity<>(productDto1, HttpStatus.CREATED);
    }

    @PutMapping("/product/{productId}/{categoryId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable Integer productId,@PathVariable Integer categoryId){
        ProductDto productDto1 = this.productService.updateProduct(productDto,productId,categoryId);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public  ResponseEntity<ProductDto> getSingleProduct(@PathVariable Integer productId){
        ProductDto productDto=this.productService.getSingleProduct(productId);
        return  new ResponseEntity<>(productDto,HttpStatus.OK);
    }
    @GetMapping("/products")
    public  ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> productDtos=this.productService.getAllProducts();
        return  new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable Integer categoryId){
        List<ProductDto> productDtos = this.productService.getProductByCategory(categoryId);
        return  new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productId){
        this.productService.deleteProduct(productId);
        return  new ResponseEntity<>("product with Id"+productId+"was deleted successfully" ,HttpStatus.OK);
    }

    @PostMapping("/product/upload/{productId}")
    public ResponseEntity<ProductDto> uploadImage(@RequestParam("image") MultipartFile image ,@PathVariable Integer productId) throws IOException {
        ProductDto productDto= this.productService.getSingleProduct(productId);

       String name= this.fileService.uploadImage(path,image);
       productDto.setImage(name);
       CategoryDto category=productDto.getCategory();
       Integer categoryId=category.getCategoryId();
       ProductDto updateProduct= this.productService.updateProduct(productDto,productId,categoryId);
       return  new ResponseEntity<>(updateProduct,HttpStatus.OK);
    }
    @GetMapping("/products/search/{title}")
    public ResponseEntity<List<ProductDto>> searchProducts(@PathVariable String title){
        List<ProductDto> productDtos=this.productService.searchProduct(title);
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

}
