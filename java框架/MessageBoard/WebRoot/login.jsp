<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#ddd" style="font-family:Microsoft YaHei" >  
  <div style="text-align:center;margin-top:120px">  
    
    <form action="loginServlet" method="post">  
        <table style="margin-left:40%">  
            <caption style="font-size:30px;">�û���¼ <br /></caption> 
            <tr >  
                <td>��¼����</td>  
                <td><input name="name" type="text" size="20"></td>  
            </tr>  
            <tr>  
                <td>��&nbsp;&nbsp;&nbsp;�룺</td>  
                <td><input name="password" type="password" size="20"></td>  
            </tr>  
        </table>   
       <div style="margin-top:10px;margin-left:-80px;">
        <input type="submit" value="��¼">  
        <input type="reset" value="����"> 
        <a href="register.jsp">ע��</a>  
        </div>   
    </form>  
    <br>  
   
    </div>  
  </body> 
</html>
