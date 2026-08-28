package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first02")
public class ServletRefreshFirst extends HttpServlet {
	/**
	 * refresh 통한 포워딩
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("addHeader()를 이용한 refresh 포워딩");
		out.println("</body></html>");
		
		// Refresh 속성 : 시간(초);url=맵핑이름
		response.addHeader("Refresh", "3;url=sec02");
	}

}
