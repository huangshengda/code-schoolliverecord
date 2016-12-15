<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>直播详情页</title>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <meta name="viewport" content="width=device-width">
  <%@ include file="../../_commons/meta.jsp"%>
<script type="text/javascript" src="${ROOT_UI}/public/_tools/tool.js"></script>
<script type="text/javascript" src="${ROOT_UI}/public/player_flash/player_flash.js"></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_live.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/_module/live/live_detail.js"></script>
<style type="text/css">
.chat-li{
	position: relative;
}
.chat-delete{
	cursor: pointer;
	position: absolute;
	top: 10px;
	right: 0px;
}
.chat-delete:hover{
	font-size: 18px;
}
</style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
<!-- 直播课程详情 start-->
<div class="container mt40">
	<p class="l-title">汉语言文学（第一节）
		<span class="ft12">
			<!--<i class="iconfont icon-play-times"></i>123</span>  -->
		<small class="ft12">一年级/语文/谢春华</small>
	</p>
	<div class="row" >
		<div class="col-md-9" >
			<div class="vedio"></div>
		</div>
		<div class="col-md-3" >
			<div class="l-right fr">
				<div class="chat-bland" id="console">
		          <div class="right-head ft16">交流区（26人）</div>
		          <div class="v-recommend" >
		         	<ul id="chat_context" >
		         		<!-- <li class="chat-li" id="7635aef91820487590c58f907724c72f" data-timestamp="true"  >
	         				<span class="fb mr20">管理员</span>
	         				<span>5分钟之前</span>
	         				<p class="s-flow">加入聊天</p>
	         				<i class="iconfont icon-delete chat-delete fr" data-uuid="7635aef91820487590c58f907724c72f"></i>
		         		</li> -->
		         	</ul>
		          </div>
		          <div class="chat-btm mt20">
		          	<div class="bar"></div>
		          	<div class="c-text">
		            	<textarea id="chat"></textarea>
		            	<button class="commit fr" id="chat_send">发表</button>
		            	<div class="clear"></div>
		          	</div>
		          </div>
		        </div>
			</div>
		</div>
	</div>
</div>
<!-- 点播课程详情  end-->
<script type="text/javascript">

</script>
</body>
</html>
