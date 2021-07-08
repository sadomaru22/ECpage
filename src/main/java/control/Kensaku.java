package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductBeans;
import model.SeafoodDAO;

/**
 * Servlet implementation class Kensaku
 */
@WebServlet("/Kensaku")
public class Kensaku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kensaku() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		String keyword = request.getParameter("keyword");
//		ProductBeans pb = new ProductBeans();
//		pb.setName(keyword);
			
    	SeafoodDAO sfb = new SeafoodDAO();
    	SeafoodDAO.getConnection();		
		
    	
    	
		ArrayList<ProductBeans> key = sfb.kensaku(keyword);
		
		request.setAttribute("keyword", key);
		
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/kensakuhit.jsp");
        rd.forward(request, response);		
	}

}
