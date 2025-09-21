package com.zaliczenie.sklep.products.domain.product.converter;


import com.zaliczenie.sklep.products.domain.product.ProductDto;
import com.zaliczenie.sklep.products.domain.product.ProductEntity;

public class ProductConverter {
    public static ProductDto toDto(ProductEntity productEntity) {
        return ProductDto.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice())
                .imageUrl(productEntity.getImageUrl())
                .build();
    }

    public static ProductEntity toEntity(ProductDto productDto) {
        return ProductEntity.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .build();
    }
}
