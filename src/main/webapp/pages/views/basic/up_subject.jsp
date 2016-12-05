<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>上传课程资源</title>
  <meta name="viewport" content="width=device-width">
  <%@ include file="../../_commons/meta.jsp"%>
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
	.w800{width: 800px;}
	.input-fileup{
		position: absolute;
		top: 0px;
		left: 0px;
		z-index: 9;
		width: 150px !important;
		height: 28px;
		opacity: 0;
		cursor: pointer !important;
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
          <span class="cd-f-value w800">
          	<button class="btn fileup-button" style="position: relative;width: 150px;height: 28px;" >
          		上传视频文件
          		<input type="file" value="" class="input-fileup" >
          	</button>
             <div class="up-list mt20">
	             <div class="up-item">
	               <div class="inb vat">
	                  <p>上传资源1<span class="ml10">4.8M</span></p>
	                  <p><span class="mr10"></span>63%</p>
	                  <p>上传中</p>
	               </div>
	               <div class="inb">
	               		<img src="" width="140" height="80" class="mr20 vab">
						<button class="upbtn mr20">使用系统截图</button>
						<button class="upbtn">上传本地图片</button>
	               </div>
	               <a href="#a" class="vam inb c9"><i class="iconfont icon-delete"></i></a>
	             </div>
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
    </form>
    </div>
  </div>
  <!-- 点播课程详情  end-->
  <script type="text/javascript">

  </script>
</body>
</html>