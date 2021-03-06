<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav role="navigation" class="navbar navbar-default"> 
  <div class="wamp"> 
   <img src="${basicInfo.logoPath}" id="logo_img" class="inb">
   <div class="head inb">
    <div class="navHead" id="sys_slr_nav" > 
    <%--  <span><a href="${ROOT_SERVER}/#/index" class="router-link-active">首页 </a></span>
     <span><a href="${ROOT_SERVER}/#/onDemand" class="">点播 </a></span>
     <span><a href="${ROOT_SERVER}/#/basic" class=""> 基础管理 </a></span> --%>
    </div>
   </div>
   <div class="head-out fr" id="user_info" style="display: none;" >
    	<span id="user_realname" ></span>
        <span class="g-line">|</span>
        <i class="iconfont icon-sign-out" id="logout" ></i>
   </div>
   <div class="fr" id="login_button" style="display: none;"><i class="iconfont icon-login-name"></i>登录</div>
  <!--  <button class="btn fr" id="login_button" style="display: none;" >登录</button> -->
  </div>
  <form action="" id="login" class="layBox mt40 layui-layer-wrap" style="display: none;"> 
   <div class="cd-f-row"> 
    <div class="cd-f-eve"> 
     <span class="cd-f-name"> <label>用户名:</label> </span> 
     <span class="cd-f-value"> <input type="text" id="username" name="username" data-vali="notnull" value="admin" /> </span> 
    </div>
    <div class="cd-f-eve"> 
     <span class="cd-f-name"><label>密码:</label></span> 
     <span class="cd-f-value"><input type="password" id="password" name="password" data-vali="notnull" value="123456" /></span>
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
	/**登录**/
	function loginIn(){
		var result = Validation.validation({
		       containerId: "login",
		     });
		     if(result==true){
		       	var data = { 
					userName: $("#username").val(), 
					userPwd: md5($("#password").val()), 
					CheckCode: $("#auto").val()
		      	};
		       	//提交数据给Login.ashx页面处理 
		     	//提交数据给到后台处理
				CDUtil.ajaxPost("/login",params,function(retVO){
				  if(retVO.code == 1){
					self.userType= retVO.data.userType;
					layer.msg(retVO.msg);  
					layer.close(laryIndex);
					$("#user_info").show();
					$("#login_button").hide();
					sessionStorage.loginFlag = "1";
					sessionStorage.token = retVO.data.token;
					sessionStorage.realname = retVO.data.realname;
					$("#user_realname").html(retVO.data.realname);
				  }
				  if (retVO.code == 0 && $("#username").val() !='' &&　$("#password").val() !=''){
					  setTimeout(function () {
				        	layer.msg(retVO.msg);
		       			}, 1000);	
		             }
				});
			}
	}
	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
  		if(retVO.code == 2){
  			$("#user_info").hide();
    		$("#login_button").show();
    		sessionStorage.clear();
  		}else if(retVO.code == 1){
  			$("#user_info").show();
			$("#login_button").hide();
			sessionStorage.setItem("realname", retVO.data.realname);
			$("#user_realname").html(retVO.data.realname);
  		}
  	});
	CDUtil.ajaxPost("/menu",{},function(retVO){
		var menus = retVO.data;
		$(menus).each(function(i,menu){
			var id = menu.id,
			name = menu.name,
			url = menu.url;
			var htmlStr = '<span><a id="'+id+'_menu" href="${ROOT_SERVER}/#'+url+'">'+name+'</a></span>';
			$(htmlStr).appendTo("#sys_slr_nav");
		});
		if(sessionStorage.getItem("nav")=="demand"){
			$(".navHead span").eq(1).css({"border-bottom":"2px solid #fff"});
		}else if(sessionStorage.getItem("nav")=="basic"){
			$(".navHead span").eq(2).css({"border-bottom":"2px solid #fff"});
		}
	});
	
	if(sessionStorage.getItem("loginFlag") == "1"){
        $("#user_info").show();
        $("#login_button").hide();
        $("#user_realname").html(sessionStorage.getItem("realname"));
      }else{
    	  $("#login_button").show();
      }
	var laryIndex = null;
	$("#login_button").click(function(){
		laryIndex = layer.open({
	          type: 1,
	          title: '登录',
	          skin: 'layui-layer-rim', //加上边框
	          area: ['450px', '375px'], //宽高
	          content: $("#login"),
	          end: function() {
	  			$(".cd-f-vali").remove();
	  		}
	      });
	});
	$("#loginIn").click(function(){
		loginIn();
	});
	$("#login").bind('keyup', function(event) {
		if (event.keyCode == "13") {
			loginIn();
		}
	});
	$("#user_realname").click(function(){
		sessionStorage.setItem("nav","basic");
		window.open(ROOT_SERVER+"/front/path/editpwd?token="+sessionStorage.getItem("token"));
	});
	$("#logout").click(function(){
		layerIndex = layer.confirm('是否确定退出用户登录？',{btn: ['确定', '取消']},function(){
			localStorage.removeItem("SLR_LOGINFLAG","1");
   	 		localStorage.removeItem("SLR_LOGINTIME", new Date().getTime());
   	 		localStorage.removeItem("SLR_USERNAME", params.username);
   	 		localStorage.removeItem("SLR_PASSWORD", params.password);
			layer.close(layerIndex);
			layer.msg("等待退出登录. . .");
			CDUtil.ajaxPost("/loginout",{},function(retVO){
		        $("#user_info").hide();
		        $("#login_button").show();
		        sessionStorage.clear();
		       // window.location.href = ROOT_SERVER+"/#/index";
		        setTimeout(function () {
		        	// window.close();
		        	window.location.href = ROOT_SERVER+"/#/index";
		        	//window.location.reload();
       			}, 1000);
		        //window.location.reload();
		    });
		});
	});

});
</script>