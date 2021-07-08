package control.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminDAO;
import model.ProductBeans;

/**
 * Servlet implementation class AdUpdateComp
 */
@WebServlet("/AdUpdateComp")
public class AdUpdateComp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdateComp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		//データはすでに入っている状態なので、以下の長い処理は必要ない！(データが入ってないときだけset)
		ProductBeans pb = (ProductBeans)session.getAttribute("pb");
		
		System.out.println(pb.getPrice());
		System.out.println(pb.getId());
		
		//IdとPriceはString型にキャスト
//		int Id = p.getId();
//		String stId = String.valueOf(Id);
//		int Price = p.getPrice();
//		String stPrice = String.valueOf(Price);
//		
//		int id = Integer.parseInt(request.getParameter(stId));
//		String name = request.getParameter(p.getName());
//		int price = Integer.parseInt(request.getParameter(stPrice));
//		String exp = request.getParameter(p.getExp());
//		String fileName = request.getParameter(p.getFileName());
//			
//		
//		ProductBeans pb = new ProductBeans();
//		pb.setId(id);
//		pb.setName(name);
//		pb.setPrice(price);
//		pb.setExp(exp);
//		pb.setFileName(fileName);
		
		AdminDAO ad = new AdminDAO();
		ad.updateData(pb);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/mente/AdUpdateComp.jsp");
		dispatch.forward(request, response);
	}

}
