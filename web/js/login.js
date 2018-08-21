$(document).ready(function() {
	$("#username").focus(function(){
		$("#username").val("");
	});
	$("#username").blur(function(event) {
		/* Act on the event */
		if ($("#username").val()=="") {
			$("#username").val("用户名");
		}
	});
	$("#tel").focus(function(){
		$("#tel").val("");
	});
	$("#tel").blur(function(event) {
		/* Act on the event */
		if ($("#tel").val()=="") {
			$("#tel").val("手机号");
		}
	});
	$("#password").focus(function(){
		$("#password").val("");
		$("#password").hide();
		$("#password1").show();
		$("#password1").focus();
		$("#password1").val("");
	});
	$("#password1").blur(function(){
		if ($("#password1").val()=="") {
            $("#password1").hide();
            $("#password").show();
			$("#password").val("密码");
		}
		if ($("#password1").val()!=""){
		    $("#password1").show();
        }
	});
	$("#password2").focus(function(){
		$("#password2").val("");
		$("#password2").hide();
		$("#password3").show();
		$("#password3").focus();
		$("#password3").val("");
	});
	$("#password3").blur(function(){
        if ($("#password3").val()=="") {
            $("#password3").hide();
            $("#password2").show();
            $("#password2").val("密码");
        }
        if ($("#password3").val()!=""){
            $("#password3").show();
        }
	});
});

