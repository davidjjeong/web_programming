package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class InsertBoardTest {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		//글 등록 처리
		BoardVO vo = new BoardVO();
		vo.setTitle("VO 패턴");
		vo.setWriter("테스터");
		vo.setContent("VO 패턴 테스트 중입니다.");
		boardDAO.insertBoard(vo);
		
		//글 목록 검색 처리
		boardDAO.getBoardList();
	}

}
