package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ProductMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<ProductDto> getProducts() {
        return mapper.mapToProductDtoList(service.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return mapper.mapToProductDto(service.getProduct(productId).orElseThrow(()-> new ProductNotFoundException(productId)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void addProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(mapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return mapper.mapToProductDto(service.saveProduct(mapper.mapToProduct(productDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        service.deleteProduct(productId);
    }
}