<template>
<div class="content">
<div class="subBtn"></div>
  <div class="dashboard">
    <form action="" id="platform">
     <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>网站title:</label></span>
          <span class="cd-f-value ">
            <input type="text" class="w730" name="title" data-vali="notnull" id="basic_tit" maxlength="50">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name vat"><label class="cd-f-notnull">*</label><label>网站logo:</label></span>
          <span class="cd-f-value ">
            <img src="" width="360" height="70" id="thispage_fileup_img" file-name="" file-path="" class="show">
            <div class="btn btn-default smp-fileupshow mt10 inb">上传logo
              <input type="file" id="thispage_fileup" @change="impup();"  class="smp-fileupinput" accept="image/png,image/jpeg" />
              <input type="hidden" id="img_resourceId" name="logoPath" value="" />
            </div>
            <div class="upTit">注：图片格式支持png、jpg，最大5M。</div>
          </span>
          <input type="hidden" id="msg_img" value="false" name="thumbFlag">
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>网站底部:</label></span>
          <span class="cd-f-value ">
             <input type="text" class="w730" name="buttomMsg" id="basic_btm"  maxlength="100"> 
          </span>
        </div>
        <div class="cd-f-eve mt40">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn mr20" @click="subPlat" type="button">保存</button>
          </span>
        </div>   
      </div>
    </form>
  </div>
</div>
</template>
<script>
/**
 * Vue组件对象
**/
export default {
    created() {
		this.basic()
	},
    methods:{
    	/** 表单--内容获取**/
    	basic: function(){
    		CDUtil.ajaxPost("/base/basicinfo/get",{},function(retVO){
      			if (retVO.code == 1) {
					$('#basic_tit').val(retVO.data.title);
					$('#thispage_fileup_img').attr('src',retVO.data.logoPath);
					$('#basic_btm').val(retVO.data.buttomMsg);
				}
      		});
    	},
     /** 表单操作--上传图片**/
        impup: function(){
        	var fileDom = $("#thispage_fileup")[0];
        	var file = fileDom.files[0];
        	var size = (Math.round(file.size * 100 / (1024 * 1024)) / 100);
        	var filename = file.name;
			var ldot = filename.lastIndexOf(".");
			var name = filename.substring(0,ldot);
			var type = filename.substring(ldot+1).toLowerCase();
			var refuseType = "$png$jpg$";
			if(refuseType.indexOf("$"+type+"$")<0){
				layer.msg("选择文件格式不正确");
				return;
			}
			if(size>5){
				layer.msg("图片太大，请小于5M");
				return;
			}
        	var fileupUrl = ROOT_SERVER+"/image/upload?token="+sessionStorage.getItem("token");
        	var sequence = H5fileup.getSequence();
        	H5fileup.startFileup(file,fileupUrl,sequence,function(retVO){
				retVO = eval('(' + retVO + ')');
				var dataVO = retVO.data;
				var resourceId = dataVO.resourceId;
				H5fileup.showImgAuto(file,"thispage_fileup_img");
				$("#img_resourceId").val(resourceId);	
				$("#msg_img").val(true);
			});
        },
          /** 表单操作--保存**/
      subPlat: function(){
      	//添加表单验证--Validation
       	var result = Validation.validation({
          	containerId: "platform",
        });
       	if(result==true){
        	var platParams = $('#platform').serializeJSON();
      		CDUtil.ajaxPost("/base/basicinfo/update",platParams,function(retVO){
      			if (retVO.code == 1) {
					layer.msg(retVO.msg);
					$('#platform')[0].reset();
				    window.location.reload();
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
    }
   }
</script>
