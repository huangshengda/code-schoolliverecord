<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">添加学科</button></div>
 <div class="dashboard">
  <!-- 表单 start -->
    <form action="" id="grade">
    <table>
      <thead><th>学科</th><th>排序</th><th>操作</th></thead>
      <tbody id="sort">
        <tr v-for="(grade,index) in grades.data">
        <td :data-id="grade.subjectId">{{grade.subjectName}}</td>
         <td><i class="iconfont icon-moveup upbtn" @click="upbtn"></i><i class="iconfont icon-movedown downbtn" @click="downbtn"></i></td>
        <td class="colorTd"><span @click="manEdit(grade.subjectName,grade.subjectId)">编辑</span>&nbsp;&nbsp;&nbsp;<span @click="manDel(grade.subjectId)">删除</span></td></tr>
      </tbody>
    </table>
  </form> 
  <!-- 表单 start -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" class="grade"></div>
    <!-- 表单 end --> 
  </div>
      <!-- 编辑学科弹窗表单 start -->
  <form action="" id="editsubject" class="layBox">
  <input type="hidden" name="subjectId" id="m-subjectId">
   <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName" id="m-subjectName" maxlength="10">
          </span>
        </div>
    </div>
  </form>
    <!-- 编辑学科弹窗表单 end -->
    <!-- 添加学科弹窗表单 start -->
  <form action="" id="addsubject" class="layBox">
    <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName" maxlength="10">
          </span>
        </div>
    </div>
  </form>
    <!-- 添加学科弹窗表单 end -->
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
     upbtn: function(event){ 
    	var el = event.target;
    	var $this = $(el);
     	var tr = $this.parents('tr');
     	var _index=tr.index() ;
     	var _str;
     	if (_index != 0) {
			tr.prev().before(tr);
			 $("#sort tr").each(function() {
			 	_str += $(this).find('td').attr("data-id") + ",";
			 });
			 CDUtil.ajaxPost("/base/subject/sort",_str,function(retVO){});
		}
     },
     /**下移**/
     downbtn:function(event){
		var el = event.target;
    	var $this = $(el);
     	var tr = $this.parents('tr');
    	 var trLength = $this.length; 
    	 var _index=tr.index() ;
    	 var _str;
     	if (_index != trLength - 1){ 
			tr.next().after(tr);
			$("#sort tr").each(function() {
			 	_str += $(this).find('td').attr("data-id") + ",";
			 });
			CDUtil.ajaxPost("/base/subject/sort",_str,function(retVO){});
		}
     },
    }
   }
</script>
<style>
.colorTd{color:#03a9f4}
.colorTd span{cursor: pointer;}
</style>