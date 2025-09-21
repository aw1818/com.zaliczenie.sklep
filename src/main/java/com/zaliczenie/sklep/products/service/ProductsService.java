package com.zaliczenie.sklep.products.service;

import com.zaliczenie.sklep.products.domain.product.ProductDto;
import com.zaliczenie.sklep.products.domain.product.ProductEntity;
import com.zaliczenie.sklep.products.domain.product.converter.ProductConverter;
import com.zaliczenie.sklep.products.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public List<ProductDto> getAllProducts() {
        List<ProductEntity> productEntities = this.productsRepository.findAll();
        return productEntities.stream().map(ProductConverter::toDto).toList();
    }

    public ProductDto getProductById(Long id) {
        ProductEntity productEntity = this.productsRepository.findById(id).orElseThrow();
        return ProductConverter.toDto(productEntity);
    }

    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = ProductConverter.toEntity(productDto);
        productEntity = this.productsRepository.save(productEntity);
        return ProductConverter.toDto(productEntity);
    }

    public void deleteProduct(Long id) {
        this.productsRepository.deleteById(id);
    }
}
