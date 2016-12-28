<template>
	<div class="mysubject">
		<div class="subBtn"><button class="btn fr" @click="openUploadup">上传资源</button></div>
		<div class="demand">
			<!-- 中间内容 start-->
			<div class="d-main">
				<div class="search">
					共{{pages}}个资源
				</div>
				<div class="clear"></div>
				<div class="man-list">
					<p class="data-none"><img src="'+ROOT_UI_PUBLIC+'../../public/_compnents/v1/images/grid_have_nodata.png" /></p>
				<!-- 中间内容-列表 start-->
				  <div class="list mt40"  id="sub_list">
				     
				   </div>
				   <div class="clear"></div>
				   <!-- 中间内容-列表 end-->
				 </div>
			</div>
			<!-- 中间内容 end-->
		</div>
	</div>
</template>
<script>
var data={mycourceList:"", pages:""};
/****点击进入点播详情页****/
window.openDemondDetail=function(resourceId){
	CDUtil.ajaxPost("/token/hasexpire",{},function(retVO){
      		if(retVO.code == 1){
      			sessionStorage.setItem("resourceId",resourceId);
        		window.open(ROOT_UI+"/front/path/demond?token="+sessionStorage.getItem("token"));
      		}else{
      			//alert("用户信息失效");
      			layerIndex = layer.confirm('未登录暂无权限访问', {
					btn: ['确定']
				},function() {
					layer.close(layerIndex);
					sessionStorage.clear();
      				window.location.href = ROOT_SERVER+"/#/index";
				});
      		}
    });
};
window.mySub = function(newPage){
		if(newPage == "undefined"){
     		newPage=1;
     	}
        var _self = this;
		var params = {curPage: newPage ,pageSize:16,};
        CDUtil.ajaxPost("/resource/myresource/list",params,function(retVO){
        	/*  无消息显示 */
       			if(retVO.totalDatas == 0){
					$('.data-none').show();
				}else{
					$('.data-none').hide();
				}
          data.mycourceList = retVO;
          data.pages = retVO.totalDatas;
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
				if(data.classlevelName.length>7){
    				var classLevelName= data.classlevelName.substr(0,7) + "...";
    			}else{
    				var classLevelName= data.classlevelName;
    			}
				var htmlStr = '<div class="col-4">';
				htmlStr += '<div class="demandImg" onClick="openDemondDetail(\''+data.resourceId+'\')">';
				htmlStr += '<img src='+data.thumbPath+' width="280" height="157">';       
				htmlStr += '<div class="times"><span class="fr"><i class="iconfont icon-play-times ft20"></i>'+data.viewCnt+'</span></div> ';  
				htmlStr += '</div>' ;
				htmlStr += '<p class="c4 tel ft16" title='+data.resourceName+'>'+data.resourceName+'</p>' ;
				htmlStr += '<p class="ft12 c9 tel"><span class="sub-code" title='+data.classlevelName+'>'+classLevelName+'</span>&nbsp;'+data.subjectName+'&nbsp;'+data.author+'</p>' ;
				htmlStr += '<div class="sub-del" onClick="mysubjectDel(\''+data.resourceId+'\')"><i class="iconfont icon-delete"></i></div>' ;       
				htmlStr += ' </div>';	
				return htmlStr;
			},
         	 //执行页面查询的方法
			searchFun: mySub, 
         	};
         	Paging.initPaging(config,function(){});
        });
      };
 window.mysubjectDel=function(resourceId){
   layer.alert('删除后则该资源在点播列表同步删除?',function(index) {
		var reidParams = {resourceId: resourceId};
		CDUtil.ajaxPost("/resource/delete", reidParams,function(retVO) {
			if (retVO.code == 1) {
				mySub();
				layer.msg(retVO.msg);
				layer.close(index);
			}
		});
	});
};
export default {  
		data() {
		    return data
		  },
		 created () {    
		      this.showdemand()
		    },
    methods:{
     showdemand: mySub,
	/*跳转到上传资源页面*/
    	openUploadup: function(){
    		sessionStorage.setItem("mysub","subject");
    		sessionStorage.removeItem("resourceId");
    		sessionStorage.setItem("nav","basic");
    		window.open(ROOT_UI+"/front/path/upload?token="+sessionStorage.getItem("token"));
    	}
     }
   }  
</script>
<style>
.mysubject .search{line-height:37px;}
.mysubject .subBtn{height: 70px;padding-top: 30px;}
</style>