layui.use(['form','jquery','layer', 'element'],function () {
    var form=layui.form,$=layui.$,layer=layui.layer,elem=layui.element
    var usercode = "",treelevels="",fristlevels = []

    var SaveUrl=post+"/WMS/PrivilegeManageController/updateUserPrivilege";
var QueryPermissionUrl=post+"/WMS/PrivilegeManageController/getPrivilege";
    function refreshPermission(){
        $('input[type="checkbox"]').prop("checked",false)
        var level =  $("#username").val()
        console.log("level:"+level)
        _Ajax($,QueryPermissionUrl,{
            level : level,
        },function(data){
          console.log(data)
                $('input[type="checkbox"]:checked').prop("checked",false)
                for(let i=0; i<data.data.length; i++){
                    $('input[name="'+data.data[i].treelevel+'"]').prop("checked",true)
                }
                form.render()
        })
    }

    form.on("select(username)",function(data){
        usercode = data.value;
        refreshPermission()
    })


    $("#save").on("click",function(){
        if(usercode == ""){
            layer.alert("请选择角色")
        }else{
            $('input[type="checkbox"]:checked').each(function(i){
                if(i==0){
                    treelevels = $(this).attr("name")
                }else{
                    treelevels+= (","+$(this).attr("name"))
                }
               /* let fristlevel = $(this).attr("name").substr(0,2)
                if(fristlevels.indexOf(fristlevel) == -1){
                    fristlevels.push(fristlevel)
                    treelevels += ","+fristlevel
                }*/
            })
            _Ajax($,SaveUrl,{
                usercode : usercode,
                treelevels : treelevels,
                level:$("#username").val()
            },function(data){

                    layer.alert(data.message)
                form.render();

            })
        }
    })

    refreshPermission()
})