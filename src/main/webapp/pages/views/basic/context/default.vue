<template>
<div class="content" id="user_form">
  <div class="subBtn fr">
  	<button class="btn mr15" @click="addUser">添加用户</button>
  	<button class="btn mr15" @click="batchAdd">批量添加</button>
  	<button class="btn" @click="output">导出</button>
  </div>
  <div class="clear"></div>
  <div class="dashboard">
  <!-- 条件 start -->
    <form action="" id="condition">
      <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="username" id="search_username" data-vali="username" maxlength="18">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" id="search_realname" data-vali="notnull" maxlength="10">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType" id="search_userType">
            	<option value="-1">请选择</option>
            	<option value="ADMIN">管理员</option>
            	<option value="TEACHER">教师</option>
            	<option value="STUDENT">学生</option>
            </select>
          </span>
        </div>   
        <button class="sBtn" type="button" @click="userSear(1)">查询</button>
      </div>
    </form>
  <!-- 条件 end -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" ></div>
    <!-- 表单 end -->
  </div>
<!-- 编辑用户弹窗表单 start -->
  <form action="" id="edituser" class="layBox">
  	<input type="hidden" name="userId" id="edit_userId">
   	<div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value" name="username" id="edit_username" maxlength="18"> 
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull" id="edit_realname" maxlength="10">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="password" name="password" id="edit_password" value="" data-vali=""> 
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
             <select name="userType" id="edit_userType">
             <option value="-1">请选择</option>
             <option value="ADMIN">管理员</option>
            <option value="TEACHER">教师</option>
            <option value="STUDENT">学生</option></select>
          </span>
        </div>
    </div>
  </form>
<!-- 编辑用户弹窗表单 end -->
<!-- 添加用户弹窗表单 start -->
  <form action="" id="adduser" class="layBox">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="username" id="add_username" data-vali="username" value="">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull" id="add_realname" value="" maxlength="10">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="password" id="add_password" value="666666">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType" data-vali="notnull" id="add_userType" value="">
           	 	<option value="-1">请选择</option>
           	 	<option value="ADMIN">管理员</option>
            	<option value="TEACHER">教师</option>
            	<option value="STUDENT">学生</option>
            </select>
          </span>
        </div>
    </div>
  </form>
<!-- 添加用户弹窗表单 end -->
<!-- 批量添加用户弹窗表单 start -->
  <form action="" id="batch_user" class="layBox">
   <div><div class="btn" @click="mbdown">模板下载</div></div>
   <div>请先下载模板，录入数据后导入</div>
   <div>Excel导入：<input type="file" placeholder="浏览" @change="viewFile" id="view_file" value="" accept=".xls,.xlsx"></div>
  </form>
    <input type="hidden" value="" id="sourceId">
