/**
 * Created by GFY on 2018/5/19.
 */
layui.use(['element','table','layer','jquery','laydate','form'],function(){
    var element = layui.element, layer = layui.layer, table = layui.table;
    var $ = layui.$, laydate = layui.laydate,form = layui.form;

    var TableUrl = post + "/WMS/StoreKeeperInfoController/info";
    var delectCheckURL = post + "/WMS/StoreKeeperInfoController/deleteinfo";
    var UpdatePersoninfoUrl = post + "/WMS/StoreKeeperInfoController/updateinfo";
    var AddPersoninfoUrl = post + "/WMS/StoreKeeperInfoController/insertinfo";



    // 查询
    $("#search").on('click',function(){
        initTable();
    });



    // 编辑
    table.on('tool(Admin_table)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'edit'){

            $("#id1").val(data.id);
            $("#username1").val(data.username);
            $("#password1").val(data.password);
            $("#unit_code1").val(data.unit_code);
            $("#level1").val(data.level);
            $("#tel1").val(data.tel);
            $("#depart1").val(data.depart);
            $("#group1").val(data.group);
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

        var unit_code = $("#unit_code1").val(),
            username = $("#username1").val(),
            password = $("#password1").val(),
            level = $("#level1").val(),
            tel = $("#tel1").val(),
            depart = $("#depart1").val(),
            group = $("#group1").val()

        _Ajax($,UpdatePersoninfoUrl,{
            unit_code:unit_code,
            username:username,
            password:password,
            level:level,
            tel:tel,
            depart:depart,
            group:group,
            token:token
        },function(data){
            if(data.code === 403){
                layer.alert("用户登陆信息过期");
                goLogin()
            }else {
                var success = data.message;
                if(data.code === 0){
                    layer.confirm("修改成功",{
                        btn: ["确认"],
                        yes: function(){
                            initTable();
                            layer.closeAll()
                        }
                    });
                }else{
                    layer.alert("修改失败");
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
            console.log("ad");
            _Ajax($,delectCheckURL,{
                token:token,
                data:JSON.stringify(deleteInfo)
            },function (data) {
                 layer.alert("删除成功");
                 layer.close(index);
                 initTable()
            })
        },function (index) {
            layer.close(index)
        })

    });

    // 添加
    $("#add").on('click',function (obj) {

        layer.open({
            type:1,
            title:"添加管理员",
            area: ['1000px', '500px'],
            shadeClose: true,
            content: $('#alert_add_form'),
        })
    });
    $("#closeLayer2").on('click',function(){
        layer.closeAll()
    });
    form.on('submit(demo2)', function(data){

        var usercode = $("#usercode2").val(),
            username = $("#username2").val(),
            password = $("#password2").val(),
            unit_code = $("#unit_code2").val(),
            level = $("#level2").val(),
            tel = $("#tel2").val(),
            depart = $("#depart2").val(),
            group = $("#group2").val();

        _Ajax($,AddPersoninfoUrl,{
            usercode:usercode,
            username:username,
            password:password,
            unit_code:unit_code,
            level:level,
            tel:tel,
            depart:depart,
            group:group,
            token:token
        },function(data){
            if(data.code === 403){
                layer.alert("用户登陆信息过期");
                goLogin()
            }else {
                var success = data.message;
                if(data.code === 0){
                    layer.confirm("添加成功",{
                        btn: ["确认"],
                        yes: function(){
                            initTable();
                            layer.closeAll()
                        }
                    });
                }else{
                    layer.alert("添加失败");
                }
            }
        });
        form.render();
        return false;
    });


    function initTable() {
        var tableInts = table.render({
            elem: '#Admin_table',
            url:TableUrl,
            cols: [[
                {checkbox: true, fixed: true}
                ,{field:'id', title: '管理员ID', width:160}
                ,{field:'usercode', title: '管理员账号', width:180,}
                ,{field:'username', title: '管理员姓名', width:180,}
                ,{field:'password',title:'密码',width:180,}
                ,{field:'unit_code', title: '工作单位', width:180,}
                ,{field:'level', title: '级别', width:120,}
                ,{field:'tel', title: '联系电话', width:200,}
                ,{field:'depart', title: '部门', width:200,}
                ,{field:'group1', title: '组', width:200,}
                ,{field:'handle', title: '操作', width:120,toolbar:'#btn_wraper'}
            ]],
            id: 'test',
            page: true,
            limit: 10,
            even: true,
            where: {
                username:$("#username").val(),
                usercode:$("#usercode").val(),
                token: token
            },
            done: function(data){

            }
        });
    }

    initTable()
});

