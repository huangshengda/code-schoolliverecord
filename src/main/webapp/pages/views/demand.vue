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
			<div class="s-left">"<span class="sub-tit">全部</span>"相关课程&nbsp;&nbsp;共<span class="totalnums"></span>条
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
		<div class="list mt30" id="de_list">
			
			<div class="clear"></div>
<!-- 中间内容-列表 end-->
		</div>
<!-- 中间内容 end-->
</div>
</template>
<script>


function search_ten(newPage){
       var _self= this;
		var params = this.params;
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
       	  _self.params.curPage=retVO.curPage;
          _self.courseList = retVO;
          var config = {   
           //用来展示表格控件的div的id
			containerId: "de_list",     	
         	 //这个应该是后台返回的部分
        	 gData: retVO,
         	 //是否需要分页，true：需要，不写默认需要
         	 pagingFlag: true,
         	  //用来拼接单个循环体的回调方法。
			spellHtmlFun: function(data){
				var htmlStr = '<div class="col-4">';
				htmlStr += '<div class="demandImg">';
				htmlStr += '<a href="#a"><img src='+data.thumbPath+' width="280" height="157"></a>';       
				htmlStr += '<div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>'+data.viewCnt+'</span></div> ';  
				htmlStr += '</div>' ;
				htmlStr += '<p class="c4 tel">'+data.resourceName+'</p>' ;
				htmlStr += '<p class="ft12 c9 tel"><span class="sub-code" title='+data.classlevelName+'>'+data.classlevelName+'</span>&nbsp;'+data.subjectName+'&nbsp;'+data.author+'</p>' ;    
				htmlStr += ' </div>';	
				/*  无消息显示 */
				if(data.resourceId == ""){
					htmlStr +='<div id="de_list"><p>暂无相关数据</p></div>';
				}
				return htmlStr;
			},
         	 //执行页面查询的方法
			searchFun: _self.showdemand,
         	};
         	Paging.initPaging(config,function(){});
        });
}


var data={newPage:1}
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
					curPage: data.newPage,
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
     showdemand: search_ten,
     //function(newPage){},
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