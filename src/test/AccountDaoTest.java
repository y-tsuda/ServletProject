package test;

import dao.AccountDao;
import model.Account;
import model.Login;

public class AccountDaoTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testFindByLogin1();
		testFindByLogin2();
	}
	
	public static void testFindByLogin1(){
		Login login = new Login("minato", "1234");
		AccountDao dao = new AccountDao();
		Account result = dao.findByLogin(login);
		if(result != null){
			System.out.println("login成功");
		}
	}
	
	public static void testFindByLogin2(){
		Login login = new Login("minato", "12345");
		AccountDao dao = new AccountDao();
		Account result = dao.findByLogin(login);
		if(result == null){
			System.out.println("login成功");
		}
	}

}
