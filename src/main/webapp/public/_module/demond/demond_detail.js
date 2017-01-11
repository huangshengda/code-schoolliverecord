$(function() {
	var resourceId = sessionStorage.getItem("resourceId");
	if(resourceId == undefined){
		layerIndex = layer.confirm('缺少资源信息，请返回首页',{btn: ['确定', '取消']},function(){
			window.location.href = ROOT_SERVER+"/#/index";
		});
	}
	//添加播放次数
	CDUtil.ajaxPost("/resource/viewcnt/addone", {resourceId: resourceId},function(retVO) {
		if(retVO.code == 1){
			$("#play_times").html(retVO.data);
		}
	});
	
	var SWF_ID = "evideo_" + new Date().getTime();
	var SWF_NAME = ROOT_UI_PUBLIC + "/evideo/evideo.swf";
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
	
	/**
	 * 获取播放视频的url
	 */
	CDUtil.ajaxPost("/resource/get", {resourceId: resourceId},function(retVO) {
		if(retVO.code == 1){
			//课程名称，年级、学科、主讲教师
			var resourceName = retVO.data.resourceName;
			var classlevelName = retVO.data.classlevelName;
			if(classlevelName.length>7){
				var classlevelName= classlevelName.substr(0,7) + "...";
			}else{
				var classlevelName= classlevelName;
			}
			var subjectName = retVO.data.subjectName;//学科
			var author = retVO.data.author;//
			$("#resource_name").html(resourceName);
			$("#resource_info").html(classlevelName+"/"+subjectName+"/"+author);
			$("#down_times").html(retVO.data.downloadCnt);
			$("#resource_info").attr("title",retVO.data.classlevelName);
			var videoUrl = retVO.data.storePath+"?token=" + sessionStorage.getItem("token");
			$("#video").val(videoUrl);
			var width = $("#video_player_content").width();
			var height = width*9/16+60;
			EmbedSWF_SWF("video_player_content", videoUrl,width,height);
		}
	});
	/**
	 * 点击下载视频
	 */
	$('#down_video').click(function(){
		var video = $("#video").val()+ "&resourceId=" + resourceId;
		window.location=video; 
		//下载次数
		CDUtil.ajaxPost("/resource/downloadcnt/addone", {resourceId: resourceId},function(retVO) {
			if(retVO.code == 1){
				
			}
		});
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
					+'<p class="c4 ft14" title="'+cour.resourceName+'" >'+cour.resourceName+'</p>'
					+'<p class="ft12 c6" title="'+cour.classlevelName+'&nbsp;'+cour.subjectName+'&nbsp;'+cour.author+'" >'+cour.classlevelName+'&nbsp;'+cour.subjectName+'&nbsp;'+cour.author+'</p>'
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
	 * 评论
	 */
	//初始化评论一级的表情
	$('#commonts_first_face').qqFace({
		id : 'facebox', 
		assign:'comment_one_textarea', //输入框id
		path: ROOT_UI+'/public/qqFace/arclist/'	//表情存放的路径
	});

	//监听评论一级输入的内容。
	$("#comment_one_textarea").on("input",function(){
		var value = $(this).val();
		var valueTs = value.replace(/\[em_([0-9]*)\]/g,'E');
		//console.log(valueTs.length);
		var len = valueTs.length;
		$("#comment_one_count").html(150-len);
	});
	
	//添加评论一级
	$("#comment_one_save").click(function(){
		var value = $("#comment_one_textarea").val();
		if(value == ""){
			layer.msg('评论不能为空');
			return;
		}else if(value.replace(/\[em_([0-9]*)\]/g,'E').length>150){
			layer.msg('评论不能超过150个字符');
			return;
		}
		params = {
			resourceId: resourceId,
			commentContent: value
		}
		CDUtil.ajaxPost("/resource/comment/add",params,function(retVO){
			if(retVO.code == 1){
				layer.msg('评论成功');
				$("#comment_one_textarea").val("");
				$("#comment_one_count").html(150);
				searchCommentOne();
			}else{
				layer.msg('评论失败');
			}
		});
	});
	
	//拼接评论一级循环体的html
	var spellHtmlCommentOne = function(data){
		var commentTwo = data.childrenCommentList;
		//console.log(data);
		var commentOneId = ValueCheck.getSequence();
		var htmlStr = '<div class="com-comments-level1" style="cursor: pointer;" '
					+' data-userName="'+data.userName+'" data-commentUserId="'+data.commentUserId+'" data-resourceCommentId="'+data.resourceCommentId+'" data-commentTwoLenght="'+commentTwo.length+'" >'
					+'<p>'
						+'<span class="inb vat">'+data.userName+':</span>'
						+'<span class="comment-one-content inb wd750 ml5">'+replace_em(data.commentContent)+'</span>'
					+'</p>'
					+'<p class="clearfix">'
						+'<span class="com-comments-time">'+data.createTimeStr+'</span>'
						+'<span class="commtent-text-btn comment-one-reply fr" style="display: block;" data-show="0">回复（'+commentTwo.length+'）</span>'
						+(data.delAuth?'<span class="commtent-text-btn comment-one-del fr mr20" style="display: block;" data-show="0">删除</span>':'')
					+'</p>'
					+'<div class="comment-two" data-userName="" data-commentUserId="" >'
						+'<div class="comment-two-write" >'
							+'<textarea name="" id="'+commentOneId+'_two_tx" limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="comment-two-textarea"></textarea>'
							+'<div class="">'
								+'<span onclick="" id="" class="e-xpression comment-two-expression">'
									+'<i class="iconfont icon-face"></i>'
								+'</span>'
								+'<button type="button" class="fr  smp-button one comment-two-save" >提交</button>'
							+'</div>'
						+'</div>'
						+spellHtmlCommentTwo(commentTwo)
					+'</div>'
				+'</div>';
		return htmlStr;
	}
	//拼接评论二级
	var spellHtmlCommentTwo = function(commentTwo){
		var htmlStr = '';
		if(ValueCheck.isNull(commentTwo) || commentTwo.length == 0){
			return htmlStr;
		}
		$(commentTwo).each(function(i,data){
			//console.log(data);
			htmlStr += '<div class="com-comments-level2" style="cursor: pointer;" '
				+' data-commentUserId="'+data.commentUserId+'" data-parentCommentId="'+data.parentCommentId+'" data-userName="'+data.userName+'" data-resourceCommentId="'+data.resourceCommentId+'" >'
				+'<p>'
					+'<span class="vat">'+data.userName+'回复</span>'
					+'<span class="inb vat">'+data.replyToUserName+':</span>'
					+'<span class="comment-one-content inb wd550 ml5">'+replace_em(data.commentContent)+'</span>'
				+'</p>'
				+'<p class="clearfix">'
					+'<span class="com-comments-time">'+data.createTimeStr+'</span>'
					+'<span class="list_hide">'
					+'<span class="commtent-text-btn comment-two-reply fr" style="display: block;" data-show="0">回复</span>'
					+(data.delAuth?'<span class="commtent-text-btn comment-two-del fr mr20" style="display: block;" data-show="0">删除</span>':'')
					+'</span>'
				+'</p>'
			+'</div>'
		});
		return htmlStr;
	};
	//查询评论列表
	var searchCommentOne = function(newPage){
		if(newPage == undefined){
			newPage = 1;
		}
		params = {
			curPage: newPage,
			pageSize: 20,
			resourceId: resourceId
		}
		CDUtil.ajaxPost("/resource/comment/list",params,function(retVO){
			$("#comment_one_totalDatas").html(retVO.totalDatas);
			configCommentOne.gData = retVO;
			Paging.initPaging(configCommentOne,function(){
				//评论列表初始化成功后，添加事件
				
				//初始化评论二级表情
				$("#comment_one_list .comment-two-expression").each(function(i,dom){
					var pDom = $(this).parents(".comment-two-write").get(0);
					var txDom = $(pDom).children(".comment-two-textarea").get(0);
					//console.log(txDom.id);
					$(dom).qqFace({
						id : 'facebox',
						assign: txDom.id, //输入框id
						path: ROOT_UI+'/public/qqFace/arclist/'	//表情存放的路径
					});
				});
			});
		});
	}
	//配置用来查询评论一级
	var configCommentOne = {
		containerId: "comment_one_list",
		gData: {},
		pagingFlag: true,
		spellHtmlFun: spellHtmlCommentOne,
		optParams: ["id","title"],
		searchFun: searchCommentOne	
	};
	searchCommentOne();
	
	//评论一级上的回复操作
	$("#comment_one_list").on("click",".comment-one-reply",function(){
		var oneDom = $(this).parents(".com-comments-level1").get(0);
		var twoDom = $(oneDom).find(".comment-two").get(0);
		var show = $(this).attr("data-show");
		if(show == "0"){
			var txDom = $(twoDom).find(".comment-two-textarea").get(0);
			$(twoDom).show();
			$(txDom).focus();
			$(this).attr("data-show",1);
			$(this).html("收起");
		}else{
			$(twoDom).hide();
			$(this).attr("data-show",0);
			$(this).html("回复（"+$(oneDom).attr("data-commenttwolenght")+"）");
		}
	});
	
	//点击删除评论一级
	$("#comment_one_list").on("click",".comment-one-del",function(){
		var thisDom = this;
		layerIndex = layer.confirm('确定删除该评论吗？',{btn: ['确定', '取消']},function(){
			layer.close(layerIndex);
			var oneDom = $(thisDom).parents(".com-comments-level1");
			var commentId = $(oneDom).attr("data-resourcecommentid");
			params.resourceCommentId = commentId;
			console.log(params);
			CDUtil.ajaxPost("/resource/comment/delete",params,function(retVO){
				if(retVO.code == 1){
					layer.msg('删除成功');
					//searchCommentOne(params.curPage);
					searchCommentOne();
				}else{
					layer.msg('删除失败');
				}
			});
		});
	});
	
	//监听评论二级输入框获取焦点事件
	$("#comment_one_list").on("focus",".comment-two-textarea",function(){
		var oneDom = $(this).parents(".com-comments-level1");
		var userId = $(oneDom).attr("data-commentuserid");
		var userName = sessionStorage.getItem("realname");
		var replyUserId = $(this).attr("data-replyUserId");
		var replyUserName = $(this).attr("data-replyUserName");
		if(replyUserId == undefined){
			$(this).attr("data-replyUserId",userId);
			$(this).attr("data-replyUserName",replyUserName);
			$(this).attr("placeholder",userName+"回复"+$(oneDom).attr("data-username")+"：");
		}
	});
	
	$("#comment_one_list").on("input",".comment-two-textarea",function(){
		var value = $(this).val();
		if(value == ""){
			$(this).removeAttr("data-replyUserId");
			$(this).removeAttr("data-replyUserName");
		}
	});
	
	//添加评论二级
	$("#comment_one_list").on("click",".comment-two-save",function(){
		var oneDom = $(this).parents(".com-comments-level1").get(0);
		var twoDom = $(this).parents(".comment-two").get(0);
		var twoDomL2 = $(this).parents(".com-comments-level2").get(0);
		var wDom = $(this).parents(".comment-two-write").get(0);
		var txDom = $(wDom).children(".comment-two-textarea").get(0);
		var value = $(txDom).val();
		//value = value.substr((value.indexOf("：")+1));
		if(value == ""){
			layer.msg('评论不能为空');
			return;
		}else if(value.replace(/\[em_([0-9]*)\]/g,'E').length>150){
			layer.msg('评论不能超过150个字符');
			return;
		}
		params.resourceId = resourceId;
		params.commentContent = value;
		params.parentCommentId = $(oneDom).attr("data-resourceCommentId");
		//alert($(txDom).attr("data-replyUserId"));
		params.replyToUserId = $(txDom).attr("data-replyUserId");
		if(params.replyToUserId == undefined || params.replyToUserId == null){
			params.replyToUserId = $(wDom).attr("data-replyUserId");
		}
		CDUtil.ajaxPost("/resource/comment/add",params,function(retVO){
			if(retVO.code == 1){
				layer.msg('回复成功');
				var data = retVO.data;
				//alert(data.replyToUserName);
				var htmlStr = '<div class="com-comments-level2" style="cursor: pointer;" '
					+' data-commentUserId="'+data.commentUserId+'" data-parentCommentId="'+data.parentCommentId+'"'
					+' data-userName="'+data.userName+'" data-resourceCommentId="'+data.resourceCommentId+'" >'
					+'<p>'
						+'<span class="vat">'+data.userName+'回复</span>'
						+'<span class="inb vat">'+data.replyToUserName+':</span>'
						+'<span class="comment-one-content inb wd550 ml5">'+replace_em(data.commentContent)+'</span>'
					+'</p>'
					+'<p class="clearfix">'
						+'<span class="com-comments-time">'+data.createTimeStr+'</span>'
						+'<span class="list_hide">'
						+'<span class="commtent-text-btn comment-two-reply fr" style="display: block;" data-show="0">回复</span>'
						+(data.delAuth?'<span class="commtent-text-btn comment-two-del fr mr20" style="display: block;" data-show="0">删除</span>':'')
						+'</span>'
						+'</p>'
				+'</div>';
				$(htmlStr).appendTo(twoDom);
				var comTwoLen = ValueCheck.getNumber($(oneDom).attr("data-commenttwolenght"),0)
				$(oneDom).attr("data-commenttwolenght",comTwoLen+1);
				$(txDom).removeAttr("data-replyUserId");
				$(txDom).removeAttr("data-replyUserName");
				$(txDom).val("");
				$(txDom).attr("placeholder","请添加评论");
			}else{
				layer.msg('回复失败');
			}
		});
	});
	
	//点击评论二级的回复
	$("#comment_one_list").on("click",".comment-two-reply",function(){
		var twoDom = $(this).parents(".com-comments-level2");
		var topDom = $(this).parents(".comment-two");
		var wDom = $(topDom).find(".comment-two-write").get(0);
		var txDom = $(topDom).find(".comment-two-textarea").get(0);
		var userName = sessionStorage.getItem("realname");
		var replyName = $(twoDom).attr("data-username");
		var replyUserId = $(twoDom).attr("data-commentUserId");
		$(wDom).attr("data-replyUserId",replyUserId);
		$(wDom).attr("data-replyUserName",replyName);
		$(txDom).attr("data-replyUserId",replyUserId);
		$(txDom).attr("data-replyUserName",replyName);
		$(txDom).attr("placeholder",userName+"回复"+replyName+"：");
		$(txDom).focus();
	});
	//点击删除评论二级
	$("#comment_one_list").on("click",".comment-two-del",function(){
		var thisDom = this;
		layerIndex = layer.confirm('确定删除该评论吗？',{btn: ['确定', '取消']},function(){
			layer.close(layerIndex);
			var oneDom = $(thisDom).parents(".com-comments-level1").get(0);
			var twoDom = $(thisDom).parents(".com-comments-level2");
			var commentId = $(twoDom).attr("data-resourcecommentid");
			CDUtil.ajaxPost("/resource/comment/delete",{resourceCommentId: commentId},function(retVO){
				if(retVO.code == 1){
					layerIndex = layer.msg('删除成功');
					$(twoDom).remove();
					var comTwoLen = ValueCheck.getNumber($(oneDom).attr("data-commenttwolenght"),1)
					$(oneDom).attr("data-commenttwolenght",comTwoLen-1);
				}else{
					layer.msg('删除失败');
				}
			});
		});
	});
	
});
function replace_em(str){
	str = str.replace(/\</g,'&lt;');
	str = str.replace(/\>/g,'&gt;');
	str = str.replace(/\n/g,'<br/>');
	str = str.replace(/\[em_([0-9]*)\]/g,'<img src="'+ROOT_UI+'/public/qqFace/arclist/$1.gif" border="0" />');
	return str;
}