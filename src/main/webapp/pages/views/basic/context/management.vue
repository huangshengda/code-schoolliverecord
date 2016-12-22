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
        <td :data-id="grade.subjectId" :title="grade.subjectName">{{grade.subjectName}}</td>
        <td v-if="index===0"><i class="iconfont icon-movedown downbtn" @click="downbtn"></i></td>
        <template v-else> 
         <td v-if="index===(grades.data.length-1)"><i class="iconfont icon-moveup" @click="upbtn"></i></td>
         <td v-else><i class="iconfont icon-moveup upbtn" @click="upbtn"></i><i class="iconfont icon-movedown downbtn" @click="downbtn"></i></td>
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
<!-- 编辑学科弹窗表单 start -->
  <form action="" id="editsubject" class="layBox">
  <input type="hidden" name="subjectId" id="edit-subjectId">
   <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName" id="edit-subjectName" maxlength="10" data-vali="notnull">
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
            <input type="text" name="subjectName" maxlength="10" data-vali="notnull">
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
     created () {    
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
      	$('#edit-subjectName').val(subjectName);
      	$('#edit-subjectId').val(subjectId);
      	layer.open({
		type: 1,
		title: '编辑学科',
		skin: 'layui-layer-rim',
		//加上边框
		area: ['450px', '240px'],
		//宽高
		content: $("#editsubject"),
		btn: ['确定', '取消'],
		yes: function(index, layero) {
			//添加表单验证--Validation
       		var result = Validation.validation({
          		containerId: "editsubject",
        	});
       		if(result==true){
				var editparams = $('#editsubject').serializeJSON();
				CDUtil.ajaxPost("/base/subject/update", editparams,
				function(retVO) {
					if (retVO.code == 1) {
						_self.show();
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
			}
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
				layer.msg(retVO.msg);
				layer.close(index);
			}
			if(retVO.code == 2){
				layer.msg("用户信息失效，请重新登录！");
				setTimeout(function () {
		        	window.location.href = ROOT_SERVER+"/#/index";
		        	window.location.reload();
       			}, 1000);
			}
		});
	});
      },
      /*添加学科*/
       add: function(){
       		$('#addsubject')[0].reset();
      		$(".cd-f-vali").remove();
      	 var _self = this;
          layer.open({
             type: 1,
              title: '添加学科',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '240px'], //宽高
              content: $("#addsubject"),
              btn: ['确定', '取消'],
              yes:function(index,layero){
              //添加表单验证--Validation
       			var result = Validation.validation({
          			containerId: "addsubject",
        		});
       			if(result==true){
              		var addparams = $('#addsubject').serializeJSON();
      				CDUtil.ajaxPost("/base/subject/add",addparams,function(retVO){
      					if (retVO.code == 1) {
							_self.show();
							layer.close(index);
							layer.msg(retVO.msg);
							$('#addsubject')[0].reset();
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
      			
      			}
              }
           });
      },     
     /**上移**/
     upbtn: function(event){ 
    	var _self = this;
    	var el = event.target;
    	var $this = $(el);
     	var tr = $this.parents('tr');
     	var _index=tr.index() ;
     	var _str="";
			tr.prev().before(tr);
			 $("#sort tr").each(function() {
			 	_str += $(this).find('td').attr("data-id") + ",";
			 });
			 CDUtil.ajaxPost("/base/subject/sort",{subjectIds:_str},function(retVO){
			 	if (retVO.code == 1) {
					_self.show();
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
     },
     /**下移**/
     downbtn:function(event){
     	var _self = this;
		var el = event.target;
    	var $this = $(el);
     	var tr = $this.parents('tr');
    	 var trLength = $this.length; 
    	 var _index=tr.index() ;
    	 var _str="";
			tr.next().after(tr);
			$("#sort tr").each(function() {
			 	_str += $(this).find('td').attr("data-id") + ",";
			 });
			CDUtil.ajaxPost("/base/subject/sort",{subjectIds:_str},function(retVO){
				if (retVO.code == 1) {
					_self.show();
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
     },
    }
   }
</script>
<style>
.colorTd{color:#03a9f4}
.colorTd span{cursor: pointer;}
#sort td {
    white-space: nowrap;
    overflow: hidden;
    white-space: nowrap;
    -o-text-overflow: ellipsis;
    text-overflow: ellipsis;
}
</style>