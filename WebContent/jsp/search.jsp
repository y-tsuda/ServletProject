<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/jsp/css/common.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/jsp/css/jquery-ui.min.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/jsp/js/jquery-2.1.4.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/jsp/js/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/jsp/js/search.js" />" type="text/javascript"></script>
<title>一覧画面</title>
</head>
<body>
<%@ include file="common.jsp" %>
<form id="form1" method="post" >
	<table border="1">
		<tr>
			<td width="100px">ID</td><td><input type="text" name="id" value="<c:out value='${id}' />"/></td>
		</tr>
		<tr>
			<td width="100px">氏名</td><td><input type="text" name="name" value="<c:out value='${name}' />"/></td>
		</tr>
		<tr>
			<td width="100px">入社日</td><td><input type="text" id="hire_date" name="hire_date" /></td>
			
		</tr>
		<tr>
			<td width="50px">役職</td>
			<td>
			<select name="grade" id="grade">
				<option value="1">社長</option>
				<option value="2">部長</option>
				<option value="3">課長</option>
				<option value="4">社員</option>
			</select>
			</td>
		</tr>
		<tr>
			<td width="100px">給与</td><td><input type="text" name="salary" /></td>
		</tr>
	</table>
	<input type="button" id="search" value="検索">
	<input type="reset" value="クリア">
	<input type="button" id="txt" value="txt出力" />
	<input type="button" id="excel" value="excel出力" />
	<input type="button" id="pdf" value="pdf出力" />
</form><br>
<form action="EntryServlet" method="get">
	<input type="submit" value="新規登録" />
</form>
<hr>
<table class="sample_01">
	<tr>
		<th width="50px">ID</th>
		<th width="100px">氏名</th>
		<th width="100px">入社日</th>
		<th width="50px">役職</th>
		<th width="100px">給与</th>
		<th width="100px">編集</th>
	</tr>
	<c:forEach items="${empList}" var="list">
	<tr>
		<td><c:out value="${list.id}" /></td>
		<td><c:out value="${list.name}" /></td>
		<td><fmt:formatDate value="${list.hireDate }" pattern="yyyy/MM/dd"/></td>
		<td><c:out value="${list.grade}" /></td>
		<td><c:out value="${list.salary}" /></td>
		<td><a href="EditServlet?id=<c:out value="${list.id}" />">編集</a></td>
	</tr>
	</c:forEach>
</table>


</body>
</html>