package pri.shen.daily.test;

import java.sql.SQLException;


import org.junit.Test;

import pri.shen.daily.entity.User;
import pri.shen.daily.exception.LoginException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.service.UserService;
import pri.shen.daily.service.impl.UserServiceImpl;

public class TestUserService {
	private UserService userService=new UserServiceImpl();
	
	@Test
	public void testLogin() {
		try {
			User user=userService.login("admin3", "12345");
			System.out.println(user);
		} catch (LoginException | SQLException | NullParamException | TypeNotMatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRegister() {
		try {
			userService.register("admin1", "1234");
		} catch (SQLException | NullParamException | TypeNotMatchException | LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
