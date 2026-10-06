package com.spring_boot_react.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_react.project.dto.ProductDTO;
import com.spring_boot_react.project.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductRestController {
    
    @Autowired
    ProductService service;
    
    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요";
    }
    
    @GetMapping("/product/productList")
    public ArrayList<ProductDTO> listAllProduct() { // Model 파라미터 제거
        ArrayList<ProductDTO> prdList = service.listAllProduct();
        return prdList;
    }
    
    @GetMapping("/product/productDetailView/{prdNo}")
    public ProductDTO detailViewProduct(@PathVariable("prdNo") String prdNo) {
        return service.detailViewProduct(prdNo);
    }
    
    //상품등록
    @PostMapping("/product/insert") // 앞에 슬래시(/) 추가
    public void insertProduct(ProductDTO prd) {
        service.insertProduct(prd);
    }
    
    //상품 정보 수정
    @PostMapping("/product/update")
    public void updateProduct(ProductDTO prd) {
        service.updateProduct(prd);
    }
    
    //상품 정보 삭제
    //@PostMapping("/product/delete/{prdNo}")
    @DeleteMapping("/product/delete/{prdNo}")
    //@RequestMapping(value="/product/delete/{prdNo}", method=RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("prdNo") String prdNo) { // 명시적으로 "prdNo" 매핑 추가
        service.deleteProduct(prdNo);
        System.out.println(prdNo + "삭제완료");
    }
}