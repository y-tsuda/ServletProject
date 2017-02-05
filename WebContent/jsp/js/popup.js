$(function() {

	$("#open").click(function(){
		window.open("OpenPopUpServlet","windowname","width=500,height=500");
	})
	$("#modal").click(function(){
		window.showModalDialog("OpenPopUpServlet","modalwindowname","dialogWidth=500,dialogHeight=500");
	})
	
	$("#i").change(function(){
		alert("change!");
	})
	
	

})