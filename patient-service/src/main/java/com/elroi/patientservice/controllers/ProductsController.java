package com.elroi.patientservice.controllers;

import com.elroi.patientservice.dto.ProductsRequestDto;
import com.elroi.patientservice.dto.ProductsResponseDto;
import com.elroi.patientservice.model.Products;
import com.elroi.patientservice.service.ProductsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Products API")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @GetMapping("/api/products")
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }


    @PostMapping("api/products")
    public ResponseEntity<ProductsResponseDto> createProduct(@Valid @RequestBody ProductsRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productsService.createProduct(request));
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