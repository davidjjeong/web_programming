package com.multicampus.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			//1. �ܰ� : ����̹� ��ü ���
			//DriverManager.registerDriver(new org.h2.Driver());
			Class.forName("org.h2.Driver");
			
			//2. �ܰ� : Ŀ�ؼ� ����
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""); //JDBC URL, ID, PW �� ������ �ݵ�� �ʿ�
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Statement stmt, Connection conn) {
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs = null;
		}
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt = null;
		}
		
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
