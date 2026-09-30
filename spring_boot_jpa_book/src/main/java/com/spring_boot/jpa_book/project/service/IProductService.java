package com.spring_boot.jpa_book.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.jpa_book.project.dto.ProductDTO;

public interface IProductService {
	void insertProduct(ProductDTO prdDto);
	void updateProduct(ProductDTO prdDto);
	void deleteProduct(String prdNo);
	ArrayList<ProductDTO> listAllProduct();
	ProductDTO detailViewProduct(String prdNo);
	String prdNoCheck(String prdNo);
	ArrayList<ProductDTO> productSearch(HashMap<String, Object> map);
}