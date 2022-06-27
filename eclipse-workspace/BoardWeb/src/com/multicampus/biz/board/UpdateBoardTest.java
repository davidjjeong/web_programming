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
			
			//3. 단계 : Statement 생성
			String sql = "update board set title = ?, content = ? where seq = ?";
			stmt = conn.prepareStatement(sql);
			
			// ?에 값 설정
			stmt.setString(1,  "---수정 제목");
			stmt.setString(2,  "---수정 내용");
			stmt.setInt(3, 5);
			
			//4. 단계 : SQL 전송
			int cnt = stmt.executeUpdate(); // SQL 필요 없음
			System.out.println(cnt + "건 데이터 처리 성공!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5. 단계 : 연결 끊기
			JDBCUtil.close(stmt, conn);}
		}
	}

}
