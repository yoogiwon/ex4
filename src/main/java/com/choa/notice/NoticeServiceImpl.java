package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service // NoticeService noticeService = new noticeService();
public class NoticeServiceImpl implements BoardService {
	@Inject
	private NoticeDAOImpl noticeDAO;
	
	/*public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}*/
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		int totalCount = noticeDAO.boardCount(listInfo);
		
		listInfo.makePage(totalCount);
		listInfo.setRow();
		
		return noticeDAO.boardList(listInfo);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		noticeDAO.boardHit(num);
		
		return noticeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
	
	public BoardDTO noticeUpdateForm(int num) throws Exception {
		return noticeDAO.boardView(num);
	}
}
