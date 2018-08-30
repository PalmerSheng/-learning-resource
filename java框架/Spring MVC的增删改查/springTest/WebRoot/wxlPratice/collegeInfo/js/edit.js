

(function($){
	
$.Collage_Edit=function(){
	this.dealkind = "";
	this.checkFormObj={};
	//编辑页面初始化
	this.InitPage=function(){
		//这和request.getParameter("")都一样，不过在里是这样写的
		var dealkind = ObjCollage_Edit.QueryString("dealkind");
		if(dealkind == null || dealkind == undefined || dealkind == "undefined")
	    {
	    	return;
	    }
		ObjCollage_Edit.dealkind=dealkind;
		if(dealkind=="upd"){
		var	ObjSelectRow=window.parent.ObjCollage_Main.ObjSelectRow;
		$("#collageid").val(ObjSelectRow.id);
		$("#collagecode").val(ObjSelectRow.collagecode);
		$("#collagename").val(ObjSelectRow.collagename);
		}
		
	};
	//初始化表单验证
	this.InitFormValidate=function(){
		//这是一个jQuery的表单校验
		ObjCollage_Edit.checkFormObj=$("#addNewCollage").validate({
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
		if(!ObjCollage_Edit.checkFormObj.form()){
			return;
		}
		var url="";
		if(ObjCollage_Edit.dealkind=="upd"){
			url="/springTest/College/upd";
		}
		if(ObjCollage_Edit.dealkind=="add"){
			url="/springTest/College/add";
		}
		$.ajax({
			type: "POST",
			url: url,
			data:{
				"collageid": $("#collageid").val(),
				"collagecode": $("#collagecode").val(),
				"collagename": $("#collagename").val()
			},
			success:function(data){
				if(data.result=='0'){
					layer.alert(data.msg,{skin: 'layui-layer-lan',closeBtn: 0,shift: 5,btn:['确定'],
						yes:function(index,layero){
							window.parent.ObjCollage_Main.TableInit();
							//因为已经进行了客户端修改，必须初始化表格
							var indexs=window.parent.layer.index;
							parent.layer.close(indexs);
						}
					});
				}
			}
		});
	};
	this.btnCancal = function(){
		var indexs = window.parent.layer.index;
		parent.layer.close(indexs);
	};
	this.QueryString = function(name) 
    { 
    	var reg = new RegExp("(^|\\?|&)"+ name +"=([^&]*)(\\s|&|$)", "i"); 
    	if (reg.test(location.href)) return unescape(RegExp.$2.replace(/\+/g, " ")); return ""; 
    };
	
};	
	
	
})(jQuery);

var ObjCollage_Edit=new jQuery.Collage_Edit();
$(function(){
	ObjCollage_Edit.InitPage();
	ObjCollage_Edit.InitFormValidate();
});