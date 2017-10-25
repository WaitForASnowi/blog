package pri.shen.daily.test;

import java.sql.SQLException;

import org.junit.Test;

import pri.shen.daily.dao.UserDao;
import pri.shen.daily.dao.impl.UserDaoImpl;
import pri.shen.daily.entity.User;

public class TestUserDao {
	private UserDao userDao;
	
	@Test
	public void testAdd() {
		userDao=new UserDaoImpl();
		User user=new User();
		user.setUsername("admin");
		user.setPassword("1234");
		try {
			userDao.add(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		userDao=new UserDaoImpl();
		try {
			User user=userDao.get("admin");
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
