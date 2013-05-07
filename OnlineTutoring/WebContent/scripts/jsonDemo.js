window.onload = function (){
	document.getElementById("b").onclick=jsonExample;
};


function jsonExample(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var jsonObj = {
			"email" : email,
			"password" : password
	};
	
	postServlet("TestJson", JSON.stringify(jsonObj), responseHandler);
}

function responseHandler (jsonStr) {
	var result = JSON.parse(jsonStr);
	alert(result.firstName);
	alert(result.lastName);
	alert(result.email);
	alert(result.password);
}