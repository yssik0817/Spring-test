package kr.or.sol.board.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import kr.or.sol.board.dao.BoardDAO;
import kr.or.sol.board.dto.BoardDTO;
import kr.or.sol.board.dto.PageDTO;
import kr.or.sol.board.service.BoardWriteService;

@Service("boardWriteService")
public class BoardWriteServiceImpl implements BoardWriteService {

	@Resource 
	BoardDAO boardDao;
	
	//writeForm�� �ش�, DAO �ʿ� ����
	@Override
	public PageDTO writeArticle(PageDTO pdto) {

		if(pdto.getCurrentPage()==0) {
			pdto.setCurrentPage(1);
			}
		if(pdto.getCurrPageBlock()==0) {
			pdto.setCurrPageBlock(1);
			}

		return pdto;
	}
	public void writeProArticle(BoardDTO bdto, HttpServletRequest request, 
			HttpServletResponse resonse) {
//	   Map<String, Object> mutlDTO =
//			   ServletUpload.uploadEx(req, res);
	   	 //DAO�� ���ؼ� ���� ������ �����ϱ�
         //DAO�� ���� �ν��Ͻ� �޾ƿ���
//         dao.boardWrite((BoardDTO)mutlDTO.get("dto"));
//         req.setAttribute("pdto",(PageDTO)mutlDTO.get("pdto"));   
		
		//number ���ϱ� (���ο� num)
		int number = boardDao.getNewNum();
		//num==0 �����
		//num�� 0 �ƴϸ� ���
		
		if(bdto.getNum()==0) {
			bdto.setNum(number);
			bdto.setRef(number);
			bdto.setRe_level(1);
			bdto.setRe_step(1);
		}else {
			bdto.setRe_level(bdto.getRe_level()+1);
			bdto.setRe_step(bdto.getRe_step()+1);
			
		}
	
		boardDao.boardWrite(bdto);
	}
	
	
}
