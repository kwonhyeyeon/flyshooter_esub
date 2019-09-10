/**
 * 
 */

		
$(document).ready(function(){
	var arg = $("#p_status").text();
	if(arg){
		$("#status").val(arg);
	}
	
	
	$("#status").change(function(){
		$("#such_status").attr({
			"method":"get",
			"action":"/admin/member/memberList.do"
		});
		$("#such_status").submit();
	});
});