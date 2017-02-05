<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>編集画面</title>
		<link href="<c:url value="/jsp/css/jquery-ui.min.css" />" rel="stylesheet" type="text/css">
		<script src="<c:url value="/jsp/js/jquery-2.1.4.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/jsp/js/jquery-ui.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/jsp/js/edit.js" />" type="text/javascript"></script>
	</head>
	<body>
		<%@ include file="common.jsp"%>
		<form id="form1" method="post">
			<table border="1">
				<tr>
					<td width="100px">ID</td><td><c:out value="${vo.id}" /></td>
				</tr>
			
				<tr>
					<td width="100px">氏名</td><td><input type="text" name="name" value="${vo.name}" /></td>
				</tr>
				<tr>
					<td width="100px">入社日</td><td><input type="text" id="hire_date" name="hire_date" value="${vo.hire_date }" /></td>
				</tr>
				<tr>
					<td width="50px">等級</td><td><input type="text"  name="grade" value="${vo.grade}" /></td>
				</tr>
				<tr>
					<td width="100px">給与</td><td><input type="text" name="salary" value="${vo.salary}" /></td>
				</tr>
				<tr>
					<td width="100px">削除</td><td><input type="checkbox" id="del_flg" name="del_flg" value="${vo.del_flg}" /></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="${vo.id}" />
			<input type="hidden" name="update_date" value="${vo.update_date}" />
			<input type="button" id="edit" value="編集">
			<input type="button" id="rtn" value="戻る">
		</form>
	</body>
</html>