package pri.shen.daily.dao;

import java.sql.SQLException;

import pri.shen.daily.entity.User;

/**
 * @author ZhiqiangShen
 * �û����ݲ���
 */
public interface UserDao {
	public void add(User user) throws SQLException;
	public User get(String username) throws SQLException;
}
