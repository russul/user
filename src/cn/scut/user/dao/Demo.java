package cn.scut.user.dao;

import cn.scut.domain.User;



public class Demo {

	public static void main(String[] args) throws Exception{
		UserDao userDao=new UserDaoImpl();

		System.out.println(userDao.findByName("张三").toString());
		
		User user =new User();
		user.setUsername("李四");
		user.setPassword("sjdsk");
		
		userDao.add(user);
	
		System.out.println(userDao.findByName("李四").toString());
	}

}
