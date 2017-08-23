package com.situ.shixun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentTest {
	public static void main(String[] args) {
		/*Student student = new Student("zs", 28, "男", "市南");
		addStudent(student);*/
		findAll();
	}

	private static void findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		//1、加载驱动 Class.forNmae("");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2、获取连接对象Connection。
		try {
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/java1707", "root", "root");
			//3、写sql语句。
			String sql = "SELECT * FROM student;";
			//4、创建Satement。
			statement = connection.prepareStatement(sql);
			//5、执行sql语句。
			//  更新：delete/update/insert   executeUpdate   返回值int表示影响的行数。
			//  查询：select                         executeQuery       返回结果集ResultSet。
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, name, age, gender, address);
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
