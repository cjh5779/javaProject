package com.spring_mvc.projectData;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
	@RequestMapping("/productPathTest")
	public String productPathTest(Model model) {
		model.addAttribute("prdNo", "P101");
		model.addAttribute("prdName", "keyboard");
		model.addAttribute("prdStock", 25);
		model.addAttribute("prdPrice", 45000);
		model.addAttribute("prdCompany", "Logitech");
		model.addAttribute("prdDate", "2026-09-11");

		return "product/productPathTest";
	}

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
	public String productResult2(@RequestParam("prdNo") String prdNo, @RequestParam("prdName") String prdName,
			@RequestParam("prdPrice") int prdPrice, @RequestParam("prdCompany") String prdCompany,
			@RequestParam("prdDate") String prdDate, @RequestParam("prdStock") int prdStock, Model model) {

		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);

		return "product/productResult";
	}

	@RequestMapping("/productResult3")
	public String productResult3(String prdNo, String prdName, int prdPrice, String prdCompany, String prdDate,
			int prdStock, Model model) {

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

	@RequestMapping("/productDetailView/{prdName}")
	public String productDetailView(@PathVariable String prdName) {
		System.out.println(prdName);
		return "product/productResult5";
	}

	@RequestMapping("/productDetailView/{prdName}/{prdStock}/{prdNo}")
	public String productDetailView2(@PathVariable String prdName, @PathVariable int prdStock,
			@PathVariable String prdNo) {
		System.out.println(prdName);
		System.out.println(prdStock);
		System.out.println(prdNo);
		return "product/productResult5";
	}
}
