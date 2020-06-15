package kr.or.sol.board.service;

import java.util.List;
import java.util.Map;

import kr.or.sol.board.dto.BoardDTO;
import kr.or.sol.board.dto.PageDTO;


public interface BoardListService {
   public int getAllCount();
   public List<BoardDTO> getArticles(PageDTO pdto);
   
   public Map<String, Object> getArticle(BoardDTO bdto, PageDTO pdto);
}