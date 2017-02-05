<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Boards 'R' Us</title>
<link href="<c:url value="/jsp/css/boards.css" />" rel="stylesheet"
	type="text/css">
<script language="javascript" type="text/javascript">

</script>
</head>

<body>
	<%@ include file="common.jsp"%>
	<form action="Security2Servlet" method="GET">
		名前:<input type="text" name="name" />
		<input type="submit" value="送信"/>
	</form>
	
</body>
</html>