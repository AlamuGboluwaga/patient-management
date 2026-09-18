package com.elroi.patientservice.controllers;

import com.elroi.patientservice.dto.ProductsRequestDto;
import com.elroi.patientservice.dto.ProductsResponseDto;
import com.elroi.patientservice.service.ProductsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Products API")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping("api/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductsResponseDto> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("api/products/{id}")
    public ProductsResponseDto getProductById(@PathVariable @Positive(message = "Id must be greater than 0) Integer id") Integer id) {
        return productsService.getProductById(id);
    }

    @PostMapping("api/products")
    public ResponseEntity<ProductsResponseDto> createProduct(@Valid @RequestBody ProductsRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productsService.createProduct(request));
    }

    @PutMapping("api/products/{id}")
    public ResponseEntity<ProductsResponseDto> updateProduct(@PathVariable Integer id, @Valid @RequestBody ProductsRequestDto request) {
        var product = productsService.updateProduct(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Valid @PathVariable Integer id) {
        productsService.deleteById(id);
    }


    @PostMapping("api/products/{keyword}")
    public List<ProductsResponseDto> searchProduct(@PathVariable String keyword) {
        return productsService.searchProduct(keyword);
    }

//    @PostMapping(value = "/products", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<ProductsResponseDto> createProduct(
//            @RequestPart("product") ProductsRequestDto request,
//            @RequestPart("image") MultipartFile image) {
//
//        ProductsResponseDto response =
//                productsService.createProduct(request, image);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(response);
//    }


}