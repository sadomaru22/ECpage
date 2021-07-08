package control.admin;

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

/**
 * Servlet implementation class GoBack
 */
@WebServlet("/GoBack")
public class GoBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * データの登録、更新、削除をして操作ページに戻るときに、更新した情報を即時に反映させるためのサーブレット
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

    	SeafoodDAO sfb = new SeafoodDAO();
    	//SeafoodDAO.getConnection();
    	ArrayList<ProductBeans> list = sfb.searchAll();
    	
    	session.setAttribute("list", list);
    	
		RequestDispatcher rd = request.getRequestDispatcher("mente/AdloginOk.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
