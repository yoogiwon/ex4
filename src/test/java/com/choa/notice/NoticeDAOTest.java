package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.util.PageMaker;

public class NoticeDAOTest extends MyAbstractTest {
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	@Test
	public void connectionTest() throws Exception {
		PageMaker pageMaker = new PageMaker(1);
		
		List<BoardDTO> ar = noticeDAOImpl.boardList(pageMaker.getRowMaker());
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void countTest() throws Exception {
		int result = noticeDAOImpl.boardCount();
		
		assertNotEquals(0, result);
	}
}
