package control.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminBeans;
import model.AdminDAO;
import model.ProductBeans;

/**
 * Servlet implementation class AdRegister
 */
@WebServlet("/AdRegister")
public class AdRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		
		AdminDAO.getConnection();  //staticクラスだから(おそらくもう必要ない)
		
		HttpSession session = request.getSession();
		
		//情報セキュリティ
		AdminBeans amb = (AdminBeans)session.getAttribute("amb");
		if (amb == null) {
			System.out.println("nullです");
			String message = "不正アクセスの可能性があります。";
			session.setAttribute("message", message);
        	RequestDispatcher rd = request.getRequestDispatcher("/mente/login.jsp");
        	rd.forward(request, response);
		}
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String exp = request.getParameter("exp");
		String fileName = request.getParameter("fileName");
		
		//AdRegister.jspから受け取った値をBeansにセット
		ProductBeans pb = new ProductBeans();
		pb.setName(name);
		pb.setPrice(price);
		pb.setExp(exp);
		pb.setFileName(fileName);
		
		AdminDAO amd = new AdminDAO();
		
		amd.insertData(pb);
		
		session.setAttribute("pb", pb);
		
		
        RequestDispatcher rd = request.getRequestDispatcher("/mente/AdRegisterCheck.jsp");
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
