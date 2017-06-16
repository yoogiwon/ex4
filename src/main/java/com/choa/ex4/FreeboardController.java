package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.choa.board.BoardDTO;
import com.choa.freeboard.FreeboardDTO;
import com.choa.freeboard.FreeboardServiceImpl;

@Controller
@RequestMapping(value = "/freeboard/**")
public class FreeboardController {
	@Inject
	private FreeboardServiceImpl freeboardService;
	
	@RequestMapping(value = "freeboardList", method = RequestMethod.GET)
	public String freeboardList(@RequestParam(defaultValue = "1") int curPage, Model model) throws Exception {
		List<BoardDTO> ar = freeboardService.boardList(curPage);
		
		model.addAttribute("list", ar);
		model.addAttribute("board", "freeboard");
		
		return "board/boardList";
	}
	
	@RequestMapping(value = "freeboardView", method = RequestMethod.GET)
	public String freeboardView(Integer num, Model model) throws Exception {
		BoardDTO boardDTO = freeboardService.boardView(num);
		
		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "freeboard");
		
		return "board/boardView";
	}
	
	@RequestMapping(value = "freeboardWrite", method = RequestMethod.GET)
	public String freeboardWrite(Model model) {
		model.addAttribute("path", "Write");
		model.addAttribute("board", "freeboard");
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "freeboardWrite", method = RequestMethod.POST)
	public String freeboardWrite(FreeboardDTO freeboardDTO, Model model) throws Exception {
		int result = freeboardService.boardWrite(freeboardDTO);
		String message = "WRITE FAIL";
		
		if(result>0) {
			message = "WRITE SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "freeboardList?curPage=1");
		
		return "common/result";
	}
	
	@RequestMapping(value = "freeboardUpdate", method = RequestMethod.GET)
	public String freeboardUpdate(Integer num, Model model) throws Exception {
		BoardDTO boardDTO = freeboardService.freeboardUpdateForm(num);
		
		model.addAttribute("update", boardDTO);
		model.addAttribute("path", "Update");
		model.addAttribute("board", "freeboard");
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "freeboardUpdate", method = RequestMethod.POST)
	public String freeboardUpdate(BoardDTO boardDTO, Model model) throws Exception {
		int result = freeboardService.boardUpdate(boardDTO);
		String message = "UPDATE FAIL";
		
		if(result>0) {
			message = "UPDATE SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "freeboardList?curPage=1");
		
		return "common/result";
	}
	
	@RequestMapping(value = "freeboardDelete", method = RequestMethod.GET)
	public String freeboardDelete(Integer num, Model model) throws Exception {
		int result = freeboardService.boardDelete(num);
		String message = "DELETE FAIL";
		
		if(result>0) {
			message = "DELETE SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "noticeList?curPage=1");
		
		return "common/result";
	}
}
