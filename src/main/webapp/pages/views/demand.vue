<template>
<div class="demand">
<!-- 查询条件 start-->
	<div class="d-search">
		<div><label>年级 :</label><div class="itemList"><span @click="gradesearch('',$event)" class="active">全部</span><span v-for="grade in classList.data" @click="gradesearch(grade.classlevelName,$event)">{{grade.classlevelName}}</span></div>
		</div>
		<div><label>学科 :</label><div class="itemList"><span @click="subjectsearch('',$event)" class="active">全部</span><span v-for="subject in subjectList.data" @click="subjectsearch(subject.subjectName,$event)">{{subject.subjectName}}</span></div>
		</div>
	</div>
<!-- 查询条件 end-->
<!-- 中间内容 start-->
	<div class="d-main">
		<div class="search">
			<!-- 中间内容 --左侧-->
			<div class="s-left">相关课程&nbsp;&nbsp;共{{pages}}条
				<span data-sort="desc" @click="sortByTime" class="active">按时间<i class="iconfont icon-low ft12"></i></span>
				<span data-sort="desc" @click="sortByHot">按热门<i class="iconfont icon-low ft12"></i></span>
			</div>
			<!-- 中间内容 --右侧-->
			<div class="s-right fr">
				<input type="text" placeholder="输入课程或老师" name="resourceNameKey" id="s_resource" @keyup.enter="searchKey">
				<i class="iconfont icon-search" @click="searchKey"></i>
			</div>
		</div>
		<div class="clear"></div>
<!-- 中间内容-列表 start-->
		<div class="list mt30">
			<p class="data-none"><img src="'+ROOT_UI_PUBLIC+'../../public/_compnents/v1/images/grid_have_nodata.png" /></p>
			<div id="de_list"></div>
			<div class="clear"></div>
<!-- 中间内容-列表 end-->
		</div>
<!-- 中间内容 end-->
</div>
</template>
<script>
/****点击进入点播详情页****/
window.openDemondDetail=function(resourceId){
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
};
/**
 * Vue组件对象
**/
	export default {  
		data() {
		    return {
		        courseList:"",
		        classList:"",
		        subjectList:"",
		        pages:"",
		        params:{
		        	orderType:"desc",
					pageSize: 16,
					
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
     	if(newPage == "undefined"){
     		newPage=1;
     	}
       var _self= this;
       _self.params.curPage=newPage;
		var params = this.params;
        CDUtil.ajaxPost("/demand/list",params,function(retVO){
        	/*  无消息显示 */
				if(retVO.totalDatas == 0){
					$('.data-none').show();
				}else{
					$('.data-none').hide();
				}
          _self.courseList = retVO;
          _self.pages = retVO.totalDatas;
          var config = {   
           //用来展示表格控件的div的id
			containerId: "de_list",     	
         	 //这个应该是后台返回的部分
        	 gData: retVO,
         	 //是否需要分页，true：需要，不写默认需要
         	 pagingFlag: true,
         	  //用来拼接单个循环体的回调方法。
			spellHtmlFun: function(data){
				if(data.classlevelName.length>7){
    				var classLevelName= data.classlevelName.substr(0,7) + "...";
    			}else{
    				var classLevelName= data.classlevelName;
    			}
				var htmlStr = '<div class="col-4" onClick="openDemondDetail(\''+data.resourceId+'\')">';
				htmlStr += '<div class="demandImg">';
				htmlStr += '<img src='+data.thumbPath+' width="280" height="157">';       
				htmlStr += '<div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>'+data.viewCnt+'</span></div> ';  
				htmlStr += '</div>' ;
				htmlStr += '<p class="c4 tel ft16" title='+data.resourceName+'>'+data.resourceName+'</p>' ;
				htmlStr += '<p class="demn-tit c9 tel"><span class="sub-code" title='+data.classlevelName+'>'+classLevelName+'</span>&nbsp;'+data.subjectName+'&nbsp;'+data.author+'</p>' ;    
				htmlStr += ' </div>';	
				return htmlStr;
			},
         	 //执行页面查询的方法
			searchFun: _self.showdemand,
         	};
         	Paging.initPaging(config,function(){});
        });
      },
/** 获取选择的年级参数**/
    	gradesearch: function(classlevelName,event){
    		$(event.target).addClass("active").siblings().removeClass("active");
			//this.params= Object.assign({},this.params,{classlevelName:classlevelName});
			this.$set(this.params,'classlevelName',classlevelName);
			this.showdemand();
     	},
/** 获取选择的学科参数**/
     	subjectsearch: function(subjectName,event){
     		$(event.target).addClass("active").siblings().removeClass("active");
     		//this.params= Object.assign({},this.params,{subjectName:subjectName});
     		this.$set(this.params,'subjectName',subjectName);
     	 	this.showdemand();
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
     			$(e.target).attr("data-sort","desc");
     			this.params.orderType="desc";
     		}
     		//this.params= Object.assign({}, this.params,{orderBy:"createTime"});
     		this.$set(this.params,'orderBy',"createTime");
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
     			$(e.target).attr("data-sort","desc");
     			this.params.orderType="desc";
     		}
     		//this.params= Object.assign({}, this.params,{orderBy:"viewCnt"});
     		this.$set(this.params,'orderBy',"viewCnt");
     		this.showdemand();
     	},
/** 根据关键字排序**/
     	searchKey:function(){
     		var sourceName = $('#s_resource').val();
     		//this.params= Object.assign({}, this.params,{resourceNameKey:sourceName});
     		this.$set(this.params,'resourceNameKey',sourceName);
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