package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.multicampus.biz.common.JDBCUtil;

public class DeleteBoardTest {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		
		//�� ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(3);
		boardDAO.deleteBoard(vo);
		
		//�� ��� �˻� ó��
		boardDAO.getBoardList();
	}

}
