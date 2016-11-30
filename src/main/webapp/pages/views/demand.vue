<template>
		<div class="demand">
			<div class="d-search">
				<div><label>年级 :</label><div class="itemList"><span v-for="grade in classList.data">{{grade.classlevelName}}</span></div>
				</div>
				<div><label>学科 :</label><div class="itemList"><span v-for="subject in subjectList.data">{{subject.subjectName}}</span></div>
				</div>
			</div>
			<!-- 中间内容 start-->
			<div class="d-main">
				<div class="search">
					<div class="s-left">
						"语文" 相关课程&nbsp;&nbsp;共26条
						<span>按时间<i class="iconfont icon-low"></i></span>
						<span>按热门<i class="iconfont icon-low"></i></span>
					</div>
					<div class="s-right fr">
						<input type="text" placeholder="输入课程或老师">
						<i class="iconfont icon-search"></i>
					</div>
				</div>
				<div class="clear"></div>
				<!-- 中间内容-列表 start-->
				  <div class="list">
				      <div class="col-4"  v-for="course in courseList.data">
				        <div class="demandImg">
					        <a href="#a"><img src="" width="280" height="157"></a>
					        <div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>{{course.viewCnt}}</span></div> 
					    </div>
				        <p class="c4 tel">{{course.resourceName}}</p>
				        <p class="ft12 c9 tel">{{course.classlevelName}}&nbsp;{{course.subjectName}}&nbsp;{{course.author}}</p>
				      </div>
				   </div>
				   	<div class="clear"></div>
				   <!-- 中间内容-列表 end-->
			</div>
			<!-- 中间内容 end-->
		</div>
</template>
<script>
	export default {  
		data() {
		    return {
		        courseList:"",
		        classList:"",
		        subjectList:""
		    }
		  },
		 mounted () {    
		      this.showdemand(),
		      this.showclass(),
		      this.showsubject()
		    },
    methods:{
       showdemand:function(){
        var _self = this;
        $.ajax({
          type:'POST',
          url:'mockjs_ondemand_list.json',
          success:function(data){
            _self.courseList = JSON.parse(data);
          }
        });
      },
      showclass:function(){
      	var _self = this;
        $.ajax({
          type:'POST',
          url:'mockjs_class_list.json',
          success:function(data){
            _self.classList = JSON.parse(data);
          }
        });
      },
       showsubject:function(){
      	var _self = this;
        $.ajax({
          type:'POST',
          url:'mockjs_subject_list.json',
          success:function(data){
            _self.subjectList = JSON.parse(data);
          }
        });
      },
    }
   }
</script>
