<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   <%@ page import="kr.or.sol.board.dto.*, java.util.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<script type="text/javascript" src="/resources/js/boardScript.js"></script>
<script type="text/javascript" src="/resources/js/jquery_board.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/board.css">
</head>
<body>
	
	<form action="writePro.sp" method="post" name="writeForm" onsubmit="return sendData()">
<!-- 	enctype="multipart/form-data"> -->
         <input type="text" name = "num" value = "${bdto.num}">
         <input type="text" name = "ref" value = "${bdto.ref}">
         <input type="text" name = "re_step" value = "${bdto.re_step}">
         <input type="text" name = "re_level" value = "${bdto.re_level}">
       	<input type = "text" name = "currentPage" value = '<c:out value="${pdto.currentPage}"/>'>
 		 <input type = "text" name = "currPageBlock" value = '<c:out value="${pdto.currPageBlock}"/>'>
   
      <table border=1>
         <thead>
            <tr>
               <th colspan=2>
                  <h3>글쓰기</h3>
               </th>
            </tr>
         </thead>
         <tbody>
            <tr>
               <th>제목 : </th>
               <c:if test="${bdto.num==0}">
               <td><input type="text" size="70%" 
               placeholder="제목을 입력하세요" name="subject" /></td>
               </c:if>
               
               <c:if test="${bdto.num!=0}">
               <td><input type="text" size="70%" 
               placeholder="제목을 입력하세요" name="subject" value="[답글]" /></td>
               </c:if>
            </tr>
            <tr>
               <th>내용 : </th>
               <td><textarea cols="100" rows="20" 
               placeholder="내용을 입력하세요" name="content"/></textarea></td>
            </tr>
            <tr>
               <th>첨부파일 :</th>
               <td><input type="file"  name="attachNm"/></td>
            </tr>
            <tr>
               <th>작 성 자 :</th>
               <td><input type="text" 
               placeholder="작성자를 입력하세요" name="writer"/></td>
            </tr>
            <tr>
               <th>이 메 일 :</th>
               <td><input type="text" 
               placeholder="메일 주소를 입력하세요" name="email"/></td>
            </tr>
            <tr>
               <th>비밀번호 :</th>
               <td><input type="password" 
               placeholder="비밀번호를 입력하세요" name="passwd"/></td>
            </tr>
            <tr>
               <td colspan="2" align="center">
               <input type="submit" name="submit" value="등록">
               <input type="button" name = "listbtn" value="글 목록으로..." id="list1"/></td>
            </tr>
         </tbody>
      </table>
   </form>

</body>
</html>