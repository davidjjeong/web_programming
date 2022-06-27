package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.multicampus.biz.common.JDBCUtil;

public class GetBoardListTest {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		//�� ��� �˻� ó��
		BoardVO vo = new BoardVO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// CASE - 1
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		/*
		// CASE - 2
		for(BoardVO board : boardList) {
			System.out.println(board.getSeq() + " : " + board.getTitle());
		}
		
		// CASE - 3
		System.out.println("�˻��� ������ �� : " + boardList.size() + "��"); */
	}

}
