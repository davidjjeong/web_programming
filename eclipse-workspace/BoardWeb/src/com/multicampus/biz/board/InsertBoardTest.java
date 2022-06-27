package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class InsertBoardTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn = JDBCUtil.getConnection();
			
			//3. �ܰ� : Statement ����
			String sql = "insert into board(seq, title, writer, content) " + 
					 	 "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			
			// ?�� �� ����
			stmt.setString(1,  "JDBC �׽�Ʈ");
			stmt.setString(2,  "�׽���");
			stmt.setString(3,  "JDBC �׽�Ʈ���Դϴ�...");
			
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
