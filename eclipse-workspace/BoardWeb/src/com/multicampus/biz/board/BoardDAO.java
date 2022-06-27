package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.multicampus.biz.common.JDBCUtil;

// DAO(Data Access Object) Ŭ����
public class BoardDAO {
	//JDBC ���� ���� ����
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//BOARD ���� SQL ����
	private String board_insert = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private String board_update = "update board set title = ?, content = ? where seq = ?";
	private String board_delete = "delete board where seq = ?";
	private String board_get	= "select * from board where seq = ?";
	private String board_list	= "select * from board order by seq desc";
	
	//BOARD ���� CRUD �޼ҵ� ����
	//�� ���
	public void insertBoard(BoardVO vo) {
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(board_insert);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//�� ����
	public void updateBoard(BoardVO vo) {
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(board_update);
			
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//�� ����
	public void deleteBoard(BoardVO vo) {
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(board_delete);
			
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//�� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(board_get);
			stmt.setInt(1,vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	
	//�� ��� �˻�
	public void getBoardList() {
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(board_list);
			rs = stmt.executeQuery();
			System.out.println("�Խ� �� ���");
			
			while(rs.next()) {
				System.out.print(rs.getInt("SEQ") + " : ");
				System.out.print(rs.getString("TITLE") + " : ");
				System.out.print(rs.getString("WRITER") + " : ");
				System.out.print(rs.getString("CONTENT") + " : ");
				System.out.print(rs.getDate("REGDATE") + " : ");
				System.out.println(rs.getInt("CNT"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(board_list);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}
