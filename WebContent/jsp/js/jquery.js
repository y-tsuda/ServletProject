$(function() {

	$("#txt").change(function(){
		
		alert("onChange!");
		
	})
	
	$("#edit").click(function(){
		$("#txt").val("変更!");
	})
	
	$("#hidedit").click(function(){
		$("#hid").val("変更!");
	})
	$("#hiddisp").click(function(){
		var disp = $("#hid").val();;
		$("#txt2").val(disp);
	})
})