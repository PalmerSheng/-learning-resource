<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="<%=path%>/resources/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="<%=path%>/resources/css/style.css" />
<link href="<%=path%>/resources/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/resources/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=path%>/resources/font/css/font-awesome.min.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="<%=path%>/resources/js/jquery-1.9.1.min.js"></script>
<script src="<%=path%>/resources/js/juqery.form.js"></script>
<link href="<%=path%>/resources/assets/css/bootstrap-table.min.css"
	rel="stylesheet" />
<script src="<%=path%>/resources/assets/js/bootstrap-table.min.js"></script>
<script src="<%=path%>/resources/assets/js/bootstrap-table-zh-CN.min.js"></script>
<script src="<%=path%>/resources/assets/js/bootstrap.min.js"></script>
<script src="<%=path%>/resources/assets/js/jquery.dataTables.min.js"></script>
<script
	src="<%=path%>/resources/assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="<%=path%>/resources/assets/layer/layer.js"
	type="text/javascript"></script>
<script src="<%=path%>/resources/assets/laydate/laydate.js"
	type="text/javascript"></script>
<script src="<%=path %>/resources/Widget/Validform/5.3.2/Validform.min.js" type="text/javascript"></script>  
<script src="<%=path %>/resources/js/ajaxClear.js"
	type="text/javascript"></script>
<script src="<%=path %>/wxlPratice/collegeInfo/js/CollegeMain.js"></script>

</head>

<body>
	<div class="margin clearfix" id="print">
		<div class="search_style">
			<div class="title_names">搜索查询</div>
			<ul class="search_content clearfix">
				<li><label class="l_f">学院名称：</label> <input name="collagename"
					id="collagename" type="text" class="text_add" placeholder="输入学院名称"
					style=" width:200px" /></li>
				<li style="width:120px;">
					<button type="button" class="btn_search"
						onclick="ObjCollage_Main.search()">
						<i class="icon-search"> </i>查询
					</button></li>
			</ul>
		</div>
		<div class="border clearfix">
			<span class="r_f"> <a href="#"
				id="Competence_add" class="btn btn-info" title="新增"
				onclick="ObjCollage_Main.add();"> <i class="fa fa-plus"></i>新增学院</a>
			</span>

		</div>
		<div class="compete_list">
			<table style="width:100%"
				class="tablecss table table-striped table-bordered table-hover"
				id="dept-table">
				<colgroup id="colgroup">
			</table>
		</div>
	</div>

</body>
</html>
