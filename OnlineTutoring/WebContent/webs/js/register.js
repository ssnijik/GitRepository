var emailvalid=false;
var passwordvalid=false;
var sndpasswdvalid=false;
var firstnamevalid=false;
var lastnamevalid=false;

function emailCheck () {
	if($("#email").val()!=""){
		var emailStr=$("#email").val();
		var emailPat=/^(.+)@(.+)$/;
		var matchArray=emailStr.match(emailPat);
		if (matchArray==null) {
			$("#_email").addClass("error");
			$("#email_info").html("邮箱格式不正确");
			emailvalid=false;
		}
		else{
			registeraction.checkEmail($("#email").val(),checkEmailCallback);
		}
	}
	else
	{
		$("#_email").addClass("error");
		$("#email_info").html("邮箱不可以为空");
		emailvalid=false;
	}
}

function checkEmailCallback(msg)
{
	if(msg=="exist")
	{
		
		$("#_email").addClass("error");
		$("#email_info").html("邮箱已注册");
		emailvalid=false;
	}
	else
	{
		$("#_email").removeClass("error");
		$("#email_info").html("邮箱合格");
		emailvalid=true;
	}
		
}

function passwordCheck()
{
	if($("#password").val()!=""){
		var length = $("#password").val().length;
		if(length>6)
		{
			$("#_password").removeClass("error");
			$("#password_info").html("");
			passwordvalid=true;
		}
		else
		{
			$("#_password").addClass("error");
			$("#password_info").html("密码长度必须大于6");
			passwordvalid=false;
		}
	}
	else{
		$("#_password").addClass("error");
		$("#password_info").html("密码不可以为空");
		passwordvalid=false;
	}
}

function passwordIsSame()
{
	if($("#secondpassword").val()!="")
	{
		if($("#password").val()!=$("#secondpassword").val())
		{
			$("#_secondpassword").addClass("error");
			$("#secondpassword_info").html("两次密码不一致");
			sndpasswdvalid=false;
		}
		else
		{
			$("#_secondpassword").removeClass("error");
			$("#secondpassword_info").html("");
			sndpasswdvalid=true;
		}
	}else{
		$("#_secondpassword").addClass("error");
		$("#secondpassword_info").html("确认密码不能为空");
		sndpasswdvalid=false;
	}
}

function firstnameCheck()
{
	if($("#firstname").val()!="")
	{
		$("#_firstname").removeClass("error");
		$("#firstname_info").html("");
		firstnamevalid=true;
	}
	else
	{
		$("#_firstname").addClass("error");
		$("#firstname_info").html("姓不能为空");
		firstnamevalid=false;
	}
}

function lastnameCheck()
{
	if($("#lastname").val()!="")
	{
		$("#_lastname").removeClass("error");
		$("#lastname_info").html("");
		lastnamevalid=true;
		
	}
	else
	{
		$("#_lastname").addClass("error");
		$("#lastname_info").html("名不能为空");
		lastnamevalid=false;
	}
}

function RegisterSubmit()
{
	if(emailvalid&passwordvalid&sndpasswdvalid&firstnamevalid&lastnamevalid)
		$("#registerform").submit();
	else
		alert("信息填写不合法");
}

