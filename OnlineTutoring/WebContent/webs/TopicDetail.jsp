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
  
  <div class="container">
  	<section>
    	<div class="page-header">
        	<div class="media">
            	<a class="pull-left">
                	<img class="media-object" data-src="holder.js/64x64" />
                </a>
                <div class="media-body">
                	<h4 class="media-heading"><s:property value="user.firstName"/><s:property value="user.lastName"/></h4>
                </div>
               
            </div>
        </div>
        <div class="bs-docs-example">
            <h3>话题：<s:property value="title"/></h3>
            <div class="row">
                <div class="span10 offset1">
                <p class="text-info" style="word-wrap:break-word"><s:property value="content"/></p>
                
                <s:if test='picture!=null'>
            	<img src='../images/<s:property value="picture"/>' alt="" style="width:200px;height:200px;"/>
            	</s:if>
            	
            	</div>
            </div>
            
            <div class="row">
            	<div class="span11">
            		<p class="text-right">
            		<s:if test='attachment!=null'>
                    <i class="icon-download-alt"></i><a href="DownloadAction?fileName=<s:property value="attachment"/>"><s:property value="attachname"/></a>&nbsp;
                    </s:if>
                    <em><strong><s:date name="time" format="dd/MM/yyyy"/></strong></em>&nbsp;
                    <em><strong>类别：
                    	<s:property value="subject.name"/>
                    </strong></em>
                    </p>
                </div>
            </div>
        </div>
    </section>	
    <section id="comments">
    <s:form action="MakeCommentAction.action " method="post" enctype="multipart/form-data" id="commentform">
    	<div class="page-header">
        	<h5>评论区</h5>
        </div>
        <textarea rows="4" style="width:100%;" placeholder="说点什么......" id="replybox" name="content"></textarea>
        <input type="text" style="display:none" name="topicid" value="${topicid} "/>
        
        <p align="right">
        <a class="btn btn-link btn-small" style="margin-left:0" href="javascript:fileopen();" >图片</a>
        <input type="file" id="commentpicture" style="width:0;height:0" name="picture"/>
        <button type="button" class="btn" onclick="makeComment()">我要评论</button>
        </p>
    <s:token/>
    </s:form>   
        
        
        <table class="table">
        <tbody>
        <s:iterator value="#answers">
        <tr>
        <td>
        <div class="media">
        	<a href="#" class="pull-left">
            	<img class="media-object" data-src="holder.js/64x64" />
            </a>
            <div class="media-body">
            	<h6><s:property value="user.firstName"/><s:property value="user.lastName"/></h6>
                <p class="text-info"><s:property value="content"/></p>
                <s:if test='picture!=null'>
            	<img src='../images/<s:property value="picture"/>' alt="" style="width:200px;height:200px;"/>
            	</s:if>
            	
            	</div>
            </div>
            <p align="right">
            <em><s:date name="time" format="dd/MM/yyyy"/></em>
            <button class="btn btn-link" onclick="focusReplyBox('<s:property value="user.firstName"/>')">回复</button>
            </p>
        </div>
        </td>
        </tr>
        </s:iterator>
        </tbody>
        </table>
        
        
        <div class="btn-group" style="padding-left:20px;">
      		<s:if test="pageIndex>1">
            <a class="btn" href="TopicDetail?pageIndex=<s:property value="PageIndex-1" />#comments">上一页</a>
            </s:if>
      		<s:iterator value="new int[pageCount]" status="i">
      		<s:if test="pageIndex==#i.index+1">
            <a class="btn btn-link active" href='TopicDetail?pageIndex=<s:property value="#i.index+1"/>#comments'><s:property value="#i.index+1"/></a>
            </s:if>
            <s:else>
            <a class="btn btn-link" href='TopicDetail?pageIndex=<s:property value="#i.index+1"/>#comments'><s:property value="#i.index+1"/></a>
            </s:else>
            </s:iterator>
            <s:if test="pageCount!=0">
            <s:if test="pageIndex!=pageCount">
            <a class="btn" href="TopicDetail?pageIndex=<s:property value="PageIndex+1" />#comments">下一页</a>
            </s:if>
            </s:if>
        </div>
        
        
    </section>
  </div>
  
  <div class="footer" style="margin-top:400px;">
  	<div class="container">
    	<p>copyright © 2013</p>
    </div>
  </div>

<script language="javascript" type="text/javascript" src="bootstrap/js/holder.js"></script>
<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript">
function focusReplyBox(person)
{
	$("#replybox").focus();
	$("#replybox ").val("回复"+person+":");
}
</script>
<script src='/OnlineTutoringSystem/dwr/engine.js'></script>
<script src='/OnlineTutoringSystem/dwr/util.js'></script>
<script src='/OnlineTutoringSystem/dwr/interface/makecommentaction.js'></script>
<script type="text/javascript">
function makeComment()
{
	if(checkPicture())
		$("#commentform").submit();
}

function fileopen()
{
	$("#commentpicture").click();
}
function checkPicture()
{
	var picturename = $("#commentpicture").val();
	//alert(picturename.split('.')[1]);
	if(picturename!="")
	{
		if(picturename.split('.')[1]=="jpg"||picturename.split('.')[1]=="png"||picturename.split('.')[1]=="jpeg"
			||picturename.split('.')[1]=="bmp")
			return true;
		else
		{
			alert("图片格式不允许");
			return false;
		}
	}
	return true;
}
</script>
</body>
</html>
