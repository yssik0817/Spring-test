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
           //���� ��ü ������ �� 
           pdto.setAllPage(pdto.getAllCount()/pdto.getLinePerPage());
        }else {
           //���� +1�� ��ü ������ �� 
           pdto.setAllPage(pdto.getAllCount()/pdto.getLinePerPage()+1);
        }
        
        //���� �������� ��������� �� 0�̸� 1�� setting
        if(pdto.getCurrentPage()==0) {
           pdto.setCurrentPage(1);
        }
        if(pdto.getCurrPageBlock()==0) {
           pdto.setCurrPageBlock(1);
        }
        
        //��ü���������� ������ �۴�
        int startPage = 1;
        int endPage=1;
   
        //��ü���������� ������ ũ��
        //���������� ���� ���� �ٲ�
        startPage = (pdto.getCurrPageBlock()-1)*pdto.getPageBlock()+1;
          endPage = pdto.getCurrPageBlock()*pdto.getPageBlock()>pdto.getAllPage()? 
              pdto.getAllPage(): pdto.getCurrPageBlock()*pdto.getPageBlock();
       
        //��ü���������� ������ ũ�� ������ ������
        pdto.setStartPage(startPage);
        pdto.setEndPage(endPage);
      //���� ��
      int start=(pdto.getCurrentPage()-1)*pdto.getLinePerPage()+1;
      int end = pdto.getCurrentPage()*pdto.getLinePerPage()+1;
      Map<String,Integer> hmap = new HashMap<String, Integer>();
      hmap.put("start",start);
      logger.info("start"+start);
      hmap.put("end",end);
      logger.info("end"+end);
      
         List<BoardDTO> list = 
               boardDao.getArticles(hmap);
        logger.info("������ ���ڵ��"+list.size());
        
      return list;
   }

   @Override
   public Map<String, Object> getArticle(BoardDTO bdto, PageDTO pdto){
	   //���� �������� �޾ƿ��µ� �� �޾ƿ� ��� 0�̹Ƿ� 1�� ����
	   if(pdto.getCurrentPage()==0) {
       pdto.setCurrentPage(1);
	   }
	   if(pdto.getCurrPageBlock()==0) {
       pdto.setCurrPageBlock(1);
	   }
	   
	   //�ش�Ǵ� �Խñ� ��������
	   BoardDTO bdto2 = boardDao.getArticle(bdto);
	   //ó���� ����� controller���� �����ϱ� ���� ���
	   Map<String, Object> cmap = new HashMap<String, Object>();
    
	   cmap.put("pdto",pdto);
	   cmap.put("bdto",bdto2);
    
	   return cmap;
   }
   
   
}