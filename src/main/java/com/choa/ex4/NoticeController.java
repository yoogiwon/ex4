package com.choa.ex4;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	@Inject
	private NoticeServiceImpl noticeService;
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public String noticeList(Model model, @RequestParam(defaultValue = "1") Integer curPage) throws Exception {
		List<BoardDTO> ar = noticeService.boardList(curPage);
		
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		
		return "board/boardList";
	}
	
	@RequestMapping(value = "noticeView", method = RequestMethod.GET)
	public void noticeView(Integer num, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.boardView(num);
		
		model.addAttribute("view", boardDTO);
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public void noticeWrite(Model model) {
		model.addAttribute("path", "Write");
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, RedirectAttributes rd) throws Exception {
		int result = noticeService.boardWrite(noticeDTO);
		String message = "WRITE FAIL";
		
		if(result>0) {
			message = "WRITE SUCCESS";
		}
		
		//model.addAttribute("message", message);
		rd.addFlashAttribute("message", message);
		
		return "redirect:noticeList?curPage=1";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(Integer num, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.noticeUpdateForm(num);
		
		model.addAttribute("update", boardDTO);
		model.addAttribute("path", "Update");
		
		return "notice/noticeWrite";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.boardUpdate(noticeDTO);
		String message = "UPDATE FAIL";
		
		if(result>0) {
			message = "UPDATE SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "noticeList?curPage=1");
		
		return "common/result";
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public String noticeDelete(Integer num, Model model) throws Exception {
		int result = noticeService.boardDelete(num);
		String message = "DELETE FAIL";
		
		if(result>0) {
			message = "DELETE SUCCESS";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("path", "noticeList?curPage=1");
		
		return "common/result";
	}
}
