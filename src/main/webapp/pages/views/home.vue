<template>
 <div class="wamp" id="home">
  <div class="s-title"><span></span><h3>直播课程</h3></div>
  <div id="courseList">
  <div v-if="posts.data != null">
     <div class="row" v-for="post in posts.data">
      <div class="col-md-4 tel">{{post.resourceName}}</div>
      <div class="col-md-4 tel">{{post.classlevelName}}/{{post.subjectName}}/{{post.author}}</div>
      <div class="col-md-4"><a :href="post.resourceId" target="_blank"><i class="iconfont icon-avpic"></i>
      进入直播</a></div>
    </div>
  </div>
   <div v-else class="tac"><img src="../../public/_compnents/v1/images/empty.png"></div>
  </div>
  <div class="s-title"><span></span><h3 class="fl">点播课程</h3><a href="onDemand" target="_blank" class="fr">更多</a></div>
  <div class="demand">
    <div class="col-4" v-for="course in courseList.data">
      <div class="home-img">
      <a href="#a"><img :src="course.thumbPath" width="285" height="160" ></a>
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
        $.ajax({
          type:'POST',
          url:'mockjs_grid_a.json',
          success:function(data){
            _self.posts = JSON.parse(data);
            console.log(_self.posts)
          }
        });
      },
       showdemand:function(){
        var _self = this;
        $.ajax({
          type:'POST',
          url:'mockjs_grid_demand.json',
          success:function(data){
            _self.courseList = JSON.parse(data);
          }
        });
      }
    }

    }   
/*   search_xxx(){
    CDUtil.ajaxPost(url,params,function(retVO){
      
    })
   }*/

</script>
<style>
 body{background-color:#fff;}

</style>