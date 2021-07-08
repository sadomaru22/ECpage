package control.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductBeans;
import model.SeafoodDAO;

/**
 * Servlet implementation class AdUpdateCheck
 */
@WebServlet("/AdUpdateCheck")
public class AdUpdateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		
		SeafoodDAO sfb = new SeafoodDAO();  //searchメソッドを呼び出すためのインスタンス化
		ProductBeans pb = sfb.search(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("pb", pb);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/mente/AdUpdateCheck.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
