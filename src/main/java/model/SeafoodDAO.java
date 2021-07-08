package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class SeafoodDAO implements Serializable {
static Connection con = null;
String tableName = "product";
String tableName2 = "customer";
static Statement stmt = null;
private ResultSet rs = null;


	

	public static Connection getConnection() {
		String dbName = "shop";
		if(con == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				
				con = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/" + dbName, "root", "scc1449scc");
				stmt = con.createStatement();
				System.out.println("データベースと接続しました...");
			} catch(Exception e) {
				System.out.println("データベース接続に失敗しました。");
				e.printStackTrace();
			}
		}
		return con;
	}	
	
	public ArrayList<ProductBeans> searchAll() {   //ここでProductからもらってくるから
		ArrayList<ProductBeans> list = new ArrayList<>();
		
		String sql = "SELECT * FROM " + tableName;
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
//			int id = rs.getInt(1);   //	こっちの方が丁寧
//			String name = rs.getString(2);
//			int price = rs.getInt(3);
//			Product p = new Product(id, name, price);
				ProductBeans p = new ProductBeans(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5)
						);
				list.add(p);
			}	
		} catch (Exception e) {
			System.out.println("SELECT文の実行に失敗しました");
			e.printStackTrace();
		}
		return list;
	}
	
	public ProductBeans search(String id) {
		ProductBeans p = null;
		String sql = "SELECT * FROM " + tableName + " WHERE id=" + id;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
//				int id2 = rs.getInt(1);
//				String name = rs.getString(2);
//				int price = rs.getInt(3);
//				String exp = rs.getString(4);
//				String fileName = rs.getString(5);
//				Product p = new Product(id2, name, price, exp, fileName);
				p = new ProductBeans(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5)
						);
			}
		} catch (Exception e) {
			System.out.println("SELECT文の実行に失敗しました");
			e.printStackTrace();
		}
		return p;
	}
	
	public ArrayList<ProductBeans> kensaku(String keyword) {
		ArrayList<ProductBeans> key = new ArrayList<>();
		
		String sql = "SELECT * FROM " + tableName + " WHERE name like ?";
		
		try {			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, "%"+keyword+"%");   //"%"+aaa+"%"でaaaが?だと認識される。このセット。
			
			rs = ps.executeQuery();
			
            while(rs.next()) {
            	ProductBeans p = new ProductBeans(  //引数ありコンストラクタがあるから、newしたときに値はセットされている
	            	rs.getInt("id"),
	            	rs.getString("name"),
	            	rs.getInt("price"),
	            	rs.getString("exp"),
	            	rs.getString("fileName")
            			);
            		key.add(p);
            		
            		
            } 			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	public void closeConnection() {
			if(con != null) {
				try {
					con.close();
					con = null; //ガベージコレクション		
					System.out.println("接続を中断しました...");
				} catch (Exception e) {
					System.out.println(e.toString());				
				}
			}
	}

}
