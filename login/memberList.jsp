<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kr.or.sol.board.dto.*, java.util.*" %>
    <%request.setCharacterEncoding("utf-8"); %>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="resources/member/css/board.css" rel="stylesheet">
<script type="text/javascript">
function callContent(num){
   	document.content.num.value=num;
   	document.content.submit();
	}
</script>
</head>
<body>
   <!-- 글목록 출력 -->
   
   
   <h3 style="text-align: center;">게시글목록</h3>
   
   <c:choose>
   <c:when test="${list.size()==0}">
   <table border="1">
      <tbody class = "class02">
         <tr>
         <th><h4>가입된 회원이 없습니다.</h4></th>
         </tr>
      </tbody>
   </table>
   </c:when>
   <c:when test="${list.size()!=0}">
   <table border="1">
   <thead class = "class01">
   		<tr><td colspan="7">
   		<h4 style="text-align: right;">전체 회원 개수:&nbsp;<c:out value="${pdto.allCount}"/>&nbsp;건</h4>
   		</td></tr>
   		
      <tr><td>순번</td>
         <th>회원명(id)</th>
         <td>생년월일</td>
         <td>가입일자</td>
         <td>연락처</td>
         <td>성별</td>
         </tr>
      <tbody class = "class02">
      
         <!-- 해당 리스트 출력 jstl사용 -->
      <c:forEach var="mdto" items="${list}" varStatus="i">
         <tr>
            <td><c:out value="${mdto.rr}"/>
            <input type = "hidden" value = '<c:out value="${mdto.memseq}"/>'>
            </td>
            
            <td>
            <a href='#' onclick="javascript:callContent('<c:out value="${mdto.memid}"/>');">
            <c:out value="${mdto.memname}"/>(<c:out value="${mdto.memid}"/>)
            </a></td>
            
            <td >
            <a><c:out value="${mdto.membirth}"/></a>
            </td>
            
            <td ><c:out value="${mdto.regdate}"/></td>
            <td><c:out value="${mdto.memtel}"/></td>
            <td><c:out value="${mdto.memgender}"/></td>
            
         </tr>
      </c:forEach>
      <tr>
         <td colspan="5" align="right">
         <a href = "writeForm.sp">
         <input type = "button" value="글쓰기"/></a>
         </td>
      </tr>
      </tbody>
   </table>
 <%--   		<h3 style="text-align: center">
   			<c:if test="${pdto.startPage>pdto.pageBlock}">
   				<a href="/boardList.sp?currentPage=${pdto.startPage-pageBlock}&currPageBlock=${pdto.currPageBlock-1}"
   				 style="text-decoration: none;">[이전]</a>
  			</c:if>
   			<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
   				<a href="/boardList.sp?currentPage=${i}&currPaageBlock=${pdto.currPageBlock}"
   					style="text-decoration: none;">
   				<c:out value="[${i}]"/>&nbsp;</a>
   			</c:forEach>
   			<c:if test="${pdto.endPage<pdto.allPage}">
   				<a href="/boardList.sp?currentPage=${pdto.endPage+1}&currPageBlock=${pdto.currPageBlock+1}"
   				 style="text-decoration: none;">[다음]</a>
   			</c:if>
   		</h3> --%>
   </c:when>
   </c:choose>
   
<!--    <form action="board">
   		<input type="hidden" name="currentPage"/>
   		<input type="hidden" name="currentBlock"/>
   </form> -->
   
   <form action="content.sp" name = "content" method="post" >
   <input type = "hidden" name = "currentPage" value = '<c:out value="${pdto.currentPage}"/>'>
   <input type = "hidden" name = "currPageBlock" value = '<c:out value="${pdto.currPageBlock}"/>'>
   <input type = "hidden" name = "num" value = '<c:out value="${dto.num}"/>'>
   </form>
<%--       
   
   <c:forEach var="dto" items="${list}">
      <c:out value="${dto.writer}"/>
   </c:forEach>    --%>
   
   
   <!-- 해당 리스트를 출력 jstl사용 -->
   
</body>
</html>