$(function() {

	$("#hire_date").datepicker();
	$("#hire_date").datepicker("option", "dateFormat", 'yy/mm/dd');
	$("#rgst").click(function(){
		$("#form1").attr("action", "EntryServlet");
		$("#form1").attr("method", "post");
		$("#form1").submit();
	})
	$("#rtn").click(function(){
		$("#form1").attr("action", "SearchServlet");
		$("#form1").attr("method", "get");
		$("#form1").submit();
	})
})