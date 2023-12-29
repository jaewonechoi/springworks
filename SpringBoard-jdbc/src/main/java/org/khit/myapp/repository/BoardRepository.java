package org.khit.myapp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.springframework.stereotype.Repository;


@Repository
public class BoardRepository {
	
	Connection conn = null; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//글쓰기 처리
	public void save(BoardDTO board) {
		
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into boards(boardtitle, boardwriter, boardcontent) "
					+ "values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardWriter());
			pstmt.setString(3, board.getBoardContent());
						
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}	
	}
	
	public List<BoardDTO> getListAll(){
		List<BoardDTO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from boards order by id desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setId(rs.getLong("id"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardContent(rs.getString("boardContent"));
				board.setCreatedTime(rs.getTimestamp("createdTime"));
				
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}

	public BoardDTO findById(Long id) {
		BoardDTO board = new BoardDTO();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from boards where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setId(rs.getLong("id"));
				board.setBoardTitle(rs.getString("boardTitle"));
				board.setBoardWriter(rs.getString("boardWriter"));
				board.setBoardContent(rs.getString("boardContent"));
				board.setCreatedTime(rs.getTimestamp("createdTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
	}
	
	//글 삭제
	public void delete(Long id) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from boards where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
						
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}	
	}

	public void update(BoardDTO board) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update boards set boardtitle = ?, boardcontent = ? "
					+ "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setLong(3, board.getId());
						
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
}
