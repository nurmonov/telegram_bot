package com.uz.telegrambot.service;

import com.uz.telegrambot.dto.ProductDTO;
import com.uz.telegrambot.entity.Product;
import com.uz.telegrambot.mapper.ProductMapper;
import com.uz.telegrambot.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper= ProductMapper.INSTANCE;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList());

    }

    public ProductDTO getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::toProductDTO).orElse(null);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDTO(savedProduct);
    }

    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(productDTO.getId());
        if (product.isPresent()) {

            Product updatedProduct = productMapper.toProduct(productDTO);
            updatedProduct.setId(id);
            updatedProduct = productRepository.save(updatedProduct);
            return productMapper.toProductDTO(updatedProduct);

        }
        return null;
    }
    public void deleteProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(productRepository::delete);
    }
}

