package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/insertMember")
public class JoinResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String phone3 = request.getParameter("phone3");
        String grade = request.getParameter("grade");
        String[] interests = request.getParameterValues("interest");
        String major = request.getParameter("major");

        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>회원 가입 내용</title></head><body>");
        out.println("<h3>회원 가입 내용</h3>");
        out.println("성명 : " + name + "<br>");
        out.println("ID : " + id + "<br>");
        out.println("비밀번호 : " + pwd + "<br>");
        out.println("휴대폰 번호 : " + phone1 + "-" + phone2 + "-" + phone3 + "<br>");
        out.println("학년 : " + (grade != null ? grade : "") + "<br>");
        
        out.print("관심분야 : ");
        if (interests != null) {
            for (String interest : interests) {
                out.print(interest + " ");
            }
        }
        out.println("<br>");
        
        out.println("학과 : " + major + "<br>");
        out.println("</body></html>");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