<!-- 批量添加用户弹窗表单 end -->
</div>
</template>
<script>
/**
 * 表格中的操作---编辑用户
**/
var userEdit = function(params, dom) {
	$("#edit_password").attr("data-vali","");
	$("#edit_userType option[value='"+params.userType+"']").prop("selected",true);
	$('#edit_username').text(params.username);
	$('#edit_realname').val(params.realname);
	$('#edit_userId').val(params.userId);
	$("#edit_password").val(params.password);
	var pwd = $("#edit_password").val();
	$("#edit_password").change(function(){
   		$("#edit_password").attr("data-vali","password");
   		pwd = md5($("#edit_password").val());
	});
	layer.open({
		type: 1,
		title: '编辑用户',
		skin: 'layui-layer-rim',
		//加上边框
		area: ['450px', '375px'],
		//宽高
		content: $("#edituser"),
		btn: ['确定', '取消'],
		yes: function(index, layero) {
		//添加表单验证--Validation
       		var result = Validation.validation({
          		containerId: "edituser",
        	});
       		if(result==true){
				var editparams = { 
          			userType: $("#edit_userType").val(), 
          			password: pwd, 
           			realname: $("#edit_realname").val(),
           			userId: $("#edit_userId").val()
         		};
				CDUtil.ajaxPost("/base/user/update", editparams,function(retVO) {
					if (retVO.code == 1) {
						userSearch();
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
};
/**
 * 表格中的操作---删除用户
**/
var userDel = function(params, dom) {
	layer.alert('确定删除该用户?',function(index) {
		var userId = params.userId;
		var useridParams = {
			userId: userId
		};
		CDUtil.ajaxPost("/base/user/delete", useridParams,
		function(retVO) {
			if (retVO.code == 1) {
				userSearch();
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
 * 进行查询用户信息的方法
**/
var userSearch = function(newPage) {
	if(newPage == "undefined"){
     		newPage=1;
     }
	var params = {
		curPage: newPage,
		pageSize: 20,
		username: $("#search_username").val(),
		realname: $("#search_realname").val(),
		userType: $("#search_userType").val()
	};
	CDUtil.ajaxPost("/base/user/list",params,function(retVO) {
		if(retVO.code == 2){
			layer.msg("用户信息失效，请重新登录！");
			setTimeout(function () {
		        // window.close();
		      	window.location.href = ROOT_SERVER+"/#/index";
		     	window.location.reload();
       		}, 1000);
		}
		config.gData = retVO;
		Grid.initGrid(config, function(){});
	});
};

/**
 * 表格中的操作--进行表格分页的配置
**/
var config = {
	//用来展示表格控件的div的id
	containerId: "use_to_load_grid",
	//用来展示表格的表头数据
	thead: [{
		name: "用户名",
		valuekey: "username",
		css:"width: 130px;"
	},
	{
		name: "姓名",
		valuekey: "realname",
		css:"width: 130px;"
	},
	{
		name: "角色",
		valuekey: "userType_chinese"
	},
	{
		name: "操作",
		valuekey: "opt",
		type: "opt"
	}],
	//用来展示表格的数据
	//这个应该是后台返回的部分
	gData: {},
	//是否需要分页，true：需要，不写默认需要
	pagingFlag: true,
	//执行页面查询的方法
	searchFun: userSearch,
	//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
	optParams: ["userId", "username", "realname", "userType","userType_chinese","password"],
	//表格中的行操作名称
	optName: {
		edit_fun: "编辑",
		del_fun: "删除"
	},
	//表格中的行操作方法
	optFuns: {
		edit_fun: userEdit,
		del_fun: userDel,
	}
};
/**
 * Vue组件对象
**/
export default {
	created() {
		this.userSear()
	},
	methods: {
		userSear: userSearch,
		/*** 添加用户**/
		addUser: function(){
			$('#adduser')[0].reset();
      		$(".cd-f-vali").remove();
			var _self = this;
			layer.open({
				type: 1,
				title: '添加用户',
				skin: 'layui-layer-rim',
				//加上边框
				area: ['450px', '375px'],
				//宽高
				btn: ['确定', '取消'],
				content: $("#adduser"),
				yes: function(index, layero) {
					//添加表单验证--Validation
       				var result = Validation.validation({
          				containerId: "adduser",
        			});
       				if(result==true){
						 var addparams = { 
          				 	 userType: $("#add_userType").val(), 
          					 password: md5($("#add_password").val()), 
           					 username: $("#add_username").val(),
           					 realname: $("#add_realname").val(),
         				 };
						CDUtil.ajaxPost("/base/user/add", addparams,function(retVO) {
							if (retVO.code == 1) {
								_self.userSear();
								layer.msg(retVO.msg);
								layer.close(index);
								$('#adduser')[0].reset();
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
		output:function(){
		//批量导出
			window.location.href = ROOT_SERVER+'/exporUserList.do?token='+sessionStorage.getItem("token")+'&username='+$("#search_username").val()+'&realname='+$("#search_realname").val()+'&userType='+$("#search_userType").val();
		},
		//模板下载
		mbdown:function(){
			window.location.href = ROOT_SERVER+'/downloadUserModel.do?token='+sessionStorage.getItem("token");
		},
		viewFile:function(){
			var file = document.getElementById("view_file").files[0]; 
			var sequence = H5fileup.getSequence();
			var size = (Math.round(file.size * 100 / (1024 * 1024)) / 100);
			var filename = file.name;
			var ldot = filename.lastIndexOf(".");
			var name = filename.substring(0,ldot);
			var type = filename.substring(ldot+1).toLowerCase();
			var refuseType = "$xls$xlsx$";
			if(refuseType.indexOf("$"+type+"$")<0){
				layer.msg("选择文件格式不正确");
				return;
			}
			if(size>2048){
				layer.msg("文件太大，请小于5M");
				return;
			}
			var fileupUrl = ROOT_SERVER+"/batchuser/upload?token="+sessionStorage.getItem("token");
			H5fileup.startFileup(file,fileupUrl,sequence,function(retVO){
				retVO = eval('(' + retVO + ')');
				$('#sourceId').val(retVO.data.resourceId);
			});
		},
		batchAdd: function(){
			var toke = sessionStorage.getItem("token");
			var _self = this;
			layer.open({
				type: 1,
				title: '批量添加',
				skin: 'layui-layer-rim',
				//加上边框
				area: ['450px', '350px'],
				//宽高
				btn: ['确定', '取消'],
				content: $("#batch_user"),
				yes: function(index, layero){
					if($('#view_file').val()==''){
						layer.msg('未选择需要导入的文档！');
					}
					if($('#view_file').val()!=''){
						var indexLode = layer.load(2);
						var link = $('#sourceId').val();
		 				var bcParams = {
		 					filename: link,
		 					token:	sessionStorage.getItem("token")
		 				};
						CDUtil.ajaxPost("/importUser",bcParams,function(retVO) {
							if(retVO.code==0){
								layer.msg(retVO.msg);
								layer.close(indexLode);
							}
							if(retVO.code==1){
								layer.close(indexLode);
								_self.userSear();
								layer.msg(retVO.msg);
								layer.close(index);
								$('#batch_user')[0].reset();
							}
							if(retVO.code==2){
								layer.close(indexLode);
								layer.open({
									title:'请确认',
									content: '导入失败，是否下载问题明细？',
									btn: ['确认', '取消'],
									shadeClose: false,
									yes: function(indexone, layero){
										$('#batch_user')[0].reset();
										//下载问题明细
										window.location.href = ROOT_SERVER+'/downLoadErrorDetail.do?token='+toke+'&fileName='+retVO.msg;
										layer.close(indexone);
									},
									end: function(){
										$('#batch_user')[0].reset();
									}
								})
							}
						})
					}
				}
			})
		}
	}
}
</script>
<style>
#user_form .cd-f-value input,#user_form .cd-f-value select{width:180px;}
#user_form #condition input,#user_form #condition select{width:152px;}
</style>