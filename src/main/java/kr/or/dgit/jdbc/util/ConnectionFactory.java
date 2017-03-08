package kr.or.dgit.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final ConnectionFactory instance = new ConnectionFactory();
	
	public static Connection getConnection(){
		return instance.createConnection();
	}

	public Connection createConnection() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mybatis";
			String user = "user_mybatis";
			String password = "rootroot";
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public ConnectionFactory(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL Driver not Found!!");
			System.exit(-1);
		}
	}	// end of class
}
