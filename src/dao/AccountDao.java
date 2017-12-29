package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDao extends CommonMySQLDAO {

	public Account findByLogin(Login login) {
		Account account = null;
		String sql = "SELECT id, password, mail, name" + " FROM account WHERE id = ? AND password = ?";
		PreparedStatement psmt;
		try {
			psmt = getPreparedStatement(sql);

			psmt.setString(1, login.getId());
			psmt.setString(2, login.getPassword());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				String userId = rs.getString("id");
				String pass = rs.getString("password");
				String mail = rs.getString("mail");
				String name = rs.getString("name");

				account = new Account(userId, pass, mail, name);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return account;
	}

	public int registerUser(Account account) {
		int count = 0;
		try {
			String sql = " INSERT INTO account VALUES (?,?,?,?,now(),now())";
			PreparedStatement psmt = getPreparedStatement(sql);
			psmt.setString(1, account.getId());
			psmt.setString(2, account.getPassword());
			psmt.setString(3, account.getMail());
			psmt.setString(4, account.getName());

			count = psmt.executeUpdate();

			super.commit();

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return count;
	}

}
