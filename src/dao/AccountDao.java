package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDao {

	public Account findByLogin(Login login){
		Connection conn = null;
		Account account = null;
		String url = "jdbc:mysql://192.168.56.100/mydb";
		String user = "root";
		String password = "password";
		try{
			// JDBCドライバ読み込み
			Class.forName("com.mysql.jdbc.Driver");
			// データベース接続
			conn = DriverManager.getConnection(url, user, password);
			String sql = "SELECT id, password, mail, name"
					+ " FROM Account WHERE id = ? AND password = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, login.getId());
			psmt.setString(2, login.getPassword());
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()){
				String userId = rs.getString("id");
				String pass = rs.getString("password");
				String mail = rs.getString("mail");
				String name = rs.getString("name");
				
				account = new Account(userId, pass, mail, name);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return null;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return account;
	}
	
	public int registerUser(Account account){
		Connection conn = null;
		String url = "jdbc:mysql://192.168.56.100/mydb";
		String user = "root";
		String password = "password";
		int count = 0;
		try{
			// JDBCドライバ読み込み
			Class.forName("com.mysql.jdbc.Driver");
			// データベース接続
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); 
			String sql = " INSERT INTO Account VALUES (?,?,?,?,now(),now())";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, account.getId());
			psmt.setString(2, account.getPassword());
			psmt.setString(3, account.getMail());
			psmt.setString(4, account.getName());
			
			count = psmt.executeUpdate();
			
			conn.commit();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
}
