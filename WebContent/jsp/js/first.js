$(function(){
	$("#hire_date").datepicker();
	$("#button1").click(function(){
		alert("get");
	})
	$("#entryButton").click(function(){
		alert("1");
		$("#form1").attr("action", "EntryServlet");
		$("#form1").attr("method", "get");
		alert("2");
		$("#form1").submit();
	})
})