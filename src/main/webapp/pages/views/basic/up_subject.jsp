<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<%@ include file="../../_commons/meta.jsp" %>
<script type="text/javascript" src="${ROOT_UI}/public/_module/videoup/videoup.js"></script>
<style type="text/css">
	body{background-color: #f5f8fa;} 
	.cd-f-eve{width:100%;margin-bottom:30px;} .cd-f-name{width:100px;} 
	input[type="checkbox"]{ width: 13px; height: 13px; vertical-align: middle; margin-right: 3px; } 
	.upbtn{ width: 125px; height: 30px; background-color: #f5f8fa; border: 1px solid #dcdcdc; } 
	.cd-f-value span{margin-right:30px;} .up-item{background-color:#f5f8fa;padding:15px;margin-bottom:10px;} 
	.w300{width: 300px;} .w800{width: 800px;} 
	.sysprint-img-button{display: none;}
	.input-fileup{ position: absolute; top: 0px; left: 0px; z-index: 9; height: 28px; opacity: 0; cursor: pointer !important; } 
	.del-fileup{ margin-top: 45px; float: right; } .del-fileup:hover{ cursor: pointer; } 
	.showfile-name{ display: inline-block; vertical-align: top; margin: 0px !important; max-width: 200px !important; cursor: pointer; } 
	.showfile-name-input{ display: none; }
	.gray-btn{background-color: #C6CAC7;}
	.sysprint-img{cursor: pointer;}
	.sysprint-img.active{border: 1px solid #337ab7;}
	.m10{margin: 10px;}
	.p10{padding: 10px;}
	.smp-main{margin-top: 40px;border: 1px solid #ddd;}
</style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp" %>
<!-- 点播课程详情 start-->
<div class="wamp">
	<div class="smp-main">
		<form action="" class="up-subject" id="form_save_videoup" >
			<input type="hidden" id="resourceId" name="resourceId" />
			<div class="cd-f-row">
				<div class="cd-f-eve">
					<span class="cd-f-name">
						<label class="cd-f-notnull">*</label>
						<label>课程资源名称:</label></span>
					<span class="cd-f-value ">
						<input type="text" name="resNickName" data-vali="notnull" id="res_name"></span>
				</div>
				<div class="cd-f-eve">
					<span class="cd-f-name">
						<label class="cd-f-notnull">*</label>
						<label>学科:</label></span>
					<span class="cd-f-value ">
						<select id="subjectId" name="subjectId" data-vali="notnull"></select>
					</span>
				</div>
				<div class="cd-f-eve">
					<span class="cd-f-name">
						<label class="cd-f-notnull">*</label>
						<label>年级:</label>
					</span>
					<span class="cd-f-value" id="show_chose_grade" style="width: 800px;" >
						<input type="hidden" value="" id="classlevelIds" name="classlevelIds" data-vali="notnull" />
						<!-- <span><input type="checkbox" class="chose-grade" value="quanbu" data-type="all" >全部</span>
						<span><input type="checkbox" class="chose-grade others" value="yinianji" >一年级</span> -->
					</span>
				</div>
				<div class="cd-f-eve">
					<span class="cd-f-name">
						<label class="cd-f-notnull">*</label>
						<label>主讲教师:</label></span>
					<span class="cd-f-value ">
						<input type="text" name="author" data-vali="notnull" id="auth"></span>
				</div>
				<div class="cd-f-eve">
					<span class="cd-f-name vat">
						<label class="cd-f-notnull">*</label>
						<label>课程视频:</label></span>
					<span class="cd-f-value">
						<div class="btn fileup-button" style="position: relative;width: 150px;height: 28px;">上传视频文件
							<input type="file" value="" class="input-fileup" id="fileup_video" accept="video/mp4">
						</div>
						<div class="up-list mt20" id="show_fileup_detail"></div>
						<input type="hidden" id="video_resourceId" name="resName" data-vali="notnull" />
						<input type="hidden" id="video_name" data-vali="notnull" />
						<input type="hidden" id="video_size" name="size" data-vali="notnull" />
						<input type="hidden" id="video_img_resourceId" name="thumbName" data-vali="notnull" />
						<input type="hidden" id="video_img_flag" name="thumbFlag" value="0" />
					</span>
				</div>
				<div class="cd-f-eve">
					<span class="cd-f-name"></span>
					<span class="cd-f-value ">
						<button class="green-btn lay-btn" type="button" id="save_video_info" >保存</button></span>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- 弹出选择封面 -->
<div id="chose_sysimg" class="layBox mt40 layui-layer-wrap" style="display: none;">
	<div class="row" id="show_sysprint_img" style="" >
		<!-- <div class="col-md-4 m10">
			<img alt="..." class="img-thumbnail sysprint-img" src="http://localhost:8080/SchoolLiveRecord/download/img/temp/6b72694694424ae895f62378e4c74d92_001.png"  >
		</div> -->
	</div>
	<div style="height: 60px;">
		<button type="button" class="gray-btn lay-btn fr" id="chose_sysimg_cancel" >取消</button>
		<button type="button" class="green-btn lay-btn fr" id="chose_sysimg_sure" >确定</button>
	</div>
</div>
<script type="text/javascript"></script>
</body>
</html>