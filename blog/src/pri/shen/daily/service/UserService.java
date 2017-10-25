package pri.shen.daily.service;

import java.sql.SQLException;

import pri.shen.daily.entity.User;
import pri.shen.daily.exception.LoginException;
import pri.shen.daily.exception.NullParamException;
import pri.shen.daily.exception.TypeNotMatchException;

/**
 * @author ZhiqiangShen
 * 与用户有关的业务逻辑
 */
public interface UserService {
	public User login(String usernameParam,String passwordParam) throws NullParamException, TypeNotMatchException, SQLException, LoginException;
	public void register(String usernameParam,String passwordParam) throws NullParamException, TypeNotMatchException, SQLException, LoginException;
}
