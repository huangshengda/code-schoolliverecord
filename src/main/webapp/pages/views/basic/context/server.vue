<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">新增服务器</button></div>
  <div class="dashboard">
    <!-- 表单 start -->
    <div id="use_to_load_grid" ></div>
    <!-- 表单 end -->
  </div>
    <!-- 编辑服务器弹窗表单 start -->
  <form action="" id="editserver" class="layBox">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>服务器名称:</label></span>
          <span class="cd-f-value" name="serverName">
            <input type="text" name="serverName" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>服务器地址:</label></span>
          <span class="cd-f-value">
            <input type="text" name="serverValue" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>
        </div>
    </div>
  </form>
    <!-- 编辑服务器弹窗表单 end -->
    <!-- 添加服务器弹窗表单 start -->
  <form action="" id="addserver" class="layBox" >
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>服务器名称:</label></span>
          <span class="cd-f-value" name="serverName">
            <input type="text" name="serverName" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>服务器地址:</label></span>
          <span class="cd-f-value">
            <input type="text" name="serverValue" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn" @click="addServerFun">确定</button>
            <button class="lay-btn gray-btn">取消</button>
          </span>
        </div>
    </div>
  </form>
    <!-- 添加服务器弹窗表单 end -->
</div>
</template>
<script>
  export default {
    data() {
      return {
       
      }
    },
    mounted () {    
      this.server()
    },
     methods: {
      server: function(){
    	var params = {}; 
    	CDUtil.ajaxPost("/base/dmsserver/list",params,function(retVO){ 
       		var config = {
         	 //用来展示表格控件的div的id
          	containerId: "use_to_load_grid",
          	//用来展示表格的表头数据
          	thead: [
          		{name:"序号",valuekey:""},
                {name:"服务器名称",valuekey:"serverName"},
                {name:"DMS 地址",valuekey:"serverValue"},
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
          optParams: ["serverId"],
          //表格中的行操作名称
          optName: {edit_fun:"编辑",del_fun:"删除"},
          //表格中的行操作方法
          optFuns: {
         	edit_fun:function(params,dom){
         	alert($("input[name=serverName]").val());
         	$("input[name=serverName]").val(params.serverName);
         	 $("input[name=serverValue]").val(params.serverValue);
               layer.open({
             	 	type: 1,
             	 	title: '编辑服务器',
              		skin: 'layui-layer-rim', //加上边框
              		area: ['450px', '375px'], //宽高
              		content: $("#editserver")
           		});
            },
            del_fun:function(params,dom){
         
                layer.alert('确定删除该行数据?',function(index){
                var serverId = params.serverId;
               	CDUtil.ajaxPost("/base/dmsserver/delete",serverId,function(retVO){
          		});
                layer.close(index);
                layer.msg('删除成功!')
               });
            },
          }
      };
      Grid.initGrid(config,function(){});
    });
  },
      add: function(){
          layer.open({
              type: 1,
              title: '添加服务器',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '375px'], //宽高
              content: $("#addserver")
              
           });
      },
    addServerFun: function(){
    	var addparams = $('#addserver').serialize();
        CDUtil.ajaxPost("/base/dmsserver/add",addparams,function(retVO){});
    }
        
    }

   }
</script>
