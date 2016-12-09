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
	
	/*$('.e-xpression').qqFace({
		id: 'facebox',
		assign: 'saytext',
		path: 'src/public/qqFace/arclist/' //表情存放的路径
	});
	$(".com-button").click(function() {
		var str = $(this).parent().prev('textarea').val();
		var myDate = new Date();
		var now = myDate.toLocaleString();
		//var html = '<div class="clearfix com-comments-level1">' + '<div class="com-comments-img-r">' + '<p>' + replace_em(str) + '</p>' + '<p class="clearfix"><span class="com-comments-time">' + now + '</span><span class="commtent-text-btn fr level1-btn" data-show="0">回复</span></p>' + '</div>' + '</div>'$(this).parent().parent().append(html);
	});

	//查看结果
	function replace_em(str) {

		str = str.replace(/\</g, '&lt;');

		str = str.replace(/\>/g, '&gt;');

		str = str.replace(/\n/g, '<br/>');

		str = str.replace(/\[em_([0-9]*)\]/g, '<img src="src/public/qqFace/arclist/$1.gif" border="0" />');

		return str;

	}

	function caculateLength(str) {
		if (str == null || str == '') {
			return 0;
		}
		var len = str.match(/[^ -~]/g) == null ? str.length: str.length + str.match(/[^ -~]/g).length;
		return len;
	}
	//字数统计
	$("body").on("keyup input propertychange focus blur", ".counterBox textarea",
	function() {
		var realValue = String.trim ? this.value.trim() : this.value.replace(/(^\s*)|(\s*$)/g, "");
		var len = realValue.length;
		var chineseCountTwo = this.getAttribute("chinese-count-two");
		if (chineseCountTwo) {
			len = caculateLength(realValue);
		}
		var limit = this.getAttribute("limit-len");
		if (len >= limit) {
			//len = limit;
		}
		$(this).parent(".counterBox").find(".limitCount").html(limit - len);
	})
	//微博评论区域//
	$(".com-comments-level1").each(function() {
		var $this = $(this).find(".level1-btn");
		var $_this = $(this).find(".com-comments-level2");
		$this.click(function() {
			var showFlag = $(this).attr("data-show");
			if (showFlag == 0) {
				$_this.removeClass("hide");
				$this.html("收起").parents(".com-comments-img-r").addClass("showbtn");
				var showFlag = $this.attr("data-show", 1);
			} else {
				$_this.addClass("hide");
				$this.html("回复").parents(".com-comments-img-r").removeClass("showbtn");
				var showFlag = $this.attr("data-show", 0);
			}
		});
	});
	$(".comments-level2-each").each(function() {
		var $this = $(this).find(".level2-btn");
		var $_this = $(this).find(".level2-comments");

		$this.click(function() {
			var showFlag = $(this).attr("data-show");
			if (showFlag == 0) {
				$_this.removeClass("hide");
				var showFlag = $this.attr("data-show", 1);
			} else {
				$_this.addClass("hide");
				var showFlag = $this.attr("data-show", 0);
			}
		})
	});
	$('.commtent-remove').click(function() {
		$(this).parent().parent().parent().remove();
	});*/
});