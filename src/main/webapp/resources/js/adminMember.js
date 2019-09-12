/**
 * 
 */
$(document).ready(function(){
	// 회원 상태 변경 버튼 클릭 시
	$(".memberEdit").click(function() {
		var index = $(".memberEdit").index(this);
		setTd(index);
	});
	
	// 회원상태 변경후 저장버튼 클릭시
	$(".goUpdate").click(function(){
		
		
		var index = $(".goUpdate").index(this);
		setUpdateForm(index);
		
		if(confirm("수정하시겠습니까 ? ")){
			$("#memberUpdate").attr({
				"method":"post",
				"action":"/admin/member/memberUpdate.do"
			});
				$("#memberUpdate").submit();
		}
		
	});

	
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

	function setTd(index){
			//$("#m_status").css("display","block");
			$(".statusText:eq("+index+")").css("display","none");
			$(".m_status:eq("+index+")").show();
			$(".memberEdit:eq("+index+")").css("display","none");
			$(".goUpdate:eq("+index+")").show();
	}
	
	function setUpdateForm(index){
		
		var m_id = $(".m_id:eq("+index+")").text();
		var m_status = $(".m_status:eq("+index+")").val();
		var m_type = $(".m_type:eq("+index+")").attr("data-type");
		$("#m_id").val(m_id);
		$("#m_type").val(m_type);
		$("#m_status").val(m_status);
		
	}