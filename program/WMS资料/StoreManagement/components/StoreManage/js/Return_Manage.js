layui.use(['form','jquery','layer'],function(){
    var form=layui.form,$=layui.$,layer=layui.layer
    var saveURL=post+"/WMS/OnOrOutStoreController/outStore01"
    form.on('submit(save)',function(data) {
        layer.confirm("是否提交", {
            title: '提交信息',
            btn: ["确认", "取消"],
            yes: function () {
                _Ajax($, saveURL, {
                    goods_code:$("#goods_code").val(),
                    goods_num:$("#goods_num").val(),
                    supply_code:$("#supply_code").val(),
                    single_money:$("#single_money").val()
                }, function (data) {
                    console.log("code:"+data.code)
                    var error = data.message;
                    if(data.code==200){
                        layer.alert(data.message)
                    }
                    else {
                        layer.alert(error);
                    }
                });
            }
        })
        form.render('','selFilter');
        return false;
    })
})