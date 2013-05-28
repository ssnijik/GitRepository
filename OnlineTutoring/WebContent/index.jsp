<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src='/OnlineTutoringSystem/dwr/engine.js'></script>
	<script src='/OnlineTutoringSystem/dwr/interface/testdwr.js'></script>
	<script src='jquery.js'></script>
	<script type="text/javascript" src="ajax-pushlet-client.js"></script>
	<script type="text/javascript">
		function test(){
			var user = $('#user').val();
			testdwr.sayHello(user,callback);
			//alert(user);
		}
		function callback(msg)
		{
			alert(msg);
		}
	</script>
	
	<script type="text/javascript">
		PL._init();
		PL.joinListen("/test2/he");
		function onData(event)
		{
			alert(event.get("he"));
		}
		
		function cancelListen()
		{
			PL.leave();
		}
		
	</script>
	
  </head>
  
  <body>
    <input id="user" type="text"/>
    <input type='button' value="test" onclick='test();'/>
  </body>
</html>
