

var _ajax = function(_url,_data,_success) {
    $.ajax({
        url: _url,
        type: 'post',
        data: _data,
//        dataType: 'json',
        success: _success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	layer.alert("发生意外错误");
            // 状态码
            console.log("state code:"+XMLHttpRequest.status);
            // 状态
            console.log("state:"+XMLHttpRequest.readyState);
            // 错误信息   
            console.log("error message:"+textStatus);
        }
    })
}