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

	"use strict";
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

		Chat.socket.onmessage = function(message) {
			console.log(message.data);
			if(message.data.delFlag){
				var msg = message.data.msg;
			}else{
				//addinfo
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
		var message = document.getElementById('chat').value;
		if (message != '') {
			Chat.socket.send(message);
			document.getElementById('chat').value = '';
		}
	});

	$("#chat").keypress(function(data) {
		if (data.keyCode == 13) {
			var message = document.getElementById('chat').value;
			if (message != '') {
				Chat.socket.send(message);
				document.getElementById('chat').value = '';
			}
		}
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

	Chat.initialize();

	$("#console").on("click", ".icon-delete",function() {
		var uuid = $(this).attr("data-uuid");
		var params = {
			uuid: uuid
		}
		Chat.sendMessage(params);
		//$("#fdafdafdafda").remove();
	});

	$('#aa').click(function() {
		Chat.sendMessage();
	})

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