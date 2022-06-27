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
		BoardDAO boardDAO = new BoardDAO();
		
		//글 상세 정보 검색 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(4);
		
		BoardVO board = boardDAO.getBoard(vo);
		
		if(board != null) {
			System.out.println(board.getSeq() + "번 게시글 상세 정보");
			System.out.println(board.getTitle());
			System.out.println(board.getContent());
			System.out.println(board.getRegDate());
			System.out.println(board.getCnt());
		}else {
			System.out.println("검색 결과가 없습니다!");
		}
	}

}
