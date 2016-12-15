<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">  
<title>点播详情</title>
<meta name="viewport" content="width=device-width">
<%@ include file="../../_commons/meta.jsp"%>
<script type="text/javascript" src="${ROOT_UI}/public/_module/comment/comment.css" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/evideo/swfobject.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_demond.js" ></script>
<script  type="text/javascript" src="${ROOT_UI}/public/_module/demond/demond_detail.js"></script>
<style type="text/css">
.com-comments-h2{
    font-size: 16px;
    text-indent: 20px;
    height: 40px;
    line-height: 40px;
    background-color: #f7f7f7;
    border-bottom: 1px solid #dcdcdc;
    margin: 0px;
}
.com-commonts-area{
    margin: 20px 20px 10px 20px;
}
.edit-wb-frame{
    width: 872px;
    margin: 0;
    padding: 0;
    margin-top: 0px;
    height: 120px;
    border: 1px solid #ececec;
    background-color: #fff;
    outline: 0;
}
.mb10{
    margin-bottom: 10px;
}
.com-commonts-area .edit-wb-frame{
    width: 100%;
}
.e-xpression, .i-mage, .a-udio, .send-time, .circle-group-i {
    vertical-align: middle;
    float: left;
    line-height: 23px;
    cursor: pointer;
    margin-top: 5px;
    margin-right: 20px;
}
#smileBox {
    background: url("../images/bg_face.png") no-repeat scroll 0 0;
    padding: 6px;
    position: absolute;
    z-index: 10000;
}
#smileBox li img{
	border: 1px solid #fff;
    cursor: pointer;
    display: block;
    padding: 2px;
    width: 30px;
}

/*微博，博文区域的评论区域*/
.com-comments{border:1px solid #dcdcdc;background-color:#fff;}
.com-comments-h2{font-size:16px;text-indent:20px;height:40px;line-height:40px;background-color:#f7f7f7;border-bottom:1px solid #dcdcdc;}
.com-commonts-area{margin:20px 20px 10px 20px;}
.com-commonts-area .edit-wb-frame{width:100%;}
.com-comarea-h80{margin:0;}
.com-comarea-h80 textarea{height:80px;}
.com-comarea-h80 textarea:disabled{background:#f6f6f6;}
.e-xpression .svgclass{width:24px;height:24px;}
.e-xpression .svgpath,.e-xpression:hover .svgpath{fill:#f1b93c;}
i{font-style:normal;}
.orange{color:#ff9c00;}
.com-comments-h3{font-size:14px;height:30px;line-height:30px;}
.com-comments-img-r{/*float:right;*/margin-left:70px;margin-top:-54px;}
.com-comments-time{color:#999;font-size:12px;}
.com-commonts-area .commtent-text-btn{color:#444;font-size:12px;cursor:pointer;display:none;} 
.com-commonts-area .commtent-remove{padding:0px 5px;margin-right:5px;cursor:pointer;border-right:1px solid #ddd;font-size:12px;display:none;}
.com-comments-img-r:hover .commtent-text-btn,.com-comments-img-r:hover .commtent-remove,.com-comments-img-r.showbtn .commtent-text-btn{display:inline-block;}
.com-comments-img-r.showbtn:hover .commtent-remove{display:none;}
.com-comments-img-r:hover .commtent-text-btn.hide{display: inline-block!important;}
.com-comments-level1{padding-top:20px;margin-bottom:20px;border-top:1px solid #dcdcdc;}
.com-comments-level2{background-color:#f7f7f7;margin-left:50px;padding:20px;margin-top:20px;clear:both;}
.com-comments-level2 .edit-wb-frame{height:40px;}
.com-comments-level2 .com-comments-img-r{color:#666;}
.commtent-remove{padding:0px 5px;margin-right:5px;border-right:1px solid #ddd;}
.commtent-text-btn:hover{color:#ff9c00;}
.commtent-remove:hover{color:#f00;}
.level2-comments{margin-top:20px;}
.ft12{font-size:12px;}
.container .l-title span{color:#999;}
</style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
<!-- 点播课程详情 start-->
<div class="container mt40" >
	<p class="l-title">汉语言文学（第一节）
		<span class="ft12">
			<i class="iconfont icon-play-times"></i>123</span>
		<small class="ft12">一年级/语文/谢春华</small>
	</p>
	<div class="row" >
		<div class="col-md-9" >
			<div class="vedio" id="video_player_content"></div>
			<div style="border: 1px solid #dddddd;">
				<h2 class="com-comments-h2">评价</h2>
				<div class="com-commonts-area clearfix" name="divNode">
					<div class="counterBox">
						<textarea name="" id="blogCommentId"  limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame"></textarea>
						<div class="clearfix">
							<div id="blogFace"></div>
							<span id="" class="e-xpression" onclick="initShowFace(event);">
								<i class="iconfont icon-face"></i>
							</span>
							<a class="fr mt10 com-button orange-btn ml10" id='publishBlogComment' onclick="publishFirstComment()">评论</a>
							<span class="textarea-ft-cont-pos"><i class="limitCount orange">150</i>/150</span>
						</div>
					</div>
					<h3 class="com-comments-h3" id="firstCount"></h3>
					<div id="blogComment"></div>
					<div id="splitPages" class="com-grid-page"></div>
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