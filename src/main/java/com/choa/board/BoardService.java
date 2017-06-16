package com.choa.board;

import java.util.List;

public interface BoardService {
	public List<BoardDTO> boardList(int curPage) throws Exception;
	
	public BoardDTO boardView(int num) throws Exception;
	
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	public int boardDelete(int num) throws Exception;
}
