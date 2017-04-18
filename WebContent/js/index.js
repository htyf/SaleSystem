$(function(){
	$("#user-login").submit(function(){
		var userName=$("#edit-name").val();
		var password=$("#edit-pass").val();
		$(".messages.error").remove();
		if(userName==""){
			$("#login-window-warp").prepend("<div class='messages error'><strong>错误信息</strong><br/>用户名不能为空</div>");
			return false;
		}
		if(password==""){
			$("#login-window-warp").prepend("<div class='messages error'><strong>错误信息</strong><br/>密码不能为空</div>");
			return false;
		}
		return true;
	});
	
	$("#edit-name").focus(function(){
		$(".messages.error").remove();
	});
	$("#edit-pass").focus(function(){
		$(".messages.error").remove();
	});
});