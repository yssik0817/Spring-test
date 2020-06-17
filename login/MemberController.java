package kr.co.hs.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.hs.member.dto.MemberDTO;
import kr.co.hs.member.dto.PageDTO;
import kr.co.hs.member.service.MemberService;


@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberForm.mg")
	public String memberForm(HttpServletRequest request, HttpServletResponse response) {
		
		return "member/memberForm";
	}
	
	
	@RequestMapping(value="joinPro.mg")
	public String joinPro(HttpServletRequest request, 
			HttpServletResponse response, MemberDTO mdto, PageDTO pdto, Model model) {
		
		int r=memberService.joinMember(mdto, pdto);
		if(r>0) {
			model.addAttribute("message","회원가입이 성공하였습니다.");
		}else {
			model.addAttribute("message","회원가입이 실패하였습니다.");
		}
		return "member/joinPro";
	}
}
