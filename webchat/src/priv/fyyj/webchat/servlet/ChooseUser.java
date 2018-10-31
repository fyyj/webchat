package priv.fyyj.webchat.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 选择user进行聊天
 * @author fyyj
 *
 */
@WebServlet(urlPatterns={"/choose"})
public class ChooseUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		String userName = req.getParameter("selectPerson");
		req.setAttribute("userName", userName);
		req.getRequestDispatcher("/select.jsp").forward(req, resp);
	}
}
