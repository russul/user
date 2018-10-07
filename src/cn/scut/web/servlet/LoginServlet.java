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

import util.Common;
import cn.scut.domain.User_login;
import cn.scut.user.service.UserException;
import cn.scut.user.service.UserService;

public class LoginServlet extends HttpServlet {

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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserService();
		User_login user = null;

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
			user = (User_login) Common.toBean(map2, User_login.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		User_login _user = null;
		try {
			_user = userService.login(user);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/userpage/login.jsp").forward(
					request, response);
			return;
		}

		request.getSession().setAttribute("info",
				_user.getUsername() + ":" + _user.getPassword());
		response.sendRedirect("/user/userpage/index.jsp");

	}
}
