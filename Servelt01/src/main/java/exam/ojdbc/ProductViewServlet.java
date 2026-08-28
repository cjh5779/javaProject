package exam.ojdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unchecked")
@WebServlet(name = "ProductViewServlet2", urlPatterns = { "/productview" })
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>)request.getAttribute("prdList");
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>상품명</td><td>상품가격</td><td>제조사</td><td>제품번호</td><td>삭제</td></tr>");
		
		for(int i=0; i<prdList.size(); i++) {
			ProductVO vo = prdList.get(i);
			String name = vo.getPrdName();
			String price = vo.getPrdPrice();
			String maker = vo.getPrdMaker();
			String id = vo.getPrdId();
			
			out.print("<tr><td>" + name + "</td><td>" + price + "</td><td>" + maker + "</td><td>" + id + "</td><td>" + "<a href='/Servlet01/productDelete?id=" + id + "'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
		out.close();
	}

}
