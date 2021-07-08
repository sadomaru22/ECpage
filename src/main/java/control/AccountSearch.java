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

import model.AccountBeans;
import model.AccountDAO;
import model.ProductBeans;
import model.SeafoodDAO;

/**
 * Servlet implementation class AccountSearch
 */
@WebServlet("/AccountSearch")
public class AccountSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * アカウントがすでにある時用
     */
    public AccountSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("password");
		
        // login.jspから受け取ったログインIDとpassをビーンズにセット
        AccountBeans acb = new AccountBeans();
        acb.setLoginId(loginId);
        acb.setPass(pass);
        
        String inputPass = acb.getPass();
        
        
        //検索したアカウント情報を取得
        AccountDAO ad = new AccountDAO();
        AccountBeans returnAb = ad.findAccount(acb);
        
        
        String correctPass = returnAb.getPass();
        String userName = returnAb.getName();
        
          
        if(inputPass.equals(correctPass)) {
        	//セッションにアカウント情報を登録
        	HttpSession session = request.getSession();
        	
        	SeafoodDAO sfb = new SeafoodDAO();
        	SeafoodDAO.getConnection();
        	ArrayList<ProductBeans> list = sfb.searchAll();
        	
        	session.setAttribute("list", list);
        	
        	session.setAttribute("account", acb);   //★
        	
        	session.setAttribute("name", userName);
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/JSP/seafood.jsp");
        	rd.forward(request, response);
        } else {
        	RequestDispatcher rd = request.getRequestDispatcher("/JSP/error.jsp");
        	rd.forward(request, response);
        }
	}

}
