<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">  
<title>点播详情</title>
<meta name="viewport" content="width=device-width">
<%@ include file="../../_commons/meta.jsp"%>
<script type="text/javascript" src="${ROOT_UI}/public/evideo/swfobject.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_demond.js" ></script>
<script  type="text/javascript" src="${ROOT_UI}/public/_module/demond/demond_detail.js"></script>
<style type="text/css">
</style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
<!-- 点播课程详情 start-->
<div class="container" >
	<p class="l-title">汉语言文学（第一节）
		<span class="ft12">
			<i class="iconfont icon-play-times"></i>123</span>
		<small class="ft12">一年级/语文/谢春华</small>
	</p>
	<div class="row" >
		<div class="col-md-9" >
			<div class="vedio" id="video_player_content"></div>
			<div class="comment mt40">
				<div class="c-title ft16 c4">用户评价</div>
				<!-- 用户评论主体部分 start-->
				<!-- 评论公共组件 -->
				<div class="">
					放置评论
				</div>
				<!-- 用户评论主体部分 end-->
				<div class="more">
					<a href="#a" class="ft12 c9">点击查看更多评论</a>
				</div>
			</div>
		</div>
		<div class="col-md-3" >
			<div class="l-right fr">
			<div class="right-head ft16">课程推荐</div>
			<div class="v-recommend">
				<ul id="quality_courses" ></ul>
			</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../../_commons/footer.jsp"%>
<!-- 点播课程详情  end-->
</body>
</html>