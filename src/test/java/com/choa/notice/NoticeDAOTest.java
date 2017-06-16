package com.choa.notice;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {
	@Inject
	private NoticeDAOImpl noticeDAO;

	//@Test
	public void test() throws Exception {
	 	BoardDTO boardDTO = noticeDAO.boardView(29);
	 	System.out.println(boardDTO.getTitle());
	 	
	 	assertNotNull(boardDTO); // 데이터가 null인지 아닌지 확인(초록색이면 not null, 아니면 null)
	}
	
	@Test
	public void test2() throws Exception {
		int result = noticeDAO.boardDelete(29);
		System.out.println(result);
		
		assertEquals(1, result); // 데이터가 같은지 확인
	}

}
