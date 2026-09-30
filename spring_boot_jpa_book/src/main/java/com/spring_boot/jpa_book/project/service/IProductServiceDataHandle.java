package com.spring_boot.jpa_book.project.service;

import java.util.ArrayList;

import com.spring_boot.jpa_book.project.entity.ProductEntity;

// Entity 기준으로 데이터를 주고받는 규격
public interface IProductServiceDataHandle {
    ArrayList<ProductEntity> listAllProduct();
    void insertProduct(ProductEntity entity);
    void updateProduct(ProductEntity entity);
    void deleteProduct(String prdNo);
    ProductEntity detailViewProduct(String prdNo);
    String prdNoCheck(String prdNo);
}