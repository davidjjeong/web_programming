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
		
		//�� ��� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle("VO ����");
		vo.setWriter("�׽���");
		vo.setContent("VO ���� �׽�Ʈ ���Դϴ�.");
		boardDAO.insertBoard(vo);
		
		//�� ��� �˻� ó��
		boardDAO.getBoardList();
	}

}
