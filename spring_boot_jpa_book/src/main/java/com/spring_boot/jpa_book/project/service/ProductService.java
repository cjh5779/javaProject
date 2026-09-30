package com.spring_boot.jpa_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot.jpa_book.project.dto.ProductDTO;
import com.spring_boot.jpa_book.project.entity.ProductEntity;


@Service
public class ProductService implements IProductService {

    @Autowired
    IProductServiceDataHandle dataHandle; // DAO 주입
    
    @Override
    public ArrayList<ProductDTO> listAllProduct() {
        ArrayList<ProductEntity> entityList = dataHandle.listAllProduct();
        ArrayList<ProductDTO> dtoList = new ArrayList<>();
        for(ProductEntity entity : entityList) {
            dtoList.add(ProductDTO.toDto(entity));
        }
        return dtoList;
    }

    @Override
    public void insertProduct(ProductDTO prdDto) {
        dataHandle.insertProduct(ProductEntity.toEntity(prdDto));
    }

    @Override
    public void updateProduct(ProductDTO prdDto) {
        dataHandle.updateProduct(ProductEntity.toEntity(prdDto));
    }

    @Override
    public void deleteProduct(String prdNo) {
        dataHandle.deleteProduct(prdNo);
    }

    @Override
    public ProductDTO detailViewProduct(String prdNo) {
        ProductEntity entity = dataHandle.detailViewProduct(prdNo);
        return entity != null ? ProductDTO.toDto(entity) : null;
    }

    @Override
    public String prdNoCheck(String prdNo) {
        String res = dataHandle.prdNoCheck(prdNo);
        return res != null ? "no_available" : "available";
    }

    @Override
    public ArrayList<ProductDTO> productSearch(HashMap<String, Object> map) {
        // JPA 동적 검색 로직은 별도 구현 필요 (생략)
        return null; 
    }
}