<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ポップアップ画面</title>
<script>
	function setId(id,name) {
		window.opener.document.frm1.ids.value = id;
		window.opener.document.frm1.names.value = name;
		window.close();
	}
</script>
</head>
<body>
	<%@ include file="common.jsp"%>
	<form action="SearchPopUpServlet" method="post">
		<input type="submit" value="検索" />
		<table class="sample_01" border="1">
			<tr>
				<th width="50px">ID</th>
				<th width="100px">氏名</th>
				<th width="100px">入社日</th>
				<th width="50px">役職</th>
				<th width="100px">給与</th>
			</tr>
			<c:forEach items="${empList}" var="list">
				<tr>
					<td><a href="javascript:setId('<c:out value="${list.id}" />','<c:out value="${list.name}" />')"><c:out
								value="${list.id}" /></a></td>
					<td><c:out value="${list.name}" /></td>
					<td><fmt:formatDate value="${list.hireDate }"
							pattern="yyyy/MM/dd" /></td>
					<td><c:out value="${list.grade}" /></td>
					<td><c:out value="${list.salary}" /></td>
				</tr>
			</c:forEach>
		</table>

	</form>
</body>
</html>