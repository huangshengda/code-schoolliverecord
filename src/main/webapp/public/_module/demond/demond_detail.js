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
	
	
	
	
});