package model;

import dao.AccountDao;

public class AccountLogic {

	public int execute(Account account) {

		AccountDao dao = new AccountDao();
		return dao.registerUser(account);

	}

}
