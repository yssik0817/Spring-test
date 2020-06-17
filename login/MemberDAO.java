package kr.co.hs.member.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.hs.member.dto.MemberDTO;

@Repository(value="memberDAO")
public class MemberDAO {

	@Resource
	private SqlSession sqlsession;
	
	private String namespace="member.";
	
	public int joinMember(MemberDTO mdto) {
	  return sqlsession.insert(namespace+"joinMember",mdto);
   }
}
