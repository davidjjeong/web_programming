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
		
		//臂 昏力 贸府
		BoardVO vo = new BoardVO();
		vo.setSeq(3);
		boardDAO.deleteBoard(vo);
		
		//臂 格废 八祸 贸府
		boardDAO.getBoardList();
	}

}
