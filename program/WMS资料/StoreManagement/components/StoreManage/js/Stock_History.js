layui.use(['laydate','table','jquery','form'],function(){
    var laydate=layui.laydate,table=layui.table,$=layui.$,form=layui.form
    var SearchUrl=post+"/WMS/InOutRecordsController/InOutRecordsInit";
    laydate.render({
        elem:'#afterDate',
        format:'yyyy-MM-dd'
    });
    laydate.render({
        elem:'#beforeDate',
        format:'yyyy-MM-dd'
    });
    $("#select").on('click',function () {
        initTable()
    })
function initTable(){
    var tableInts = table.render({
        elem: '#table'
        , url: SearchUrl
        ,method:"post"
        , cols: [[
            {checkbox: true, fixed: true}
            , {field: 'user_code', title:'用户名',width:100}
            , {field: 'time', title: '操作时间', width:180}
            , {field: 'state', title: '操作名称',width:100}
            , {field: 'goods_code', title: '商品号',width:100}
            , {field: 'goods_num', title: '商品数量',width:100}
            , {field: 'single_money', title:'商品单价',width:100}
            , {field: 'supply_code', title:'供货商',width:100}

            ]]
        , id: 'testReload'
        , page: true
        ,limit: 10
        ,where: {
            startTime:$('#beforeDate').val()
          , endTime:$('#afterDate').val()
        }
    })
}
initTable()
})