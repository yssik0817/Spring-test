package kr.or.sol.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.sol.board.dto.BoardDTO;
import kr.or.sol.board.dto.PageDTO;

public interface BoardWriteService {
	public PageDTO writeArticle(PageDTO pdto);
	public void writeProArticle(BoardDTO bdto, HttpServletRequest request, 
			HttpServletResponse resonse);
}
