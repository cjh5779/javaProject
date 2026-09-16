package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// 1. Ajax 방식 받기 (폼 데이터 전송)
		@ResponseBody
		@RequestMapping("/book/bookNoCheck1")
		public String bookNoCheck1(@RequestParam("bookNo") String bookNo) {
			// service에 bookNoCheck 메서드가 구현되어 있어야 합니다.
			String result = service.bookNoCheck(bookNo); 
			return result;
		}

		// 2. Fetch 방식 받기 (URL 경로 변수 전송)
		@ResponseBody
		@RequestMapping("/book/bookNoCheck2/{bookNo}")
		public String bookNoCheck2(@PathVariable("bookNo") String bookNo) {
			String result = service.bookNoCheck(bookNo);
			return result;
		}

		// 3. Axios 방식 받기 (JSON Body 데이터 전송)
		@ResponseBody
		@RequestMapping("/book/bookNoCheck3")
		public String bookNoCheck3(@RequestBody java.util.HashMap<String, String> map) {
			// JSON 객체로 넘어온 데이터 중 "bookNo" 키의 값을 꺼냅니다.
			String bookNo = map.get("bookNo");
			String result = service.bookNoCheck(bookNo);
			return result;
		}
}