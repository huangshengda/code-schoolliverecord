<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String token = request.getParameter("token");
	String resourceId = request.getParameter("resourceId");
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>直播详情页</title>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <meta name="viewport" content="width=device-width">
  <%@ include file="../../_commons/meta.jsp"%>
<script type="text/javascript" src="<%=ROOT_UI_PUBLIC%>/_tools/tool.js"></script>
<script type="text/javascript" src="<%=ROOT_UI_PUBLIC%>/player_flash/player_flash.js"></script>
  <style type="text/css">
    /* 直播课程详情 start*/
.live{
  margin-top:50px;
}
.l-left{
  display: inline-block;
  width: 918px; }
  .chat-bland{
    background-color: #fff;}
    ul{
      color:#444;
      padding:0 10px;
      height: 326px;
      overflow-y: auto;}
      .c-content{
        display: inline-block;
        width:195px;}
        .c-time {color:#999;margin-left:10px;}

      .c-del{color:#999;margin-top:10px;cursor: pointer;}

 .l-title{
      font-size:20px;
      color:#222;
      line-height: 35px;
    }
.l-title small{
        color:#666;
      }
.vedio{
      width: 100%;
    height: 562px;
    position: relative;

}
.l-right{
  width: 281px;
  border:1px solid #ececec;
  border-top:1px solid #34a150;
  }
  .right-head{
    height:45px;
    line-height: 45px;
    color:#34a150;
    padding: 0 15px;
    border-bottom:1px solid #ececec;
  }
  .bar{
    margin-top:20px;
    border-radius: 1px;
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
    background-color: #f5f5f5;
    height:23px;
    border: 1px solid #DDDDDD;
  }

.c-text{
  padding: 10px;
  background-color: #f5f5f5;}
  .c-text textarea{
    width:258px;
    height:80px;
  }
.c-text button{ margin-right: 9px;padding:2px 14px;margin-top:8px;margin-bottom:4px;}

/* 直播课程详情 end*/
  </style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
<!-- 直播课程详情 start-->
<div class="container" >
	<p class="l-title">汉语言文学（第一节）
		<span class="ft12">
			<i class="iconfont icon-play-times"></i>123</span>
		<small class="ft12">一年级/语文/谢春华</small>
	</p>
	<div class="row" >
		<div class="col-md-9" >
			<div class="vedio"></div>
		</div>
		<div class="col-md-3" >
			<div class="l-right fr">
				<div class="chat-bland" id="console">
		          <div class="right-head ft16">交流区（26人）</div>
		          <div class="v-recommend" >
		          <ul>
			            <li id="fdafdafdafda" >
				            <div class="c-content">
				            	<span class="fb">李明珠</span>
				            	<span class="c-time ft12">5分钟前</span>
				            	<p class="s-flow">李老师讲的好好啊。。。</p>
				            	<i class="iconfont icon-delete" data-uuid="fdafdafdafda" ></i>
				            </div>
			            </li>
			          </ul>
		          </div>
		          <div class="bar"></div>
		          <div class="c-text">
		            <textarea id="chat"></textarea>
		            <button class="commit fr" id="aa">发表</button>
		          </div>
		        </div>
			</div>
		</div>
	</div>
</div>
<!-- 点播课程详情  end-->
  <script type="text/javascript">
    $(function(){
    	
    	
    	var resourceId = sessionStorage.getItem("resoureceId");
    	var token = sessionStorage.getItem("token");
    	var liveUrl = "";
    	CDUtil.ajaxPost("/resource/get",{resourceId: resourceId},function(retVO){
    		if(retVO.code == 1){
    			liveUrl = retVO.data.storePath;
        		var pms = "",    //dms服务器地址，需要后台传过来
        		streamName = "",	//课程id，需要后台传过来
        		dmc = "",
        		tool = vm.module["tool"],
        		flashBuilder = vm.module["playerBuilder"];
    		}
    	});
    	
    	
      	$('.c-del').click(function(){
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
            Chat.socket.onopen = function () {
            };

            Chat.socket.onclose = function () {
                document.getElementById('chat').onkeydown = null;
                Console.log('Info: WebSocket closed.');
            };

            Chat.socket.onmessage = function (message) {
                Console.log(message.data);
            };
        });

        Chat.initialize = function() {
            if (window.location.protocol == 'http:') {
                Chat.connect('ws://'+ROOT_SERVER_CHAT+"?resoureceId="+resourceId+"&token="+token);
            } else {
                Chat.connect('wss://'+ROOT_SERVER_CHAT+"?resoureceId="+resourceId+"&token="+token);
            }
        };

        Chat.sendMessage = (function(params) {
            var message = document.getElementById('chat').value;
            if (message != '') {
                Chat.socket.send(message);
                document.getElementById('chat').value = '';
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
        
        $("#console").on("click",".icon-delete",function(){
        	var uuid = $(this).attr("data-uuid");
        	var params = {uuid: uuid}
        	Chat.sendMessage(params);
        	$("#fdafdafdafda").remove();
        });
        
        
        $('#aa').click(function(){
           Chat.sendMessage();
        })
        
        function buildPlayer(wrap, _streamName, receiveType) {
			function _buildPlayer(pms) {
				var player = flashBuilder.init({
					id: "player_" + tool.random(),
					wrap: wrap,
					nameSpace: "play_" + tool.random(),
					swf: publicPath+"/player_flash/streamPlayer.swf",
					fullpos: 4,
					type: "receive",
					receiveType: receiveType,
					file: _streamName,
					url: pms,
				}, false);
				
				player.streamEvent.addCustEvent("onLoad", function() {
					player.play();
				});
			}
			
			if(dmc) {
				$jsonp(dmc, {
					"method": "play",
					"stream": _streamName,
					"confid": _streamName
				},function(dms){
					if(!dms) alert("dmc服务器错误！");
					_buildPlayer(dms);
				});
			} else {
				_buildPlayer(pms);
			}
		}
        
        buildPlayer(document.getElementsByClassName("vedio")[0], streamName, "mix");
    })
  </script>
</body>
</html>
