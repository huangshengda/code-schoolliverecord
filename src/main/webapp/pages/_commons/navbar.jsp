<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <nav data-v-c4f038aa="" role="navigation" class="navbar navbar-default"><div data-v-c4f038aa="" class="wamp">
  <img data-v-c4f038aa="" src="<%=ROOT_UI_PUBLIC%>/_module/images/logo.png" class="inb">
  <div data-v-c4f038aa="" class="head inb"><div data-v-c4f038aa="" class="navHead">
    <span data-v-c4f038aa=""><a href="<%=ROOT_SERVER%>/#/index" class="router-link-active" data-v-c4f038aa="">
              首页
             </a></span><span data-v-c4f038aa=""><a href="<%=ROOT_SERVER%>/#/onDemand" class="" data-v-c4f038aa="">
              点播
             </a></span><span data-v-c4f038aa=""><a href="<%=ROOT_SERVER%>/#/basic" class="" data-v-c4f038aa="">
              基础管理
             </a></span></div> </div> <div data-v-c4f038aa="" class="out fr"><button data-v-c4f038aa="" class="fr">登录</button></div></div>  <form data-v-c4f038aa="" action="" id="login" class="layBox mt40"><div data-v-c4f038aa="" class="cd-f-row"><div data-v-c4f038aa="" class="cd-f-eve"><span data-v-c4f038aa="" class="cd-f-name"><label data-v-c4f038aa="">用户名:</label></span> <span data-v-c4f038aa="" class="cd-f-value"><input data-v-c4f038aa="" type="text" name="username" data-vali="notnull,username"></span></div> <div data-v-c4f038aa="" class="cd-f-eve"><span data-v-c4f038aa="" class="cd-f-name"><label data-v-c4f038aa="">密码:</label></span> <span data-v-c4f038aa="" class="cd-f-value"><input data-v-c4f038aa="" type="text" name="password" data-vali="notnull,password"></span></div> <div data-v-c4f038aa="" class="cd-f-eve"><input data-v-c4f038aa="" type="checkbox" name="auto" class="ml30">自动登录
      </div> <div data-v-c4f038aa="" class="cd-f-eve"><button data-v-c4f038aa="" class="lay-btn gray-btn">登录</button></div></div></form></nav>
 --%>

<nav role="navigation" class="navbar navbar-default">
	<div class="wamp">
	<img src="<%=ROOT_UI_PUBLIC%>/_module/images/logo.png" class="inb">
	<div class="head inb"><div class="navHead">
	<span><a href="<%=ROOT_SERVER%>/#/index" class="router-link-active">
              首页
             </a></span><span><a href="<%=ROOT_SERVER%>/#/onDemand" class="">
              点播
             </a></span><span><a href="<%=ROOT_SERVER%>/#/basic" class="">
              基础管理
             </a></span></div> </div> <div class="head-out fr"><button class="btn fr" id="openLogin">登录</button></div></div>  
             <form action="" id="login" class="layBox mt40 layui-layer-wrap" style="display: none;"><div class="cd-f-row"><div class="cd-f-eve"><span class="cd-f-name"><label>用户名:</label></span> <span class="cd-f-value"><input type="text" name="username" data-vali="notnull,username"></span></div> <div class="cd-f-eve"><span class="cd-f-name"><label>密码:</label></span> <span class="cd-f-value"><input type="text" name="password" data-vali="notnull,password"></span></div> <div class="cd-f-eve"><input type="checkbox" name="auto" class="ml30">自动登录
      </div> <div class="cd-f-eve"><button class="lay-btn gray-btn" id="loginIn">登录</button></div></div></form>
</nav>
<script type="text/javascript">
$(function(){
	$("#openLogin").click(function(){
		layer.open({
	          type: 1,
	          title: '登录',
	          skin: 'layui-layer-rim', //加上边框
	          area: ['450px', '375px'], //宽高
	          content: $("#login")
	      });
	});
	$("loginIn").click(function(){
		var result = Validation.validation({
		       containerId: "login",
		     });
		     if(result==true){
		       var data = { 
		         userName: $('[name="username"]').val(), 
		         userPwd: $('[name="password"]').val(), 
		         CheckCode: $('[name="auto"]').val() 
		       }; 
		       //提交数据给Login.ashx页面处理 
		       $.post("",data,function(result){ })
		     }
	});
});
</script>
 