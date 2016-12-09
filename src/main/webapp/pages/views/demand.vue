<template>
		<div class="demand">
			<div class="d-search">
				<div><label>年级 :</label><div class="itemList"><span v-for="grade in classList.data" @click="gradesearch(grade.classlevelName)">{{grade.classlevelName}}</span></div>
				</div>
				<div><label>学科 :</label><div class="itemList"><span v-for="subject in subjectList.data" @click="subjectsearch(subject.subjectName)">{{subject.subjectName}}</span></div>
				</div>
			</div>
			<!-- 中间内容 start-->
			<div class="d-main">
				<div class="search">
					<div class="s-left">
						"语文" 相关课程&nbsp;&nbsp;共26条
						<span data-sort="desc" @click="sortByTime">按时间<i class="iconfont icon-low"></i></span>
						<span data-sort="desc" @click="sortByHot">按热门<i class="iconfont icon-low"></i></span>
					</div>
					<div class="s-right fr">
						<input type="text" placeholder="输入课程或老师" name="resourceNameKey" id="s-resource">
						<i class="iconfont icon-search" @click="searchKey"></i>
					</div>
				</div>
				<div class="clear"></div>
				<!-- 中间内容-列表 start-->
				  <div class="list">
				      <div class="col-4"  v-for="course in courseList.data">
				        <div class="demandImg">
					        <a href="#a"><img :src="course.thumbPath" width="280" height="157"></a>
					        <div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>{{course.viewCnt}}</span></div> 
					    </div>
				        <p class="c4 tel">{{course.resourceName}}</p>
				        <p class="ft12 c9 tel"><span class="sub-code" :title="course.classlevelName">{{course.classlevelName}}</span>&nbsp;{{course.subjectName}}&nbsp;{{course.author}}</p>
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
		        subjectList:"",
		        params:{
		        	orderType:"desc"
		        }
		    }
		  },
		 mounted () {    
		      this.showdemand(),
		      this.showclass(),
		      this.showsubject()
		    },
    methods:{
    	gradesearch: function(classlevelName){
			this.params= Object.assign({},this.params,{classlevelName:classlevelName});
			this.showdemand();
     	},
     	subjectsearch: function(subjectName){
     		this.params= Object.assign({},this.params,{subjectName:subjectName});
     	 	this.showdemand();
     	},
     	sortByTime: function(e){
     		$(e.target).addClass("active").siblings().removeClass("active");
     		e.stopPropagation();
     		var $sortType=$(e.target).attr("data-sort");
     		if($sortType==="desc"){
     			$(e.target).attr("data-sort","asc");
     			this.params.orderType="asc";
     		}else{
     			$(e.target).attr("data-sort","asc");
     			this.params.orderType="desc";
     		}
     		this.params= Object.assign({}, this.params,{orderBy:"createTime"});
     		this.showdemand();
     	},
     	sortByHot: function(e){
     		e.stopPropagation();
     		$(e.target).addClass("active").siblings().removeClass("active");
     		var $sortType=$(e.target).attr("data-sort");
     		if($sortType==="desc"){
     			$(e.target).attr("data-sort","asc");
     			this.params.orderType="asc";
     		}else{
     			$(e.target).attr("data-sort","asc");
     			this.params.orderType="desc";
     		}
     		this.params= Object.assign({}, this.params,{orderBy:"viewCnt"});
     		this.showdemand();
     	},
     	searchKey:function(){
     		var sourceName = $('#s-resource').val();
     		this.params= Object.assign({}, this.params,{resourceNameKey:sourceName});
     		this.showdemand();
     	},
       showdemand:function(){
        var _self = this;
        var params = this.params;
        console.log(params);
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
