package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatisEx.vo.BookVO;
import com.spring_mvc.mybatisEx.service.IBookService;

@Controller
public class BookController {
	@Autowired
	IBookService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		ArrayList<BookVO> bookList = service.getAllBookList();
		model.addAttribute("bookList", bookList);
		
		return "book/bookListView";
	}
	
	@RequestMapping("/book/detailViewBook/{bookNo}")
    public String detailViewBook(@PathVariable String bookNo, Model model) {
        BookVO book = service.detailViewBook(bookNo);
        model.addAttribute("book", book);
        return "book/bookDetailView";
    }
	
	@RequestMapping("/book/newBookForm")
    public String newBookForm() {
        return "book/newBookForm";
    }
	
	@RequestMapping("/book/updateBookForm/{bookNo}")
    public String updateBookForm(@PathVariable String bookNo, Model model) {
        BookVO book = service.detailViewBook(bookNo);
        model.addAttribute("book", book);
        return "book/updateBookForm";
    }
	
	@RequestMapping("/book/updateBook")
    public String updateBook(BookVO book) {
        service.updateBook(book);
        return "redirect:/book/listAllBook";
    }
	
	@RequestMapping("/book/deleteBook/{bookNo}")
    public String deleteBook(@PathVariable String bookNo) {
        service.deleteBook(bookNo);
        return "redirect:/book/listAllBook";
    }
}