<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="addgrd">添加年级</button></div>
 <div class="dashboard">
  <!-- 表单 start -->
    <form action="" id="grade">
    <table>
      <thead><th>年级</th><th>排序</th><th>操作</th></thead>
      <tbody id="sort">
        <tr v-for="(grade,index) in grades.data">
        <td :data-id="grade.classlevelId" :title="grade.classlevelName">{{grade.classlevelName}}</td>
         <td><i class="iconfont icon-moveup upbtn" @click="up"></i><i class="iconfont icon-movedown downbtn" @click="down"></i></td>   
        <td class="colorTd"><span @click="manEdit(grade.classlevelName,grade.classlevelId)">编辑</span>&nbsp;&nbsp;&nbsp;<span @click="manDel(grade.classlevelId)">删除</span></td></tr>
      </tbody>
    </table>
  </form> 
  <!-- 表单 start -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" class="grade"></div>
    <!-- 表单 end --> 
  </div>
<!-- 编辑年级弹窗表单 start -->
  <form action="" id="editgrade" class="layBox">
 	 <input type="hidden" name="classlevelId" id="edit-classlevelId">
  	 <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>年级:</label></span>
          <span class="cd-f-value">
            <input type="text" name="classlevelName" id="edit-classlevelName" data-vali="notnull" maxlength="10">
          </span>
        </div>
    </div>
  </form>
<!-- 编辑年级弹窗表单 end -->
<!-- 添加年级弹窗表单 start -->
  <form action="" id="addgrade" class="layBox">
    <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>年级:</label></span>
          <span class="cd-f-value">
            <input type="text" name="classlevelName" maxlength="10" data-vali="notnull">
          </span>
        </div>
    </div>
  </form>
<!-- 添加年级弹窗表单 end -->
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
       	 CDUtil.ajaxPost("/base/classlevel/list",params,function(retVO){
        	_self.grades = retVO;  
        });
      },
      /*编辑年级*/
      manEdit: function(classlevelName,classlevelId){
      	var _self = this;
      	$('#edit-classlevelName').val(classlevelName);
      	$('#edit-classlevelId').val(classlevelId);
      	layer.open({
		type: 1,
		title: '编辑年级',
		skin: 'layui-layer-rim',
		//加上边框
		area: ['450px', '240px'],
		//宽高
		content: $("#editgrade"),
		btn: ['确定', '取消'],
		yes: function(index, layero) {
		//添加表单验证--Validation
       		var result = Validation.validation({
          		containerId: "editgrade",
        	});
       		if(result==true){
				var editparams = $('#editgrade').serializeJSON();
				CDUtil.ajaxPost("/base/classlevel/update", editparams,
				function(retVO) {
					if (retVO.code == 1) {
						_self.show();
						layer.msg(retVO.msg);
						layer.close(index);
						$(".cd-f-vali").remove();
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
		},
		end: function() {
			$(".cd-f-vali").remove();
		}
	});
   },
/*删除年级*/
  manDel: function(classlevelId){
      var _self = this;
      layer.alert('确定删除该行数据?',function(index) {
			var nanidParams = {
				classlevelId: classlevelId
			};
		CDUtil.ajaxPost("/base/classlevel/delete", nanidParams,function(retVO){
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
	});
},
     /*添加年级*/
    addgrd: function(){
    	$('#addgrade')[0].reset();
      	$(".cd-f-vali").remove();
       	var _self = this;
          layer.open({
             type: 1,
              title: '添加年级',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '240px'], //宽高
              content: $("#addgrade"),
              btn: ['确定', '取消'],
              yes:function(index,layero){
              //添加表单验证--Validation
       			var result = Validation.validation({
          			containerId: "addgrade",
        		});
       			if(result==true){
              		var addparams = $('#addgrade').serializeJSON();
      				CDUtil.ajaxPost("/base/classlevel/add",addparams,function(retVO){
      					if (retVO.code == 1) {
							_self.show();
							layer.msg(retVO.msg);
							layer.close(index);
							$('#addgrade')[0].reset();
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
     up: function(event){ 
     	var _self = this;
    	var el = event.target;
    	var $this = $(el);
     	var tr = $this.parents('tr');
     	var $index= tr.index();
     	var _str="";
			 $("#sort tr").each(function(index,value) {
				 if(index== $index-1){
					 _str += $(this).next().find('td').attr("data-id") + ",";
				 }else if( index== $index ){
				 	_str += $(this).prev().find('td').attr("data-id") + ",";
				 }else{
				 	_str += $(this).find('td').attr("data-id") + ",";
				 }
			 	
			 });
			  CDUtil.ajaxPost("/base/classlevel/sort",{classlevelIds:_str},function(retVO){
			 	 	if (retVO.code == 1) {
						_self.show()
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
     down:function(event){
     	var _self = this;
    	var el = event.target;
    	var $this = $(el);
     	var tr = $this.parents('tr');
     	var $index= tr.index();
     	var _str="";
			$("#sort tr").each(function(index,value) {
				 if(index == $index+1){
					 _str += $(this).prev().find('td').attr("data-id") + ",";
				 }else if( index == $index){
				 	_str += $(this).next().find('td').attr("data-id") + ",";
				 }else{
				 	_str += $(this).find('td').attr("data-id") + ",";
				 }
			 });
			CDUtil.ajaxPost("/base/classlevel/sort",{classlevelIds:_str},function(retVO){
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