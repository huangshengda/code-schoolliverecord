<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<title>${basicInfo.title}</title>
<script type="text/javascript">
/**
 * 前端资源文件的根目录
 */
ROOT_UI = "${ROOT_UI}";
ROOT_UI_PUBLIC = ROOT_UI+"/public";
ROOT_UI_MODULE = ROOT_UI_PUBLIC+"/_module";
ROOT_UI_PAGES = ROOT_UI+"/pages";
publicPath = ROOT_UI_PUBLIC;
/**
 * 服务端的根目录（可以有多个服务端
 */
ROOT_SERVER = "${ROOT_SERVER}";
/**
 * 在线聊天后台地址
 */
ROOT_SERVER_CHAT = "${ROOT_CHAT}/chat";
layerIndex = null;//用来定义页面提示框的层，方便关闭
params = {};//用来定义页面和后台交互的公共传参对象
</script>
<link rel="stylesheet" type="text/css" href="${ROOT_UI}/public/myLayer/layer/skin/layer.css">
<script type="text/javascript" src="${ROOT_UI}/public/jquery/jquery-2.2.4.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/jquery/jquery.serializejson.min.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/myLayer/layer/layer.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/qqFace/js/jquery.qqFace.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_manifest.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_common.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_base.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/_module/videoup/videoup.js"></script>
<script type="text/javascript" >
/**
 * 后台返回的用户在线标示
 */
TOKEN_FLAG = "${token}";
//console.log("默认加载出来的后台TOKEN_FLAG---"+TOKEN_FLAG);
if(TOKEN_FLAG == ""){
	setTimeout(function(){
		window.location.href = ROOT_SERVER+"/#/index";
	},500);
}
LOGIN_FLAG = sessionStorage.getItem("loginFlag");
AUTO_LOGIN_FLAG = localStorage.getItem("SLR_LOGINFLAG");
sessionStorage.setItem("token",TOKEN_FLAG);
/**
 * 自动登录验证。
 * 
 * 首先验证Session级别的Token，Token验证失败启动自动登录的Local级别验证。
 * 如果自动登录验证失败，重定向到首页。
 */
var autoLogin = function(){
	var logintime = localStorage.getItem("SLR_LOGINTIME");
	var username = localStorage.getItem("SLR_USERNAME");
	var password = localStorage.getItem("SLR_PASSWORD");
	var nowtime = new Date().getTime();
	if(logintime == null){
		logintime = nowtime;
	}
	if((nowtime-logintime)>7*24*60*60*1000){
		localStorage.removeItem("SLR_LOGINFLAG");
		localStorage.removeItem("SLR_LOGINTIME");
		localStorage.removeItem("SLR_USERNAME");
		localStorage.removeItem("SLR_PASSWORD");
		return;
	}
	CDUtil.ajaxPost("/login",{username: username,password: password},function(retVO){
        if(retVO.code == 1){
        	localStorage.setItem("SLR_LOGINTIME", new Date().getTime());
			$("#user_info").show();
			$("#login_button").hide();
			sessionStorage.setItem("loginFlag", "1");
			sessionStorage.setItem("token", retVO.data.token);
			sessionStorage.setItem("realname", retVO.data.realname);
			$("#user_realname").html(retVO.data.realname);
			setTimeout(function(){
   	 			window.location.reload();
   	 		},100);
        }else{
        	localStorage.removeItem("SLR_LOGINFLAG");
   	 		localStorage.removeItem("SLR_LOGINTIME");
   	 		localStorage.removeItem("SLR_USERNAME");
   	 		localStorage.removeItem("SLR_PASSWORD");
   	 		LOGIN_FLAG = null;
   	 		AUTO_LOGIN_FLAG = null;
   	 		setTimeout(function(){
   	 			window.location.href = ROOT_SERVER+"/#/index";
   	 		},100);
		}
      },false);
}
//验证Session级别的Token验证。
if(TOKEN_FLAG != "" && LOGIN_FLAG != "1"){//满足有TOKEN但是未登录
	CDUtil.ajaxPost("/token/getuser",{token: TOKEN_FLAG},function(retVO){
		if(retVO.code == 1){
			sessionStorage.setItem("loginFlag", "1");
		}else{
			autoLogin();
		}
	},false);
}else if(AUTO_LOGIN_FLAG == "1" && LOGIN_FLAG != "1"){
	autoLogin();
}else if(TOKEN_FLAG != "" && LOGIN_FLAG == "1"){
	CDUtil.ajaxPost("/token/getuser",{token: TOKEN_FLAG},function(retVO){
		if(retVO.code == 1){
			
		}else if(retVO.code == 2){
			sessionStorage.clear();
			setTimeout(function(){
				window.location.href = ROOT_SERVER+"/#/index";
   	 		},100);
		}
	},false);
}
</script>