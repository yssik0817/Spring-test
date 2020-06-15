package kr.or.sol.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.sol.board.dto.BoardDTO;

@Repository("boardDao")
public class BoardDAO {
//datatbase  ������ �� id �ʿ�
	@Autowired 
	private SqlSession sqlsession;	//connection pool�� Ŀ�ؼ� ����
	
	String prens = "model2.board.";
	public int getAllcount() {
		return sqlsession.selectOne(prens+"allCnt");
	}
	
	public List<BoardDTO> getArticles(Map<String, Integer> hmap) {
		return sqlsession.selectList(prens+"getArticles",hmap);
	}

	public BoardDTO getArticle(BoardDTO bdto) {

		return null;
	}	
	public void boardWrite(BoardDTO bdto) {
		sqlsession.insert(prens+"boardWrite",bdto);
	}

	public int getNewNum() {
		return sqlsession.selectOne(prens+"newNum");
	}
		
}
