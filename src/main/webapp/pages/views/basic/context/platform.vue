<template>
<div class="content">
<div class="subBtn"></div>
  <div class="dashboard">
    <form action="" id="platform">
     <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>网站title:</label></span>
          <span class="cd-f-value ">
            <input type="text" class="w730" name="title" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name vat"><label class="cd-f-notnull">*</label><label>网站logo:</label></span>
          <span class="cd-f-value ">
            <img src="" width="360" height="70" id="thispage_fileup_img" file-name="" file-path="" class="show">
            <div class="btn btn-default smp-fileupshow mt10" >上传logo
              <input type="file" id="thispage_fileup" @change="impup();"  class="smp-fileupinput" name="logoPath" data-vali="notnull"/>
            </div>
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>网站底部:</label></span>
          <span class="cd-f-value ">
             <input type="text" class="w730" name="buttomMsg" data-vali="notnull"> 
          </span>
        </div>
        <div class="cd-f-eve mt40">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn mr20" @click="subPlat">保存</button><button class="lay-btn green-btn" @click="rePlat">恢复默认</button>
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
    data() {
      return {
      }
    },
    methods:{
    /** 表单操作--保存**/
      subPlat: function(){
        	var platParams = $('#platform').serialize();
      		CDUtil.ajaxPost("/base/basicinfo/update",platParams,function(retVO){
      		if (retVO.code == 1) {
				layer.msg('保存成功!');
			}
      	});
       },
      /** 表单操作--重置**/
       rePlat:function(){
        	$('#platform')[0].reset();
        },
        /** 表单操作--上传图片**/
        impup: function(){
        	console.log($("#thispage_fileup"));
        	var fileDom = $("#thispage_fileup")[0];
        	var file = fileDom.files[0];
        	var fileupUrl = ROOT_SERVER+"/resource/list?";
        	var sequence = H5fileup.getSequence();
        	H5fileup.startFileup(file,fileupUrl,sequence,function(){
        		H5fileup.showImgAuto(file,"thispage_fileup_img");
        	});
        }
    }
   }
</script>
