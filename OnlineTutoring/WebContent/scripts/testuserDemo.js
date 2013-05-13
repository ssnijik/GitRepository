window.onload = function (){
	document.getElementById("b").onclick=testuserExample;
};


function testuserExample(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var jsonObj = {
			"email" : email,
			"password" : password
	};
	
	postServlet("login.html", JSON.stringify(jsonObj), responseHandler);
}

function responseHandler (str) {
	alert(str)
}