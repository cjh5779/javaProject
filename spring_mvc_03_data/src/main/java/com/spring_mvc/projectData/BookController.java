package com.spring_mvc.projectData;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class BookController {
	@RequestMapping("/book")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/book/bookInfoView")
	public String bookInfoView(Model model) {
		model.addAttribute("title", "스프링 프레임워크");
		model.addAttribute("price", 20000);
		
		return "book/bookInfoView";
	}
	
	@RequestMapping("/book/bookInfoView2")
	public ModelAndView bookInfoView2(ModelAndView mv) {
		mv.addObject("title", "스프링 프레임워크");
		mv.addObject("price", 20000);
		mv.setViewName("/book/bookInfoView2");
		
		return mv;
	}
	
	// Model과 ModelAndView 객체 모두 주입 받기
	@RequestMapping("/bookInfoView3")
	public ModelAndView bookInfoView3(Model model, ModelAndView mv) {
		model.addAttribute("name", "이몽룡");
		
		mv.addObject("name", "성춘향");
		mv.addObject("age", 23);
		mv.setViewName("bookInfoView3");
		
		model.addAttribute("address", "남원");
		
		// model은 자동 반환, ModelAndView는 명시적으로 반환
		return mv;
	}
}
