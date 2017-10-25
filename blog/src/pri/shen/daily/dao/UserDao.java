package pri.shen.daily.dao;

import java.sql.SQLException;

import pri.shen.daily.entity.User;

/**
 * @author ZhiqiangShen
 * 用户数据操作
 */
public interface UserDao {
	public void add(User user) throws SQLException;
	public User get(String username) throws SQLException;
}
