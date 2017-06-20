package com.choa.board;

import java.util.List;

import com.choa.util.ListInfo;

public interface BoardService {
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception;
	
	public BoardDTO boardView(int num) throws Exception;
	
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	public int boardDelete(int num) throws Exception;
}
