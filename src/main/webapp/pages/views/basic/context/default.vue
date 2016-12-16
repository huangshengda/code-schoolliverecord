<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="addUser">添加用户</button></div>
  <div class="dashboard">
  <!-- 条件 start -->
    <form action="" id="condition">
      <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="username" id="search_username" data-vali="notnull,username" maxlength="18">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="realname" id="search_realname" data-vali="notnull" maxlength="10">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType" id="search_userType">
            	<option value="-1">请选择</option>
            	<option value="ADMIN">管理员</option>
            	<option value="TEACHER">老师</option>
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
            <input type="text" name="password" id="edit_password" value="666666">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
             <select name="userType" id="edit_userType">
             <option value="-1">请选择</option>
             <option value="ADMIN">管理员</option>
            <option value="TEACHER">老师</option>
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
            <input type="text" name="username" id="add_username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull" id="add_realname">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull,password" id="add_password">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType" data-vali="notnull" id="add_userType">
           	 	<option value="-1">请选择</option>
            	<option value="ADMIN">管理员</option>
            	<option value="TEACHER">老师</option>
            	<option value="STUDENT">学生</option>
            </select>
          </span>
        </div>
    </div>
  </form>
<!-- 添加用户弹窗表单 end -->
</div>
</template>
<script>
/**
 * 表格中的操作---编辑用户
**/
var userEdit = function(params, dom) {
	$("#edit_userType option[value='"+params.userType+"']").prop("selected",true);
	$('#edit_username').text(params.username);
	$('#edit_realname').val(params.realname);
	$('#edit_userId').val(params.userId);
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
				/*var editparams = $('#edituser').serialize();*/
				var editparams = { 
          			userType: $("#edit_userType").val(), 
          			password: md5($("#edit_password").val()), 
           			realname: $("#edit_realname").val(),
         		};
				CDUtil.ajaxPost("/base/user/update", editparams,function(retVO) {
					if (retVO.code == 1) {
						userSearch();
						layer.msg(retVO.msg);
						layer.close(index);
					}
					if (retVO.code == 0) {
						layer.msg(retVO.msg);
					}
				});
			}
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
		width: "100px"
	},
	{
		name: "姓名",
		valuekey: "realname"
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
		addUser: function() {
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
								userSearch();
								layer.msg(retVO.msg);
								layer.close(index);
								$('#adduser')[0].reset();
							}
							if (retVO.code == 0) {
								layer.msg(retVO.msg);
							}
						});
					}
				}
			});
		}
	}
}
</script>
