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

import model.AdminBeans;
import model.AdminDAO;
import model.ProductBeans;
import model.SeafoodDAO;

/**
 * Servlet implementation class Admin
 */
@WebServlet({ "/Admin", "/watanabe" })
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);  //Post使うときも書いておいたほうががいい。
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		
		String inputId = request.getParameter("loginId");
		String inputPass = request.getParameter("password");
		
		System.out.println(inputId);
		
		AdminDAO.getConnection();  //staticクラスだから
		
		HttpSession session = request.getSession();
		
		//一覧表示部分
    	SeafoodDAO sfb = new SeafoodDAO();
    	SeafoodDAO.getConnection();
    	ArrayList<ProductBeans> list = sfb.searchAll();
    	
    	session.setAttribute("list", list);
		
		//情報セキュリティのしかけ
		if (inputId == null || inputPass == null) {
			System.out.println("nullです");
			String message = "不正アクセスの可能性があります。";
			session.setAttribute("message", message);
			System.out.println("動作確認、ここまで");		

        	url = "/mente/login.jsp";
        	  			
		} 
		
		System.out.println("動作確認");		
		
        // login.jspから受け取ったログインIDとpassをビーンズにセット
//        AdminBeans amb = new AdminBeans();
//        amb.setLoginId(loginId);
//        amb.setPassword(pass);
//        
//        String inputId = amb.getLoginId();
//        String inputPass = amb.getPassword();
        
        
        //検索したアカウント情報を取得
        AdminDAO ad = new AdminDAO();
        AdminBeans returnAmb = ad.findAccount(inputId);	
        if (returnAmb == null) {  //セキュリティ
        	String message = "失敗しました。IDまたはパスワードが違います。";
        	session.setAttribute("message", message);
        	
        	url = "/mente/login.jsp";
                	
        } else {
        	
	        String correctId = returnAmb.getLoginId();
	        String correctPass = returnAmb.getPassword();
	        
	        System.out.println(inputId);
	        System.out.println(inputPass);
	        
	        
	        if (inputId.equals(correctId) && inputPass.equals(correctPass)) {
	        	AdminBeans amb = new AdminBeans();
	        	
	        	session.setAttribute("amb", amb);
	        	
	        	String message = "ログインしました";
	        	session.setAttribute("message", message);
	        
	        	url = "/mente/AdloginOk.jsp";
	        	        	
	        } else {
	        	String message = "失敗しました。IDまたはパスワードが違います。";
	        	session.setAttribute("message", message);
	        	
	        	url = "/mente/login.jsp";
	        }
        }
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	 }
	
}
