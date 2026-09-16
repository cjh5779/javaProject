package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatisEx.dao.IBookDAO;
import com.spring_mvc.mybatisEx.vo.BookVO;

@Service
public class BookService implements IBookService {

    // DAO 객체 주입
    @Autowired
    private IBookDAO dao;

    @Override
    public ArrayList<BookVO> getAllBookList() {
        // DAO의 메소드를 호출하여 DB에서 데이터를 가져옴
        return dao.getAllBookList();
    }
    
    @Override
    public BookVO detailViewBook(String bookNo) {
        return dao.detailViewBook(bookNo);
    }

    @Override
    public void insertBook(BookVO book) {
        dao.insertBook(book);
    }

    @Override
    public void updateBook(BookVO book) {
        dao.updateBook(book);
    }

    @Override
    public void deleteBook(String bookNo) {
        dao.deleteBook(bookNo);
    }

    @Override
    public String bookNoCheck(String bookNo) {
        int count = dao.bookNoCheck(bookNo); 
        
        if (count == 0) {
            return "available"; 
        } else {
            return "unavailable";
        }
    }
    
    
}