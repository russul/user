package cn.scut.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vertifycode.VertifyCode;

public class VertifyCodeServlet extends HttpServlet {
//处理显示验证码的请求
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VertifyCode vc=new VertifyCode();
		BufferedImage image = vc.getImage();
		request.getSession().setAttribute("session_vcode", vc.getText());
		try {
			vc.output(image, response.getOutputStream());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
