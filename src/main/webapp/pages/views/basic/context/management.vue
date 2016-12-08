<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">添加学科</button></div>
 <div class="dashboard">
  <!-- 表单 start -->
    <form action="" id="grade">
    <table>
      <thead><th>学科</th><th>排序</th><th>操作</th></thead>
      <tbody>
        <tr v-for="(grade,index) in grades.data">
        <td>{{grade.subjectName}}</td>
        <td v-if="index===0"><i class="iconfont icon-movedown" @click="downbtn"></i></td>
        <template v-else> 
         <td v-if="index===(grades.length-1)"><i class="iconfont icon-moveup" @click="upbtn"></i></td>
         <td v-else><i class="iconfont icon-moveup upbtn" @click="upbtn"></i><i class="iconfont icon-movedown" @click="downbtn"></i></td>
        </template>
        <td class="colorTd"><span @click="manEdit(grade.subjectName,grade.subjectId)">编辑</span>&nbsp;&nbsp;&nbsp;<span @click="manDel(grade.subjectId)">删除</span></td></tr>
      </tbody>
    </table>
  </form> 
  <!-- 表单 start -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" class="grade"></div>
    <!-- 表单 end --> 
  </div>
      <!-- 编辑用户弹窗表单 start -->
  <form action="" id="editsubject" class="layBox">
  <input type="hidden" name="subjectId" id="m-subjectId">
   <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName" id="m-subjectName">
          </span>
        </div>
    </div>
  </form>
    <!-- 编辑用户弹窗表单 end -->
    <!-- 添加用户弹窗表单 start -->
  <form action="" id="addsubject" class="layBox">
    <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName">
          </span>
        </div>
    </div>
  </form>
    <!-- 添加用户弹窗表单 end -->
</div>
</template>
<script>
/*vue组件*/
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
    /*显示表单数据*/
      show: function(){
      	 var _self = this;
       	 var params = {};
       	 CDUtil.ajaxPost("/base/subject/list",params,function(retVO){
        	_self.grades = retVO;  
        });
      },
      /*编辑学科*/
      manEdit: function(subjectName,subjectId){
      var _self = this;
      	$('#m-subjectName').val(subjectName);
      	$('#m-subjectId').val(subjectId);
      	layer.open({
		type: 1,
		title: '编辑学科',
		skin: 'layui-layer-rim',
		//加上边框
		area: ['450px', '375px'],
		//宽高
		content: $("#editsubject"),
		btn: ['yes', 'no'],
		yes: function(index, layero) {
			var editparams = $('#editsubject').serialize();
			CDUtil.ajaxPost("/base/subject/update", editparams,
			function(retVO) {
				if (retVO.code == 1) {
					_self.show();
				}
			});
			layer.close(index);
			layer.msg('编辑成功!');
		}
		});
      },
      /*删除学科*/
      manDel: function(subjectId){
      var _self = this;
      	layer.alert('确定删除该行数据?',
		function(index) {
			var nanidParams = {
			subjectId: subjectId
		};
		CDUtil.ajaxPost("/base/subject/delete", nanidParams,function(retVO) {
		if (retVO.code == 1) {
				_self.show();
			}
		});
		layer.close(index);
		layer.msg('删除成功!');
	});
      },
      /*添加学科*/
       add: function(){
       var _self = this;
          layer.open({
             type: 1,
              title: '添加学科',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '240px'], //宽高
              content: $("#addsubject"),
              btn: ['yes', 'no'],
              yes:function(index,layero){
              	var addparams = $('#addsubject').serialize();
      			CDUtil.ajaxPost("/base/subject/add",addparams,function(retVO){
      				if (retVO.code == 1) {
						_self.show();
					}
      			});
      			layer.close(index);
              }
           });
      },     
     /**上移**/
     upbtn: function(){
     var $this = $(this);
     alert($this);
     	var tr = $ (this).closest('tr'); 
     	var newIndex = tr.prop ('rowIndex') - 1;
                if (newIndex >= 0)
                {
                    tr.insertBefore ('tr:eq(' + newIndex + ')');
                }
                else
                {
                    tr.insertAfter ('tr:last');
                }
     },
     /**下移**/
     downbtn:function(){
     	var tr = $ (this).closest('tr'); 
     	var newIndex = tr.prop ('rowIndex') + 1;
                if (newIndex < $('tr').length)
                {
                    tr.insertAfter ('tr:eq(' + newIndex + ')');
                }
                else
                {
                    tr.insertBefore ('tr:first');
                }
     },
    }
   }
</script>
<style>
.colorTd{color:#03a9f4}
.colorTd span{cursor: pointer;}
</style>