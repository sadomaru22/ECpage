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

/**
 * Servlet implementation class AdUpdateCheck2
 */
@WebServlet("/AdUpdateCheck2")
public class AdUpdateCheck2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateCheck2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * AdUpdate2.jspの段階ではまだupdateDara()を実行していないので、確認のためにここでpbを上書きする必要がある。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String exp = request.getParameter("exp");
		String fileName = request.getParameter("fileName");
		
		//AdRegister.jspから受け取った値をBeansにセット
		ProductBeans pb = new ProductBeans();
		pb.setId(id);
		pb.setName(name);
		pb.setPrice(price);
		pb.setExp(exp);
		pb.setFileName(fileName);
		
		HttpSession session = request.getSession();
		session.setAttribute("pb", pb);
		
		
        RequestDispatcher rd = request.getRequestDispatcher("/mente/AdUpdateCheck2.jsp");
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
