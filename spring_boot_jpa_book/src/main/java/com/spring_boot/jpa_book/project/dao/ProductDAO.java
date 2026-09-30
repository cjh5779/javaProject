package com.spring_boot.jpa_book.project.dao;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring_boot.jpa_book.project.entity.ProductEntity;
import com.spring_boot.jpa_book.project.repository.ProductRepository;
import com.spring_boot.jpa_book.project.service.IProductServiceDataHandle;

@Repository
public class ProductDAO implements IProductServiceDataHandle {
    
    @Autowired
    ProductRepository prdRepo;

    @Override
    public ArrayList<ProductEntity> listAllProduct() {
        return (ArrayList<ProductEntity>) prdRepo.findAll();
    }

    @Override
    public void insertProduct(ProductEntity entity) {
        prdRepo.save(entity); // JPA save는 insert 역할
    }

    @Override
    public void updateProduct(ProductEntity entity) {
        prdRepo.save(entity); // 기본키가 존재하면 update 역할
    }

    @Override
    public void deleteProduct(String prdNo) {
        prdRepo.deleteById(prdNo);
    }

    @Override
    public ProductEntity detailViewProduct(String prdNo) {
        return prdRepo.findById(prdNo).orElse(null);
    }

    @Override
    public String prdNoCheck(String prdNo) {
        return prdRepo.existsById(prdNo) ? prdNo : null;
    }
}