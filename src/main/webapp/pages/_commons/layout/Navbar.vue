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
        <div class="out fr"><!-- 某某某<span class="g-line">|</span><i class="iconfont icon-sign-out"></i> --><button class="fr" @click="login">登录</button></div>
      </div>
        <!-- 编辑用户弹窗表单 start -->
  <form action="" id="login" class="layBox mt40">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull,password">
          </span>
        </div>
        <div class="cd-f-eve">
           <input type="checkbox" name="auto" class="ml30">自动登录
        </div>
        <div class="cd-f-eve">
          <button class="lay-btn gray-btn" @click="loginIn">登录</button>
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
      
    },
   }
}
</script>

<style scoped>
.router-link-active{border-bottom:2px solid #fff;}
.navbar{
  border-radius: 0;
  margin-bottom: 0;
  background-color:#1bc840;
  height:90px;}
  .navbar span{
    margin-right: 40px;
    display: inline-block;
  }
  .navHead{
    margin-top: 30px;}
  .navHead a {font-size:20px;color:#fff;}

 .head{margin-left:120px;}
 .g-line{color: #14a733;font-size: 15px;margin-left:35px;margin-right:30px;}
 .out{margin-top: 30px;color: #fff;}
 .out i{vertical-align:middle;font-size: 20px;}

#login{display: none;}
.cd-f-eve{margin-bottom: 20px;width:100%;margin-top:0;}
.cd-f-value{margin-right: 0;}
.cd-f-value,.cd-f-value input{width:230px;}
.cd-f-name{margin-right:0;}
input[type=checkbox]{    width: 15px;
    height: 15px;
    vertical-align: top;}
  button{width:100%;}
.ml30{margin-left:30px;}
 #login .cd-f-value,#login .cd-f-name{margin-right:0;}
</style>