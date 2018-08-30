


//定义jQuery的闭包
(function($){
	$.Collage_EditServer=function(){
		this.dealkind="";
		this.checkFormObj={};
		
		//编辑页面初始化
		this.InitPage=function(){
		};
		
		//初始化表单验证
		this.InitFormValidate=function(){
			Collage_EditServer.checkFormObj=$("#addNewCollage").validate({
				rules: 
		           {  
					   collagecode: {  
		                   required: true,
		                   maxlength: 40
		               },  
		               collagename: {  
		            	   required: true,
		                   maxlength: 40
		               }      
		           },  
		           messages: 
		           {  
		        	   collagecode: {  
	                       required: "学院编码不能为空",    
	                       maxlength: "最大输入40个字符"  
	                   },  
	                   collagename: {  
	                	   required: "学院名称不能为空",    
	                       maxlength: "最大输入40个字符"   
	                   }  
		           }  
			});
		};
		this.btnOK=function(){

			if(!Collage_EditServer.checkFormObj.form()){
				return;
			}
	
			var url="/springTest/College/upd";
			$.ajax({
				type: "POST",
				url: url,
				data:{
					"collageid":$("#collageid").val(),
					"collagecode":$("#collagecode").val(),
					"collagename":$("#collagename").val(),
				},
				success:function(data){
					if(data.result=='0'){
						layer.alert(data.msg,{skin: 'layui-layer-lan',closeBtn: 0,shift: 5,btn:['确定'],
						yes:function(index,layero){
							window.parent.ObjCollage_Main.TableInit();
							indexs=window.parent.layer.index;
							window.parent.layer.close(indexs);
						}	
						});
					}
				}
			});
		};
		this.btnCancel=function(){
			indexs=window.parent.layer.index;
			window.parent.layer.close(indexs);
		};
		
	};
	
})(jQuery);


var Collage_EditServer=new jQuery.Collage_EditServer();
$(function(){
	Collage_EditServer.InitPage();
	Collage_EditServer.InitFormValidate();
});