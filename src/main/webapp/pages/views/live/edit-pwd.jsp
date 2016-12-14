<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>修改用户密码</title>
  <meta name="viewport" content="width=device-width">
  <%@ include file="../../_commons/meta.jsp"%>
  <style>
  	body{background-color: #f5f8fa;}
  	#edit-pwd input{width:295px;}
  	#edit-pwd{width:400px;margin:0 auto;}
  	.cd-f-eve{margin-top:20px;}
  </style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
  <!-- 修改密码 start-->
  <div class="wamp dashboard">
    <div class="smp-main mt40">
      <form action="" id="edit-pwd">
     <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value" name="username" id="user_name">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>原密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="prePassword" data-vali="notnull"> 
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>新密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull,password"> 
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>确认密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull"> 
          </span>
        </div>
        <div class="cd-f-eve mt40">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn mr20" id="sub_pwd" type="button">确认修改</button>
          </span>
        </div>   
      </div>
    </form>
    </div>
  </div>
  <!-- 修改密码  end-->
  <script type="text/javascript">
	$(function(){
		$('#sub_pwd').click(function(){
			//添加表单验证--Validation
       		var result = Validation.validation({
          		containerId: "edit_pwd",
        	});
       		if(result==true){
				var pwdParams = $('#edit_pwd').serialize();
      			CDUtil.ajaxPost("/base/user/update",pwdParams,function(retVO){
      				if (retVO.code == 1) {
						layer.msg('保存成功!');
					}
      			});
       		}
		});
	})
  </script>
</body>
</html>