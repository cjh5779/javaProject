package exam;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클라이언트가 form 태긑를 통해 전송한 데이터(파라미터)를 추출해서 처리
 */
@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("객체 생성");
	}
	
	/*
	 * form method post 요청 처리
	 * 1개의 파라미터 value를 추출할 때 사용 : getParameter (input type text, password, radio 1개 값 전송)
	 * 동일 파라미터명으로 여러개의 파라미터가 전송되면 getParameter는 처음 보이는 파라미터의 값만 반환
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String bookNo = request.getParameter("bookNo");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String pubDate = year + "-" + month + "-" + day;
        
        String stock = request.getParameter("stock");
        String pubNo = request.getParameter("pubNo");
        
        System.out.println("도서번호 : " + bookNo);
        System.out.println("도서명 : " + title);
        System.out.println("저자 : " + author);
        System.out.println("가격 : " + price);
        System.out.println("발행일 : " + pubDate);
        System.out.println("재고 : " + stock);
        System.out.println("출판사번호 : " + pubNo);
	}

}
