package pri.shen.daily.service.impl;

import java.sql.SQLException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import pri.shen.daily.dao.UserDao;
import pri.shen.daily.dao.impl.UserDaoImpl;
import pri.shen.daily.entity.User;
import pri.shen.daily.exception.LoginException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;
import pri.shen.daily.service.UserService;
import pri.shen.daily.util.ValidUtil;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}
	
	@Override
	public User login(String usernameParam, String passwordParam) throws NullParamException, TypeNotMatchException, SQLException, LoginException {
		User loginUser=ValidUtil.validUser(usernameParam, passwordParam);
		User realUser=userDao.get(loginUser.getUsername());
		if(realUser==null) {
			throw new LoginException("当前用户不存在");
		}
		
		if(realUser.getPassword().equals(loginUser.getPassword())) {
			return realUser;
		}else {
			throw new LoginException("密码错误");
		}
		
	}

	@Override
	public void register(String usernameParam, String passwordParam) throws NullParamException, TypeNotMatchException, SQLException, LoginException {
		User user=ValidUtil.validUser(usernameParam, passwordParam);
		try {
			userDao.add(user);
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new LoginException("当前用户名已经被注册");
		}
	}

}
