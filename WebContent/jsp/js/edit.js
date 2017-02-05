$(function() {

//	alert();
	var hire_date = $("#hire_date").val();
	//alert(hire_date);
	$("#hire_date").datepicker();
	$("#hire_date").datepicker("setDate", hire_date);
	$("#hire_date").datepicker("option", "dateFormat", 'yy/mm/dd');
	$("#hire_date").datepicker("setDate", hire_date);
	var del_flg = $("#del_flg").val();
	if (del_flg == "1") {
		$('#del_flg').prop('checked', true);
	}

	$("#del_flg").change(function() {
		if ($("#del_flg").prop('checked')) {
			$("#del_flg").val("1");
		} else {
			$("#del_flg").val("0");
		}
	})
	$("#edit").click(function(){
		$("#form1").attr("action", "EditServlet");
		$("#form1").attr("method", "post");
		$("#form1").submit();
	})
	$("#rtn").click(function(){
		$("#form1").attr("action", "SearchServlet");
		$("#form1").attr("method", "get");
		$("#form1").submit();

	})
})