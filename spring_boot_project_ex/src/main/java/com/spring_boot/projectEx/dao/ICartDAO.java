package com.spring_boot.projectEx.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.spring_boot.projectEx.dto.CartDTO;

@Mapper
public interface ICartDAO {
	void insertCart(CartDTO dto); //새로운 상품 장바구니에 추가
	int checkPrdInCart(HashMap<String,Object> map);//특정 회원 장바구니에 동일 상품 존재 여부 확인
	void updateQtyInCart(CartDTO dto);//기존 추가된 상품의 수량 변경 - 기존 수량에 새로운 수량을 추가
	ArrayList<CartDTO> cartList(String memId); //특정 회원 장바구니 목록
	void deleteCart(ArrayList<String> chkArr); //장바구니 상품 삭제
	void updateCart(HashMap<String, Object> map);
}