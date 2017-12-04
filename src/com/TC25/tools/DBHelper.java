package com.TC25.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Administrator
 *
 */
public class DBHelper {

	// --下节课 使用Properties配置文件.将四个常量移到配置文件中.
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String USER = "YICHAO";
	public static final String PWD = "19920310";

	Connection mConnection;

	/**
	 * 返回和数据库的连接对象.
	 * 
	 * @return
	 */
	public Connection getConnection() {
		if (mConnection == null) {
			try {
				// --为了纪念记忆.是可以不写的.目的是加载驱动.
				Class.forName(DRIVER);
				mConnection = DriverManager.getConnection(URL, USER, PWD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return mConnection;

	}

}
