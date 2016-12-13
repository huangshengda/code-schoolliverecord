<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>上传课程资源</title>
  <%@ include file="../../_commons/meta.jsp"%>
  <script  type="text/javascript" src="${ROOT_UI}/public/_module/videoup/videoup.js"></script>
  <style type="text/css">
	body{background-color: #f5f8fa;}
	.cd-f-eve{width:100%;margin-bottom:30px;}
	.cd-f-name{width:100px;}
	input[type="checkbox"]{
		width: 13px;
	    height: 13px;
	    vertical-align: middle;
	    margin-right: 3px;
	}
	.upbtn{
		width: 125px;
	    height: 30px;
	    background-color: #f5f8fa;
	    border: 1px solid #dcdcdc;
	}
	.cd-f-value span{margin-right:30px;}
	.up-item{background-color:#f5f8fa;padding:15px;margin-bottom:10px;}
	.w300{width: 300px;}
	.w800{width: 800px;}
	.input-fileup{
		position: absolute;
		top: 0px;
		left: 0px;
		z-index: 9;
		height: 28px;
		opacity: 0;
		cursor: pointer !important;
	}
	.del-fileup{
		margin-top: 45px;
		float: right;
	}
	.del-fileup:hover{
		cursor: pointer;
	}
	.showfile-name{
		display: inline-block;
		vertical-align: top;
		margin: 0px !important;
		max-width: 200px !important;
		cursor: pointer;
	}
	.showfile-name-input{
		display: none;
	}
  </style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
  <!-- 点播课程详情 start-->
  <div class="wamp">
    <div class="smp-main">
       <form action="" class="up-subject">
       <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>课程资源名称:</label></span>
          <span class="cd-f-value ">
            <input type="text" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>学科:</label></span>
          <span class="cd-f-value ">
            <select data-vali="notnull"><option>请选择</option></select>
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>年级:</label></span>
          <div class="cd-f-value ">
            <span><input type="checkbox" name="" >全部</span>
            <span><input type="checkbox" name="" >一年级</span>
          </div>
        </div>   
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>主讲教师:</label></span>
          <span class="cd-f-value ">
             <input type="text" data-vali="notnull">
          </span>
        </div>   
        <div class="cd-f-eve">
          <span class="cd-f-name vat"><label class="cd-f-notnull">*</label><label>课程视频:</label></span>
          <span class="cd-f-value">
          	<div class="btn fileup-button" style="position: relative;width: 150px;height: 28px;" >
          		上传视频文件
          		<input type="file" value="" class="input-fileup" id="fileup_video" accept="video/mp4" >
          	</div>
             <div class="up-list mt20" id="show_fileup_detail" >
	             <!-- <div class="up-item">
	               <div class="inb vat">
	                  <p>上传资源1<span class="ml10">4.8M</span></p>
	                  <div class="progress w300">
						  <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
						    <span class="sr-only">45% Complete</span>
						  </div>
						</div>
	                  <p>上传中</p>
	               </div>
	               <div class="inb">
	               		<img src="" width="140" height="80" class="mr20 vab">
	               		<button type="button" class="upbtn local-img" >选择系统截图</button>
						<button type="button" class="btn fileup-button" style="position: relative;width: 150px;height: 28px;" >
			          		上传本地图片
			          		<input type="file" value="" class="input-fileup" accept="image/png,image/gif" >
			          	</button>
	               </div>
	               <i class="iconfont icon-delete del-fileup"></i>
	             </div> -->
             </div>
          </span>
        </div>   
  		<div class="cd-f-eve">
          <span class="cd-f-name"></span>
          <span class="cd-f-value ">
              <button class="green-btn lay-btn" type="button">保存</button>
          </span>
        </div>
      </div>
      <input type="hidden" id="video_resourceId" />
      <input type="hidden" id="video_name" />
      <input type="hidden" id="video_size" />
      <input type="hidden" id="video_img_resourceId" />
    </form>
    </div>
  </div>
  <!-- 点播课程详情  end-->
<script type="text/javascript">
</script>
</body>
</html>