<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
	String path = request.getContextPath();
%>
<html>
<head>
    <title>Diary | 系统日志</title>
    <jsp:include page="include/commonfile.jsp"/>
    <link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css">
<script src="<%=path%>/static/layui/layui.js"></script>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="am-cf admin-main">
    <jsp:include page="include/sidebar.jsp"/>

   <%--  <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统日志</strong> / <small>log</small></div>
        </div>
        <div class="am-tabs am-margin">
            <table class="am-table am-table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>用户名</th>
                        <th>时间</th>
                        <th>详情</th>
                        <th>IP</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="log" varStatus="status">
                        <tr>
                            
                            <td width="30">${status.index + 1}</td>
                            <td width="100">${log.userid}</td>
                            <td width="100">${log.time}</td>
                          
                            <td width="100">${log.detail}</td>
                            <td width="100">${log.ip}</td>
                        
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div id="page" style="float: right"></div>
        </div>
    </div>
    <!-- content end --> --%>
    
    <!-- content start -->
    <div class="admin-content">
        <div class="am-cf am-padding" style="padding:3rem;">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统日志</strong> / <small>log</small></div>
        </div>
        <div class="am-tabs am-margin" style="padding:3rem;">
            <table id="sample_table" lay-filter="sample_table"></table>
            <div id="page" style="float: right"></div>
        </div>
    </div>
    <!-- content end --> 
    
</div>
<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<div style="display:none" hidden="hidden"  id="userid_field">${userid}</div>

<%-- <input type="hidden"  value="${num}" id="num"> --%>
<jsp:include page="include/footer.jsp"/>

<script>
layui.use(['form','layer','table'],function(){
    var   form = layui.form,
        layer = layui.layer, table = layui.table;
    
    form.render();
        
    var userid = $("#userid_field").text();
    function initTable() {
        var tableInts = table.render({
            elem: '#sample_table',
            url: "/Diary/"+userid+"/log1",
            width:900,
            cols: [[
               
                {field:'id', title: '#', width:100, fixed: true}
                ,{field:'userid', title: '用户名', width:150,}
                ,{field:'time', title: '时间', width:200}
                ,{field:'detail', title: '详情', width:200}
                ,{field:'ip', title: 'IP'}
                
            ]],
            id: 'tableReload',
            page: true,
            limit: 5,
            limits:[5],
            even: true,
            where: {
               
               	
            },
            done: function(data){
               
            }
        });
    }

    initTable();
	
});

</script>
</body>
</html>
