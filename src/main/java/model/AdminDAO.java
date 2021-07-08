package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO {
static Connection con = null;
String tableName = "product";
String tableName2 = "admin";
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
	
    public AdminBeans findAccount(String ab) { //AccountBeans型

    	//AdminBeans returnAb = new AdminBeans();
    	AdminBeans returnAb = null;
    	
        try { 
            
        	String sql = "SELECT * FROM admin WHERE loginId=?";  //WHEREでとってきて？つけてるから、5項目のうちひとりが選ばれていることになる
            
        	PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ab);  //?に入れる用,きまり	

            rs = ps.executeQuery();
            
            
            if(rs.next()) {
            	returnAb = new AdminBeans(
            	rs.getString("loginId"),
            	rs.getString("password")
            			);
            } else {
            	//アカウントがなければnullを返す
            	return null;
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.out.println("データベース接続に失敗しました。");
        	return null;        //参照型の場合戻り値が必要→戻り値がなくてもnull書いておく
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return returnAb;
    }
    
	public void insertData(ProductBeans pb) {
		try {
		String sql = "INSERT INTO product (name, price, exp, fileName) VALUES (?, ?, ?, ?)";
//		String sql = "INSERT INTO product_copy (name, price, exp, fileName) VALUES (?, ?, ?, ?)";
			
		PreparedStatement ps= con.prepareStatement(sql);
//		Statement stmt = con.createStatement();
        ps.setString(1, pb.getName());
        ps.setInt(2, pb.getPrice());
        ps.setString(3, pb.getExp());
        ps.setString(4, pb.getFileName());
        
        System.out.println(pb.getPrice());
        
		System.out.println("Commit = " + con.getAutoCommit());
		
			//int check = 
					ps.executeUpdate();
					
		System.out.println("Commit = " + con.getAutoCommit());			
//			if (check != 0) {
//				System.out.println("データの挿入に成功しました...");				
//			} else {
//				System.out.println("データの挿入に失敗しました...");
//			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(int id) {
		try {
			String sql = "DELETE FROM " + tableName + " WHERE id=?";
			
			PreparedStatement ps= con.prepareStatement(sql);
			
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i == 0) {
				System.out.println("データの削除に失敗しました");
			} else {
				System.out.println("成功しました。");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(ProductBeans pb) {
		try {
			String sql = "UPDATE " + tableName + " SET name = ?, price = ?, exp = ?, fileName = ? WHERE id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getPrice());
			ps.setString(3, pb.getExp());
			ps.setString(4, pb.getFileName());
			ps.setInt(5, pb.getId());
			
//			System.out.println(pb.getPrice());
//			System.out.println(pb.getId());
			
			int i = ps.executeUpdate();
			if (i == 0) {
				System.out.println("データの更新に失敗しました");
			} else {
				System.out.println("成功しました。");
			}
			
		} catch(Exception e) {
			System.out.println("データの更新に失敗しました。(catch)");
			e.printStackTrace();
		}
	}
}
