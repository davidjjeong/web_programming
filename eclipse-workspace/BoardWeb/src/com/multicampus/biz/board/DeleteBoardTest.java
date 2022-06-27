package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class DeleteBoardTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn = JDBCUtil.getConnection();
			
			//3. �ܰ� : Statement ����
			String sql = "delete board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			// ?�� �� ����
			stmt.setInt(1, 5);
			
			//4. �ܰ� : SQL ����
			int cnt = stmt.executeUpdate(); // SQL �ʿ� ����
			System.out.println(cnt + "�� ������ ó�� ����!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. �ܰ� : ���� ����
			JDBCUtil.close(stmt, conn);
		}
	}

}
