<template>
	<div class="mysubject">
		<div class="subBtn"><button class="btn fr" @click="openUploadup">上传资源</button></div>
		<div class="demand">
			<!-- 中间内容 start-->
			<div class="d-main">
				<div class="search">
					共<span class="totalnums"></span>个资源
				</div>
				<div class="clear"></div>
				<!-- 中间内容-列表 start-->
				  <div class="list mt40"  id="sub_list">
				     
				   </div>
				   <div class="clear"></div>
				   <!-- 中间内容-列表 end-->
			</div>
			<!-- 中间内容 end-->
		</div>
	</div>
</template>
<script>
window.mysubjectDel=function(resourceId){
   layer.alert('删除后则该资源在点播列表同步删除?',function(index) {
		var reidParams = {resourceId: resourceId};
		CDUtil.ajaxPost("/resource/delete", reidParams,function(retVO) {
			if (retVO.code == 1) {
				mySub();
			}
		});
		layer.close(index);
		layer.msg('删除成功!');
	});
};
var mySub = function(newPage){
		if(newPage == "undefined"){
     		newPage=1;
     	}
        var _self = this;
		var params = {curPage: newPage ,pageSize: 2,};
        CDUtil.ajaxPost("/resource/myresource/list",params,function(retVO){
          _self.mycourceList = retVO;
          var htmlStr = "";
          var config = { 
          //用来展示表格控件的div的id
			containerId: "sub_list",    	
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
				htmlStr += '<div class="sub-del" onClick="mysubjectDel(\''+data.resourceId+'\')"><i class="iconfont icon-delete"></i></div>' ;       
				htmlStr += ' </div>';	
				/*  无消息显示 */
				if(data.resourceId == ""){
					htmlStr +='<div id="sub_list"><p>暂无相关数据</p></div>';
				}
				return htmlStr;
			},
         	 //执行页面查询的方法
			searchFun: _self.showdemand, 
         	};
         	Paging.initPaging(config,function(){});
        });
      };
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
     showdemand: mySub,
	/*跳转到上传资源页面*/
    	openUploadup: function(){
    		window.open(ROOT_UI+"/front/path/upload?token="+sessionStorage.getItem("token"));
    	}
     }
   }  
</script>
<style>
.mysubject .search{line-height:37px;}
.mysubject .subBtn{height: 70px;padding-top: 30px;}
</style>