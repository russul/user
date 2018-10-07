package cn.scut.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import cn.scut.domain.User;
import cn.scut.user.service.UserException;
import cn.scut.user.service.UserService;
import util.Common;

;

public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 封装数据
		// String username = request.getParameter("username");
		// String password = request.getParameter("password");
		// User user = new User();
		// user.setUsername(username);
		// user.setPassword(password);
		User user = new User();

		// 去掉用户打的首尾空格
		Map<String, String[]> map = request.getParameterMap();// 不能修改，被服务器锁定
		Map<String, String[]> map2 = new HashMap<String, String[]>();
		Set<String> key = map.keySet();
		for (Iterator<String> it = key.iterator(); it.hasNext();) {
			String eachkey = it.next();
			String[] ss = map.get(eachkey);
			String[] s = ss.clone();

			for (int i = 0; i < ss.length; i++) {

				s[i] = ss[i].trim();

			}
			map2.put(eachkey, s);
		}

		try {
			user = (User) Common.toBean(map2, User.class);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// 自己写的工具jar包（myutil.jar）

		String vc = (String) request.getSession().getAttribute("session_vcode");

		request.getSession().removeAttribute("session_vcode");
		if (!user.getVertifycode().equalsIgnoreCase(vc)) {

			request.setAttribute("msg", "请输入正确的验证码");
			request.getRequestDispatcher("userpage/register.jsp").forward(
					request, response);
			return;
		}

		UserService userService = new UserService();
		try {
			userService.register(user);
		} catch (UserException e) {
			// System.out.println(e.getMessage());
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("userpage/register.jsp").forward(
					request, response);

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getSession().setAttribute("success", "注册成功，请您登录");
		response.sendRedirect("/user/userpage/login.jsp");

	}
}
