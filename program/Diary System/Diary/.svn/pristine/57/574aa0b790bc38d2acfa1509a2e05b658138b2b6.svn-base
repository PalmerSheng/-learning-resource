
document.onkeydown=function(event){
	   
		   var e = event || window.event || arguments.callee.caller.arguments[0];           
           if(e && e.keyCode==13){ // enter 键
               LogIn();
          }
	              
};

function  LogIn() {

//    $('#login_btn').attr("disabled","disabled");
    var usercode = $("#userid").val();//.trim();
    var password = $("#password").val();//.trim();
    var code = $("#code").val();//.trim();
    if(isNull(usercode)){
         layer.alert("用户名不能为空");
          $('#login_btn').removeAttr("disabled");
         return false;
    }
    if(isNull(password)){
         layer.alert("密码不能为空");
         $('#login_btn').removeAttr("disabled");
         return false;
    }
    if(isNull(code)){
         layer.alert("请输入验证码");
         $('#login_btn').removeAttr("disabled");
         return false;
    }
    else{
    	$('#login_btn').attr('value','登录中~');
    
    	return true;
    }
    
};

function myReload(){

    document.getElementById("vertifycode").src=document.getElementById("vertifycode").src + "?nocache="+new Date().getTime();
 };
 
 function isNull(input){
	    if(input == null || input == '' || input == undefined){
	      return true;
	    }
	    else{
	      return false;
	    }
	  }
 
	