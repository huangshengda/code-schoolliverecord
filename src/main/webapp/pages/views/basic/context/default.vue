<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="addUser">添加用户</button></div>
  <div class="dashboard">
  <!-- 条件 start -->
    <form action="" id="condition">
      <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>用户名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="username" id="s-username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>姓名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="realname" id="s-realname" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType" id="s-userType"><option>请选择</option><option value="ADMIN">管理员</option>
            <option value="TEACHER">老师</option>
            <option value="STUDENT">学生</option></select>
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
    <!-- 编辑用户弹窗表单 start -->
  <form action="" id="edituser" class="layBox">
  <input type="hidden" name="userId" id="userId">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value" name="username" id="e-username">
            
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull" id="realname">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" id="e-password" data-vali="notnull,password">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
             <select name="userType" id="userType"><option>请选择</option><option value="ADMIN">管理员</option>
            <option value="TEACHER">老师</option>
            <option value="STUDENT">学生</option></select>
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <!--<span>
            <button class="lay-btn green-btn">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>-->
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
            <input type="text" name="username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull,password">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType" data-vali="notnull">
            <option value="">请选择</option>
            <option value="ADMIN">管理员</option>
            <option value="TEACHER">老师</option>
            <option value="STUDENT">学生</option></select>
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <!--<span>
            <button class="lay-btn green-btn" @click="addsb">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>-->
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
	$('#userType').val(params.userType);
	$('#e-username').text(params.username);
	$('#realname').val(params.realname);
	md5($('#e-password').val(params.password));
	layer.open({
		type: 1,
		title: '编辑用户',
		skin: 'layui-layer-rim',
		//加上边框
		area: ['450px', '375px'],
		//宽高
		content: $("#edituser"),
		btn: ['yes', 'no'],
		yes: function(index, layero) {
			var editparams = $('#edituser').serialize();
			CDUtil.ajaxPost("/base/user/update", editparams,
			function(retVO) {
				if (retVO.code == 1) {
					userSearch();
				}
			});
			layer.close(index);
			layer.msg('编辑成功!');
		}
	});
}
/**
 * 表格中的操作---删除用户
**/
var userDel = function(params, dom) {
	layer.alert('确定删除该行数据?',
	function(index) {
		var userId = params.userId;
		var useridParams = {
			userId: userId
		};
		CDUtil.ajaxPost("/base/user/delete", useridParams,
		function(retVO) {
			if (retVO.code == 1) {
				userSearch();
			}
		});
		layer.close(index);
		layer.msg('删除成功!');
	});
}

//进行表格分页的配置
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
		valuekey: "userType"
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
	optParams: ["userId", "username", "realname", "userType", "password"],
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
}

/**
 * 进行查询用户信息的方法
**/
var userSearch = function() {
	var params = {
		username: $("#s-username").val(),
		realname: $("#s-realname").val(),
		userType: $("#s-userType").val(),
	};
	CDUtil.ajaxPost("/base/user/list", params,function(retVO) {
		config.gData = retVO;
		Grid.initGrid(config,function(){});
	});
};

/**
 * Vue组件对象
**/
export default {
	mounted() {
		this.search_one()
	},
	methods: {
		search_one: userSearch,
		addUser: function() {
			layer.open({
				type: 1,
				title: '添加用户',
				skin: 'layui-layer-rim',
				//加上边框
				area: ['450px', '375px'],
				//宽高
				btn: ['yes', 'no'],
				content: $("#adduser"),
				yes: function(index, layero) {
					var addparams = $('#adduser').serialize();
					CDUtil.ajaxPost("/base/user/add", addparams,function(retVO) {
						if (retVO.code == 1) {
							userSearch();
						}
					});
					layer.close(index);
				}
			});
		}
	}
}
</script>
