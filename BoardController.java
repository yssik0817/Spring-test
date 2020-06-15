package kr.or.sol.board.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.sol.board.dto.BoardDTO;
import kr.or.sol.board.dto.PageDTO;
import kr.or.sol.board.service.BoardListService;
import kr.or.sol.board.service.BoardWriteService;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//DI(Dependency Injection)
	
	@Autowired
	private BoardListService boardListService; //getArticles(s): boardList, content
	
	//write에 해당되는 것
	@Autowired
	private BoardWriteService boardWriteService; //getArticles(s)
	
	
	//갱신에 관계된것, update, delete
	
	@RequestMapping(value = "/boardList.sp")
	public String boardList(HttpServletRequest request, HttpServletResponse resonse,
			Model model, BoardDTO bdto, PageDTO pdto) {
		
		//service를 DI(Dependency Injection)하고
		// 해당 service의 메소드를 호출한 후
		//model이나 기타 DTO 저장하여 view로 전달
		//비즈니스 로직을 적지 않음
		pdto.setAllCount(boardListService.getAllCount());
		logger.info("전체 라인 레코드 수 :"+pdto.getAllCount());
		List<BoardDTO> list=boardListService.getArticles(pdto);
		model.addAttribute("pdto",pdto);
		model.addAttribute("list",list);
		return "board2/boardList";
		}
	
		@RequestMapping(value="/writeForm.sp")
		public String writeForm(HttpServletRequest request, HttpServletResponse response,
			Model model, BoardDTO bdto, PageDTO pdto) {
			PageDTO pdto2 = boardWriteService.writeArticle(pdto);
			model.addAttribute("pdto",pdto2);
			model.addAttribute("bdto",bdto); //받아온 것 다시 넣어주기
			return "board2/writeForm";
		}
		
		@RequestMapping(value = "/content.sp")
		public String content(HttpServletRequest request, HttpServletResponse response,
				Model model, BoardDTO bdto, PageDTO pdto) {
			Map<String, Object> cmap = 
					boardListService.getArticle(bdto, pdto);
			return "board2/content";
		}
		
		@RequestMapping(value="/writePro.sp")
		public String writePro(HttpServletRequest request, HttpServletResponse response,
			Model model, BoardDTO bdto, PageDTO pdto) {
			boardWriteService.writeProArticle(bdto, request, response);
				   if(pdto.getCurrentPage()==0) {
			       pdto.setCurrentPage(1);
				   }
				   if(pdto.getCurrPageBlock()==0) {
			       pdto.setCurrPageBlock(1);
				   }
			model.addAttribute("pdto",pdto);
			return "board2/writePro";
		}
		
	}
