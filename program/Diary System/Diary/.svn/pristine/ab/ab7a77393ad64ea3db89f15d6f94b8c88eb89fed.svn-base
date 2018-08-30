<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css">
<script src="<%=path%>/static/layui/layui.js"></script>
<script src="<%=path%>/static/js/jquery-1.8.0.min.js"></script>
<script src="<%=path%>/static/js/login.js"></script>
<script src="<%=path%>/static/js/giver.js"></script>
<script src="<%=path%>/static/js/util.js"></script>
<title>发奖人页面</title>
</head>
<body>
<div style="width:1400px;margin:80px auto;">
<h1 style="font-weight:bolder;text-align:center;">发奖人页面</h1><br /><br /><br />
<div class="layui-form">
   
    <div class="layui-form-item" style="display: inline-block;">
        <label class="layui-form-label">账号：</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"  id="usercode" style="width:150px" name="usercode">
        </div>
    </div>
     <div class="layui-form-item " style="display: inline-block;">
        <label class="layui-form-label">昵称：</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input"  id="nickname" name="nickname" style="width:150px;">
        </div>
    </div>
    <div class="layui-form-item " style="display: inline-block;">
        <label class="layui-form-label">用户类别</label>
        <div class="layui-input-block">
                <select id="usertype" name="usertype"   lay-filter="usertype_box" >
                    <option value="">所有</option>
                    <option value="0">普通用户</option>
                    <option value="1">发奖人</option>
                    <option value="2">系统管理员</option>
                    
                </select>
            </div>
    </div>
    <div class="layui-form-item " style="display: inline-block;margin-left:100px;">
       <button class="layui-btn" id="query_btn" lay-filter="formDemo">查询</button>

    </div>
    <div class="layui-form-item " style="display: inline-block;margin-left:40px;">
       <button class="layui-btn" id="addUser" lay-filter="formDemo">添加用户</button>

    </div>
</div>
<table id="info-box" lay-filter="test"></table>
<div>
<p>注释:</p>
<p>用户类型:0:一般用户，1:发奖人，2:系统管理员</p>
<p>账号状态:0:禁用，1:启用</P>
</div>
<script type="text/html" id="barDemo" >
    <a class="layui-btn layui-btn-normal layui-btn-mini" lay-event="save">保存</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
<script type="text/html" id="number">
    {{d.LAY_TABLE_INDEX+1}}
</script>
</div>
<script type="text/html" id="user_sort">
  <div><div class="layui-input-block" style="margin-left:0px;"><select lay-ignore><option value="0">普通用户</option><option value="1">发奖人</option><option value="2">管理员</option></select></div><div>
{{#  console.log(d.usertype);if(d.usertype =="0"){ }}
      <div><div class="layui-input-block" style="margin-left:0px;"><select lay-ignore><option value="0" selected>普通用户</option><option value="1">发奖人</option><option value="2">管理员</option></select></div><div>

  {{#  } else if(d.usertype =="1"){ }}
          <div><div class="layui-input-block" style="margin-left:0px;"><select lay-ignore><option value="0" >普通用户</option><option value="1" selected>发奖人</option><option value="2">管理员</option></select></div><div>

  {{#  } else if(d.usertype =="2"){}}
          <div><div class="layui-input-block" style="margin-left:0px;"><select lay-ignore><option value="0" >普通用户</option><option value="1" >发奖人</option><option value="2" selected> 管理员</option></select></div><div>
 {{#  } }}

</script>
<div id="addUser_content" class="layui-form" style="display:none;">
    <div class="layui-form-item" style="margin-top: 10px;">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" name="add_usercode" id="add_usercode" required lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="add_password" id="add_password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="add_nickname" id="add_nickname" required  lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户类型</label>
        <div class="layui-input-block">
            <input type="text" name="add_usertype" id="add_usertype" required  lay-verify="required" placeholder="请输入用户类型" autocomplete="off" class="layui-input">
        </div>
    </div>
</div>
</body>
</html>