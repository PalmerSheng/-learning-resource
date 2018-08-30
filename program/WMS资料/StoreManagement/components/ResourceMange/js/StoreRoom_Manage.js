/**
 * Created by GFY on 2018/5/19.
 */
layui.use(['element','table','layer','jquery','laydate','form'],function(){
    var element = layui.element, layer = layui.layer, table = layui.table;
    var $ = layui.$, laydate = layui.laydate,form = layui.form;
    var StoreRoomIDValue = "",  StoreRoomText = "";

    var TableUrl = post + "/WMS/PositionManger/show";
    var delectCheckURL = post + "";
    var UpdatePersoninfoUrl = post + "";
    var AddPersoninfoUrl = post + "";


    // 查询
    $("#search").on('click',function(){
        initTable();
    });

    form.on('select(selFilter)', function (data) {
        StoreRoomIDValue = data.value;
        StoreRoomText = data.elem[data.elem.selectedIndex].text;
        form.render('select');
    });

    // 编辑
    table.on('tool(StoreRoom_table)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'edit'){

            $("#ID").val(data.ID)
            $("#StoreRoom_Name").val(data.StoreRoom_Name)
            $("#Store_location").val(data.Store_location)
            $("#Store_ID").val(data.Store_ID)
            form.render()
        }
        layer.open({
            type:1,
            title:"信息修改",
            area: ['1000px', '500px'],
            shadeClose: true,
            content: $('#alert_edit_form'),
        })

    });

    $("#closeLayer").on('click',function(){
        layer.closeAll()
    });

    form.on('submit(demo1)', function(data){

        var data = JSON.stringify(data.field);
        var datafield = data.substring(1,data.length-1);
        _Ajax($,UpdatePersoninfoUrl,{
            ordinaryinfo:datafield,
            loginusercode: account,
            usercode: usercode,
            token:token
        },function(data){
            if(data.code ==403){
                layer.alert("用户登陆信息过期")
                goLogin()
            }else {
                var success = data.message;
                if(data.code == 200){
                    layer.confirm("修改成功",{
                        btn: ["确认"],
                        yes: function(){
                            initTable()
                            layer.closeAll()
                        }
                    });
                }else{
                    layer.alert(success);
                }
            }
        });
        form.render();
        return false;
    });

    table.on('checkbox(test)',function (obj) {

    });

    // 删除
    $("#delectCheckData").click(function (data) {
        var checkStatus = table.checkStatus('test'),
            data = checkStatus.data;                            // 获取选中行的数据

        var deleteInfo = {
            data:data
        };

        layer.confirm("确认删除吗？",{
            btn: ["确认","取消"]
        },function (index) {
            _Ajax($,delectCheckURL,{
                token:token,
                data:JSON.stringify(deleteInfo)
            },function (data) {
                if(data.code === 403){
                    layer.confirm("用户信息失效",{
                        btn:["确定"],
                        yes:function () {
                            goLogin()
                        }
                    })
                }else {
                    layer.alert("删除成功");
                    initTable()
                }
            })
        },function (index) {
            layer.close(index)
        })

    });

    // 添加
    $("#add").on('click',function (obj) {

        $("#ID2").val(data.ID);
        $("#StoreRoom_Name2").val(data.StoreRoom_Name2);
        $("#Store_location2").val(data.Store_location2);
        $("#Store_ID2").val(data.Store_ID2);
        form.render();

        layer.open({
            type:1,
            title:"信息修改",
            area: ['1000px', '500px'],
            shadeClose: true,
            content: $('#alert_add_form'),
        })
    });
    $("#closeLayer2").on('click',function(){
        layer.closeAll()
    });
    form.on('submit(demo2)', function(data){

        var data = JSON.stringify(data.field);
        var datafield = data.substring(1,data.length-1);
        _Ajax($,AddPersoninfoUrl,{
            ordinaryinfo:datafield,
            loginusercode: account,
            usercode: usercode,
            token:token
        },function(data){
            if(data.code === 403){
                layer.alert("用户登陆信息过期")
                goLogin()
            }else {
                var success = data.message;
                if(data.code === 200){
                    layer.confirm("修改成功",{
                        btn: ["确认"],
                        yes: function(){
                            initTable()
                            layer.closeAll()
                        }
                    });
                }else{
                    layer.alert(success);
                }
            }
        });
        form.render();
        return false;
    });




    function initTable() {
        var tableInts = table.render({
            elem: '#StoreRoom_table',
            url:TableUrl,
            cols: [[
                {checkbox: true, fixed: true}
                ,{field:'ID', title: '库房ID', width:160}
                ,{field:'supplierName', title: '库房名', width:250,}
                ,{field:'sex', title: '库房位置', width:250,}
                ,{field:'Phone', title: '库房所属地', width:250,}
                ,{field:'handle', title: '操作', width:250,toolbar:'#btn_wraper'}
            ]],
            id: 'test',
            page: true,
            limit: 10,
            even: true,
            where: {
                StoreRoomIDValue: StoreRoomIDValue,
                token: token
            },
            done: function(res,curr,count){

            }
        });
    }

    initTable()
});

