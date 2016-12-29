<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<%@ include file="../../_commons/meta.jsp" %>
<script type="text/javascript" src="${ROOT_UI}/public/_module/videoup/videoup.js"></script>
<link rel="stylesheet" type="text/css" href="${ROOT_UI}/public/_module/videoup/videoup.css" />
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
						<input type="text" name="resNickName" data-vali="notnull" id="res_name" maxlength="30"></span>
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
					<span class="cd-f-name v-top">
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
						<input type="text" name="author" data-vali="notnull" id="auth" maxlength="10"></span>
				</div>
				<div class="cd-f-eve">
					<span class="cd-f-name vat">
						<label class="cd-f-notnull">*</label>
						<label>课程视频:</label></span>
					<span class="cd-f-value">
						<div class="btn fileup-button inb" style="position: relative;width: 150px;height: 28px;">上传视频文件
							<input type="file" value="" class="input-fileup" id="fileup_video"  readonly unselectable="on" accept="video/mp4,.flv">
						</div>
						<p class="ft12 c9 ml20 inb">注：视频格式支持mp4、flv，最大2G。</p>
						<div class="up-list mt20" id="show_fileup_detail">
							
						</div>
						<input type="hidden" id="video_resourceId" name="resName" data-vali="notnull" />
						<input type="hidden" id="video_name" data-vali="notnull" />
						<input type="hidden" id="video_size" name="size" data-vali="notnull" />
						<input type="hidden" id="video_img_resourceId" name="thumbName" data-vali="notnull" />
						<input type="hidden" id="video_img_flag" name="thumbFlag" value="0" />
						
					</span>
					
				</div>
				<div class="tac">
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
	<div style="height: 60px;text-align: center;">
		<button type="button" class="green-btn lay-btn mr15" id="chose_sysimg_sure" >确定</button>
		<button type="button" class="gray-btn lay-btn" id="chose_sysimg_cancel" >取消</button>
	</div>
</div>
<script type="text/javascript"></script>
</body>
</html>