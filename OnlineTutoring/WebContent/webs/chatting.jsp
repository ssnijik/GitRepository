<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/webs/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="bootstrap/css/boot.css" rel="stylesheet" type="text/css" />
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="bootstrap/css/docs.css" rel="stylesheet" type="text/css" />

<title>无标题文档</title>

</head>
<body>

<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
  <div class="container">
    <a class="brand" href="#">零距离家教</a>
    <ul class="nav">
      <li><a href="#">首页</a></li>
      <li><a href="#">课程管理</a></li>
      <li><a href="Search">找老师</a></li>
      <li><a href="AllTopics">BBS</a></li>
      <li class="active"><a href="Chatting">聊天</a></li>
      <li><a href="flash/OnlineTutorPlayer.html">上课</a></li>
    </ul>
    </div>
  </div>
  </div>

<div class="container">
	<div class="row">

	<div class="span10">
	
    	<div class="page-header">
       <img src="1.png" width="50" height="50" />
       <div class="h">
       <article>	与王翌潋的对话</article>
       </div>
	</div>
    	<section>
		<div class="page-header">
        <div>
        <textarea rows="4" style="width: 570px; height: 120px;" placeholder="请输入发送的内容，300字以内"></textarea>
        
              <div class="h4">
              <p align="right" ><button type="submit" class="btn" >我要发送</button></p>
              </div>
              </div>
	   </div>


        

        <div class="">

            <div class="bs-docs-example">
            	<div class = "color">王翌潋<em>&nbsp;&nbsp;2013年5月12日</em></div>
                <p class="text-info">你好 我是XXX</p>
            </div>

        </div>

       
        <div class="">

            <div class="bs-docs-example">
            	<div class = "color">王翌潋<em>&nbsp;&nbsp;2013年5月12日</em></div>
                <p class="text-info">你好 我是XXX</p>
            </div>

        </div>
        
        <div class="">

            <div class="bs-docs-example">
            	<div class = "color">王翌潋<em>&nbsp;&nbsp;2013年5月12日</em></div>
                <p class="text-info">你好 我是XXX</p>
            </div>

        </div>
        
        <div class="">

            <div class="bs-docs-example">
            	<div class = "color">王翌潋<em>&nbsp;&nbsp;2013年5月12日</em></div>
                <p class="text-info">你好 我是XXX</p>
            </div>

        </div>
        
        
        
        <div class="btn-group">
            <button class="btn btn-link active">1</button>
            <button class="btn btn-link">2</button>
            <button class="btn btn-link">3</button>
            <button class="btn">下一页</button>
        </div>
        
        
    </section>
   
    </div>
  
	<div class="span2">
	
    <div id="userlist" class="pull-right affix" style="height:0px;width:120px;border:0px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">
	    <img src="images/headimg/1.png" />
	    <img src="images/headimg/2.png" />
	    <img src="images/headimg/3.png" />
	    <img src="images/headimg/4.png" />
	    <img src="images/headimg/5.png" />
		<img src="images/headimg/6.png" />
		<img src="images/headimg/1.png" />
	    <img src="images/headimg/2.png" />
	    <img src="images/headimg/3.png" />
	    <img src="images/headimg/4.png" />
	</div>
	
	</div>
 	
  	</div>
</div>
<div class="footer" style="margin-top:400px;">
  	<div class="container">
    	<p>copyright © 2013</p>
    </div>
  </div>
  
  <script language="javascript" type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	var height = document.documentElement.clientHeight;
	
	$("#userlist").height(height);
</script>
</body>
</html>
