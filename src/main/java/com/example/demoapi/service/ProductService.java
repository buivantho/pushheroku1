package com.example.demoapi.service;

import com.example.demoapi.entity.Product;
import com.example.demoapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private  final ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
}
