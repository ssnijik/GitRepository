/**
 * Verify
 */

function createRequest() {
	var xmlHttpRequest = false;
	if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e1) {
			try {
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				xmlHttpRequest = false;
			}
		}
	}
	return xmlHttpRequest;
}

function readyStateChangeHandler(responseHandler) {
	return function(){
		if (this.readyState == 4) {
			if (this.status == 200) {
				responseHandler(this.responseText);
			} else {
				alert("HTTP error " + req.status + ": " + req.statusText);
			}
		}
	};
}

function postServlet(servlet, queryString, responseHandler) {
	var request = createRequest();
	request.open("POST", "../" + servlet, true);
	request.onreadystatechange = readyStateChangeHandler(responseHandler);
	request.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
	request.send(queryString);
}

function addParameter(queryString, name, value) {
	if (queryString == null || queryString == "") {
		queryString = name + "=" + value;
	}
	else {
		queryString += "&" + name + "=" + value;
	}
	return queryString;
}

//String.prototype.addParameter = function(name, value) {
//	if (this == null || this == "") {
//		return name + "=" + value;
//	}
//	else {
//		return this + "&" + name + "=" + value;
//	}
//}