<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="Js/del.js"></script>
	<script type="text/javascript" src="Js/update.js"></script>
	<script>
	
	function del()
	{
		delAjax(delNo.value);
	}
	function update()
	{
		updateAjax(updateName.value,updateAge.value);
	}
	</script>
  </head>
  <%--使用servlet,ajax和Dao实现简单的增删改查功能，没有添加验证 --%>
  <body>
   
   <a href="servlet/SelSql">数据库中所有数据为</a>
   <form action="servlet/InsSql" method="post">
   <input type="text" name="SNo" placeholder="请输入学生号" />
   <input type="text" name="SName" placeholder="请输入学生名" />
   <input type="text" name="SAge" placeholder="请输入年龄" />
   <input type="submit" value="插入" /><br>
   </form>
     <input type="text" id="delNo" placeholder="请输入要删除的学生号" />
     <input type="button" onclick="del()" value="提交"/><br />
     <input type="text" id="updateName" placeholder="请输入要修改的学生名字" />
     <input	type="text" id="updateAge"  placeholder="修改后的学生年龄" />
     <input type="button" onclick="update()" value="修改" />
     <div id="infoDiv"></div>
  </body>
</html>
