(function($,window){
	var initFace = true;
	// 基础配置
	var originalConfig = {
		containerId:'commentContainer',
		currentUserId:'I do not know',
		title:'评价',
		addComment:function(){},
		deleteComment:function(){},
		cacheData:{}
	};
	
	function CommentWrap(obj){
		this.config  = $.extend({},originalConfig,obj);
		this.initEvent();
		this.init();
		
	}
	
	CommentWrap.prototype.initEvent = function(){
		var that = this;
		/**
		 * 表情
		 */
		$('#'+this.config.containerId).delegate('.e-xpression','click',function(event){
			var obj = $(this);
			var textObj = obj.parent().prev();
			if(initFace){
				initFace = false;
				smile.init(obj.get(0),textObj.get(0));
			}
			smile.reInit(obj.get(0),textObj.get(0));
			smile.show(event);
		});
		
		$.fn.insertAtCaret = function(myValue) {
			return this.each(function() {
				var me = this;
				if (document.selection) { // IE
					me.focus();
					sel = document.selection.createRange();
					sel.text = myValue;
					me.focus();
				} else if (me.selectionStart || me.selectionStart == '0') { // Real browsers
					var startPos = me.selectionStart, endPos = me.selectionEnd, scrollTop = me.scrollTop;
					me.value = me.value.substring(0, startPos) + myValue + me.value.substring(endPos, me.value.length);
					me.focus();
					me.selectionStart = startPos + myValue.length;
					me.selectionEnd = startPos + myValue.length;
					me.scrollTop = scrollTop;
				} else {
					me.value += myValue;
					me.focus();
				}
			});
		};
		
		/*点击回复*/
		$('#'+this.config.containerId).delegate('.level1-btn','click',function(){
			var obj = $(this);
			var subId = obj.attr('data-id');
			var getCurSubCommentNum = window[$(obj).attr("data-id")] || 0;
			var commentCont = '<span parent-id="'+obj.id+'">(<span>'+getCurSubCommentNum+'</span>)</span>';
			$('#commentSub'+subId).removeClass('hide');
			if(obj.hasClass('showSub')){
				obj.removeClass('showSub');
				obj.parents(".com-comments-img-r").removeClass('showbtn');
				obj.removeClass('showSub').html("回复" + commentCont);
				$('#commentSub'+subId).addClass("hide");
			} else {
				obj.addClass('showSub');
				obj.parents(".com-comments-img-r").addClass('showbtn');
				obj.html('收起');
				$('#commentSub'+subId).removeClass('hide');
			}
		});
		$('#'+this.config.containerId).delegate('.level2-btn','click',function(){
			var obj = $(this);
			var subId = obj.attr('data-id');
			$('#commentSub'+subId).removeClass('hide');
			if(obj.hasClass('showSub')){
				obj.removeClass('showSub').html("回复");
				$('#commentSub'+subId).addClass("hide");
			} else {
				obj.addClass('showSub').html('收起');
				obj.parents(".comments-level2-each").siblings().find(".level2-btn").removeClass('showSub').html('回复');
				obj.parents(".comments-level2-each").siblings().find(".level2-comments").addClass("hide");
				$('#commentSub'+subId).removeClass('hide');
			}
		});
		/**
		 * 点击评论事件
		 */
		$('#'+this.config.containerId).delegate('.orange-btn','click',function(){
			var obj = $(this);
			var id = obj.attr('data-id');
			var value = $('#textArea_'+id).val();
			if(value == ''){
				var _config = {
					msg: "很抱歉，请输入评论",
					showTime: 1500,
					type: 2
				};
				DialogOptips.dialogOptips(_config);
				return;
			}
			var len = caculateLength(value);
			if(len > 150){
				var _config = {
					msg: "很抱歉，输入字数超出最大长度150个字符",
					showTime: 1500,
					type: 2
				};
				DialogOptips.dialogOptips(_config);
				return;
			}
			var param = {};
			param.id = id;
			param.replyToUserId = obj.attr('data-userId');
			param.comment = value;
			param.parentId = obj.attr('data-parentId');
			that.config.addComment(param);
			$('#textArea_'+id).val('');
			if(id == 0){
				$('.limitCount').html('150');
			}
			$('#textArea_'+id).parent(".level2-comments").addClass("hide");
		});
		
		/**
		 * 删除回复
		 */
		$('#'+this.config.containerId).delegate('.deleteComment','click',function(){
			var obj = $(this);
			var id = obj.attr('data-id');
			var data = that.config.cacheData[id];
			that.config.deleteComment(data);
			obj.parent().parent().parent().remove();
			$('span[parent-id = "'+data.parentId +'"] span').text($('span[parent-id = "'+data.parentId +'"] span').text() - 0 - 1);
			window[data.parentId] = window[data.parentId]-1;
		});
	}
	
	CommentWrap.prototype.init = function(){
		this.config.containerDiv = $('#'+this.config.containerId);
		this.config.containerDiv.addClass('mt20');
		var html = '<div class="com-comments">'
						+'<h2 class="com-comments-h2">评价</h2>'
						+'<div class="com-commonts-area clearfix" id="">'
							+'<div class="counterBox">'
								+getTextArea(0)
								+'<div class="clearfix">'
									+'<span onclick="" id="" class="e-xpression">'+getFace()
									+'</span>'
									+'<a href="javascript:void(0);" class="fr mt10 com-button orange-btn ml10" onclick="" data-id="0" data-userId="0">评论</a>'
									+'<span class="textarea-ft-cont-pos"><i class="limitCount orange">150</i>/150</span>'
								+'</div>'
							+'</div>'
							+'<h3 class="com-comments-h3">全部评论(<span id="totalComment"></span>条)</h3>'
							+'<div class="clearfix com-comments-level1">'
							+'</div>'
						+'</div>'
					+'</div>';
		this.config.containerDiv.append(html);
	}
	
	CommentWrap.prototype.setTotal=function(total){
		$('#totalComment').html(total);
	}
	
	/**
	 * obj 中必须 id,userName,replyUserName,imagePath,time,comment
	 * 如果没有parentId是一级评论
	 * 如果有parentId是二级评论
	 */
	
	CommentWrap.prototype.appendComment = function(obj){
		this.config.cacheData[obj.id] = obj;
		var deleteHtml = '';
		var getCurSubCommentNum = window[obj.id] || 0;
		var commentCont = '<span parent-id="'+obj.id+'">(<span>'+getCurSubCommentNum+'</span>)</span>';
		if(this.config.currentUserId == obj.userId){
			deleteHtml = '<span class="commtent-remove fr deleteComment" data-id="'+obj.id+'" data-show="0">删除</span>';
		}
		obj.comment = smile.decodePubContent(obj.comment);
		if(obj.parentId == null){
			var html = '<div class="clearfix com-comments-level1" id="'+obj.id+'_level1" data-level2-reply="0" ><img class="img50" src="'+obj.imagePath+'" user-id="'+ obj.userId +'">';
				html += '<div class="com-comments-img-r break-word">'; 
				html += '<p>'+obj.userName+'：'+obj.comment+'</p>';
				html += '<p class="clearfix"><span class="com-comments-time">'+formatDate(obj.time)+'</span><span class="commtent-text-btn fr level1-btn reply" data-id="'+obj.id+'" data-show="0">回复'+commentCont+'</span>'+deleteHtml+'</p>'
				html += '</div><div class="com-comments-level2 hide" id="commentSub'+obj.id+'">';
				html += '<div class="level1-comments">'
							+getTextArea(obj.id)
							+'<div class="clearfix">'
								+'<span onclick="" id="" class="e-xpression">'+getFace()
								+'</span>'
								+'<a href="javascript:void(0);" class="fr mt10 com-button orange-btn ml10" onclick="" data-userId="'+obj.userId+'" data-parentId="'+obj.id+'" data-id="'+obj.id+'">提交</a>'
							+'</div>'
						+'</div>';
					html += '</div>';
				html +='</div>';
			$('.com-commonts-area').append(html);
		} else {
			var parent = this.config.cacheData[obj.parentId];
			var html = '<div class="clearfix mt20 comments-level2-each">'
							+'<img class="img50" src="'+obj.imagePath+'" user-id="'+ obj.userId +'">'
							+'<div class="com-comments-img-r break-word">'
								+'<p>'+obj.userName+'回复'+obj.replyToUserName+'：'+obj.comment+'</p>'
								+'<p class="clearfix"><span class="com-comments-time">'+formatDate(obj.time)+'</span><span class="commtent-text-btn fr level2-btn reply" data-show="0" data-id="'+obj.id+'">回复</span>'+deleteHtml+'</p>'
							+'</div>'
							+'<div class="level2-comments mt20 hide" id="commentSub'+obj.id+'">'
								+getTextArea(obj.id)
								+'<div class="clearfix">'
									+'<span onclick="" id="" class="e-xpression">'+getFace()
									+'</span>'
									+'<a href="javascript:void(0);" class="fr mt10 com-button orange-btn ml10" onclick="" data-userId="'+obj.userId+'" data-parentId="'+parent.id+'" data-id="'+obj.id+'">提交</a>'
								+'</div>'
							+'</div>'
						+'</div>';
			$('#commentSub'+obj.parentId).append(html);
			var oldLevel2Count = ValueCheck.getNumber($("#"+obj.parentId+"_level1").attr("data-level2-reply"));
			var curSubCommentNum = oldLevel2Count + 1;
			$("#"+obj.parentId+"_level1").attr("data-level2-reply",curSubCommentNum);
			$('span[parent-id = "'+obj.parentId +'"] span').text(curSubCommentNum );
			window[obj.parentId] = curSubCommentNum;
		}
	}
	
	CommentWrap.prototype.clear=function(){
		this.config.cacheData = {};
		$('#'+this.config.containerId+' .com-comments-level1').remove();
	}
	
	/**
	 * 生成文本框
	 */
	function getTextArea(id){
		var html = '<textarea name="" id="textArea_'+id+'"  limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame" chinese-count-two="true" limit-len="150"></textarea>';
		return html;
	}
	
	/**
	 * 获取圆脸
	 */
	function getFace(){
		var html = '';
		html += '<i class="iconfont icon-face"></i>';
		return html;
	}
	
	/**
	 * @param str
	 * 统计字符串中字符个数
	 * 英文之外的算2个
	 * 英文算1个
	 */
	function caculateLength(str){
		if(str == null || str == ''){
			return 0;
		}
		var len = str.match(/[^ -~]/g) == null ? str.length : str.length + str.match(/[^ -~]/g).length;
		return len;
	}
	
	function formatDate(date) {
		var currentDate = new Date();
		var currentDateS = currentDate.getTime();
		var date = new Date(date.replace(/-/g,'/').replace(/T|Z/g,' ').trim());
		var dateS = date.getTime();
		var interval = currentDateS - dateS;
		var intervalStr = null;
		if (interval < 60 * 1000) {
			intervalStr = '刚刚';
			return intervalStr;
		} else if (interval <= 60 * 1000 * 60) {
			intervalStr = new Number(interval / (1000 * 60)).toFixed();
			return intervalStr + '分钟前';
		} else if (interval <= 60 * 1000 * 60 * 24) {
			return '今天'+now('h:m', date);
		} else if (date.getFullYear() == currentDate.getFullYear()) {
			return now('m-d', date);
		} else {
			return now('y-m-d', date);
		}
	}
	Date.prototype.Format = function(fmt){   
		  
		  var o = {   
		    "M+" : this.getMonth()+1,                 //月份   
		    "d+" : this.getDate(),                    //日   
		    "H+" : this.getHours(),                   //小时   
		    "m+" : this.getMinutes(),                 //分   
		    "s+" : this.getSeconds(),                 //秒   
		    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
		    "S"  : this.getMilliseconds()             //毫秒   
		  };   
		  if(/(y+)/.test(fmt))   
		    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		  for(var k in o)   
			    if(new RegExp("("+ k +")").test(fmt))   
			  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
			  return fmt;   
	 }
	
	window.CommentWrap = CommentWrap;
})($,window)