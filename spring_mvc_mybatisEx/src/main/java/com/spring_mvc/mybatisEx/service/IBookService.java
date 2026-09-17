package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.mybatisEx.vo.BookVO;

public interface IBookService {
	public ArrayList<BookVO> getAllBookList();
	public BookVO detailViewBook(String bookNo);
	public void insertBook(BookVO book);
	public void updateBook(BookVO book);
	public void deleteBook(String bookNo);
	public String bookNoCheck(String bookNo);
	ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}