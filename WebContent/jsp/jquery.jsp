<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JavaScript</title>
		<link href="<c:url value="/jsp/css/jquery-ui.min.css" />" rel="stylesheet" type="text/css">
		<script src="<c:url value="/jsp/js/jquery-2.1.4.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/jsp/js/jquery-ui.min.js" />" type="text/javascript"></script>
		<script src="<c:url value="/jsp/js/jquery.js" />" type="text/javascript"></script>
	</head>
	<body>
		<%@ include file="common.jsp"%>
		<form id="form1" method="post">
			■onChange実験<br>
			<input type="text" id="txt" /><input type="button" id="edit" value="変更"><br>
			■hidden値変更<br>
			<input type="hidden" id="hid" />

			<input type="button" id="hidedit" value="hiddenの値変更">
			<input type="button" id="hiddisp" value="hiddenの値表示">
			<input type="text" id="txt2" readonly="readonly" />
		</form>
	</body>
</html>