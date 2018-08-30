layui.use(['form','jquery','layer'],function(){
    var form=layui.form,$=layui.$,layer=layui.layer

    var saveURL=post+""
    form.on('submit(save)',function(data) {
        layer.confirm("是否提交", {
            title: '提交信息',
            btn: ["确认", "取消"],
            yes: function () {
                var datafield = data.field;
                console.log(datafield)
                _Ajax($, saveURL, {
                    token: token,
                    data: JSON.stringify(datafield)
                }, function (msg) {
                    var error = msg.message;
                    if (data.code == 403) {
                        layer.alert("登录超时"),
                            goLogin()
                    } else {
                        form.val("formTest", {
                            "goods_code": ""
                            , "goods_num": ""
                            , "take_code":""
                            , "douser_code": ""
                            , "place":""
                        })
                        layer.alert(error);
                    }
                });
            }
        })
        form.render('','selFilter');
        return false;
    })
})