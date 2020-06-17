package kr.co.hs.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hs.member.dao.MemberDAO;
import kr.co.hs.member.dto.MemberDTO;
import kr.co.hs.member.dto.PageDTO;
import kr.co.hs.member.service.MemberService;

@Service(value="memberService")
public class memberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Override
	public int joinMember(MemberDTO mdto, PageDTO pdto) {
		return memberDAO.joinMember(mdto);
	}

}
