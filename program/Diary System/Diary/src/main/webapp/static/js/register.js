
document.onkeydown=function(event){
	   
		   var e = event || window.event || arguments.callee.caller.arguments[0];           
           if(e && e.keyCode==13){ // enter 键
        	   register();
          }
	              
};

function  register() {
		
//	    $('#register_btn').attr("disabled","disabled");
	    var userid = $("#userid").val();//.trim();
	    var password = $("#password").val();//.trim();
	    var checkPassword = $("#checkPassword").val();//.trim();
	    var nickname = $("#nickname").val();//.trim();
	    if(isNull(userid)){
	         layer.alert("用户名不能为空");
	          $('#login_btn').removeAttr("disabled");
	         return false;
	    }
	    if(isNull(password)){
	         layer.alert("密码不能为空");
	         $('#login_btn').removeAttr("disabled");
	         return false;
	    }
	    if(isNull(checkPassword)){
	         layer.alert("确认密码不能为空");
	         $('#login_btn').removeAttr("disabled");
	         return false;
	    }
	    if(checkPassword !=password){
	         layer.alert("两次输入密码不一致");
	         $('#login_btn').removeAttr("disabled");
	         return false;
	    }
	    if(isNull(nickname)){
	         layer.alert("昵称不能为空");
	         $('#login_btn').removeAttr("disabled");
	         return false;
	    }else{
	    	 $('#login_btn').attr('value','注册中~');
	    	 return true;
	    }
	   
	};
	
	function isNull(input){
	    if(input == null || input == '' || input == undefined){
	      return true;
	    }
	    else{
	      return false;
	    }
	  }
	