package priv.fyyj.webchat.domain;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * 用户实体类
 * @author fyyj
 *
 */
public class User implements HttpSessionBindingListener {
	private int id;
	private String username;
	private String password;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	/**
	 * 当对象和session绑定的时候,即setAttribute时
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(username+"进入了....");
		HttpSession session = event.getSession();
		//获得人员列表的map
		Map<User, HttpSession> userMap = (Map<User, HttpSession>) session
				.getServletContext().getAttribute("userMap");
		//将用户添加到map里
		userMap.put(this, session);		
	}
	/**
	 * 当对象和session接触绑定的时候
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(username+"退出了....");
		HttpSession session = event.getSession();
		// 获得人员列表
		Map<User, HttpSession> userMap = (Map<User, HttpSession>) session
				.getServletContext().getAttribute("userMap");
		// 将用户移除
		userMap.remove(this);		
	}
	@Override
	public String toString() {
		return "id=" + id + "username=" + username + "password=" + password +"type=" + type;
	}
}
