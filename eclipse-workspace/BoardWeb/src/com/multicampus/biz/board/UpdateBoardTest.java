package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class UpdateBoardTest {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		//글 수정 처리
		BoardVO vo = new BoardVO();
		vo.setContent("내용이 수정되었습니다");
		vo.setTitle("내용 수정 처리");
		vo.setSeq(3);
		boardDAO.updateBoard(vo);
		
		//글 상세 조회 처리
		boardDAO.getBoardList();
	}

}
