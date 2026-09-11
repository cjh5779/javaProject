package com.spring_mvc.projectData;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@RequestMapping("/productForm")
	public String productForm() {
		return "product/productForm";
	}
	
	@RequestMapping("/productResult")
	public String productResult(HttpServletRequest request, Model model) {
		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		String prdPrice = request.getParameter("prdPrice");
		String prdCompany = request.getParameter("prdCompany");
		String prdDate = request.getParameter("prdDate");
		String prdStock = request.getParameter("prdStock");
		
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);
		
		return "product/productResult";
	}
	
	@RequestMapping("/productForm2")
	public String productForm2() {
		return "product/productForm2";
	}
	
	@RequestMapping("/productResult2")
	public String productResult2(@RequestParam("prdNo") String prdNo,
								 @RequestParam("prdName") String prdName,
								 @RequestParam("prdPrice") int prdPrice,
								 @RequestParam("prdCompany") String prdCompany,
								 @RequestParam("prdDate") String prdDate,
								 @RequestParam("prdStock") int prdStock,
								 Model model) {

		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);

		return "product/productResult";
	}

	@RequestMapping("/productResult3")
	public String productResult3(String prdNo,
								 String prdName,
								 int prdPrice,
								 String prdCompany,
								 String prdDate,
								 int prdStock,
								 Model model) {

		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);

		return "product/productResult";
	}
	
	@RequestMapping("/productForm3")
	public String productForm3() {
		return "product/productForm3";
	}
	
	@RequestMapping("/newProduct3")
	public String newProduct3(Product product) {
		return "product/productResult3";
	}
	
	@RequestMapping("/newProduct4")
	public String newProduct4(@ModelAttribute("productInfo") Product product) {
		return "product/productResult4";
	}
}
