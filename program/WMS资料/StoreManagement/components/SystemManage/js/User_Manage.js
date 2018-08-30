/**
 * Created by GFY on 2018/5/19.
 */
layui.use(['element','table','layer','jquery','laydate','form'],function(){
    var element = layui.element, layer = layui.layer, table = layui.table;
    var $ = layui.$, laydate = layui.laydate,form = layui.form;

    var TableUrl = post + "/WMS/userManageController/selUser";
    var delUrl = post + "/WMS/userManageController/delUser";
    var UpdatePersoninfoUrl = post + "/WMS/userManageController/updateUserInfo";
    var AddPersoninfoUrl = post + "/WMS/userManageController/addUser";


    // 查询
    $("#search").on('click',function(){
        initTable();
    });


    // 编辑
    table.on('tool(User_table)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent == 'del'){
            layer.confirm('是否删除该账号？',{
                btn: ['是','否'],
                yes: function(index){
                    _Ajax($,delUrl,{
                        usercode: data.usercode
                    },function(res){
                        if(res.code == "1" ){
                            layer.alert(data.message);

                        }else if(res.code == "0" ){
                            layer.alert("删除成功");
                            initTable();
                            layer.close(index);
                        }else{
                            layer.alert("发生意外错误");
                        }

                    })
                },
                btn2: function(index){
                    layer.close(index)
                }
            })
        }else if(layEvent === 'edit') {
            {

                $("#id1").val(data.id);
                $("#usercode1").val(data.usercode);
                $("#username1").val(data.username);
                $("#password1").val(data.password);
                $("#unit_code1").val(data.unit_code);
                $("#user_state1").val(data.user_state);
                form.render()
            }
            layer.open({
                type: 1,
                title: "信息修改",
                area: ['1000px', '500px'],
                shadeClose: true,
                content: $('#alert_edit_form'),
            })
        }
    });

    $("#closeLayer").on('click',function(){
        layer.closeAll()
    });
    form.on('submit(demo1)', function(data){

        var  username = $("#username1").val(),
            usercode = $("usercode1").val(),
            password = $("#password1").val(),
            unit_code = $("#unit_code1").val(),
            level = $("#level1").val(),
            user_state = $("#user_state1").val();
        _Ajax($,UpdatePersoninfoUrl,{
            username:username,
            usercode:usercode,
            password:password,
            unit_code:unit_code,
            level:level,
            user_state:user_state,
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



    table.on('checkbox(test)',function (obj) {

    });


    // 添加
    $("#add").on('click',function (obj) {

        layer.open({
            type:1,
            title:"信息添加",
            area: ['1000px', '500px'],
            shadeClose: true,
            content: $('#alert_add_form'),
        })
    });
    $("#closeLayer2").on('click',function(){
        layer.closeAll()
    });
    form.on('submit(demo2)', function(data){

        var  username = $("#username2").val(),
            usercode = $("#usercode2").val(),
            password = $("#password2").val()
        _Ajax($,AddPersoninfoUrl,{
            username:username,
            usercode:usercode,
            password:password,
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
            elem: '#User_table',
            url: TableUrl,
            cols: [[
                {field:'id', title: 'ID', width:120}
                ,{field:'username', title: '用户名', width:230,}
                ,{field:'usercode', title: '用户账号', width:240,}
                ,{field:'password', title: '密码', width:200,}
                ,{field:'unit_code', title: '工作单位', width:100,}
                ,{field:'level', title: '级别', width:100,}
                ,{field:'user_state', title: '用户状态', width:100,}
                ,{field:'handle', title: '操作',width:200,toolbar:'#btn_wraper'}
            ]],
            id: 'test',
            page: true,
            limit: 10,
            where: {
                username:$("#username").val(),
                usercode:$("#usercode").val(),
                token: token
            },
            done: function(data){
                console.log(data)
            }
        });
    }

    initTable()
});


