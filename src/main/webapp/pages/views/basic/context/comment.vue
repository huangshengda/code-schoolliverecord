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
            <input type="text" name="keywords" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>评论人:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="realname" data-vali="notnull">
          </span>
        </div>  
        <button class="sBtn" @click="search_one">查询</button>
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
   export default {
    data() {
      return {
        
      }
    },
      mounted () {    
    this.search_one()
    },
  methods: {
    search_one: function(){
        var result = Validation.validation({
          containerId: "condition",
        });
        if(result==true){}
    var params = {};
    CDUtil.ajaxPost("/base/resource/comment/list",params,function(retVO){
        var config = {
          //用来展示表格控件的div的id
          containerId: "use_to_load_grid",
          //用来展示表格的表头数据
          thead: [{name:"评论",valuekey:"commentContent",width: "100px"},
                  {name:"来源",valuekey:"resourceName"},
                  {name:"评论人",valuekey:"realName"},
                  {name:"操作",valuekey:"opt",type:"opt"}
          ],
          //用来展示表格的数据
          //这个应该是后台返回的部分
          gData: retVO,
          //是否需要分页，true：需要，不写默认需要
          pagingFlag: true,
          //执行页面查询的方法
          searchFun: function(){

          },
          //需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
          optParams: ["resourceId","commentUserId","parentCommentId"],
          //表格中的行操作名称
          optName: {del_fun:"删除"},
          //表格中的行操作方法
          optFuns: {
          	del_fun:function(params,dom){
                  layer.alert('确定删除该行数据?',function(index){
                	var resourceId = params.resourceCommentId;
                	alert(resourceId);
               		CDUtil.ajaxPost("/resource/comment/delete",{resourceCommentId: resourceId},function(retVO){
          			});
                	layer.close(index);
               		layer.msg('删除成功!')
              	 });  
                }
          }
      };
      Grid.initGrid(config,function(){});
    });
  }
}
   }
</script>
