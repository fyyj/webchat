package priv.fyyj.webchat.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import priv.fyyj.webchat.domain.User;
import priv.fyyj.webchat.exception.RegistException;
import priv.fyyj.webchat.service.UserService;
@WebServlet(urlPatterns={"/regist"})
public class RegistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user = new User();
		try {
			BeanUtils.populate(user, req.getParameterMap());
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UserService service = new UserService();
		try {
			service.regist(user);
			req.setAttribute("regist", "注册成功");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RegistException e) {
			req.setAttribute("regist", e.getMessage());
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}
	}
}
