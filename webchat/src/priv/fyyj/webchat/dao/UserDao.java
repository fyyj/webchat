package priv.fyyj.webchat.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import priv.fyyj.webchat.domain.User;
import priv.fyyj.webchat.exception.RegistException;
import priv.fyyj.webchat.utils.JDBCUtils;

public class UserDao {
	QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	public User login(User user) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		return runner.query(sql,new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());		
	}
	public void regist(User user) throws  RegistException {
		String sql = "insert into user(username, password) values (?,?)";
		int row;
		try {
			row = runner.update(sql,user.getUsername(),user.getPassword());
			if(row==0) {
				throw new RegistException("注册失败");
			}
		} catch (SQLException e) {
			throw new RegistException("注册失败");
		}
		
	}
}
