<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>转盘抽奖活动</title>

 <link href="<%=path%>/static/css/zp_style.css" rel='stylesheet' type='text/css' />
  <script src="<%=path%>/static/js/jquery-1.8.0.min.js"></script>
  <script src="<%=path%>/static/js/jQueryRotate.2.2.js"></script>
  <script src="<%=path%>/static/js/zp.js"></script>
  <script src="<%=path%>/static/js/jquery.easing.min.js"></script>
<script type="text/javascript">
$(function(){
	//多行应用@Mr.Think
	var _wrap=$('ul.mulitline');//定义滚动区域
	var _interval=3000;//定义滚动间隙时间
	var _moving;//需要清除的动画
	_wrap.hover(function(){
		clearInterval(_moving);//当鼠标在滚动区域中时,停止滚动
	},function(){
		_moving=setInterval(function(){
			var _field=_wrap.find('li:first');//此变量不可放置于函数起始处,li:first取值是变化的
			var _h=_field.height();//取得每次滚动高度
			_field.animate({marginTop:-_h+'px'},600,function(){//通过取负margin值,隐藏第一行
				_field.css('marginTop',0).appendTo(_wrap);//隐藏后,将该行的margin值置零,并插入到最后,实现无缝滚动
			})
		},_interval)//滚动间隔时间取决于_interval
	}).trigger('mouseleave');//函数载入时,模拟执行mouseleave,即自动滚动
});


</script>
</head>
<body>
<!--<div class="letter_mian">
  <p class="ban_date"><span>活动时间</span><strong>：</strong>2014年10月15日-2014年11月10日</p>
</div>-->
<div class="con_chouj">
  <div class="chou_box">
    <div class="rotate-content">
      <div class="rotate-con-pan">
        <div class="rotate-con-zhen"></div>
      </div>
    </div>
  </div>
  <div class="win_open"> 
    <!-- 中奖列表begin -->
    <div class="win_box">
      <h2 class="win_tit">中奖列表</h2>
      <div class="win_cont">
        <div class="win_scroll" id="lottery_list_container_0">
          <div class="win_height">
            <div id="demo">
              <ul class="win_list mulitline">
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>VIP6会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>80元</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>40元</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>VIP6会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>80元</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>40元</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>10元</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
                <li><span class="txt"><font>高级会员</font></span><strong class="num">XXX</strong></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 中奖列表end --> 
  </div>
  <div class="Rule">
    <h2><img src="/Activity/static/images/Activities_08.jpg" width="108" height="35" alt=""/></h2>
    <ul>
      <li>
        <p>1. 注册或登录；</p>
      </li>
      <li>
        <p><span style=" float:left;display:inline-block">2. 点击</span>
        <div class="pop_right_qq1"><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=87423050&amp;site=qq&amp;menu=yes" style="padding-right:0;background:transparent"><img border="0" src="http://wpa.qq.com/pa?p=2:87423050:51" alt="点击这里给我发消息" title="点击这里给我发消息"></a></div>
        <span style=" float:left;display:inline-block; color:#FFF;">进入活动页面，参与抽奖，抽奖结果将在活动当前<br />
页面立即显示；</span>
        </p>
      </li>
      <li>
        <p>3. 点击向客服人员提供您会员名（<a href="#">立即注册</a>）；</p>
      </li>
      <li>
        <p>4. XXX会在第一时间将中奖礼品发送至您的账户；</p>
      </li>
      <li>
        <p>5. 所有中奖结果将于活动结束后5个工作日内在XXX网站首页进行公示；</p>
      </li>
    </ul>
  </div>
</div>

<div class="Activities">
  <h1><span class="fh_top2"> <a href="#top" target="_self" title="返回顶部"><img src="/Activity/static/images/ic_top.png" /></a></span><img src="/Activity/static/images/Activities_09.jpg" width="146" height="35" alt=""/></h1>
  <div class="ate_box">
    <p>1. 该活动仅限被审核通过的会员参加（<a href="#">立即注册</a>）；</p>
    <p>2. 每位会员有且仅有一次抽奖资格；</p>
    <p>3. 对未按照活动规则参与抽奖，或不符合抽奖资格的会员，活动主办方有权取消其抽奖资格，并收回其抽奖所获得奖品；</p>
    <p>4. 会员参加活动的否成功，以活动页面提示为准，如因网络系统异常问题，导致无法参与抽奖，将不给予补偿；</p>
    <p>5. 本活动由XXX独家承办，XXX联合赞助；</p>
    <p>6. XXX拥有此次活动的最终解释权。更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
  </div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$(".rotate-con-zhen").rotate({
		bind:{
			click:function(){
				var obj = this;
				var rotateAngle = "1569";
				var message = "default";
				$.ajax({
					url:"/Activity/luckDraw/goodLuck",
					async : false, 
					/* 需要获取后台传过来的角度 ,后台根据转的角度向数据库中插入不同的奖品信息*/
					success: function(data){
						rotateAngle = data.map["rotateAngle"];
						/* console.log(rotateAngle); */
						message = data.map["message"];
						
						/* console.log("data.map:"+data.map["message"]); */
						console.log("抽奖成功！");
					},
					error:function(){
						alert("发生了未知错误,本次抽奖失败！");
						/* location.href="error.jsp"; */
					}
				});
			
				$(this).rotate({
						 	duration:3000,
						 	angle: 0, 
	            			animateTo:parseInt(rotateAngle) ,
							easing: $.easing.easeOutSine,
							callback: function(){
							
								/* console.log("rotateAngle"+rotateAngle); */
								 alert("您抽到了："+message+"   "+"弹出角度:"+ $(this).getRotateAngle()%360 ); 
								
							}
					 });
				/* var a = runzp(); */
				 
			}
		}
	});
});
</script>
</html>