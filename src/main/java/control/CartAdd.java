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

/**
 * Servlet implementation class CartAddAction
 */
@WebServlet("/CartAddAction")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");   
		
		HttpSession session = request.getSession();	
		
		ArrayList<ProductBeans> cart = (ArrayList)session.getAttribute("cart");
		if (cart == null) {  //初回
			cart = new ArrayList<ProductBeans>();  //これ使う
		}
		
//		ProductBeans p = new ProductBeans();   //引数ありコンストラクタのおかげで、setint,setStringなどは完了済み
//		p.setId(id);  
		
		SeafoodDAO sfb = new SeafoodDAO();  
		ProductBeans p = sfb.search(id);
		
		
		cart.add(p);
		
		session.setAttribute("cart", cart);
		
		System.out.println("カートに商品を追加しました。");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/JSP/cartGet.jsp");
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
