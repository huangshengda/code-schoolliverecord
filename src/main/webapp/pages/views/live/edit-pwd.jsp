<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>修改用户密码</title>
  <meta name="viewport" content="width=device-width">
  <%@ include file="../../_commons/meta.jsp"%>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
  <!-- 修改密码 start-->
  <div class="wamp">
    <div class="smp-main">
      <form action="" id="edit-pwd">
     <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="">
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
            <button class="lay-btn green-btn mr20" id="subPwd">保存</button><button class="lay-btn green-btn" id="rePwd">恢复默认</button>
          </span>
        </div>   
      </div>
    </form>
    </div>
  </div>
  <!-- 修改密码  end-->
  <script type="text/javascript">
	$(function(){
		$('#subPwd').click(function(){
			var pwdParams = $('#edit-pwd').serialize();
      		CDUtil.ajaxPost("/base/user/update",pwdParams,function(retVO){
      			if (retVO.code == 1) {
					layer.msg('保存成功!');
				}
      		});
		});
		$('#subPwd').click(function(){
			$('#edit-pwd')[0].reset();
		});	
	})
  </script>
</body>
</html>