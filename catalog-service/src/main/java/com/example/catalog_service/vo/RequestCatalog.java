package com.example.catalog_service.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestCatalog {
    @NotBlank
    private String productId;
    @NotBlank
    private String productName;
    @NotNull
    private Integer stock;
    @NotNull
    private Integer unitPrice;



}
