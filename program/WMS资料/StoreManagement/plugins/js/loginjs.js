/**
 * Created by 12564 on 2018/5/21.
 */
layui.use(['jquery','layer'],function(){
    var $ = layui.$, layer = layui.layer;
    var url = post+"/WMS/login/goIndex";

    $("#login").on("click",function() {

        var username = $("#username").val(),
            password = $("#password").val()

        if (username == '') {
            layer.alert("账号不能为空");
        } else if (password == '') {
            layer.alert("密码不能为空");
        }
        else {
            $.ajax({
                url: url,
                type: 'post',
                data: {
                    usercode: username,
                    password: password,
                },
                dataType: 'json',
                success: function (data) {
                    console.log(data.datas)
                    if (data.code == 0) {
                        sessionStorage.setItem('token', data.datas.token);
                        window.location.href = 'index.html';
                    } else {
                        layer.alert(data.message);
                    }
                },
                error: function () {
                    alert('数据请求错误')
                }
            })
        }
    })

    $("#fbtn").on('click',function(){
        $("#ctt").show()
    })
    $("#register").on("click",function () {
        window.location.href = 'register.html'

    })


});