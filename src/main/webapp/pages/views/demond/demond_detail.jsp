<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">  
<meta name="viewport" content="width=device-width">
<%@ include file="../../_commons/meta.jsp"%>
<script type="text/javascript" src="${ROOT_UI}/public/evideo/js-swf.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_demond.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/qqFace/js/jquery.qqFace.js" ></script>
<script  type="text/javascript" src="${ROOT_UI}/public/_module/demond/demond_detail.js"></script>
<link rel="stylesheet" type="text/css" href="${ROOT_UI}/public/comment/css/comment.css">
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
<!-- 点播课程详情 start-->
<div class="container" >
	<p class="l-title">
		<span id="resource_name" style="margin-right: 15px;" ></span>
		<span class="c9 mr15 ft12"><i class="iconfont icon-play-times ft18"></i><span id="play_times" class="ft12" >0</span></span>
		<span id="resource_info" class="ft12 c6" title=""></span>
	</p>
	<div class="row" >
		<div class="col-md-9" >
			<div class="vedio" id="video_player_content"></div>
			<div id="" style="border: 1px solid #dddddd;" class="mt30">
				<div class="com-comments mb20" >
					<h2 class="com-comments-h2">用户评论</h2>
					<div class="com-commonts-area clearfix" id="comment_area">
						<div class="counterBox">
							<textarea name="" id="comment_one_textarea" placeholder="请添加评论" limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame"></textarea>
							<div class="clearfix">
								<span id="commonts_first_face" class="e-xpression">
									<i class="iconfont icon-face"></i>
								</span>
								<button class="fr smp-button one" type="button" id="comment_one_save" >评论</button>
								<span class="textarea-ft-cont-pos"><i id="comment_one_count" class="limitCount orange">150</i>/150</span>
							</div>
						</div>
						<h3 class="com-comments-h3">全部评论(<span id="comment_one_totalDatas" >0</span>条)</h3>
						<div id="comment_one_list" >
							<!-- <div class="com-comments-level1 comment-one" 
									data-userName="" data-commentUserId="" data-commentId="" >
								<p>
									<span class="comment-username">李老师</span>：
									<span class="comment-one-content">下雪了，真是太激动了，可以我在南方。欣赏不到雪景...想和朋友们一起去紫荆城，欣赏雪景去。作为故宫控的默默的又喊一遍，明年一定要约一次故宫的雪！</span>
								</p>
								<p class="">
									<span class="com-comments-time">2015-02-03 12:00</span>
									<span class="commtent-text-btn comment-one-reply fr" style="display: block;" data-show="0">回复</span>
								</p>
								<div class="comment-two" data-userName="" data-commentUserId="" >
									<div class="comment-two-write" >
										<textarea name="" id="ddjjdjdjjdjdjdjjdjd" limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="comment-two-textarea"></textarea>
										<div class="">
											<span onclick="" id="fdhaklfjdakjdk" class="e-xpression comment-two-expression">
												<i class="iconfont icon-face"></i>
											</span>
											<button type="button" class="fr com-button orange-btn comment-two-save" >提交</button>
										</div>
									</div>
									<div class="com-comments-level2" style="cursor: pointer;" >
										<p>
											<span class="comment-username">李老师</span>
											回复
											<span class="comment-username">李老师</span>：
											<span class="comment-one-content">下雪了，真是太激动了，可以我在南方。欣赏不到雪景...想和朋友们一起去紫荆城，欣赏雪景去。作为故宫控的默默的又喊一遍，明年一定要约一次故宫的雪！</span>
										</p>
										<p class="clearfix">
											<span class="com-comments-time">2015-02-03 12:00</span>
											<span class="commtent-text-btn comment-two-reply fr" style="display: block;" data-show="0">回复</span>
										</p>
									</div>
									<div class="comment-two-more" style="" >
										<<点击查看更多评论>>
									</div>
								</div>
							</div> -->
						</div>
					</div>
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