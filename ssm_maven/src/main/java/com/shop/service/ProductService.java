package com.shop.service;

import com.shop.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductList();

    Product getProductById(Integer id);

    void updateItem(Product product);
}
