package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    
    //ログインアカウントを探す
    public AccountBeans findAccount(AccountBeans ab) { //AccountBeans型
    	String dbName = "shop";
    	
    	AccountBeans returnAb = new AccountBeans();
    	
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	
        	Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/" + dbName, "root", "scc1449scc"); 
            
        	String sql = "SELECT * FROM customer WHERE loginId=?";  //WHEREでとってきて？つけてるから、5項目のうちひとりが選ばれていることになる
            
        	PreparedStatement ps= con.prepareStatement(sql);
        	
        	//System.out.println("データベース接続に成功しました。★");

            ps.setString(1, ab.getLoginId());

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
            	returnAb.setLoginId(rs.getString("loginId"));
            	returnAb.setPass(rs.getString("password"));
            	returnAb.setName(rs.getString("name"));
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
}
