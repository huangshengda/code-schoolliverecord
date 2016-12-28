<template>
 <div class="wamp" id="home">
  <div class="s-title"><span></span><h3 class="fb">直播课程</h3></div>
<!-- 展示直播列表  start -->
  <div id="courseList">
  	<div v-if="posts.data != ''">
     <div class="row" v-for="post in posts.data" >
      <div class="col-md-4 tel c4">{{post.resourceName | unescape}}</div>
      <div class="col-md-4 tel"><span class="sub-code" :title="post.classlevelName | unescape">{{post.classlevelName | cutStr  | unescape}}</span>/{{post.subjectName  | unescape}}/{{post.author  | unescape}}</div>
      <div class="col-md-4" @click="openLiveDetail(post.resourceId)" ><i class="iconfont icon-avpic ft20"></i>进入直播</a></div>
    </div>
  </div>
   <div v-else class="tac"><img src="../../public/_compnents/v1/images/empty.png"></div>
  </div>
<!-- 展示直播列表  end -->
  <div class="s-title demanBtm"><span></span><h3 class="demanCour fb fl">点播课程</h3><div class="movede fr" @click="openMore">更多</div></div>
<!-- 展示点播列表  start -->
  <div class="demand">
    <div class="col-4" v-for="course in courseList.data" @click="openDemondDetail(course.resourceId)" >
      <div class="home-img">
      <img :src="course.thumbPath" width="285" height="160" >
      <div class="home-times"><span class="fr"><i class="iconfont icon-play-times ft20"></i>{{course.viewCnt}}</span></div>        
      </div>
      <p class="c4 tel ft16" :title="course.resourceName  | unescape">{{course.resourceName | unescape}}</p>
      <p class="ft12 c9 tel"><span class="sub-code" :title="course.classlevelName">{{course.classlevelName | cutStr  | unescape}}</span>&nbsp;{{course.subjectName | unescape}}&nbsp;{{course.author | unescape}}</p>
    </div>
  </div>
<!-- 展示点播列表  end -->
</div>
</template>
<script>
/**
 * 弹出框的层信息
**/
var laryIndex = null;
/**
 * Vue组件对象
**/
export default {  
data() {
    return {
        posts:"",
        courseList:"",
    }
  },
  mounted() {
  	$("body").addClass("bgBody");
  },
  beforeDestroy(){
    	$("body").removeClass("bgBody");
    },
 created () {    
      this.show(),
      this.showdemand()
    },
    filters:{
    	cutStr: function(value){
    		if(value.length>7){
    			return value.substr(0,7) + "...";
    		}else{
    			return value;
    		}
    	},
    	unescape:function (html) {
  			  return html
  			  	.replace(/&amp;/g, "&")
      			.replace(/&lt;/g, "<")
      			.replace(/&gt;/g, ">")
  		}
    },
    
methods:{
     isShow: function(){
       return this.data.length 
     },
/** 获取列表的方法 alert($('.sub-code').text());**/
      show:function(){
        var _self = this;
        var params = {};
        CDUtil.ajaxPost("/home/live/list",params,function(retVO){
          _self.posts = retVO;
        },false);
      },
/** 获取点播列表的方法 **/
       showdemand:function(){
        var _self = this;
        var params = {pageSize:8};
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
            _self.courseList = retVO;//JSON.parse(retVO);
        },false)
      },
/** 跳转到直播详情页 **/
      openLiveDetail: function(resourceId){
      	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
      		if(retVO.code == 1){
      			sessionStorage.setItem("resourceId",resourceId);
      			sessionStorage.setItem("nav","demand");
        		//window.open(ROOT_SERVER+"/pages/views/live/live_detail.jsp?token="+sessionStorage.getItem("token"));
        		window.open(ROOT_SERVER+"/front/path/live?token="+sessionStorage.getItem("token"));
      		}else{
      			//alert("用户信息失效");
      			laryIndex = layer.open({
         		 	type: 1,
       			 	title: '登录',
         			skin: 'layui-layer-rim', //加上边框
          			area: ['450px', '360px'], //宽高
          			content: $("#login")
      			});
      		}
      	});
      },
	/** 跳转到点播详情页 **/
      openDemondDetail: function(resourceId){
      	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
      		if(retVO.code == 1){
      			sessionStorage.setItem("resourceId",resourceId);
      			sessionStorage.setItem("nav","demand");
        		window.open(ROOT_UI+"/front/path/demond?token="+sessionStorage.getItem("token"));
      		}else{
      			//alert("用户信息失效");
      			laryIndex = layer.open({
         		 	type: 1,
       			 	title: '登录',
         			skin: 'layui-layer-rim', //加上边框
          			area: ['450px', '360px'], //宽高
          			content: $("#login")
      			});
      		}
      	});
      },
       openMore: function(){
       	window.location.href = ROOT_SERVER+"/#/onDemand";
      // 	window.location.reload();
      }
    },
   }   
</script>
<style>
	.bgBody{background-color: #fff;}
	.s-title .demanCour{margin:0;}
	.ft12{font-size:12px;}
</style>