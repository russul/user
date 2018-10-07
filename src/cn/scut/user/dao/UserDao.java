package cn.scut.user.dao;

import java.io.IOException;

import org.dom4j.DocumentException;

import cn.scut.domain.User;
import cn.scut.domain.User_login;

public interface UserDao {
	User findByName(String username);
	User_login findByNames(String username);
	void add(User user) throws DocumentException, IOException;
}
