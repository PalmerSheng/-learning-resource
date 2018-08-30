<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <style>
    *{
    margin:0px;
    padding:0px;
    font-size:32px;
    }
   #main{
background-image:url(/WeChat/resources/img/2.jpg);
height:100%;
background-size:cover;
}
    #content{
    width:300px;
    margin-top:100px;
    }
    input[type="submit"]{
    background-image: url(/WeChat/resources/img/btn.jpg);
	text-align: center;
	border-radius:10px;
	}
    
    </style>
<%
        if(application.getAttribute("counter") == null)
        {
            application.setAttribute("counter", "1");
        }
        else
        {
            String strnum = null;
            strnum = application.getAttribute("counter").toString();
            int icount = 0;
            icount = Integer.valueOf(strnum).intValue();
            icount++;
            application.setAttribute("counter", Integer.toString(icount));
            
        }
            
    %>
  </head>
  
 <body>
 

    
<div id="main">
<div style="height:100%;width:100%;border:1px solid black">

<div style="float:left;width:30%;margin-top:300px;margin-left:30%;text-align:center;" >
用户登陆<br /><br />
<form method = "post" action = "chuli.jsp">
用户名:<input type = "text" name = "user"><br />
</input><br />

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value ="登录" style=></input><span style="font-size:16px;float:right">您是第<%=application.getAttribute("counter") %>位访问者！</span>
</form>
</div>
</div>
</div>
</body>
</html>
