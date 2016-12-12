$(function() {
	var resourceId = sessionStorage.getItem("resourceId");
	var token = sessionStorage.getItem("token");
	var liveUrl = "";
	CDUtil.ajaxPost("/resource/get", {resourceId: resourceId},function(retVO){
		if (retVO.code == 1) {
			liveUrl = retVO.data.storePath;
			var pms = "",
			//dms服务器地址，需要后台传过来
			streamName = retVO.data.resourceName,
			//课程id，需要后台传过来
			dmc = "",
			tool = vm.module["tool"],
			flashBuilder = vm.module["playerBuilder"];
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
			console.log(retVO.data);
			var dataVO = eval('(' + retVO.data + ')'); ;
			var delFlag = dataVO.delFlag;
			var id = dataVO.id;
			if(delFlag){
				$("#"+id).remove();
			}else{
				console.log(typeof(dataVO))
				var msg = dataVO.msg,
				author = dataVO.author,
				delAuth = dataVO.delAuth,
				timestamp = dataVO.timestamp,
				times = new Date().getTime();
				var htmlStr = '<li class="chat-li" id="'+id+'" data-timestamp="'+timestamp+'"  >'
 					+'<span class="fb mr20">'+author+'</span>'
 					//+'<span>5分钟之前</span>'
 					+'<p class="s-flow">'+msg+'</p>';
				if(delAuth){
					htmlStr += '<i class="iconfont icon-delete chat-delete fr" data-id="'+id+'"></i>'
				}
				$(htmlStr).appendTo("#chat_context");
			}
		};
	});
	
	Chat.initialize = function() {
		if (window.location.protocol == 'http:') {
			Chat.connect('ws://' + ROOT_SERVER_CHAT + "/" + resourceId + "/" + token);
		} else {
			Chat.connect('wss://' + ROOT_SERVER_CHAT + "/" + resourceId + "/" + token);
		}
	};
	
	Chat.sendMessage = (function(params) {
		Chat.socket.send(json2str(params));
	});
	
	$("#chat").keypress(function(data) {
		if (data.keyCode == 13) {
			debugger;
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
		}
	});
	
	/** 
	* json对象转字符串形式 
	*/ 
	function json2str(o) { 
	var arr = []; 
	var fmt = function(s) { 
	if (typeof s == 'object' && s != null) return json2str(s); 
	return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s; 
	} 
	for (var i in o) arr.push("'" + i + "':" + fmt(o[i])); 
	return '{' + arr.join(',') + '}'; 
	} 

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
	
	Chat.initialize();

	$("#console").on("click", ".icon-delete",function() {
		var id = $(this).attr("data-id");
		var params = {
			id: id
		}
		Chat.sendMessage(params);
	});
	
	$('#chat_send').click(function() {
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

	//buildPlayer(document.getElementsByClassName("vedio")[0], streamName, "mix");
});