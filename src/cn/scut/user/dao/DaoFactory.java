package cn.scut.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	public static UserDao getUserDao(){
		InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream(
				"dao.properties");
		Properties prop = new Properties();

		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userDaoImplName = prop.getProperty("cn.scut.user.dao.UserDao");
		Class clazz=null;
		try {
			clazz=Class.forName(userDaoImplName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao userDao=null;
		
		try {
			userDao=(UserDao)clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return userDao;
	}
	
}
