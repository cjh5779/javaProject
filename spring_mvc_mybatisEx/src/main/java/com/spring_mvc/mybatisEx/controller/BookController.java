package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
	
		@ResponseBody
		@RequestMapping("/book/bookNoCheck1")
		public String bookNoCheck1(@RequestParam("bookNo") String bookNo) {
			String result = service.bookNoCheck(bookNo); 
			return result;
		}

		@ResponseBody
		@RequestMapping("/book/bookNoCheck2/{bookNo}")
		public String bookNoCheck2(@PathVariable("bookNo") String bookNo) {
			String result = service.bookNoCheck(bookNo);
			return result;
		}

		@ResponseBody
		@RequestMapping("/book/bookNoCheck3")
		public String bookNoCheck3(@RequestBody java.util.HashMap<String, String> map) {
			String bookNo = map.get("bookNo");
			String result = service.bookNoCheck(bookNo);
			return result;
		}
		
		@ResponseBody
		@RequestMapping("/book/bookNoCheckAjax")
		public String checkAjax(@RequestParam("bookNo") String bookNo) {
		    return service.bookNoCheck(bookNo); // 사용 가능 시 "available", 중복 시 "duplicate"
		}

		@ResponseBody
		@RequestMapping("/book/bookNoCheckFetch")
		public String checkFetch(@RequestBody HashMap<String, String> map) {
		    return service.bookNoCheck(map.get("bookNo"));
		}

		@ResponseBody
		@RequestMapping("/book/bookNoCheckAxios/{bookNo}")
		public String checkAxios(@PathVariable("bookNo") String bookNo) {
		    return service.bookNoCheck(bookNo);
		}
		
		@RequestMapping("/book/bookSearchForm")
		public String bookSearchForm() {
		    return "book/bookSearchForm";
		}

		@RequestMapping("/book/bookSearch")
		public String bookSearch(@RequestParam HashMap<String, Object> map, Model model) {
		    ArrayList<BookVO> bookList = service.bookSearch(map);
		    model.addAttribute("bookList", bookList);
		    return "book/bookSearchResultView";
		}
}