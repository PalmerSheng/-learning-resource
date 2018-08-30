<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>  
<%@page import="org.model.MessBoar" %>  
<%@page import="org.dao.*" %>  
  
<html>  
  <head>    
    <title>留言板界面</title>  
    <style>
    table tr td{
     width:150px;
    /*text-align:left;
    text-indent:16px; */
    }
    </style>
  </head>  
  
  <body bgcolor="#ddd" >  
  <div style="font-family:Microsoft YaHei;width:800px;margin:100px auto;text-align:center;">  
   <h1>这里是留言板主界面</h1> 
   <div style="width:600px;margin:0px auto;text-align:center;">
   <form  action="leavemessage.jsp" method="post" style="text-align:center;">  
        <table style="text-align:center;">  
            <caption></caption>  
            <tr><th>留言人姓名</th><th>留言时间</th>  
                <th>留言标题</th><th>留言内容</th></tr>  
        <%  
            ArrayList<MessBoar> al=new ArrayList<MessBoar>();  
            al= (ArrayList)session.getAttribute("al");  
            if(al!=null){  
                Iterator iter=al.iterator();  
                while(iter.hasNext()){  
                MessBoar mb=(MessBoar)iter.next();  
        %>  
                <tr><td><%= mb.getName().toString() %></td>  
                    <td><%= mb.getTime().toString() %></td>  
                    <td><%= mb.getTitle() %></td>  
                    <td><%= mb.getMessage() %></td></tr>  
        <%   
            }  
            }  
         %>  
        </table>  
    </form>  
   <a style="margin-left:22%" href="leavemessage.jsp">留言</a>  
   </div> 
    </div>  
  </body>  
</html>  