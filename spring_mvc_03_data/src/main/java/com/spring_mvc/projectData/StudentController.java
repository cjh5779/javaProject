package com.spring_mvc.projectData;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	//경로 테스트용 메소드
	@RequestMapping("/newView")
	public String newViewT(Model model) {
		model.addAttribute("name", "bookName");
		return "newView";
	}
	
	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm2";
	}
	
	// getParameter() 메소드 사용 - 파라미터값 추출
	@RequestMapping("/student/newStudent")
	public String insertStudent(HttpServletRequest request, Model model) {
		// form에서 각 input 태그의 name 속성값 받아오기
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		// view 전달
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 2. @RequestParam 이용 - 처리함수의 매개변수로 주입
	@RequestMapping("/student/newStudent2")
	public String insertStudent2(@RequestParam("no") String no,
								 @RequestParam("name") String name,
								 @RequestParam("year") String year,
								 Model model) {
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 2. @RequestParam 이용 - 처리함수의 매개변수로 주입
	// form태그 내 input의 name 속성값이 매개변수와 동일하면 @RequestParam을 생략할 수 있다
	// 파라미터명과 매개변수 명이 동일한 경우 
		@RequestMapping("/student/newStudent3")
		public String insertStudent3(String no,
									 String name,
									 String year,
									 Model model) {
			model.addAttribute("no", no);
			model.addAttribute("name", name);
			model.addAttribute("year", year);
			
			return "student/studentResult";
		}
		
	// 3. command 객체 사용 -> 요청 처리에 사용되는 객체 command 객체라고 함 매개변수에 사용됨
	// student command 객체가 되고 파라미터가 전달된다면 필드명과 같은 이름의 파라미터 값이 필드값으로 대입된 객체가 전달됨
	// command 객체를 사용하면 지정된 뷰로 model이 자동 전송됨
	// command 객체 사용 시 주의사항 : 파라미터명과 필드명이 동일해야 함 다르면 매칭되지 않는다
	@RequestMapping("/student/newStudent4")
	public String insertStudent4(Student student) {
		System.out.println(student.getNo());
		System.out.println(student.getName());
		System.out.println(student.getYear());
		
		return "student/studentResult2";
	}
	
	// 3-1. command 객체 사용
	// attr의 이름을 변경해서 view로 전달 -> @ModelAttribute("새로운 이름") 사용해서 변경
	@RequestMapping("/student/newStudent5")
	public String insertStudent5(@ModelAttribute("StudentInfo") Student student) { // 매개변수명이 아닌 StudentInfo로 attr의 이름이 설정
		return "student/studentResult3";
	}
}
