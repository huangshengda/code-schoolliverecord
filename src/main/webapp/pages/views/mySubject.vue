<template>
<div class="mysubject">
<div class="subBtn"><button class="btn fr">上传资源</button></div>
		<div class="demand">
			<!-- 中间内容 start-->
			<div class="d-main">
				<div class="search">
					共{{mycourceList.totalDatas}}个资源
				</div>
				<div class="clear"></div>
				<!-- 中间内容-列表 start-->
				  <div class="list mt40">
				      <div class="col-4"  v-for="course in mycourceList.data">
				        <div class="demandImg">
					        <a href="#a"><img :src="course.thumbPath" width="280" height="157"></a>
					        <div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>{{course.viewCnt}}</span></div> 
					    </div>
				        <p class="c4 tel">{{course.resourceName}}</p>
				        <p class="ft12 c9 tel"><span class="sub-code" :title="course.classlevelName">{{course.classlevelName}}</span>&nbsp;{{course.subjectName}}&nbsp;{{course.author}}</p>
				      <div class="sub-del" @click="mysubjectDel(course.resourceId)"><i class="iconfont icon-delete"></i></div>
				      </div>
				   </div>
				   <div class="clear"></div>
				   <!-- 中间内容-列表 end-->
			</div>
			<!-- 中间内容 end-->
		</div>
		</div>
</template>
<script>
	export default {  
		data() {
		    return {
		        mycourceList:"",
		    }
		  },
		 created () {    
		      this.showdemand()
		    },
    methods:{
     showdemand:function(newPage){
     	if(newPage == undefined){
			newPage = 1;
		}
        var _self = this;
        var params = {curPage: newPage,
		pageSize: 2,};
        CDUtil.ajaxPost("/resource/myresource/list",params,function(retVO){
          _self.mycourceList = retVO;
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
      mysubjectDel:function(resourceId) {
      	 var _self = this;
		layer.alert('删除后则该资源在点播列表同步删除?',
		function(index) {
			var reidParams = {
			resourceId: resourceId
		};
		CDUtil.ajaxPost("/resource/delete", reidParams,
		function(retVO) {
			if (retVO.code == 1) {
				_self.showdemand();
			}
		});
		layer.close(index);
		layer.msg('删除成功!');
	});
	}
     }
   }  
</script>
<style>
.mysubject .search{line-height:37px;}
.mysubject .subBtn{height: 70px;padding-top: 30px;}
</style>