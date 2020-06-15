package kr.or.sol.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.sol.board.dao.BoardDAO;
import kr.or.sol.board.dto.BoardDTO;
import kr.or.sol.board.dto.PageDTO;
import kr.or.sol.board.service.BoardListService;

@Service("boardListService")
public class BoardListServiceImpl implements BoardListService {
   private static final Logger logger = LoggerFactory.getLogger(BoardListServiceImpl.class);
   
   @Resource 
   BoardDAO boardDao;
   
   @Override
   public int getAllCount() {
      return boardDao.getAllcount();
   }

   @Override
   public List<BoardDTO> getArticles(PageDTO pdto) {
      
        if(pdto.getAllCount()%pdto.getLinePerPage()==0) {
           //몫이 전체 페이지 수 
           pdto.setAllPage(pdto.getAllCount()/pdto.getLinePerPage());
        }else {
           //몫이 +1이 전체 페이지 수 
           pdto.setAllPage(pdto.getAllCount()/pdto.getLinePerPage()+1);
        }
        
        //현재 페이지와 페이지블록 이 0이면 1로 setting
        if(pdto.getCurrentPage()==0) {
           pdto.setCurrentPage(1);
        }
        if(pdto.getCurrPageBlock()==0) {
           pdto.setCurrPageBlock(1);
        }
        
        //전체페이지수가 블럭보다 작다
        int startPage = 1;
        int endPage=1;
   
        //전체페이지수가 블럭보다 크다
        //현재페이지 블럭에 따라서 바뀜
        startPage = (pdto.getCurrPageBlock()-1)*pdto.getPageBlock()+1;
          endPage = pdto.getCurrPageBlock()*pdto.getPageBlock()>pdto.getAllPage()? 
              pdto.getAllPage(): pdto.getCurrPageBlock()*pdto.getPageBlock();
       
        //전체페이지수가 블럭보다 크면 블럭으로 나누기
        pdto.setStartPage(startPage);
        pdto.setEndPage(endPage);
      //시작 값
      int start=(pdto.getCurrentPage()-1)*pdto.getLinePerPage()+1;
      int end = pdto.getCurrentPage()*pdto.getLinePerPage()+1;
      Map<String,Integer> hmap = new HashMap<String, Integer>();
      hmap.put("start",start);
      logger.info("start"+start);
      hmap.put("end",end);
      logger.info("end"+end);
      
         List<BoardDTO> list = 
               boardDao.getArticles(hmap);
        logger.info("가져온 레코드수"+list.size());
        
      return list;
   }

   @Override
   public Map<String, Object> getArticle(BoardDTO bdto, PageDTO pdto){
	   //현재 페이지를 받아오는데 못 받아올 경우 0이므로 1로 세팅
	   if(pdto.getCurrentPage()==0) {
       pdto.setCurrentPage(1);
	   }
	   if(pdto.getCurrPageBlock()==0) {
       pdto.setCurrPageBlock(1);
	   }
	   
	   //해당되는 게시글 가져오기
	   BoardDTO bdto2 = boardDao.getArticle(bdto);
	   //처리된 결과를 controller에게 전달하기 위해 담기
	   Map<String, Object> cmap = new HashMap<String, Object>();
    
	   cmap.put("pdto",pdto);
	   cmap.put("bdto",bdto2);
    
	   return cmap;
   }
   
   
}