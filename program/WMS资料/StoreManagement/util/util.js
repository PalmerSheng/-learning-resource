/*
 * Created by GFY on 2018/5/18.
 * 基于Jquery 需要引入jquery
 */


var post = "http://127.0.0.1:8080"

var token = sessionStorage.getItem("token");
var pathName = "http://"+window.location.host+"/StoreManage/Login.html";

var _Ajax = function($,D_url,data,success) {
    $.ajax({
        url: D_url,
        type: 'post',
        data: data,
        dataType: 'json',
        success: success,
        error: function(){
            alert('数据请求错误')
        }
    })
}

var goLogin = function(){
    // window.location.href = pathName
    window.location.href="file:///F:/程序练习/eclipse/WMS资料/StoreManagement/Login.html"
}

var checkToken = function(token){
    if(token == null && location.href.indexOf("Login.html")<1){
        goLogin()
    }
}

//checkToken(token)