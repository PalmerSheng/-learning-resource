
//1.调用参数问题

/*jQuery(function(){ 
}); 
全写为 
jQuery(document).ready(function(){       
}); 

意义为在DOM加载完毕后执行了ready()方法。*/

/*

(function($){ 

})(jQuery)； 

其实际上是执行(function(arg){…})(param)匿名方法,只不过是传递了jQuery对象。
之所以只在形参使用$，是为了不与其他库冲突。
 */

/*
jQuery(function(){ });用于存放操作DOM对象的代码，执行其中代码时DOM对象已存在。
不可用于存放开发插件的代码，因为jQuery对象没有得到传递，外部通过jQuery.method也调用不了其中的方法（函数）。 
(function($){ })(jQuery)；用于存放开发插件的代码，执行其中代码时DOM不一定存在，
所以直接自动执行DOM操作的代码请小心使用。*/

/*(function() {})()：这function() {}表示的是一个匿名函数，而()则包裹着function() {}，
()表示的是拥有最高级的优先执行权，即会优先执行function() {}这个匿名函数。
最后的()，则表示的是执行完function() {}后，立即调用这个function() {}匿名函数。*/

/**
 * 定义JQuery的闭包
 */
(function($){
	//定义了一个Collage_Main类
	$.College_Main=function(){
		var myObj=this;
		//this代表方法本身;

		this.ObjSelectRow={};

		this.search=function(){
			myObj.TableInit();
		};
		this.TableInit=function(){
			$("#dept-table").bootstrapTable('destroy');
			//每次加载都要销毁，以防止浏览器有缓存
			$("#dept-table").bootstrapTable({
				url: '/springTest/College/sel', 
				contentType:"application/x-www-form-urlencoded; charset=UTF-8",
				dataType:"json",
				method: 'post', 
				striped: true, //设置为 true 会有隔行变色效果
				// toolbar: false, 
				//一个jQuery 选择器，指明自定义的toolbar 例如: #toolbar, .toolbar. 
				// cache: true,  
				//设置为 false 禁用 AJAX 数据缓存
				pagination: true,//设置为 true 会在表格底部显示分页条
				// sortable: true, 
				//设置为 true 将获得稳定的排序，我们会添加_position属性到 row 数据中。
				// sortOrder: "asc",定义排序方式 'asc' 或者 'desc'
				queryParams: ObjCollage_Main.queryParams,
				//为什么这样写，参数呢
				/*请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，
	            例如 toolbar 中的参数 如果 queryParamsType = 'limit' ,返回参数必须包含
	            limit, offset, search, sort, order 否则, 需要包含:
	            pageSize, pageNumber, searchText, sortName, sortOrder.
	            返回false将会终止请求 
	            如下所示：
	            queryParamsType: "limit",//查询参数组织方式
                queryParams: function getParams(params) {
                    //params obj
                    params.other = "otherInfo";
                    return params;
                },
				 */
				//调用参数方法
				sidePagination: "server",
				//设置在哪里进行分页，可选值为 'client' 或者 'server'。
				//设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
				pageNumber: 1,  //如果设置了分页，首页页码
				pageSize: 5,  //如果设置了分页，页面数据条数
				pageList: [5,10,15,20], 
				//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。

				//showExport: true,  //显示导出按钮                     
				//exportDataType: "basic",到出类型
				// searcidh: true,  是否启用搜索框
				// strictSearch: true,设置为 true启用 全匹配搜索，否则为模糊搜索
				// showColumns: true, 是否显示 内容列下拉框
				// showRefresh: true,  是否显示 刷新按钮
				// minimumCountColumns: 2,当列数小于此值时，将隐藏内容列下拉框。 
				// clickToSelect: true,  设置true 将在点击行时，自动选择rediobox 和 checkbox
				// height: 500,  //高度调整
				// uniqueId: "id",  Indicate an unique identifier for each row.
				// showToggle: true, 是否显示 切换试图（table/card）按钮  
				// cardView: false, 设置为 true将显示card视图，适用于移动设备。否则为table试图，适用于pc
				// detailView: false,设置为 true 可以显示详细页面模式
				paginationPreText: "上一页",
				paginationNextText: "下一页",
				onLoadSuccess : function(data){// 触发时, 远程数据加载成功。
					/*if(data.rows[0] != undefined){
					Myobj.isFirstPage(data.rows[0].currentPage,data.rows[0].totalPage);
					Myobj.isLastPage(data.rows[0].currentPage,data.rows[0].totalPage);
					}*/   
				},
				columns:[
				{//列配置项
					field:'id',
					title:'序号',
					formatter:function(value,row,index){
						return index+1;
						//代表每一行都从1开始
					}
				},
				{
					field: 'collagecode',
					title: '学院代码',
					formatter:function(value, row, index)
					{
						return '<a href="javascript:alert(\''+row.collagename+'\')">' + value +'</a>';
					}
				},
				{
					field: 'collagename',
					title: '学院名称'
				},
				{
					field: 'opt',
					title: '操作',
					width: 350,
					formatter: function(value, row, index){
						return '<a class="btn btn-primary" href="#" onclick="ObjCollage_Main.UpdByClient(\'' + row.id + '\')">客户端修改</a> '
						+ '<a class="btn btn-primary" href="#" onclick="ObjCollage_Main.UpdByServer(\'' + row.id + '\')">服务器修改</a> ' 
						+'<a href="#" onclick="ObjCollage_Main.delCollage('+row.id+')" class="btn btn-primary btn-sm"  >删除</a>' ;
					}
				}
				]


			});

		};

		this.queryParams=function(param){

			var temp={//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					limit:param.limit, //每页多少条
					offset:param.offset, //当前查询分页的初始条数
					collageName:$('#collagename').val()	//取得控件id的value值
			};
			return temp;
		};

		
		//仅仅在前台传递数据进行修改
		this.UpdByClient=function(rowid){
			//获取table当前页的所有数据集合
			var allTableData=$('#dept-table').bootstrapTable('getData');
			for(var i=0;i<allTableData.length;i++){
				//判断ID获取唯一的一条数据集合
				if(allTableData[i].id==rowid){
					ObjCollage_Main.ObjSelectRow=allTableData[i];
					break;
				}
			}

			layer.open({
				type:2,//2（iframe层）
				content:'/springTest/wxlPratice/collegeInfo/edit.jsp?dealkind=upd',
				shadeClose: false, //点击遮罩关闭层
				area: ['800px', '70%'],
				//在默认状态下，layer是宽高都自适应的，但当你只想定义宽度时，你可以area: '500px'，
				//高度仍然是自适应的。当你宽高都要定义时，你可以area: ['500px', '300px']
				maxmin:false,
				//该参数值对type:1和type:2有效。默认不显示最大小化按钮。需要显示配置maxmin: true即可
				offset: '20px' //只定义top坐标，水平保持居中


			});
		};
		this.UpdByServer=function(rowid){
			layer.open({
				type:2,
				content:'/springTest/College/forwardEdit?collageid='+rowid,
				shadeClose: false, //点击遮罩关闭层
				area: ['800px', '70%'],
				maxmin:false,
				offset: '20px'
			});
		};

		this.add=function(){
			layer.open({
				type: 2,
				title: "添加学院信息",
				shadeClose: false, //点击遮罩关闭层
				area: ['800px', '70%'],
				maxmin:false,
				offset: '20px',
				content:'/springTest/wxlPratice/collegeInfo/edit.jsp?dealkind=add'
			});
		};
		this.delCollage=function(id){
			console.log(id);
			//layer一个弹出层框架
			layer.confirm('确认要删除吗？',function(index){
				//询问框
				$.ajax({
					type: "POST",
					url: "/springTest/College/del",
					data: {
						"collageid": id
					},
					success: function(data){
						if(data.result=='0'){
							layer.alert(data.msg,{skin: 'layui-layer-lan',closeBtn: 0,shift: 5,btn:['确定'],
								yes:function(index,layero)
								{
									layer.close(index);

									ObjCollage_Main.TableInit();
								}
							});

						}if (data.result == "1") {
							layer.alert(data.msg,{skin: 'layui-layer-lan',closeBtn: 0,shift: 5,btn:['确定'],
								yes:function(index,layero)
								{
									layer.close(index);
								}
							});
						}
					}
				});
			});

		};

	};



})(jQuery);
//必须jQuery，代表引入jQuery
var ObjCollage_Main=new jQuery.College_Main();
jQuery(function(){ 

	ObjCollage_Main.TableInit();//一般都要加（）
}); 



