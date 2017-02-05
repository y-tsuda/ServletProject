package model;

import dao.AccountDao;

public class LoginLogic {

	public boolean execute(Login login){
		AccountDao dao = new AccountDao();
		Account account = dao.findByLogin(login);
		return account != null;
	}
	
}
