package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/*
 * /member/로 시작하는 모든 uri(servlet path)
 *  /member/abc, /member/list.... 
 *  /member/ 요청
 */

@WebServlet("/MemberControllerFront")
public class MemberControllerFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;
	
	public void init() throws ServletException {
		memberDAO = new MemberDAO(); // 초기화 메소드에서 DAO 생성
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null; // forward 시킬 location 저장
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); // 서블릿에 전달된 최종 결로만 반환 /member는 현재 서블릿이 제거했음
		System.out.println("action : " + action); // 해당 함수에 전달되는 경로는 /member 뒤의 경로만 반환 
		// /member/list로  요청했다면 action에는 /list를 저장하게 됨
		
		// /member/listMembers.do 또는 /member -> 회원목록
		if(action == null || action.equals("/listMembers.do")) {
			List<MemberVO> memberList = memberDAO.listMembers();
			request.setAttribute("memberList", memberList);
			nextPage = "/view/listMembers.jsp"; // 포워딩될 url
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		
	}

}
