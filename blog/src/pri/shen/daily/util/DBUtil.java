package pri.shen.daily.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static final String USER="root";
	private static final String PASSWORD="1234";
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/daily";
	private static final int ACQUIRE_RETRY_ATTEMPTS=2;
	private static final int INIT_POOL_SIZE=5;
	private static final int MIN_POOL_SIZE=5;
	private static final int MAX_POOL_SIZE=20;
	private static final int CHECKOUT_TIMEOUT=8000;
	
	private static ComboPooledDataSource dataSource;
	
	static {
		dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(DRIVER_CLASS);
			dataSource.setUser(USER);
			dataSource.setPassword(PASSWORD);
			dataSource.setJdbcUrl(JDBC_URL);
			dataSource.setAcquireRetryAttempts(ACQUIRE_RETRY_ATTEMPTS);
			dataSource.setInitialPoolSize(INIT_POOL_SIZE);
			dataSource.setMinPoolSize(MIN_POOL_SIZE);
			dataSource.setMaxPoolSize(MAX_POOL_SIZE);
			dataSource.setCheckoutTimeout(CHECKOUT_TIMEOUT);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void closeResource(Connection connection,PreparedStatement ps,ResultSet rs) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(ps!=null) {
			ps.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
	
}
