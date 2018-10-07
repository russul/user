package cn.scut.domain;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import cn.scut.user.dao.DaoFactory;
import cn.scut.user.dao.JdbcUtil;
import cn.scut.user.dao.UserDao;

public class Demo {

	public static void main(String[] args)  {
		UserDao userDao=DaoFactory.getUserDao();
		System.out.println(userDao);
		System.out.println(JdbcUtil.getConnection());
		Connection con=JdbcUtil.getConnection();
		java.sql.Statement s=null;
		try {
			s=con.createStatement();
			s.executeUpdate("insert into user values('djfs','jgkrdjf')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
