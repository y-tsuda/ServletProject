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
	var request = null;

	function createRequest() {
		try {
			request = new XMLHttpRequest();
		} catch (trymicrosoft) {
			try {
				request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (othermicrosoft) {
				try {
					request = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (failed) {
					request = null;
				}
			}
		}

		if (request == null)
			alert("Error creating request object!");
	}

	function getBoardsSold() {
		createRequest();
		var url = "GetUpdatedBoardSalesServlet";
		request.open("GET", url, true);
		request.onreadystatechange = updatePage;
		request.send(null);
	}

	function updatePage() {
		if (request.readyState == 4) {
			var newTotal = request.responseText;
			var boardsSoldEl = document.getElementById("boards-sold");
			var cashEl = document.getElementById("cash");
			replaceText(boardsSoldEl, newTotal);

			/* Figure out how much cash Katie has made */
			var priceEl = document.getElementById("price");
			var price = getText(priceEl);
			var costEl = document.getElementById("cost");
			var cost = getText(costEl);
			var cashPerBoard = price - cost;
			var cash = cashPerBoard * newTotal;

			/* Update the cash for the slopes on the form */
			cash = Math.round(cash * 100) / 100;
			replaceText(cashEl, cash);
		}
	}

	function replaceText(el, text) {
		if (el != null) {
			clearText(el);
			var newNode = document.createTextNode(text);
			el.appendChild(newNode);
		}
	}

	function clearText(el) {
		if (el != null) {
			if (el.childNodes) {
				for (var i = 0; i < el.childNodes.length; i++) {
					var childNode = el.childNodes[i];
					el.removeChild(childNode);
				}
			}
		}
	}

	function getText(el) {
		var text = "";
		if (el != null) {
			if (el.childNodes) {
				for (var i = 0; i < el.childNodes.length; i++) {
					var childNode = el.childNodes[i];
					if (childNode.nodeValue != null) {
						text = text + childNode.nodeValue;
					}
				}
			}
		}
		return text;
	}
</script>
</head>

<body>


	<%@ include file="common.jsp"%>
	<h1>売上表</h1>
	<div id="boards">
		<table>
			<tr>
				<th>販売数</th>
				<td><span id="boards-sold">1012</span></td>
			</tr>
			<tr>
				<th>売値</th>
				<td>$<span id="price">249.95</span></td>
			</tr>
			<tr>
				<th>原価</th>
				<td>$<span id="cost">84.22</span></td>
			</tr>
		</table>
		<h2>
			利益: $<span id="cash">167718.76</span>
		</h2>
		<form method="GET">
			<input value="Show Me the Money" onClick="getBoardsSold();"
				type="button" />
		</form>
	</div>
</body>
</html>