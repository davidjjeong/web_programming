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
		
		//�� �� ���� �˻� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(4);
		
		BoardVO board = boardDAO.getBoard(vo);
		
		if(board != null) {
			System.out.println(board.getSeq() + "�� �Խñ� �� ����");
			System.out.println(board.getTitle());
			System.out.println(board.getContent());
			System.out.println(board.getRegDate());
			System.out.println(board.getCnt());
		}else {
			System.out.println("�˻� ����� �����ϴ�!");
		}
	}

}
