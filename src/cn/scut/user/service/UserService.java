package cn.scut.user.service;

import java.io.IOException;

import org.dom4j.DocumentException;

import cn.scut.domain.User;
import cn.scut.domain.User_login;
import cn.scut.user.dao.DaoFactory;
import cn.scut.user.dao.UserDao;

public class UserService {
	private UserDao userDao = DaoFactory.getUserDao();

	public void register(User user) throws UserException, IOException,
			DocumentException {

		if (user.getUsername().equals("")) {
			throw new UserException("用户名不能为空");
		} else if (!user.getUsername().matches(".{4,10}")) {
			throw new UserException("用户名为4-10个字符");
		} else if (user.getPassword().equals("")) {
			throw new UserException("密码不能为空");
		} else if (!user.getPassword().matches("\\w{6,}+")) {
			throw new UserException("密码不能少于6位数字或者英文字符");
		} else if (user.getVertifycode().equals("")) {
			throw new UserException("验证码不能为空");

		} else if (!user.getVertifycode().matches("\\w{4}")) {
			throw new UserException("验证码只能是4位");
		} else if (userDao.findByName(user.getUsername()) != null) {
			throw new UserException("用户名“" + user.getUsername() + "”已存在");

		} else {
			userDao.add(user);
		}
	}

	public User_login login(User_login user) throws UserException {
		if (user.getUsername().equals("")) {
			throw new UserException("用户名不能为空");
		} else if (!user.getUsername().matches(".{4,10}")) {
			throw new UserException("用户名为4-10个字符");
		} else if (user.getPassword().equals("")) {
			throw new UserException("密码不能为空");
		} else if (!user.getPassword().matches("\\w{6,}+")) {
			throw new UserException("密码不能少于6位数字或者英文字符");
		} else if (userDao.findByNames(user.getUsername()) == null) {
			throw new UserException("用户名或密码错误");

		} else {
			User_login _user = userDao.findByNames(user.getUsername());
			if (!_user.getPassword().equals(user.getPassword())) {
				throw new UserException("用户名或密码错误");
			}
			return user;
		}
		
	}
}
