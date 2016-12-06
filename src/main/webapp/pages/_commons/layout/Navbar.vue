<template>
  <nav class="navbar navbar-default" role="navigation">
    <div class="wamp">
    <img src="../../../public/_module/images/logo.png" class="inb">
      <div class="head inb">
          <div class="navHead">
            <span v-for="item in menu">
               <router-link :to="item.path">
                {{item.meta.showName}}
               </router-link>
            </span>
          </div>
          <!-- <div class="line"></div> -->
        </div>
        <div class="head-out fr"><!-- 某某某<span class="g-line">|</span><i class="iconfont icon-sign-out"></i> --><button class="btn fr" @click="login">登录</button></div>
      </div>
        <!-- 编辑用户弹窗表单 start -->
  <form action="" id="login" class="layBox mt40">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value">
            <input type="text" id="username" name="username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" id="password" name="password" data-vali="notnull,password">
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
import menu from "menu"
export default{
  data () { 
      return{
        menu: menu,
        item: [],
      }
  },
   methods:{
    login:function(){
      layer.open({
          type: 1,
          title: '登录',
          skin: 'layui-layer-rim', //加上边框
          area: ['450px', '375px'], //宽高
          content: $("#login")
      });
    },
    loginIn:function(){
       var result = Validation.validation({
          containerId: "login"
        });
        if(result==true){
          var params = { 
            userName: $("#username").val(), 
            userPwd: $("#password").val(), 
            CheckCode: $("#auto").val() 
          };
          //提交数据给Login.ashx页面处理
          CDUtil.ajaxPost("",params,function(ret){
            
          },isCrossDomain);
        }
      
    },
   }
}
</script>