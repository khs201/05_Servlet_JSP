<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL(Jsp Standard Tag Library) 
    - JSP에서 자주 사용하는 Java 기능(if, for 등)을  태그 형식으로 만들어 제공
    - JSP 개발을 간소화하고 유지 관리를 용이하게 하는 강력한 도구
--%>

<!-- JSTL 라이브러리를 현재 JSP에서 사용하겠다는 JSP 지시자 작성 -->
<!-- c == core (if, for문 등) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- fn == functions (길이, 자르기, 나누기) -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>${todo.title}</title>

<style>
.detail{
	white-space: pre-wrap; 
}
</style>

</head>
<body>


	<ul>

		<li>제목 : ${todo.title}</li>
		<li>완료 여부 : 
		<c:if test="${todo.complete}">O</c:if>
		<c:if test="${not todo.complete}">X</c:if>
		
		
		</li>
		<li>등록일 : ${todo.regDate}</li>
		<li class="detail">${todo.detail}</li>



	</ul>



</body>
</html>