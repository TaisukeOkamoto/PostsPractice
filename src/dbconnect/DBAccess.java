package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {

	public static Connection getDBAccess() {
	    Connection con = null;
	    try {
	        // JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        // MySQLに接続
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_posts", "root", "password");
	        System.out.println("MySQLに接続できました。");

	    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
	        System.out.println("JDBCドライバのロードに失敗しました。");
	    } catch (SQLException e) {
	        System.out.println("MySQLに接続できませんでした。");
	    } finally {

	    }
		return con;
	}
}
