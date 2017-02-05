<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ポップアップ機能</title>
	<link href="<c:url value="/jsp/css/jquery-ui.min.css" />" rel="stylesheet" type="text/css">
	<script src="<c:url value="/jsp/js/jquery-2.1.4.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/jsp/js/jquery-ui.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/jsp/js/popup.js" />" type="text/javascript"></script>
</head>
<body>
<%@ include file="common.jsp"%>
<form 	name="frm1" action="PopUpServlet" method="post">
<table>
	<tr>
	<td>ID</td><td><input type="text" id="i" name="ids" onChange="doChange()"/></td><td>名前</td><td><input type="text" id="id" name="names" readonly="readonly"/></td><td><input type="button" id="open" value="ポップアップ" /></td><td><input type="button" id="modal" value="モーダル" /></td>
	</tr>
</table>



</form>

</body>
</html>