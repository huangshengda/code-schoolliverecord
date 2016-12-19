$(function() {
	var resourceId = sessionStorage.getItem("resourceId");
	if(resourceId == undefined){
		layerIndex = layer.confirm('缺少资源信息，请返回首页',{btn: ['确定', '取消']},function(){
			window.location.href = ROOT_SERVER+"/#/index";
		});
	}
	var token = sessionStorage.getItem("token");
	var liveUrl = "",
		dmc = "",
		pms = "",
		tool = vm.module["tool"],
		flashBuilder = vm.module["playerBuilder"];
		CDUtil.ajaxPost("/resource/get", {resourceId: resourceId},function(retVO){
		if (retVO.code == 1) {
			//课程名称，年级、学科、主讲教师
			var resourceName = retVO.data.resourceName;
			var classlevelName = retVO.data.classlevelName;
			var subjectName = retVO.data.subjectName;//学科
			var author = retVO.data.author;//
			$("#resource_name").html(resourceName);
			$("#resource_info").html(classlevelName+"/"+subjectName+"/"+author);
			pms = retVO.data.storePath;
			var streamName = retVO.data.resourceId;
			buildPlayer(document.getElementsByClassName("vedio")[0], streamName, "mix");
		}
	});

	$('.c-del').click(function() {
		$(this).parent().remove();
	});
	
	var Chat = {};
	Chat.socket = null;
	
	Chat.connect = (function(host) {
		if ('WebSocket' in window) {
			Chat.socket = new WebSocket(host);
		} else if ('MozWebSocket' in window) {
			Chat.socket = new MozWebSocket(host);
		} else {
			Console.log('Error: WebSocket is not supported by this browser.');
			return;
		}
		Chat.socket.onopen = function() {};

		Chat.socket.onclose = function() {
			document.getElementById('chat').onkeydown = null;
		};

		Chat.socket.onmessage = function(retVO) {
			var dataVO = eval('(' + retVO.data + ')');
			console.log(dataVO);
			var delFlag = dataVO.delFlag;
			var id = dataVO.id;
			if(delFlag){
				$("#"+id).remove();
			}else{
				var msg = dataVO.msg,
				author = dataVO.author,
				delAuth = dataVO.delAuth,
				timestamp = dataVO.timestamp,
				times = new Date().getTime();
				$("#online_count").html(dataVO.onlineCount);
				var htmlStr = '<li class="chat-li" id="'+id+'" data-timestamp="'+timestamp+'"  >'
 					+'<span class="fb mr20">'+author+'</span>'
 					//+'<span>5分钟之前</span>'
 					+'<p class="s-flow">'+msg+'</p>';
				if(delAuth){
					htmlStr += '<i class="iconfont icon-delete chat-delete fr c9" data-id="'+id+'"></i>'
				}
				$(htmlStr).appendTo("#chat_context");
				$("#chat_context").scrollTop($("#chat_context").height());
			}
			$("#chat").val("");
		};
	});
	
	Chat.initialize = function() {
		if (window.location.protocol == 'http:') {
			Chat.connect('ws://' + ROOT_SERVER_CHAT + "/" + resourceId + "/" + token);
		} else {
			Chat.connect('wss://' + ROOT_SERVER_CHAT + "/" + resourceId + "/" + token);
		}
	};
	/**
	 * 与后台发起消息通信
	 */
	Chat.sendMessage = (function(params) {
		Chat.socket.send(ValueCheck.jsonTostr(params));
	});
	
	Chat.initialize();

	$("#console").on("click", ".icon-delete",function() {
		var id = $(this).attr("data-id");
		var params = {
			id: id
		}
		Chat.sendMessage(params);
	});
	/**
	 * 处理发送信息的方法。
	 */
	var readyMsg = function(){
		var msg = $("#chat").val();
		msg = $.trim(msg);
		var len = ValueCheck.lengthStr(msg);
		if(len == 0){
			
		}else if(len < 141){
			var params = {
				msg: msg,
				timestamp: new Date().getTime()
			};
			Chat.sendMessage(params);
		}else{//弹框提示
			alert("聊天内容太长");
		}
	};
	/**
	 * 在输入框使用Enter事件发送信息
	 */
	$("#chat").keypress(function(keyObj) {
		if (keyObj.keyCode == 13) {
			readyMsg();
		}
	});
	
	/**
	 * 点击发表按钮事件
	 */
	$('#chat_send').click(function() {
		readyMsg();
	});
	
	var Console = {};
	Console.log = (function(message) {
		var console = document.getElementById('console');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.innerHTML = message;
		while (console.childNodes.length > 25) {
			console.removeChild(console.firstChild);
		}
		console.scrollTop = console.scrollHeight;
	});
	

	function buildPlayer(wrap, _streamName, receiveType) {
		function _buildPlayer(pms) {
			var player = flashBuilder.init({
				id: "player_" + tool.random(),
				wrap: wrap,
				nameSpace: "play_" + tool.random(),
				swf: publicPath + "/player_flash/streamPlayer.swf",
				fullpos: 4,
				type: "receive",
				receiveType: receiveType,
				file: _streamName,
				url: pms,
			},
			false);

			player.streamEvent.addCustEvent("onLoad",
			function() {
				player.play();
			});
		}

		if (dmc) {
			$jsonp(dmc, {
				"method": "play",
				"stream": _streamName,
				"confid": _streamName
			},
			function(dms) {
				if (!dms) alert("dmc服务器错误！");
				_buildPlayer(dms);
			});
		} else {
			_buildPlayer(pms);
		}
	}
});