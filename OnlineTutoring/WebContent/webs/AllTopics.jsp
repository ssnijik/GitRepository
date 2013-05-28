<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/webs/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<link href="css/topic.css" rel="stylesheet" type="text/css"/>
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
      <li class="active"><a href="AllTopics">BBS</a></li>
      <li><a href="Chatting">聊天</a></li>
      <li><a href="flash/OnlineTutorPlayer.html">上课</a></li>
    </ul>
    </div>
  </div>
  </div>
  
  
  
  
  
  <div style="margin-top:20px">
  <div class="container">
  <div class="row">
    <div class="span3 bs-docs-sidenav dropdown" style="z-index:100">
      <!--Sidebar content-->
      <ul class="affix bs-docs-sidenav nav nav-list" role="menu" aria-labelledby="dLabel">
      	<li class="active"><a href="AllTopics">帖子全览</a></li>
        <li><a href="MyTopics">我的帖子</a></li>
	    <li><a href="MakeTopic">发表帖子</a></li>
        <li class="dropdown-submenu"><a href="#">分类</a>
        	<ul class="dropdown-menu">
            <li><a href="#">数学</a></li>
            <li><a href="#">语文</a></li>
            <li><a href="#">物理</a></li>
            <li><a href="#">化学</a></li>
            <li><a href="#">英语</a></li>
            </ul>
        </li>
      </ul>
    </div>
    <div class="span9">
      <!--Body content-->
     <s:iterator value="#questions">
     	<div class="topic">
        <div class="well">
    <p class="text-left text-info"><a href="TopicDetail?topicid=${id}"><s:property value="title"/></a></p>
    
    <div class="row">
    <div style="padding-right:10px;padding-left:30px;">
    <p class="text-warning" style="word-wrap:break-word"><s:property value="content"/></p>
    </div>
    </div>
    
    
    <div class="row">
    <div class="span3">
     <p class="text-success">
     <em class="text-left"><s:date name="time" format="dd/MM/yyyy"/></em>
     <em class="text-center">发帖者：<s:property value="user.firstName"/><s:property value="user.lastName"/></em>
     </p>
     </div>
     
     <p class="text-error text-right">
     <em><a href="TopicDetail?topicid=${id}#comments">评论(<s:property value="answers.size"/>)</a></em>
     </p>
     
      </div>
      
      
      
      </div>
      </div>
     </s:iterator>
     
     
      <div class="btn-group" style="padding-left:20px;">
      		<s:if test="pageIndex>1">
            <a class="btn" href="AllTopics?pageIndex=<s:property value="PageIndex-1" />">上一页</a>
            </s:if>
      		<s:iterator value="new int[pageCount]" status="i">
      		<s:if test="pageIndex==#i.index+1">
            <a class="btn btn-link active" href='AllTopics?pageIndex=<s:property value="#i.index+1"/>'><s:property value="#i.index+1"/></a>
            </s:if>
            <s:else>
            <a class="btn btn-link" href='AllTopics?pageIndex=<s:property value="#i.index+1"/>'><s:property value="#i.index+1"/></a>
            </s:else>
            </s:iterator>
            <s:if test="pageCount!=0">
            <s:if test="pageIndex!=pageCount">
            <a class="btn" href="AllTopics?pageIndex=<s:property value="PageIndex+1" />">下一页</a>
            </s:if>
            </s:if>
        </div>
      
      
      </div>
      
     
      </div>
     </div>
    
  </div>



  <div class="footer" style="margin-top:400px;">
  	<div class="container">
    	<p>copyright © 2013</p>
    </div>
  </div>





</body>
</html>
