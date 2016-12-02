<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>直播详情页</title>
  <meta name="viewport" content="width=device-width">
  <script type="text/javascript" src="../../../../public/_config/sys_front_config.js" ></script>
  <script type="text/javascript" src="../../../../public/jquery/jquery-2.2.4.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_manifest.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_common.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_base.js" ></script>
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
  border-right:1px solid #ececec;
  border-bottom:1px solid #ececec;
  border-top:1px solid #34a150;
  }
  .right-head{
    height:45px;
    line-height: 45px;
    color:#34a150;
    padding: 0 15px;
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
<nav data-v-c4f038aa="" role="navigation" class="navbar navbar-default"><div data-v-c4f038aa="" class="wamp">
  <img data-v-c4f038aa="" src="../../../public/_module/images/logo.png" class="inb"> 
  <div data-v-c4f038aa="" class="head inb"><div data-v-c4f038aa="" class="navHead">
    <span data-v-c4f038aa=""><a href="/#/index" class="router-link-active" data-v-c4f038aa="">
              首页
             </a></span><span data-v-c4f038aa=""><a href="/#/onDemand" class="" data-v-c4f038aa="">
              点播
             </a></span><span data-v-c4f038aa=""><a href="/#/basic" class="" data-v-c4f038aa="">
              基础管理
             </a></span></div> </div> <div data-v-c4f038aa="" class="out fr"><button data-v-c4f038aa="" class="fr">登录</button></div></div>  <form data-v-c4f038aa="" action="" id="login" class="layBox mt40"><div data-v-c4f038aa="" class="cd-f-row"><div data-v-c4f038aa="" class="cd-f-eve"><span data-v-c4f038aa="" class="cd-f-name"><label data-v-c4f038aa="">用户名:</label></span> <span data-v-c4f038aa="" class="cd-f-value"><input data-v-c4f038aa="" type="text" name="username" data-vali="notnull,username"></span></div> <div data-v-c4f038aa="" class="cd-f-eve"><span data-v-c4f038aa="" class="cd-f-name"><label data-v-c4f038aa="">密码:</label></span> <span data-v-c4f038aa="" class="cd-f-value"><input data-v-c4f038aa="" type="text" name="password" data-vali="notnull,password"></span></div> <div data-v-c4f038aa="" class="cd-f-eve"><input data-v-c4f038aa="" type="checkbox" name="auto" class="ml30">自动登录
      </div> <div data-v-c4f038aa="" class="cd-f-eve"><button data-v-c4f038aa="" class="lay-btn gray-btn">登录</button></div></div></form> </nav>
<!-- 点播课程详情  start-->
<div class="wamp">
  <!-- 直播课程详情  start-->
  <div class="live">
    <p class="l-title">汉语言文学（第一节）<small class="ft12">一年级/语文/谢春华</small></p>
      <div class="l-left">
        <div class="vedio"></div>
      </div>
      <div class="l-right fr">
        <div class="chat-bland" id="console">
          <div class="right-head ft16">交流区（26人）</div>
          <ul>
            <li>
            <div class="c-content"><span class="fb">李明珠</span><span class="c-time ft12">5分钟前</span><p class="s-flow">李老师讲的好好啊。。。</p></div>
            <a class="c-del fr"><i class="iconfont icon-delete"></i></a>
            </li>
            <li>
            <div class="c-content"><span class="fb">李明珠</span><span class="c-time ft12">5分钟前</span><p class="s-flow">李老师讲的好好啊。。。</p></div>
            <a class="c-del fr"><i class="iconfont icon-delete"></i></a>
            </li>
          </ul>
          <div class="clear"></div>
          <div class="bar"></div>
          <div class="c-text">
            <textarea id="chat"></textarea>
            <button class="commit fr" id="aa">发表</button>
            <div class="clear"></div>
          </div>
          <div class="clear"></div>
        </div>
    </div>
  </div>
<!-- 直播课程详情  end-->
</div>
<!-- 点播课程详情  end-->
  <script type="text/javascript">
    $(function(){
      $("#locationToDemond").click(function(){
        window.location.href = ROOT_UI+"/#/onDemand";
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
                Chat.connect('ws://' + window.location.host + '/chart');
            } else {
                Chat.connect('wss://' + window.location.host + '/chart');
            }
        };

        Chat.sendMessage = (function() {
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
            console.appendChild(p);
            while (console.childNodes.length > 25) {
                console.removeChild(console.firstChild);
            }
            console.scrollTop = console.scrollHeight;
        });

        Chat.initialize();
        $('#aa').click(function(){
           Chat.sendMessage();
        })

    })
  </script>
</body>
</html>
