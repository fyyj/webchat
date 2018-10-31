package priv.fyyj.webchat.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws 
		ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;chatset=utf-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		String methodName = req.getParameter("method");
		Class c = this.getClass();
		try {
			Method m = c.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//			System.out.println(m);
			String result = (String)m.invoke(this, req, resp);
//			System.out.println(result);
			if(result != null && !result.isEmpty()) {
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
