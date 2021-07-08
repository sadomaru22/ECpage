package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountBeans;
import model.AccountRegisterDAO;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 新規登録の時用
     */
    public AccountRegister() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		
        // register.jspから受け取った値をビーンズにセット
        AccountBeans ab = new AccountBeans();
        ab.setName(name);
        ab.setLoginId(loginId);
        ab.setPass(pass);
        
        //アカウントをDBに登録
        AccountRegisterDAO ard = new AccountRegisterDAO(ab);
        
        
        //セッションにアカウント情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("account", ard);   //★
        
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/registerSuccess.jsp");
        rd.forward(request, response);
	}

}
