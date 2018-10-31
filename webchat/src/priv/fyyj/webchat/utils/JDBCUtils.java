package priv.fyyj.webchat.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 获取连接对象的工具类
 * @author fyyj
 *
 */
public class JDBCUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//获得连接池
	public static DataSource getDataSource() {
		return dataSource;
	}
	//获得连接
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
