package cn.scut.user.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.dom4j.DocumentException;

import cn.scut.domain.User;
import cn.scut.domain.User_login;

public class JdbcUserDaoImpl implements UserDao {

	@Override
	public User findByName(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			con = JdbcUtil.getConnection();
			System.out.println(con);
			String sql = "select *from user where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}
			//这里就需要把表中的数据转变成实体对象，而不能直接返回表对象
//			这就是ORM---->对象关系映射
			
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return user;
	}

	@Override
	public User_login findByNames(String username) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User_login user=new User_login();
		try {
			con=JdbcUtil.getConnection();
			String sql="select *from user where username=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			
			if (rs == null) {
				return null;
			}
			//这里就需要把表中的数据转变成实体对象，而不能直接返回表对象
//			这就是ORM---->对象关系映射
			
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}else{
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return user;
	}

	@Override
	public void add(User user) throws DocumentException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		// ResultSet rs=null;
		try {
			con = JdbcUtil.getConnection();
			String sql = "insert into user values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
