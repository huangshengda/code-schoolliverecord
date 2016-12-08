<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">添加年级</button></div>
 <div class="dashboard">
    <!-- 表单 start -->
  <form action="" id="grade">
    <table>
      <thead><th>年级</th><th>排序</th><th>操作</th></thead>
      <tbody>
        <tr v-for="(grade,index) in grades.data"><td>{{grade.classlevelName}}</td>
        <td v-if="index===0"><i class="iconfont icon-movedown"></i></td>
        <template v-else> 
         <td v-if="index===(grades.length-1)"><i class="iconfont icon-moveup"></i></td>
         <td v-else><i class="iconfont icon-moveup"></i><i class="iconfont icon-movedown"></i></td>
        </template>
        <td class="colorTd"><span>编辑</span>&nbsp;&nbsp;<span>删除</span></td></tr>
      </tbody>
    </table>
  </form>
  <!-- 表单 start -->
  </div>
      <!-- 编辑用户弹窗表单 start -->
  <form action="" id="editgrade" class="layBox">
   <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>年级:</label></span>
          <span class="cd-f-value">
            <input type="text" name="classlevelName">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn mr20">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>
        </div>
    </div>
  </form>
    <!-- 编辑用户弹窗表单 end -->
    <!-- 添加用户弹窗表单 start -->
  <form action="" id="addgrade" class="layBox">
    <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>年级:</label></span>
          <span class="cd-f-value">
            <input type="text" name="classlevelName">
          </span>
        </div>
    </div>
  </form>
    <!-- 添加用户弹窗表单 end -->
</div>
</template>
<script>
   export default {
    data() {
      return {
       grades:"",
      }
    },
     mounted () {    
      this.show()
    },
    methods: {
      show: function(){
      	 var _self = this;
       	 var params = {};
       	 CDUtil.ajaxPost("/base/classlevel/list",params,function(retVO){
       	 	console.log(retVO);
        	_self.grades = retVO;  
        });
      },
      /*编辑学科*/
      classEdit: function(){
      	
      	layer.open({
		type: 1,
		title: '编辑年级',
		skin: 'layui-layer-rim',
		//加上边框
		area: ['450px', '375px'],
		//宽高
		content: $("#editgrade"),
		btn: ['yes', 'no'],
		yes: function(index, layero) {
			var editparams = $('#editgrade').serialize();
			CDUtil.ajaxPost("/base/classlevel/update", editparams,
			function(retVO) {
				if (retVO.code == 1) {
				}
			});
			layer.close(index);
			layer.msg('编辑成功!');
		}
		});
      },
      /*删除学科*/
      classDel: function(){
      	
      },
      /*添加学科*/
       add: function(){
          layer.open({
             type: 1,
              title: '添加年级',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '240px'], //宽高
              content: $("#addgrade"),
              btn: ['yes', 'no'],
              yes:function(index,layero){
              	var addparams = $('#addgrade').serialize();
      			CDUtil.ajaxPost("/base/classlevel/add",addparams,function(retVO){
      				show();
      			});
      			layer.close(index);
              }
           });
      },     
      
    }
   }
</script>
<style>
	.colorTd{color:#03a9f4}
	.colorTd span{cursor: pointer;}
</style>