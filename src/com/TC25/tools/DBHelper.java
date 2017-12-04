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

	// --�½ڿ� ʹ��Properties�����ļ�.���ĸ������Ƶ������ļ���.
	public static final String DRIVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static final String USER = "YICHAO";
	public static final String PWD = "19920310";

	Connection mConnection;

	/**
	 * ���غ����ݿ�����Ӷ���.
	 * 
	 * @return
	 */
	public Connection getConnection() {
		if (mConnection == null) {
			try {
				// --Ϊ�˼������.�ǿ��Բ�д��.Ŀ���Ǽ�������.
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
