/**
 * Created by GFY on 2018/5/19.
 */
layui.use(['element','table','layer','jquery','laydate','form'],function(){
    var element = layui.element, layer = layui.layer, table = layui.table;
    var $ = layui.$, laydate = layui.laydate,form = layui.form;

    var TableUrl = post + "/WMS/SupplyInfoController/info";
    var UpdatePersoninfoUrl = post + "/WMS/SupplyInfoController/updateinfo";
    var delUrl = post + "/WMS/SupplyInfoController/deleteinfo";
    var AddPersoninfoUrl = post + "/WMS/SupplyInfoController/insertinfo";


    // 查询
    $("#search").on('click',function(){
        initTable();
    });


    // 修改 删除
    table.on('tool(supplier_table)',function(obj){
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent == 'del'){
            layer.confirm('是否删除该账号？',{
                btn: ['是','否'],
                yes: function(index){
                    _Ajax($,delUrl,{
                        supply_code: data.supply_code
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
                $("#supply_name1").val(data.supply_name);
                $("#tel1").val(data.tel);
                $("#supply_code1").val(data.supply_code);
                $("#duty_name1").val(data.duty_name);
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

        var  supply_name = $("#supply_name1").val(),
            supply_code = $("#supply_code1").val(),
            tel = $("#tel1").val(),
            duty_name = $("#duty_name1").val();

        _Ajax($,UpdatePersoninfoUrl,{
            supply_name:supply_name,
            supply_code:supply_code,
            tel:tel,
            duty_name:duty_name,
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

        var  supply_name = $("#supply_name2").val(),
            supply_code = $("#supply_code2").val(),
            tel = $("#tel2").val(),
            duty_name = $("#duty_name2").val();

        _Ajax($,AddPersoninfoUrl,{
            supply_name:supply_name,
            supply_code:supply_code,
            tel:tel,
            duty_name:duty_name,
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
            elem: '#supplier_table',
            url: TableUrl,
            cols: [[
                {checkbox: true, fixed: true}
                ,{field:'id', title: '供应商ID', width:120}
                ,{field:'supply_name', title: '供应商名', width:230,}
                ,{field:'tel', title: '联系电话', width:120,}
                ,{field:'supply_code', title: '供应商账号', width:200,}
                ,{field:'duty_name', title: '负责人', width:200,}
                ,{field:'handle', title: '操作', width:120,toolbar:'#btn_wraper'}
            ]],
            id: 'test',
            page: true,
            limit: 10,
            even: true,
            where: {
                supply_name:$("#supply_name").val(),
                supply_code:$("#supply_code").val(),
                token: token
            },
            done: function(data){
console.log($("#supply_name1").val())
            }
        });
    }

    initTable()
});


