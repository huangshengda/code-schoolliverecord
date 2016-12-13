<template>
<div class="demand">
<!-- 查询条件 start-->
	<div class="d-search">
		<div><label>年级 :</label><div class="itemList"><span v-for="grade in classList.data" @click="gradesearch(grade.classlevelName,$event)">{{grade.classlevelName}}</span></div>
		</div>
		<div><label>学科 :</label><div class="itemList"><span v-for="subject in subjectList.data" @click="subjectsearch(subject.subjectName,$event)">{{subject.subjectName}}</span></div>
		</div>
	</div>
<!-- 查询条件 end-->
<!-- 中间内容 start-->
	<div class="d-main">
		<div class="search">
			<!-- 中间内容 --左侧-->
			<div class="s-left">"<span class="sub-tit">全部</span>"相关课程&nbsp;&nbsp;共{{courseList.totalDatas}}条
				<span data-sort="desc" @click="sortByTime">按时间<i class="iconfont icon-low"></i></span>
				<span data-sort="desc" @click="sortByHot">按热门<i class="iconfont icon-low"></i></span>
			</div>
			<!-- 中间内容 --右侧-->
			<div class="s-right fr">
				<input type="text" placeholder="输入课程或老师" name="resourceNameKey" id="s-resource">
				<i class="iconfont icon-search" @click="searchKey"></i>
			</div>
		</div>
		<div class="clear"></div>
<!-- 中间内容-列表 start-->
		<div class="list mt30">
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
/**
 * Vue组件对象
**/
	export default {  
		data() {
		    return {
		        courseList:"",
		        classList:"",
		        subjectList:"",
		        params:{
		        	orderType:"desc",
					pageSize: 2,
		        }
		    }
		  },
		 created () {  
		      this.showdemand(),
		      this.showclass(),
		      this.showsubject()
		    },
    methods:{
/** 查询点播列表 **/
     showdemand:function(newPage){
       var _self= this;
        if(newPage == undefined){
			newPage = 1;
		}
		this.params.curPage=newPage;
		console.log(this.params.curPage);
		var params = this.params;
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
          _self.courseList = retVO;
          var config = {      	
         	 //这个应该是后台返回的部分
        	 gData: retVO,
         	 //是否需要分页，true：需要，不写默认需要
         	 pagingFlag: true,
         	 //执行页面查询的方法
			searchFun: _self.showdemand,
         	};
         	Grid.initGrid(config,function(){});
        });
      },
/** 获取选择的年级参数**/
    	gradesearch: function(classlevelName,event){
    		$(event.target).addClass("active").siblings().removeClass("active");
			this.params= Object.assign({},this.params,{classlevelName:classlevelName});
			this.showdemand();
     	},
/** 获取选择的学科参数**/
     	subjectsearch: function(subjectName,event){
     		$(event.target).addClass("active").siblings().removeClass("active");
     		this.params= Object.assign({},this.params,{subjectName:subjectName});
     	 	this.showdemand();
     	 	$('.sub-tit').text(subjectName);
     	},
/** 根据时间排序**/
     	sortByTime: function(e){
     		$(e.target).toggleClass("arrow");
     		if($(e.target).hasClass("arrow")){
     			$(e.target).find("i").removeClass("icon-low").addClass("icon-up");
     		}else{
     			$(e.target).find("i").removeClass("icon-up").addClass("icon-low");
     		}
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
/** 根据热度排序**/
     	sortByHot: function(e){
     		e.stopPropagation();
     		$(e.target).toggleClass("arrow");
     		if($(e.target).hasClass("arrow")){
     			$(e.target).find("i").removeClass("icon-low").addClass("icon-up");
     		}else{
     			$(e.target).find("i").removeClass("icon-up").addClass("icon-low");
     		}
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
/** 根据关键字排序**/
     	searchKey:function(){
     		var sourceName = $('#s-resource').val();
     		this.params= Object.assign({}, this.params,{resourceNameKey:sourceName});
     		this.showdemand();
     	},
/** 获取年级列表 **/
      showclass:function(){
      	var _self = this;
      	var params = {};
        CDUtil.ajaxPost("/base/classlevel/list",params,function(retVO){
         	_self.classList = retVO;
        });
      },
/** 获取学科列表 **/
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