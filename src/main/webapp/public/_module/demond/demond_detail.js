$(function() {
	var SWF_ID = "evideo_" + new Date().getTime();
	var SWF_NAME = ROOT_UI_PUBLIC + "/evideo/KwVideo.swf";
	function EmbedSWF_SWF(divId, mp4Url,width,height) {
		var flashvars = {
			url: mp4Url
		};
		var params = {
			allowFullscreen: "true",
			allowScriptAccess: "always",
			wmode: "transparent" // can cause issues with FP settings & webcam
		};
		var attributes = {
			id: SWF_ID,
			name: SWF_ID
		};
		swfobject.embedSWF(SWF_NAME,
		//这里可以设置播放设置播放视频宽高
		divId, width, height, "10.0.0", "expressInstall.swf", flashvars, params, attributes);
	}
	var resourceId = sessionStorage.getItem("resourceId");
	/**
	 * 获取播放视频的url
	 */
	CDUtil.ajaxPost("/resource/get", {resourceId: resourceId},function(retVO) {
		if(retVO.code == 1){
			var videoUrl = retVO.data.storePath+"?token=" + sessionStorage.getItem("token");
			var width = $("#video_player_content").width();
			var height = width*9/16+60;
			EmbedSWF_SWF("video_player_content", videoUrl,width,height);
		}
	});
	
	/**
	 * 获取精品课程列表信息
	 */
	CDUtil.ajaxPost("/resource/recommendresource/list", {resourceId: resourceId},function(retVO) {
		var htmlStr = "";
		$(retVO.data).each(function(i,cour){
			htmlStr += '<li data-resoureceId="'+cour.resourceId+'" ><div class="media-left">'
					+'<img class="media-object" src="'+cour.thumbPath+'" data-holder-rendered="true" style="width: 149px; height:84px;">'
					+'</div><div class="media-right">'
					+'<p class="c4">'+cour.resourceName+'</p>'
					+'<p class="ft12 c6">'+cour.classlevelName+'&nbsp;'+cour.subjectName+'&nbsp;'+cour.author+'</p>'
					+'<p class="ft12 c6">'
					+'<i class="iconfont icon-play-times"></i>&nbsp;'+cour.viewCnt+'</p>'
					+'</div></li>';
		});
		$("#quality_courses").html(htmlStr);
	});
	
	$("#quality_courses").on("click","li",function(){
		var resourceId = $(this).attr("data-resoureceId");
		var token = sessionStorage.getItem("token");
		sessionStorage.setItem("resourceId",resourceId);
		var url = ROOT_SERVER+"/front/path/demond?token="+token;
		window.location.href = url;
	});
	
	
	/**
	 * 舒适化评论+对评论增删查
	 */
	//初始化表情
	smile.init($("#blogFace")[0],$("#blogCommentId")[0]);
	//评论区域的收起，回复交互
	$("#blogComment").on("click", "com-comments-level1", function(){
		alert();
		var $this = $(this).find(".level1-btn");
		var $_this = $(this).find(".com-comments-level2");
		$this.click(function(){
			var showFlag = $(this).attr("data-show");
			if(showFlag == 0){
				$_this.removeClass("hide");
				/* $this.html("收起").parents(".com-comments-img-r").addClass("showbtn"); */
				$this.html("收起");
				var showFlag = $this.attr("data-show",1);
			}else{
				$_this.addClass("hide");
				$this.html("回复").parents(".com-comments-img-r").removeClass("showbtn");
				var showFlag = $this.attr("data-show",0);
			}
		});
	});
	//显示表情
	function showFace(e, blogCommentId){
		initShowFace(e,$("#face"+blogCommentId+"")[0],$("#"+blogCommentId+"")[0]);
	};
	function initShowFace(e,o,t){
		if (!o) {
			o = $("#blogFace")[0];
			t = $("#blogCommentId")[0];
		}
		smile.reInit(o,t);
		if (smile.isShow()) {
			smile.hide();
		} else {
			smile.show(e);
		}
	};

});