<template>
  <nav class="navbar navbar-default" role="navigation">
    <div class="wamp">
    <img src="" class="inb" id="logo_img">
      <div class="head inb">
          <div class="navHead">
          	<span v-for="menuList in menus.data">
          		<router-link :to="menuList.url">{{menuList.name}}</router-link>
        	 </span>
          </div>
        </div>
        <div class="head-out fr" style="display: none;" id="user_info" >
          <span id="user_realname" @click="editPwd"></span>
          <span class="g-line">|</span>
          <i class="iconfont icon-sign-out" @click="logout" ></i>
        </div>
        <div class="fr" id="login_button" @click="login"><i class="iconfont icon-login-name"></i>登录</div>
      </div>
<!-- 编辑用户弹窗表单 start -->
  <form action="" id="login" class="layBox mt40" @keyup.enter="loginIn">
   <div class="cd-f-row">
        <div class="cd-f-eve login-use-name">
          <span class="cd-f-name input-left-img iconfont icon-login-name"></span>
          <span class="cd-f-value">
            <input type="text" id="username" name="username" data-vali="notnull" placeholder="用户名" class="login-input" maxlength="30">
          </span>
        </div>
        <div class="cd-f-eve login-password">
          <span class="cd-f-name input-left-img iconfont icon-password"></span>
          <span class="cd-f-value">
            <input type="password" id="password" name="password" data-vali="notnull" placeholder="密码" class="login-input">
        </div>
        <div class="cd-f-eve">
           <span class="l-way-auto"><div class="l-way-check" data-select="0"><input type="checkbox" id="auto" name="auto" class="ml30"></div>自动登录</span>
        </div>
        <div class="cd-f-eve login-btn">
          <button type="button" class="lay-btn gray-btn" @click="loginIn">登录</button>
        </div>
    </div>
  </form>
<!-- 编辑用户弹窗表单 end -->
</nav>
</template>
<script>
$(function(){
	//登录模拟复选框
	$(".l-way-auto").on("click",function(){
		var dataSelect = $(".l-way-auto .l-way-check").attr("data-select"),
		_input = $(".l-way-check input");
		if(dataSelect == 0){
			$(".l-way-auto .l-way-check").addClass("lw-checked");
			_input.prop("checked",true);
			$(".l-way-auto .l-way-check").attr("data-select","1");
		}else if(dataSelect == 1){
			$(".l-way-auto .l-way-check").removeClass("lw-checked");
			_input.prop("checked",false);
			$(".l-way-auto .l-way-check").attr("data-select","0");
		}
	});
	//登录框获取焦点
	$(".login-input").focus(function(){
		$(this).parent().parent().addClass("focus");
		$(this).parent().parent().siblings().removeClass("focus");
	});
});
var laryIndex  ;
import menu from "menu"
export default{
  data () { 
      return{
        menu: menu,
        userType:'',
        item: [],
        menus:''
      }
  },
  mounted () {    
      this.init()
    },
   methods:{
    init: function(){
   	 	var _self= this;
    	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
      		if(retVO.code == 1){
      			$("#user_info").show();
				$("#login_button").hide();
				sessionStorage.setItem("realname", retVO.data.realname);
				$("#user_realname").html(retVO.data.realname);
      		}else{//没有用户登录。
      		}
      	});
      	/**获取导航**/
      	CDUtil.ajaxPost("/menu",{},function(retVO){
      		_self.menus = retVO;
      	});
      	/**获取logo图片**/
      	CDUtil.ajaxPost("/base/basicinfo/get",{},function(retVO){
			if (retVO.code == 1) {
				$('#logo_img').attr('src',retVO.data.logoPath);
			}
		});
    },
    login:function(){
      laryIndex = layer.open({
          type: 1,
          title: '登录',
          skin: 'layui-layer-rim', //加上边框
          area: ['450px', '360px'], //宽高
          content: $("#login")
      });
    },
    loginIn:function(){
       	var result = Validation.validation({
          containerId: "login"
        });
        if(result==true){
          var params = { 
            username: $("#username").val(), 
            password: md5($("#password").val()), 
            CheckCode: $("#auto").val() 
          };
          var self= this;
          //提交数据给到后台处理
          CDUtil.ajaxPost("/login",params,function(retVO){
            if(retVO.code == 1){
            	self.userType= retVO.data.userType;
           	 	layer.msg(retVO.msg);
           	 	if($("#auto").prop("checked")){
           	 		localStorage.setItem("SLR_LOGINFLAG","1");
           	 		localStorage.setItem("SLR_LOGINTIME", new Date().getTime());
           	 		localStorage.setItem("SLR_USERNAME", params.username);
           	 		localStorage.setItem("SLR_PASSWORD", params.password);
           	 	}
              layer.close(laryIndex);
              $("#user_info").show();
              $("#login_button").hide();
              sessionStorage.loginFlag = "1";
              sessionStorage.token = retVO.data.token;
              sessionStorage.realname = retVO.data.realname;
              $("#user_realname").html(retVO.data.realname);
               window.location.reload();
            }
             if (retVO.code == 0 && $("#username").val() !='' &&　$("#password").val() !=''){
             	setTimeout(function () {
		        	layer.msg(retVO.msg);
       			}, 1000);	
             }
          });
        }
      },
      logout: function(){
      layerIndex = layer.confirm('是否确定退出用户登录？',{btn: ['确定', '取消']},function(){
			layer.close(layerIndex);
			layer.msg("等待退出登录. . .");
         CDUtil.ajaxPost("/loginout",{},function(retVO){
         	localStorage.removeItem("SLR_LOGINFLAG");
           	 		localStorage.removeItem("SLR_LOGINTIME");
           	 		localStorage.removeItem("SLR_USERNAME");
           	 		localStorage.removeItem("SLR_PASSWORD");
              $("#user_info").hide();
              $("#login_button").show();
              sessionStorage.clear();
              window.location.href = ROOT_SERVER+"/#/index";
       		window.location.reload();
          });
        });
      },
      editPwd: function(){
      	sessionStorage.setItem("nav","basic");
      	window.open(ROOT_SERVER+"/front/path/editpwd?token="+sessionStorage.getItem("token"));
      }
   }
}
</script>