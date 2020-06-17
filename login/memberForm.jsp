<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link href="./resources/member/css/board.css" rel="stylesheet">          
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./resources/member/js/jquery_member.js" 
          type="text/javascript"></script>
</head>
<body>
<form action="joinPro.mg" method="post" name="joinForm">
     <!-- enctype="multipart/form-data" -->  
<%--     <input type="hidden" name="currPageBlock"  
       value='<c:out value="${pdto.currPageBlock}"/>'/> --%>
  <table border = 1>
    <thead class="class01 class-center">
      <tr>
         <th colspan=2 > <h3>회원가입</h3> 
         </th>
       </tr>
    </thead>
    <tbody class="class02 class-left">
        <tr>
            <th>아이디 </th>           
            <td><input type="text" size="70%" 
               placeholder="아이디를 입력하세요. " 
               name="memid" title="아이디" value="" class="chk"/></td>           
        </tr>
        <tr>
            <th>이름 </th>           
            <td><input type="text" size="70%" 
                placeholder="이름을 입력하세요. " 
                   name="memname" title="이름" class="chk"/></td>           
        </tr>         
        <tr>
            <th>연락처 </th>           
            <td><input type="text" size="70%" 
               placeholder="연락처를 입력하세요." 
               name="memtel" title="연락처" class="chk"/></td>           
        </tr>
        <tr>
            <th>생년월일 </th>           
            <td><input type="text" size="70%" 
               placeholder="생년월일을 입력하시오.(형식:1970-11-11)" 
               name="membirth" title="생년월일" class="chk"/></td>           
        </tr>
        <tr>
            <th>성별 </th>           
            <td><input type="radio" name="memgender" value="M" /> 남성
               <input type="radio" name="memgender" value="F" checked="checked" /> 여성</td>                 
        </tr>
        <tr>
            <th>비밀번호 </th>           
            <td><input type="passwd" size="70%" 
               placeholder="비밀번호를 입력하세요. " 
               name="passwd" id="passwd" title="비밀번호" class="chk"/></td>           
        </tr>
        <tr>
            <th>비밀번호확인 </th>           
            <td><input type="password" size="70%" 
               placeholder="비밀번호를 확인하시오. " 
               name="passwd2" id="passwd2" title="비밀번호확인" class="chk"/>
               <font name="check" size="2" color="red"></font>
            </td>           
        </tr>
        <tr>
            <th>이메일 </th>           
            <td><input type="email" size="70%" 
               placeholder="메일주소를 작성해주세요.(형식:abcd@abc.ent) " 
               name="mememail" title="이메일" class="chk"/></td>           
        </tr>
        
         
        
        <tr>
           <td colspan="2" align="right">
            <button type="submit" name="submit" id="submit1">회원가입</button>
            <button type="button"  name="listbtn" id="list2">취소</button>
            </td>
        </tr>
    </tbody>
  </table>
</form>
</body>
</html>