package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbconnect.DBAccess;

public class User {

	private int id;
	private String password;
	private String mail;
	private String name;


	public User(int id, String password, String mail,String name) {
		super();
		this.id = id;
		this.password = password;
		this.mail = mail;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 全ユーザーのリストを取得
	 * @return
	 */
	public static ArrayList<User> getUserList() {

		ArrayList<User> userList = null;
		Connection conn = null;
		try {
			 conn = DBAccess.getDBAccess();

			Statement stm = conn.createStatement();
			String sql = "select * from user";

			ResultSet rs = stm.executeQuery(sql);

			userList = new ArrayList<User>();

			while(rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String mail = rs.getString("mail");
				String name = rs.getString("name");
				User user = new User(id,password,mail,name);
				userList.add(user);
			}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("SQLException:" + e.getMessage());
				}
			}
			return userList;
	}

	/**
	 *受け取ったIDのユーザー削除
	 * @return
	 */
	public static ArrayList<User> DeleteUser(int userId) {
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = null;
		try {
			conn = DBAccess.getDBAccess();

			String sql = "delete from user where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

			userList = getUserList();

			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}finally {
				try {
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					System.out.println("SQLException:" + e.getMessage());
				}
			}
			return userList;
	}

}
