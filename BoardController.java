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
	
	//write�� �ش�Ǵ� ��
	@Autowired
	private BoardWriteService boardWriteService; //getArticles(s)
	
	
	//���ſ� ����Ȱ�, update, delete
	
	@RequestMapping(value = "/boardList.sp")
	public String boardList(HttpServletRequest request, HttpServletResponse resonse,
			Model model, BoardDTO bdto, PageDTO pdto) {
		
		//service�� DI(Dependency Injection)�ϰ�
		// �ش� service�� �޼ҵ带 ȣ���� ��
		//model�̳� ��Ÿ DTO �����Ͽ� view�� ����
		//����Ͻ� ������ ���� ����
		pdto.setAllCount(boardListService.getAllCount());
		logger.info("��ü ���� ���ڵ� �� :"+pdto.getAllCount());
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
			model.addAttribute("bdto",bdto); //�޾ƿ� �� �ٽ� �־��ֱ�
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
