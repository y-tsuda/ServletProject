<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登録画面</title>
	<link href="<c:url value="/jsp/css/jquery-ui.min.css" />" rel="stylesheet" type="text/css">
	<script src="<c:url value="/jsp/js/jquery-2.1.4.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/jsp/js/jquery-ui.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/jsp/js/entry.js" />" type="text/javascript"></script>
</head>
<body>
	<%@ include file="common.jsp"%>
	<form id="form1" method="post">
		<table border="1">
			<tr>
				<td width="100px">氏名</td><td><input type="text" name="name" value="${emp.name}" /></td>
			</tr>
			<tr>
				<td width="100px">入社日</td><td><input type="text" id="hire_date" name="hire_date" value="${emp.hireDate }" /></td>
				
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
				<td width="100px">給与</td><td><input type="text" name="salary" value="${emp.salary}" /></td>
			</tr>
		</table>
		<input type="button" id="rgst" value="登録">
		<input type="button" id="rtn" value="戻る">
	</form>
</body>
</html>