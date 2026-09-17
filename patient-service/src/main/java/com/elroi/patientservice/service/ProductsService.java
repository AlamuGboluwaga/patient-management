package com.elroi.patientservice.service;

import com.elroi.patientservice.dto.ProductsRequestDto;
import com.elroi.patientservice.dto.ProductsResponseDto;
import com.elroi.patientservice.mapper.ProductsMapper;
import com.elroi.patientservice.model.Products;
import com.elroi.patientservice.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
//    private final CloudinaryService cloudinaryService;

    public ProductsService(ProductsRepository productsRepository, ProductsMapper productsMapper) {
        this.productsRepository = productsRepository;
        this.productsMapper = productsMapper;
//        this.cloudinaryService = cloudinaryService;

    }

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public ProductsResponseDto createProduct(ProductsRequestDto request) {
        Products entity = productsMapper.toEntity(request);
        var saveToDb = productsRepository.save(entity);
        return productsMapper.toDto(saveToDb);
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
