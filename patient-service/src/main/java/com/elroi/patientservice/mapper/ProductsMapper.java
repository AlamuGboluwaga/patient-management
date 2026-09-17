package com.elroi.patientservice.mapper;

import com.elroi.patientservice.dto.ProductsRequestDto;
import com.elroi.patientservice.dto.ProductsResponseDto;
import com.elroi.patientservice.model.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Products toEntity(ProductsRequestDto request);

    ProductsResponseDto toDto(Products entity);
}
