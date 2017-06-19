package com.choa.freeboard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;

@Service
public class FreeboardServiceImpl implements BoardService {
	@Inject
	private FreeboardDAOImpl freeboardDAO;
	
	@Override
	public List<BoardDTO> boardList(int curPage) throws Exception {
		int totalCount = freeboardDAO.boardCount();
		
		PageMaker pageMaker = new PageMaker(curPage);
		MakePage makePage = pageMaker.getMakePage(totalCount);
		
		return freeboardDAO.boardList(pageMaker.getRowMaker());
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		freeboardDAO.boardHit(num);
		
		return freeboardDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return freeboardDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return freeboardDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return freeboardDAO.boardDelete(num);
	}
	
	public BoardDTO freeboardUpdateForm(int num) throws Exception {
		return freeboardDAO.boardView(num);
	}
	
	public int freeboardReply(FreeboardDTO freeboardDTO) throws Exception {
		return freeboardDAO.boardReply(freeboardDTO);
	}
}
