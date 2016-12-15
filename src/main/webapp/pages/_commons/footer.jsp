<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="clear"></div>
<div class="wamp mt40">
	<div style="line-height: 60px;text-align:center;" id="foot_tit"></div>
</div>
<script type="text/javascript">
$(function(){
	var params = {};
	CDUtil.ajaxPost("/base/basicinfo/get",params,function(retVO){
		if (retVO.code == 1) {
			$('#foot_tit').text(retVO.data.buttomMsg);
		}
	});
})
</script>