package priv.fyyj.webchat.service;

import java.sql.SQLException;

import priv.fyyj.webchat.dao.UserDao;
import priv.fyyj.webchat.domain.User;
import priv.fyyj.webchat.exception.RegistException;

public class UserService {
	UserDao dao = new UserDao();
	public User login(User user) throws SQLException {
		return dao.login(user); 
	}
	public void regist(User user) throws SQLException, RegistException {
		dao.regist(user);		
	}

}
