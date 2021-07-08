package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AccountRegisterDAO {
	static Connection con = null;
	
	 final String jdbcId = "root";
     final String jdbcPass = "password";
     final String jdbcUrl = "jdbc:mariadb://localhost:3306/";
     
     
     //コンストラクタ(引数あり)→メソッド呼び出しではなく、インスタンス化したときに中の命令が実行される
     public AccountRegisterDAO(AccountBeans ab) {
    	 String dbName = "shop";
    	 
    	 try {
    		 Class.forName("org.mariadb.jdbc.Driver");
    		 
    		 con = DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/" + dbName, "root", "scc1449scc");
    		 
             String sql = "INSERT INTO customer (loginId, password, name) VALUES (?, ?, ?)";
             
             PreparedStatement ps= con.prepareStatement(sql);

             ps.setString(1, ab.getLoginId());
             ps.setString(2, ab.getPass());
             ps.setString(3, ab.getName());
             
             int r = ps.executeUpdate();
             
             if(r != 0) {
            	 System.out.println("新規登録成功！");
             } else {
            	 System.out.println("新規登録失敗...");
             }
    	 } catch (Exception e) {
    		 e.printStackTrace();
    	 }
     }
}
