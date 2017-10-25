package pri.shen.daily.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pri.shen.daily.dao.UserDao;
import pri.shen.daily.entity.User;
import pri.shen.daily.util.DBUtil;

/**
 * @author ZhiqiangShen
 * 用户数据操作
 */
public class UserDaoImpl implements UserDao{
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void add(User user) throws MySQLIntegrityConstraintViolationException,SQLException {
		connection=DBUtil.getConnection();
		
		String sql="INSERT user_ (username,password) VALUES (?,?)";
		
		ps=connection.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.execute();
		
		DBUtil.closeResource(connection, ps, rs);
		
	}

	@Override
	public User get(String username) throws SQLException {
		connection=DBUtil.getConnection();
		
		String sql="SELECT user_id,password,identity FROM user_ WHERE username=?";
		
		ps=connection.prepareStatement(sql);
		ps.setString(1, username);
		rs=ps.executeQuery();
		
		User user=null;
		
		if(rs.next()) {
			user=new User();
			user.setUserId(rs.getLong(1));
			user.setUsername(username);
			user.setPassword(rs.getString(2));
			user.setIdentity(rs.getInt(3));
		}
		
		DBUtil.closeResource(connection, ps, rs);
		
		return user;
	}
	
}
