$(function(){
	$("#hire_date").datepicker();
	var isClicked = false;
	$("#search").click(function(){
		if(isClicked){
			alert("二度押し防止！");
			return false;
		}
		isClicked = true;
		$("#form1").attr("action", "SearchServlet");
		$("#form1").attr("method", "post");
		$("#form1").submit();
	})
	$("#txt").click(function(){
		$("#form1").attr("action", "OutputTextServlet");
		$("#form1").attr("method", "post");
		$("#form1").submit();
	})
	$("#excel").click(function(){
		$("#form1").attr("action", "OutputExcelServlet");
		$("#form1").attr("method", "post");
		$("#form1").submit();
	})
	$("#pdf").click(function(){
		$("#form1").attr("action", "OutputPdfServlet");
		$("#form1").attr("method", "post");
		$("#form1").submit();
	})
})