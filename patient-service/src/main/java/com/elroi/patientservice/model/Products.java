package com.elroi.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;

@Entity
@Table(name = "products_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    @NotBlank(message = "Product name is required")
    private String name;
    @Column(name = "description")
    @NotBlank(message = "Product description is required")
    private String description;
    @Column(name = "price", precision = 10, scale = 2)
    @NotNull(message = "Product price is required")
    private BigDecimal price;
    @Column(name = "stock_quantity")
    @NotNull(message = "Stock quantity is required")
    private Integer stockQuantity;
    @Column(name = "category")
    @NotBlank(message = "Product category is required")
    private String category;
    @Column(name = "image_url")
    @NotBlank(message = "Product image URL is required")
    private String imageUrl;
    @Column(name = "active")
    @NotNull(message = "Product active status is required")
    private Boolean active = true;
    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private String updatedAt;

}
