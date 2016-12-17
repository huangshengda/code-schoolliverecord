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
        <button class="btn fr" id="login_button" @click="login">登录</button>
      </div>
<!-- 编辑用户弹窗表单 start -->
  <form action="" id="login" class="layBox mt40">
   <div class="cd-f-row">
        <div class="cd-f-eve login-use-name">
          <span class="cd-f-name input-left-img iconfont icon-login-name"></span>
          <span class="cd-f-value">
            <input type="text" id="username" name="username" data-vali="notnull,username" placeholder="用户名" class="login-input" maxlength="30">
          </span>
        </div>
        <div class="cd-f-eve login-password">
          <span class="cd-f-name input-left-img iconfont icon-password"></span>
          <span class="cd-f-value">
            <input type="password" id="password" name="password" data-vali="notnull,password" placeholder="密码" class="login-input">
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
      		if(retVO.code == 2){
      			$("#user_info").hide();
        		$("#login_button").show();
        		sessionStorage.clear();
      		}else{
      			$("#user_info").show();
				$("#login_button").hide();
				$("#user_realname").html(sessionStorage.getItem("realname"));
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
       var result = true;
       /*result = Validation.validation({
          containerId: "login"
        });*/
        if(result==true){
          var params = { 
            username: $("#username").val(), 
            password: md5($("#password").val()), 
            CheckCode: $("#auto").val() 
          };
          var self= this;
          //提交数据给到后台处理
          CDUtil.ajaxPost("/login",params,function(retVO){
          	self.userType= retVO.data.userType;
            if(retVO.code == 1){
              layer.close(laryIndex);
              $("#user_info").show();
              $("#login_button").hide();
              sessionStorage.loginFlag = "1";
              sessionStorage.token = retVO.data.token;
              sessionStorage.realname = retVO.data.realname;
              $("#user_realname").html(retVO.data.realname);
               window.location.reload();
            }
          });
        }
      },
      logout: function(){
      layerIndex = layer.confirm('是否确定退出用户登录？',{btn: ['确定', '取消']},function(){
			layer.close(layerIndex);
			layer.msg("等待退出登录. . .");
         CDUtil.ajaxPost("/loginout",{},function(retVO){
              $("#user_info").hide();
              $("#login_button").show();
              sessionStorage.clear();
              window.location.href = ROOT_SERVER+"/#/onDemand";
       		window.location.reload();
          });
        });
      },
      editPwd: function(){
      	window.open(ROOT_SERVER+"/front/path/editpwd?token="+sessionStorage.getItem("token"));
      }
   }
}
</script>
<style>
.login_button{margin-top:30px;}
#login .login-btn{text-align:center;margin-top:30px;}
#login .login-use-name:hover,#login .login-use-name.focus,#login .login-password:hover,#login .login-password.focus
{border: 2px solid #1bc840;}
.login-use-name, .login-password {
    clear: both;
    margin: 5px auto 10px;
    height: 48px;
    width: 284px;
    border: 2px solid #dcddde;
    border-radius: 3px;
}
.login-input {
    height: 44px;
    text-indent: 10px;
    outline: none;
    border: none;
    background: #fff;
    width: 232px;
    float: left;
}
.input-left-img {
    width: 46px;
    height: 100%;
    line-height: 48px;
    font-size: 24px;
    color: #fff;
    text-align: center;
    vertical-align: middle;
    display: inline-block;
    background: #dcddde;
    float: left;
}
.login-use-name.focus .input-left-img, .login-password.focus .input-left-img {
    background: #1bc840;
}
.l-way-auto{
    cursor: pointer;
}
.l-way-check {
    width: 18px;
    height: 18px;
    border: 2px solid #d0d0d0;
    position: relative;
    overflow: hidden;
    float: left;
    margin-right: 5px;
}
.l-way-check input {
    position: absolute;
    top: 30px;
}
.gray-btn{
    border-color: transparent;
    color: #fff;
    background-color: #1BC840;
}
.gray-btn:HOVER {
    background-color: #34A150;
}
#login .cd-f-row{width: 285px;margin: 0 auto;}
#login .cd-f-value{margin-left:0;}
.lw-checked {
    background: url(../../../public/_module/images/select.png) center center no-repeat;
}
#login .login-use-name{margin-bottom: 30px;margin-top: 10px;}
</style>