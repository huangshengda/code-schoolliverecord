<template>
  <nav class="navbar navbar-default" role="navigation">
    <div class="wamp">
    <img src="../../../public/_module/images/logo.png" class="inb">
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
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value">
            <input type="text" id="username" name="username" data-vali="notnull,username" value="admin">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="password" id="password" name="password" data-vali="notnull,password" value="123456">
          </span>
        </div>
        <div class="cd-f-eve">
           <input type="checkbox" id="auto" name="auto" class="ml30">自动登录
        </div>
        <div class="cd-f-eve">
          <button type="button" class="lay-btn gray-btn" @click="loginIn">登录</button>
        </div>
    </div>
  </form>
<!-- 编辑用户弹窗表单 end -->
</nav>
</template>
<script>
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
      	CDUtil.ajaxPost("/menu",{},function(retVO){
      		_self.menus = retVO;
      	});
    },
    login:function(){
      laryIndex = layer.open({
          type: 1,
          title: '登录',
          skin: 'layui-layer-rim', //加上边框
          area: ['450px', '375px'], //宽高
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
          console.log(params);
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
            }
          });
        }
      },
      logout: function(){
         CDUtil.ajaxPost("/loginout",{},function(retVO){
              $("#user_info").hide();
              $("#login_button").show();
              sessionStorage.clear();
          });
      },
      editPwd: function(){
      	window.open(ROOT_SERVER+"/front/path/editpwd?token="+sessionStorage.getItem("token"));
      }
   }
}
</script>
<style>.login_button{margin-top:30px;}</style>