package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnector;
import com.choa.util.RowMaker;

@Repository // NoticeDAO noticeDAO = new noticeDAO();
public class NoticeDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "NoticeMapper.";
	
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", rowMaker);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		/*Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		NoticeDTO noticeDTO = null;
		
		String sql = "select * from notice where num=?";
		
		st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		rs = st.executeQuery();
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return noticeDTO;*/
		
		return sqlSession.selectOne(NAMESPACE + "view", num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "write", boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", num);
	}

	@Override
	public int boardCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "count");
	}

	@Override
	public void boardHit(int num) throws Exception {
		sqlSession.update(NAMESPACE + "hit", num);
	}
}
