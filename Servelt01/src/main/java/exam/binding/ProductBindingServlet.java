package exam.binding;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prdbinding")
public class ProductBindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductVO vo1 = new ProductVO("무선 블루투스 이어폰", "150,000", "삼성전자", "1001");
		ProductVO vo2 = new ProductVO("기계식 청축 키보드", "85,000", "로지텍", "1002");
		ProductVO vo3 = new ProductVO("27인치 4K 모니터", "320,000", "LG전자", "1003");
		
		ArrayList<ProductVO> prdList = new ArrayList<>();
		prdList.add(vo1);
		prdList.add(vo2);
		prdList.add(vo3);
		
		request.setAttribute("prdList", prdList);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("prdview");
		dispatch.forward(request, response);
	}

}
