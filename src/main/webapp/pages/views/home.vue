<template>
 <div class="wamp" id="home">
  <div class="s-title"><span></span><h3 class="fb">直播课程</h3></div>
<!-- 展示直播列表  start -->
  <div id="courseList">
  	<div v-if="posts.data != ''">
     <div class="row" v-for="post in posts.data" >
      <div class="col-md-4 tel c4">{{post.resourceName}}</div>
      <div class="col-md-4 tel"><span class="sub-code" :title="post.classlevelName">{{post.classlevelName | cutStr}}</span>/{{post.subjectName}}/{{post.author}}</div>
      <div class="col-md-4" @click="openLiveDetail(post.resourceId)" ><i class="iconfont icon-avpic"></i>进入直播</a></div>
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
      <div class="home-times"><span class="fr"><i class="iconfont icon-play-times"></i>{{course.viewCnt}}</span></div>        
      </div>
      <p class="c4 tel" :title="course.resourceName">{{course.resourceName}}</p>
      <p class="ft12 c9 tel"><span class="sub-code" :title="course.classlevelName">{{course.classlevelName | cutStr}}</span>&nbsp;{{course.subjectName}}&nbsp;{{course.author}}</p>
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
        var params = {};
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
            _self.courseList = retVO;//JSON.parse(retVO);
        },false)
      },
/** 跳转到直播详情页 **/
      openLiveDetail: function(resourceId){
      	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
      		if(retVO.code == 1){
      			sessionStorage.setItem("resourceId",resourceId);
        		//window.open(ROOT_SERVER+"/pages/views/live/live_detail.jsp?token="+sessionStorage.getItem("token"));
        		window.open(ROOT_SERVER+"/front/path/live?token="+sessionStorage.getItem("token"));
      		}else{
      			//alert("用户信息失效");
      			laryIndex = layer.confirm('未登录暂无权限访问', {
					btn: ['确定']
				},function() {
					layer.close(laryIndex);
					sessionStorage.clear();
      				window.location.href = ROOT_SERVER+"/#/index";
      				window.location.reload();
				});
      		}
      	});
      },
	/** 跳转到点播详情页 **/
      openDemondDetail: function(resourceId){
      	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
      		if(retVO.code == 1){
      			sessionStorage.setItem("resourceId",resourceId);
        		window.open(ROOT_UI+"/front/path/demond?token="+sessionStorage.getItem("token"));
      		}else{
      			//alert("用户信息失效");
      			layerIndex = layer.confirm('未登录暂无权限访问', {
					btn: ['确定']
				},function() {
					layer.close(layerIndex);
					sessionStorage.clear();
      				window.location.href = ROOT_SERVER+"/#/index";
      				window.location.reload();
				});
      		}
      	});
      },
       openMore: function(){
       	window.location.href = ROOT_SERVER+"/#/onDemand";
       	window.location.reload();
      }
    },
   }   
</script>
<style>
.s-title .demanCour{margin:0;}
</style>