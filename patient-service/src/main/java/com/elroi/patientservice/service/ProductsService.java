package com.elroi.patientservice.service;

import com.elroi.patientservice.GlobalErrorHandlling.NotFoundException;
import com.elroi.patientservice.dto.ProductsRequestDto;
import com.elroi.patientservice.dto.ProductsResponseDto;
import com.elroi.patientservice.mapper.ProductsMapper;
import com.elroi.patientservice.model.Products;
import com.elroi.patientservice.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
//    private final CloudinaryService cloudinaryService;

    public ProductsService(ProductsRepository productsRepository, ProductsMapper productsMapper) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
//      this.cloudinaryService = cloudinaryService;
    }

    public List<ProductsResponseDto> getAllProducts() {

        return productsRepository.findAll()
                .stream().map(productsMapper::toDto).toList();
    }

    public ProductsResponseDto getProductById(Integer id) {
        Products product = productsRepository.findById(id)
                .orElseThrow(() -> (new NotFoundException("Product not found")));
        return productsMapper.toDto(product);


//        return productsRepository.findById(id)
//                .map(productsMapper::toDto) // <--- Use MapStruct mapper method reference
//                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));


    }

    public ProductsResponseDto createProduct(ProductsRequestDto request) {
        Products entity = productsMapper.toEntity(request);
        var saveToDb = productsRepository.save(entity);
        return productsMapper.toDto(saveToDb);
    }

    public ProductsResponseDto updateProduct(Integer id, ProductsRequestDto request) {
        Products product = productsRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        Products entity = productsMapper.toEntity(request);

        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setStockQuantity(entity.getStockQuantity());
        product.setCategory(entity.getCategory());
        product.setStockQuantity(entity.getStockQuantity());
        product.setCategory(entity.getCategory());
        product.setPrice(entity.getPrice());
        product.setImageUrl(entity.getImageUrl());
        var savedToDB = productsRepository.save(product);
        return productsMapper.toDto(savedToDB);

    }


    public void deleteById(Integer id) {
        Products product = productsRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        productsRepository.delete(product);
    }


    public List<ProductsResponseDto> searchProduct(String keyword) {
        return productsRepository.searchProducts(keyword).stream()
                .map(productsMapper::toDto)
                .collect(Collectors.toList());
    }


//    public ProductsResponseDto createProduct(
//            ProductsRequestDto request,
//            MultipartFile image) {
//
//        String imageUrl = cloudinaryService.uploadImage(image);
//
//        Products product = productsMapper.toEntity(request);
//
//        product.setImageUrl(imageUrl);
//
//        Products savedProduct = productsRepository.save(product);
//
//        return productsMapper.toDto(savedProduct);
//    }


}
