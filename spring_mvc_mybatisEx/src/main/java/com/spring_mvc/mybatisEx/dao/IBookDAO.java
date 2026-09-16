package com.spring_mvc.mybatisEx.dao;

import java.util.ArrayList;

import com.spring_mvc.mybatisEx.vo.BookVO;

public interface IBookDAO {
	public ArrayList<BookVO> getAllBookList();
	public BookVO detailViewBook(String bookNo);
	public void insertBook(BookVO book);
	public void updateBook(BookVO book);
	public void deleteBook(String bookNo);
	public int bookNoCheck(String bookNo);
}
