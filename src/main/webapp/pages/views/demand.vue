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
        var params = {};
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
        _self.courseList = retVO;
          var config = {      	
         	 //这个应该是后台返回的部分
        	  gData: retVO,
         	 //是否需要分页，true：需要，不写默认需要
         	 pagingFlag: true,
         	 
         	};
         	Grid.initGrid(config,function(){});
        });
      },
      showclass:function(){
      	var _self = this;
      	var params = {};
        CDUtil.ajaxPost("/base/classlevel/list",params,function(retVO){
         	_self.classList = retVO;
        });
      },
       showsubject:function(){
      	var _self = this;
      	var params = {};
        CDUtil.ajaxPost("/base/subject/list",params,function(retVO){
         	_self.subjectList = retVO;
        });
      },
    }
   }
</script>
