package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBeans;
import model.SeafoodDAO;


@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");  
		
			
		SeafoodDAO sfb = new SeafoodDAO();  //searchメソッドを呼び出すためのインスタンス化
		ProductBeans p = sfb.search(id);
		
		request.setAttribute("p", p);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/JSP/detail.jsp");
		dispatch.forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
