package com.spring_boot.jpa_product.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring_boot.jpa_product.project.dto.ProductDTO;
import com.spring_boot.jpa_product.project.entity.ProductEntity;

@Service
public class ProductService implements IProductService {
    IProductServiceDataHandle productServiceDataHandle;
    
    public ProductService(IProductServiceDataHandle productServiceDataHandle) {
        this.productServiceDataHandle = productServiceDataHandle;
    }
    
    @Override
    public ArrayList<ProductDTO> listAllProduct() {
        ArrayList<ProductEntity> entityList = productServiceDataHandle.listAllProduct();
        ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
        
        for(ProductEntity entity : entityList) {
            ProductDTO dto = ProductDTO.toDto(entity);
            list.add(dto);
        }
        
        return list;
    }

    @Override
    public void insertProduct(ProductDTO dto) {
        ProductEntity e = ProductEntity.toEntity(dto);
        productServiceDataHandle.insertProduct(e);
    }

    @Override
    public void updateProduct(ProductDTO dto) {
        ProductEntity e = ProductEntity.toEntity(dto);
        productServiceDataHandle.updateProduct(e);
    }

    @Override
    public void deleteProduct(String prdNo) {
        productServiceDataHandle.deleteProduct(prdNo);
    }

    @Override
    public ProductDTO detailViewProduct(String prdNo) {
        Optional<ProductEntity> entity = productServiceDataHandle.detailViewProduct(prdNo);
        ProductDTO dto = ProductDTO.toDto(entity.get());
        return dto;
    }

    @Override
    public String prdNoCheck(String prdNo) {
        String res = productServiceDataHandle.prdNoCheck(prdNo);
        return res;
    }

    
    @Override
    public List<ProductDTO> productSearch(HashMap<String, Object> map) {
        List<ProductEntity> entityList = productServiceDataHandle.productSearch(map);
        List<ProductDTO> dtoList = new ArrayList<ProductDTO>();
        
        for(ProductEntity e : entityList) {
            dtoList.add(ProductDTO.toDto(e));
        }
        
        return dtoList;
    }
}