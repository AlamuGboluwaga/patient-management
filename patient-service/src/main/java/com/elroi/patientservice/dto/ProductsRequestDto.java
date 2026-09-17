package com.elroi.patientservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductsRequestDto {
    @NotBlank(message = "Product name is required")
    private String name;
    @NotBlank(message = "Product description is required")
    private String description;
    @NotNull(message = "Product price is required")
    private BigDecimal price;
    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;
    @NotBlank(message = "Product category is required")
    private String category;
    @NotBlank(message = "Product image URL is required")
    private String imageUrl;


}
