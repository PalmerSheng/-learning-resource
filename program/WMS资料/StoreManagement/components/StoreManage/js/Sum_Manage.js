layui.use(['table','jquery'],function(){
    var table=layui.table,  $=layui.$
    var tableUrl=post+"/WMS/StockQueryInfo/Queryinfo";
    $("#select").on('click',function() {
        initTable()
    })
    function initTable() {
        var tableInts = table.render({
            elem: '#table'
            , url: tableUrl
            , method: "post"
            , cols: [[
                {checkbox: true, fixed: true}
                , {field: 'goods_code', title: '商品号', width: 100}
                , {field: 'goods_name', title:'商品名',width:100}
                , {field: 'goods_num', title: '商品数量', width: 100}
                , {field: 'single_money', title: '商品单价', width:100}
            ]]
            , id: 'testReload'
            , page: true
            , limit: 10
            ,where: {
                goods_code:$('#goods_code').val(),
            goods_name:$('#goods_name').val()
        }
        })
    }
initTable()
})