package com.shop.domain;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private Product product;
    private User user;
    private String[] ids;
    private List<Product> productList;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "product=" + product +
                ", user=" + user +
                ", ids=" + Arrays.toString(ids) +
                ", productList=" + productList +
                '}';
    }
}
