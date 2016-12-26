<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title id="title_home"></title>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width">
<%@ include file="./_commons/meta.jsp"%>
</head>
<body>
<div id="app">hello</div>
<%@ include file="./_commons/footer.jsp"%>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_app.js" ></script>
<script type="text/javascript">
$(function(){
	var params = {};
	CDUtil.ajaxPost("/base/basicinfo/get",params,function(retVO){
		if (retVO.code == 1) {
			$('#title_home').text(retVO.data.title);
		}
	});
})
</script>
</body>
</html>