package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOTest extends MyAbstractTest {
	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	@Test
	public void connectionTest() throws Exception {
		ListInfo listInfo = new ListInfo();
		
		listInfo.setSearch("test");
		listInfo.setKind("writer");
		int totalCount = noticeDAOImpl.boardCount(listInfo);
		
		System.out.println(totalCount);
		
		assertNotEquals(0, totalCount);
	}
	
	/*@Test
	public void countTest() throws Exception {
		int result = noticeDAOImpl.boardCount();
		
		assertNotEquals(0, result);
	}*/
}
