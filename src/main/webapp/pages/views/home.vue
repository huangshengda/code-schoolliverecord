<template>
 <div class="wamp" id="home">
  <div class="s-title"><span></span><h3>直播课程</h3></div>
  <div id="courseList">
  <div v-if="posts.data != null">
     <div class="row" v-for="post in posts.data">
      <div class="col-md-4 tel">{{post.resourceName}}</div>
      <div class="col-md-4 tel">{{post.classlevelName}}/{{post.subjectName}}/{{post.author}}</div>
      <div class="col-md-4" @click="openLiveDetail()" ><i class="iconfont icon-avpic"></i>
      进入直播</a></div>
    </div>
  </div>
   <div v-else class="tac"><img src="../../public/_compnents/v1/images/empty.png"></div>
  </div>
  <div class="s-title"><span></span><h3 class="demanCour fl">点播课程</h3><a href="javascript:;" target="_blank" class="fr" @click="openMore">更多</a></div>
  <div class="demand">
    <div class="col-4" v-for="course in courseList.data" @click="openDemondDetail()" >
      <div class="home-img">
      <img :src="course.thumbPath" width="285" height="160" >
      <div class="home-times"><span class="fr"><i class="iconfont icon-play-times"></i>{{course.viewCnt}}</span></div>        
      </div>
      <p class="c4 tel">{{course.resourceName}}</p>
      <p class="ft12 c9 tel">{{course.classlevelName}}&nbsp;{{course.subjectName}}&nbsp;{{course.author}}</p>
    </div>
  </div>
</div>
</template>
<script>
export default {  
data() {
    return {
        posts:"",
        courseList:""
    }
  },
 mounted () {    
      this.show(),
      this.showdemand()
    },
methods:{
     isShow: function(){
       return this.data.length 
     },
      show:function(){
        var _self = this;
        var params = {};
        CDUtil.ajaxPost("/home/live/list",params,function(retVO){
          console.log(retVO);
          _self.posts = retVO;//JSON.parse(retVO);
        })
      },
       showdemand:function(){
        var _self = this;
         var params = {};
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
            _self.courseList = retVO;//JSON.parse(retVO);
        })
      },
      openLiveDetail: function(){
        window.open(ROOT_UI+'/pages/views/live/live_detail.jsp?token='+sessionStorage.getItem("token"));
      },
      openDemondDetail: function(){
        window.open(ROOT_UI+'/pages/views/demond/demond_detail.jsp?token='+sessionStorage.getItem("token"));
      },
       openMore: function(){
        window.open(ROOT_UI+'#/onDemand');
      }
    }
    }   
</script>
<style>
 body{background-color:#fff;}
.s-title .demanCour{margin:0;}
</style>