<template>
<div class="content">
  <div class="subBtn"></div>
  <div class="dashboard">
  <!-- 条件 start-->
    <form action="" id="condition">
       <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>资源名称:</label></span>
          <span class="cd-f-value ">
            <input type="text" data-vali="notnull" name="resourceName" id="search_resourceName" maxlength="30">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>主讲教师:</label></span>
          <span class="cd-f-value ">
            <input type="text" data-vali="notnull" name="author" id="search_author">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>年级:</label></span>
          <span class="cd-f-value ">
            <select data-vali="notnull" name="classlevelName" id="search_classlevelName"><option value="">请选择年级</option><option v-for="grade in classList.data">{{grade.classlevelName}}</option></select>
          </span>
        </div>   
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value ">
            <select data-vali="notnull" name="subjectName" id="search_subjectName"><option value="">全部</option><option v-for="subject in subjectList.data">{{subject.subjectName}}</option></select>
          </span>
        </div>   
        <button class="sBtn" type="button" @click="sourSearch(1)">查询</button>
      </div>
    </form>
    <!-- 表单 start -->
    <div id="use_to_load_grid" ></div>
    <!-- 表单 end -->
  </div>
</div>
</template>
<script>
var data={newPage:1}
/**
 * 表格中的操作---删除上传资源
**/
var uploadDel = function(params, dom) {
	layer.alert('确定删除该行数据?',
	function(index) {
		var resourceId = params.resourceId;
		var reidParams = {
			resourceId: resourceId
		};
		CDUtil.ajaxPost("/resource/delete", reidParams,
		function(retVO) {
			if (retVO.code == 1) {
				sourseSearch();
				layer.msg(retVO.msg);
				layer.close(index);
			}
			if (retVO.code == 0) {
				layer.msg(retVO.msg);
			}
			if(retVO.code == 2){
				layer.msg("用户信息失效，请重新登录！");
				setTimeout(function () {
		        	// window.close();
		        	window.location.href = ROOT_SERVER+"/#/index";
		        	window.location.reload();
       			}, 1000);
			}
		});
	});
};
/**
 * 表格中的操作---查看上传资源
**/
var uploadView = function(params, dom) {
	sessionStorage.setItem("resourceId",params.resourceId);
    window.open(ROOT_UI+"/front/path/demond?token="+sessionStorage.getItem("token"));
};
/**
 * 表格中的操作---编辑上传资源
**/
var uploadEdit = function(params, dom) {
	sessionStorage.setItem("upload","source");
	sessionStorage.setItem("nav","basic");
	sessionStorage.setItem("resourceId",params.resourceId);
    window.open(ROOT_UI+"/front/path/upload?token="+sessionStorage.getItem("token"));
};
/**
 * 进行查询上传信息的方法
**/
var sourseSearch = function(newPage) {
	if(newPage == "undefined"){
     		newPage=1;
     }
	var params = {
		curPage: newPage,
		pageSize: 20,
		resourceNameKey: $("#search_resourceName").val(),
		authorKey: $("#search_author").val(),
		classlevelName: $("#search_classlevelName").val(),
		subjectName: $("#search_subjectName").val(),
		sourceType:"RECORD",
	};
	CDUtil.ajaxPost("/resource/list",params,function(retVO) {
		params.curPage=retVO.curPage;
		config.gData = retVO;
		Grid.initGrid(config,function(){});
		if(retVO.code == 2){
			layer.msg("用户信息失效，请重新登录！");
			setTimeout(function () {
		      // window.close();
		      window.location.href = ROOT_SERVER+"/#/index";
		      window.location.reload();
       		}, 1000);
		}
	});
};

/**
 * 进行表格分页的配置
**/
var config = {
	//用来展示表格控件的div的id
	containerId: "use_to_load_grid",
	//用来展示表格的表头数据
	 thead: [{name:"资源名称",valuekey:"resourceName",css:"width: 130px;"},
                  {name:"年级",valuekey:"classlevelName",css:"width: 130px;"},
                  {name:"学科",valuekey:"subjectName"},
                  {name:"主讲教师",valuekey:"author"},
                  {name:"操作",valuekey:"opt",type:"opt"}
          ],
	//用来展示表格的数据
	//这个应该是后台返回的部分
	gData: {},
	//是否需要分页，true：需要，不写默认需要
	pagingFlag: true,
	//执行页面查询的方法
	searchFun: sourseSearch,
	//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
	optParams: ["resourceId","classlevelName","resourceName","subjectName","author","creatName"],
	//表格中的行操作名称
	optName: {
		view_fun: "查看",
		edit_fun: "编辑",
		del_fun: "删除"
	},
	//表格中的行操作方法
	optFuns: {
		view_fun: uploadView,
		edit_fun: uploadEdit,
		del_fun: uploadDel,
	}
};

/**
 * Vue组件对象
**/
export default {
	data() {
    	return {
       		classList:"",
       		subjectList:"",
    	}
  	},
  	created () {    
    	this.sourSearch(),
   		this.showclass(),
    	this.showsubject()
    },
	methods: {
		/*查询列表数据*/
		sourSearch: sourseSearch,
		 /*获取年级列表*/
  		showclass:function(){
   			var _self = this;
        	var params = {};
        	CDUtil.ajaxPost("/base/classlevel/list",params,function(retVO){
         		_self.classList = retVO;
        	});
   		},
  		/*获取学科列表*/
  		showsubject:function(){
       	 var _self = this;
        	var params = {};
        	CDUtil.ajaxPost("/base/subject/list",params,function(retVO){
         		_self.subjectList = retVO;
       		 });
    	}
	}
}
</script>
