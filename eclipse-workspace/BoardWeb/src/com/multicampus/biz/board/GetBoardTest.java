package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class GetBoardTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = JDBCUtil.getConnection();
			
			//3. �ܰ� : Statement ����
			String sql = "select * from board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			//? �� ����
			//int seq = Integer.parseInt(args[0]);
			int seq = 3;
			stmt.setInt(1,seq);

			//4. �ܰ� : SQL ����
			rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println(seq + "�� �Խ� �� �� ����");
				System.out.println("���� : " + rs.getString("TITLE"));
				System.out.println("�ۼ��� : " + rs.getString("WRITER"));
				System.out.println("���� : " + rs.getString("CONTENT"));
				System.out.println("����� : " + rs.getDate("REGDATE"));
				System.out.println("��ȸ�� : " + rs.getInt("CNT"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. �ܰ� : ���� ����
			JDBCUtil.close(rs, stmt, conn);
		}
	}

}
