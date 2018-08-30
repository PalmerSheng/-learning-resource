<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",basePath);
String Path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+'/';
request.setAttribute("picpath",Path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
        <link href="<%=path %>/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="<%=path %>/resources/css/style.css"/>       
        <link href="<%=path %>/resources/assets/css/codemirror.css" rel="stylesheet"/>
        <link rel="stylesheet" href="<%=path %>/resources/assets/css/ace.min.css" />
        <link rel="stylesheet" href="<%=path %>/resources/font/css/font-awesome.min.css" />
        <link rel="stylesheet" href="<%=path %>/resources/layui/css/layui.css"/>
		<link rel="stylesheet" href="<%=path %>/resources/js/jquery-typeahead/jquery.typeahead.min.css" type="text/css"/>
        <!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="<%=path %>/resources/js/jquery-1.9.1.min.js"></script>
		<script src="<%=path %>/resources/assets/js/jquery.validate.min.js"></script>
        <script src="<%=path %>/resources/assets/js/bootstrap.min.js"></script>
		<script src="<%=path %>/resources/assets/js/typeahead-bs2.min.js"></script>           	
		<script src="<%=path %>/resources/assets/js/jquery.dataTables.min.js"></script>
		<script src="<%=path %>/resources/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script src="<%=path %>/resources/assets/layer/layer.js" type="text/javascript" ></script>          
        <script src="<%=path %>/resources/assets/laydate/laydate.js" type="text/javascript"></script>
         <script src="<%=path %>/resources/layui/layui.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path%>/resources/js/jquery-typeahead/jquery.typeahead.min.js"></script>
		<script src="<%=path %>/resources/js/ajaxClear.js" type="text/javascript"></script>
        <script type="text/javascript">var path ="<%=path%>"</script>
        <script src="<%=path %>/resources/js/juqery.form.js" type="text/javascript"></script>
    	<script src="<%=path %>/wxlPratice/collegeInfo/js/editServer.js"></script>
<!--     如果从后台返回到这个jsp，一定要用绝对路径，
    如果从前台跳转到这个jsp，可以用绝对路径，也可以用相对路径 -->
<title>添加</title>
<style>
	#sample-table textarea,#sample-table select{
	margin-left:10px;
		}
		#sample-table input{
			height:40px;
		} 
		#pic{
			display:block;
			margin:10px auto;
		}
		#addNewCollage label.error {  
        	color: Red;  
        }
    } 
</style>
</head>

<body >

 <div class="margin clearfix"  style="padding-bottom:5px;">	
 		
 	 <div class="search_style">
      <div class="title_names">编辑学院信息</div>
      <form method="post" action="" id="addNewCollage">
	   <div class="compete_list" style="padding-top:5px;">
	   <input type="hidden" id="collageid" name="collageid" value="${collageinfo.id}"/>
	    <table  class="table table-striped table-bordered table-hover" id="sample-table">
			  <tr>
				<th style="text-align:center; font-size:14px"><span style="font-family:'Applied Font Regular', 'Applied Font';color:#FF0000;">*</span>学院编码</th>
				<td style="" id="usercodes">				
                    <input  type="text" style="width:80%;" name="collagecode" id="collagecode" value="${collageinfo.collagecode}"/> 
				</td>	
			  </tr>
			  <tr>
				<th style=" text-align:center; font-size:14px"><span style="font-family:'Applied Font Regular', 'Applied Font';color:#FF0000;">*</span>学院名称</th>
				<td style="" id="usernames">				
                    <input  type="text" style="width:80%;" name="collagename" id="collagename" value="${collageinfo.collagename}"/> 
				</td>	
			  </tr>
	        </table>
	         <div style="text-align:center">
	  		 <input type="button" class="btn btn-success" onclick="Collage_EditServer.btnOK()" style="width:110px;" value="确定" /> 
	  		 <input type="button" class="btn btn-default" onclick="Collage_EditServer.btnCancel()" style="width:110px;" value="取消" /> 
	  		</div>
	  		</div>
	  </form>
    </div>     
 </div>
</body>

</html>