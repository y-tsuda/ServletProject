<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
</head>
	ようこそ
	<c:choose>
		<c:when test="${id != null}">
			<c:out value="${id}" />
		</c:when>
		<c:otherwise>
			ゲスト
		</c:otherwise>		
	</c:choose>
			さん！<br>	
<hr>
