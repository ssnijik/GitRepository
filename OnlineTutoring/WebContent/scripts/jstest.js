/**
 * Just test
 */


window.onload = init;
//
///**
// * Get a new XMLHttpRequest
// */
//function createRequest() {
//	var xmlreq = false;
//	if (window.XMLHttpRequest) {
//		xmlreq = new XMLHttpRequest();
//	} else if (window.ActiveXObject) {
//		try {
//			xmlreq = new ActiveXObject("Msxml2.XMLHTTP");
//		} catch (e1) {
//			try {
//				xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
//			} catch (e2) {
//				xmlreq = false;
//			}
//		}
//	}
//	return xmlreq;
//}
//
///**
// * set request to the handler
// */
//function getReadyStateHandler(req, responseHandler, isXML) {
//	return function() {
//		if (req.readyState == 4) {
//			if (req.status == 200) {
//				if (isXML==true)
//					responseHandler(req.responseXML);
//				else
//					responseHandler(req.responseText);
//			} else {
//				alert("HTTP error " + req.status + ": " + req.statusText);
//				alert("ok2");
//			}
//		}
//	};
//}
//
///**
// * send a POST request in XML with arguments
// * callback handler if it is not null
// * @param url
// * @param arguments
// * @param handler
// */
//function sendXMLPost(url, arguments, handler) {
//	var req = createRequest();	
//	
//	
//	req.open("POST", url, true);
//	
//	req.setRequestHeader("Content-Type", "application/xml; charset=utf-8");
//	if (arguments!=null) {
//		req.setRequestHeader("Content-Length", arguments.length);
//	}
//	if (handler != null)
//		req.onreadystatechange = getReadyStateHandler(req, handler, true);
//	req.send(arguments);
//}


function login(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var temp = "email=" + email + "&password=" + password;
	
	var req = new XMLHttpRequest();	
	req.open("post", "../PersonTest", true);
	
	req.onreadystatechange = function(){
		if (req.readyState == 4) {
			if (req.status == 200) {
				alert(req.responseText);
			} else {
				alert("HTTP error " + req.status + ": " + req.statusText);
			}
		}
	}
	
	req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	req.setRequestHeader("Content-length", temp.length);
	req.setRequestHeader("Connection", "close");
//	req.send();
	req.send(temp);

}








function init(){
	document.getElementById("b").onclick=login;
}
