package com.example.demoapi.api;

import com.example.demoapi.entity.Product;
import com.example.demoapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductAPI {
    final private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Product> findById(@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()){
            log.error("id not existed");
        }
        return ResponseEntity.ok(product.get());
    }
    @PutMapping
    public  ResponseEntity<Product> update(@PathVariable Integer id, @Valid @RequestBody Product product){
        if (!productService.findById(id).isPresent()){
            log.error("id not existed");
        }
        return ResponseEntity.ok(productService.save(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if (!productService.findById(id).isPresent()){
            log.error("id not existed");
        }
            productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
