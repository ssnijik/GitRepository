window.onload = function (){
	document.getElementById("b").onclick=verifyExample;
}


function verifyExample(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var temp = "";	
	temp = addParameter(temp, "email", email);
	temp = addParameter(temp, "password", password);
	
	postServlet("ServletTest", temp, responseHandler);
}

function responseHandler (text) {
	alert(text);
}