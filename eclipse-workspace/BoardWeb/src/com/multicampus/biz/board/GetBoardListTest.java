package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class GetBoardListTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			conn = JDBCUtil.getConnection();
			
			//3. 단계 : Statement 생성
			String sql = "select * from board order by seq desc";
			stmt = conn.prepareStatement(sql);

			//4. 단계 : SQL 전송
			rs = stmt.executeQuery();
			System.out.println("게시 글 목록");
			
			while(rs.next()) {
				System.out.print(rs.getInt("SEQ") + " : ");
				System.out.print(rs.getString("TITLE") + " : ");
				System.out.print(rs.getString("WRITER") + " : ");
				System.out.print(rs.getString("CONTENT") + " : ");
				System.out.print(rs.getDate("REGDATE") + " : ");
				System.out.println(rs.getInt("CNT"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. 단계 : 연결 끊기
			JDBCUtil.close(rs, stmt, conn);
		}
	}

}
