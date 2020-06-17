
package kr.co.hs.member.service;

import kr.co.hs.member.dto.MemberDTO;
import kr.co.hs.member.dto.PageDTO;

public interface MemberService {
   public int joinMember(MemberDTO mdto, PageDTO pdto);
}
