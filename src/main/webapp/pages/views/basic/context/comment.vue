<template>
<div class="content">
<div class="subBtn"></div>
  <div class="dashboard">
  <!-- 条件 start -->
    <form action="" id="condition">
        <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>关键词:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="keywords" id="search_keywords" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>评论人:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="realname" id="search_realname" data-vali="notnull">
          </span>
        </div>  
        <button class="sBtn" type="button" @click="search_one">查询</button>
      </div>
    </form>
 <!-- 条件 end -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" ></div>
    <!-- 表单 end -->
  </div>
</div>
</template>
<script>
var data={newPage:1}
/**
 * 表格中的操作---删除评论
**/    			
var comDel = function(params, dom) {
	layer.alert('确定删除该行数据?',
	function(index) {
		var comId = params.resourceCommentId;
		var comidParams = {
			resourceCommentId: comId
		};
		CDUtil.ajaxPost("/resource/comment/delete", comidParams,
		function(retVO) {
			if (retVO.code == 1) {
				comSearch();
			}
		});
		layer.close(index);
		layer.msg('删除成功!');
	});
};
/**
 * 进行查询评论信息的方法
**/
var comSearch = function() {
	var cParams = {
		curPage: data.newPage,
		pageSize: 20,
		keywords: $("#search_keywords").val(),
		realname: $("#search_realname").val(),
	};
	CDUtil.ajaxPost("/base/resource/comment/list", cParams,function(retVO) {
		cParams.curPage=retVO.curPage;
		config.gData = retVO;
		Grid.initGrid(config,function(){});
	});
};
/**
 * 表格中的操作---进行表格分页的配置
**/
var config = {
	//用来展示表格控件的div的id
	containerId: "use_to_load_grid",
	//用来展示表格的表头数据
	 thead: [{name:"评论",valuekey:"commentContent"},
             {name:"来源",valuekey:"resourceName"},
             {name:"评论人",valuekey:"realName"},
             {name:"操作",valuekey:"opt",type:"opt"}
          ],
	//用来展示表格的数据
	//这个应该是后台返回的部分
	gData: {},
	//是否需要分页，true：需要，不写默认需要
	pagingFlag: true,
	//执行页面查询的方法
	searchFun: comSearch,
	//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
	optParams: ["resourceCommentId","commentUserId","parentCommentId","commentContent","resourceName","realName"],
	//表格中的行操作名称
	optName: {
		del_fun: "删除",
	},
	//表格中的行操作方法
	optFuns: {
		del_fun: comDel,
		
	}
}
/**
 * Vue组件对象
**/
export default {
 	created () {    
   	 	this.search_one()
 	},
 	methods: {
   		search_one: comSearch,
	}
}
</script>
