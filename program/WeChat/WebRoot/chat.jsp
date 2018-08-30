<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
*{
margin:0px;padding:0px;}
#main{
background-image:url(/WeChat/resources/img/2.jpg);
height:100%;
background-size:cover;
}
#content{

margin-top:100px;
margin-left:200px;
width:802px;

}
input[type="submit"]{
    background-image: url(/WeChat/resources/img/btn.jpg);
	text-align: center;
	border-radius:5px;
	
	}
	input[type="button"]{
    background-image: url(/WeChat/resources/img/btn.jpg);
	text-align: center;
	border-radius:5px;
	height:30px;
	}
</style>
  </head>
  
  <body>
  
<%
  response.setHeader("refresh","15"); 
  String sess_us, talk, tmp;
  request.setCharacterEncoding("utf-8");
  sess_us = (String)session.getAttribute("sess_us");
 Date date=new Date();
 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 String time=format.format(date);
 
 if(request.getParameter("say")!="" &&request.getParameter("say")!=null){
  talk = request.getParameter("say");
  if(application.getAttribute("app_fy")== ""||application.getAttribute("app_fy")== null){
        application.setAttribute("app_fy", "欢迎进入聊天页面<br />");
    }
  if(talk != ""){
    String ans = time.toString()+"   "+sess_us+"说: "+talk+"<br>";
    
    
        tmp = (String)application.getAttribute("app_fy");
        ans = tmp + ans;
        application.setAttribute("app_fy", ans);
   
  }
  }
%>
 
    
    
<div id="main">
<div style="height:100%;width:100%;border:1px solid black">
<div id="content">
<span style="font-size:40px;">用户聊天页面</span>
<table border="1" width="800" style="border-collapse: collapse;">
<tr><td  id="tt" ><%=application.getAttribute("app_fy") %>
</table>

<form action="chat.jsp" method = "post"name = "chats" style="">
  <textarea rows="3" cols="80" name = "say" style="resize:none;border:1px solid black; width:750px;"></textarea>
  <input type = "submit" value = "发送"  style="width:52px;float:right;height:45px;" />
</form><br /><br />
<div style="height:300px;width:100%;text-align:center;">
<input type = "button" value = "刷新聊天记录"  onclick="javascript:location.href='chat.jsp';" />
  <a href="/WeChat/clear"><input type = "button" value = "清空"   /></a>
  <input type = "button" value = "退出聊天"  onclick="javascript:location.href='login.jsp';" />
</div>
    
</div>
</div>
</div>
</body>
</html>
