package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class UpdateBoardTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn = JDBCUtil.getConnection();
			
			//3. �ܰ� : Statement ����
			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			// ?�� �� ����
			stmt.setString(1,  "---���� ����");
			stmt.setString(2,  "---���� ����");
			stmt.setInt(3, 5);
			
			//4. �ܰ� : SQL ����
			int cnt = stmt.executeUpdate(); // SQL �ʿ� ����
			System.out.println(cnt + "�� ������ ó�� ����!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. �ܰ� : ���� ����
			JDBCUtil.close(stmt, conn);}
		}
	}

}
