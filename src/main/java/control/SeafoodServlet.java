package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductBeans;
import model.SeafoodDAO;


@WebServlet("/SeafoodServlet")
public class SeafoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SeafoodServlet() {
        super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
				SeafoodDAO sfb = new SeafoodDAO();
				SeafoodDAO.getConnection();   //Staticは、原則として「クラス名.メソッド名」で書く
					
				ArrayList<ProductBeans> list = sfb.searchAll();
				
				HttpSession session = request.getSession(true);
				
				session.setAttribute("list", list);
				
				RequestDispatcher dispatch = request.getRequestDispatcher("/JSP/seafood.jsp");
				dispatch.forward(request, response);
					
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
