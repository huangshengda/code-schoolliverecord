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
              <input type="file" id="thispage_fileup" class="smp-fileupinput" @click="upimg" name="logoPath" data-vali="notnull"/>
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
            <button class="lay-btn green-btn mr20">保存</button><button class="lay-btn green-btn">恢复默认</button>
          </span>
        </div>   
      </div>
    </form>
  </div>
</div>
</template>
<script>
   export default {
    data() {
      return {
        name: 'codyy'
      }
    },
    methods:{
      upimg:function(){
        //Validation
        var result = Validation.validation({
          containerId: "platform",
        });
        if(result==true){}
         /* 上传文件 */
         /* $("#thispage_fileup_img").attr("src", ROOT + "/public/smpui/v1/images/defaultImg.png");
       
        function show_fun_ss(file,file_attr){
          var fileupUrl = ROOT_SERVER + "/file/upload.do?fileType=thumb";
          H5fileup.startFileup(file, fileupUrl, file_attr.sequence,function(ret){
            $("#thispage_fileup_img").attr("file-path", ret.data);
            $("#thispage_fileup_img").attr("file-name", file.name);
            $("#thispage_fileup_img").attr("src", ROOT_IMAGE + ret.data);
          });
        };
        var config = {
            allow_type: "$jpg$,$png$,$bmp$,$png$,$jpeg$",
            max_size: 5,
            show_fun: show_fun_ss,
            warm_fun: function(msg){
              /*Dialog.optips({type: 2,msg: msg});
            }
          };

          $("#thispage_fileup").change(function(){
            H5fileup.initFileupChange(config,this);
          });
*/
      }
    }
   }
</script>
