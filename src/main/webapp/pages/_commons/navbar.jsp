<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav role="navigation" class="navbar navbar-default"> 
  <div class="wamp"> 
   <img src="${ROOT_UI}/public/_module/images/logo.png" class="inb" /> 
   <div class="head inb">
    <div class="navHead"> 
     <span><a href="${ROOT_SERVER}/#/index" class="router-link-active"> 首页 </a></span>
     <span><a href="${ROOT_SERVER}/#/onDemand" class=""> 点播 </a></span>
     <span><a href="${ROOT_SERVER}/#/basic" class=""> 基础管理 </a></span>
    </div> 
   </div> 
   <div class="head-out fr" id="user_info" style="display: none;" >
    	<span id="user_realname" ></span>
        <span class="g-line">|</span>
        <i class="iconfont icon-sign-out" id="logout" ></i>
   </div>
   <button class="btn fr" id="login_button" style="display: none;" >登录</button>
  </div> 
  <form action="" id="login" class="layBox mt40 layui-layer-wrap" style="display: none;"> 
   <div class="cd-f-row"> 
    <div class="cd-f-eve"> 
     <span class="cd-f-name"> <label>用户名:</label> </span> 
     <span class="cd-f-value"> <input type="text" id="username" name="username" data-vali="notnull,username" /> </span> 
    </div>
    <div class="cd-f-eve"> 
     <span class="cd-f-name"><label>密码:</label></span> 
     <span class="cd-f-value"><input type="text" id="password" name="password" data-vali="notnull,password" /></span>
    </div>
    <div class="cd-f-eve">
     <input type="checkbox" id="auto" name="auto" class="ml30" />自动登录 
    </div> 
    <div class="cd-f-eve">
     <button class="lay-btn gray-btn" id="loginIn">登录</button>
    </div>
   </div>
  </form> 
 </nav>
<script type="text/javascript">
$(function(){
	if(sessionStorage.getItem("loginFlag") == "1"){
        $("#user_info").show();
        $("#login_button").hide();
        $("#user_realname").html(sessionStorage.getItem("realname"));
      }else{
    	  $("#login_button").show();
      }
	var laryIndex = null;
	$("#openLogin").click(function(){
		laryIndex = layer.open({
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
				userName: $("#username").val(), 
				userPwd: $("#password").val(), 
				CheckCode: $("#auto").val()
	      	};
	       	//提交数据给Login.ashx页面处理 
	     	//提交数据给到后台处理
			CDUtil.ajaxPost("/login",params,function(retVO){
			  if(retVO.code == 1){
				layer.close(laryIndex);
				$("#user_info").show();
				$("#login_button").hide();
				sessionStorage.loginFlag = "1";
				sessionStorage.token = retVO.data.token;
				sessionStorage.realname = retVO.data.realname;
				$("#user_realname").html(retVO.data.realname);
			  }
			});
		}
	});
	$("#logout").click(function(){
		CDUtil.ajaxPost("/loginout",{},function(retVO){
	        $("#user_info").hide();
	        $("#login_button").show();
	        sessionStorage.clear();
	    });
	});
});
</script>
 