package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	static Connection con;
	private static final String DB_DRIVER="org.postgresql.Driver";
	private static final String DB_CONNECTION="jdbc:postgresql://ec2-44-194-92-192.compute-1.amazonaws.com/d8f75dvcudno1t";
	private static final String DB_USER="imguxthqgzxctp";
	private static final String DB_PASSWORD="65e0c20ac84dd080ed89ff71e0e75299aa31962e3aec8c49e4ec5216ad0f5eef";
	
	public static Connection getConnection() {
		try {
			//load the driver
			Class.forName(DB_DRIVER);
			
			try {
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		return con;
	}
}
