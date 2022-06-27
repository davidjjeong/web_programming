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
			
			//3. 단계 : Statement 생성
			String sql = "select * from board where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			//? 값 설정
			//int seq = Integer.parseInt(args[0]);
			int seq = 3;
			stmt.setInt(1,seq);

			//4. 단계 : SQL 전송
			rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println(seq + "번 게시 글 상세 정보");
				System.out.println("제목 : " + rs.getString("TITLE"));
				System.out.println("작성자 : " + rs.getString("WRITER"));
				System.out.println("내용 : " + rs.getString("CONTENT"));
				System.out.println("등록일 : " + rs.getDate("REGDATE"));
				System.out.println("조회수 : " + rs.getInt("CNT"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. 단계 : 연결 끊기
			JDBCUtil.close(rs, stmt, conn);
		}
	}

}
