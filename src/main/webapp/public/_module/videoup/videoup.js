$(function(){
	/**
	 * 当点击上传按钮，选中文件后
	 */
	$("#fileup_video").change(function(){
		var file = this.files[0];
		var sequence = H5fileup.getSequence();
		var size = (Math.round(file.size * 100 / (1024 * 1024)) / 100);
		var filename = file.name;
		var ldot = filename.lastIndexOf(".");
		var name = filename.substring(0,ldot);
		var type = filename.substring(ldot+1).toLowerCase();
		var htmlStr = spellShowFileup(sequence,size,name,type);
		$("#show_fileup_detail").html(htmlStr);
		var fileupUrl = ROOT_SERVER+"/video/upload?token="+sessionStorage.getItem("token");
		H5fileup.startFileup(file,fileupUrl,sequence,function(retVO){
			
		});
		var fileupProUrl = ROOT_SERVER+"/getUploadProgress?token="+sessionStorage.getItem("token");
		H5fileup.progressFileup(sequence,fileupProUrl,function(retVO){
			console.log(retVO);
		});
	});
	/**
	 * 拼接上传内容的过程UI
	 */
	var spellShowFileup = function(sequence,size,name,type){
		var htmlStr = "";
		htmlStr += '<div class="up-item" id="'+sequence+'" >'
            +'<div class="inb vat">'
            +'<p>'
            	+'<span class="showfile-name substr" id="'+sequence+'_name" >'+name+'</span>'
            	+'<input class="showfile-name-input" type="text" id="'+sequence+'_name_input" value="'+name+'" />'
            	+'.'+type
            	+'<span class="ml10">'+size+'M</span></p>'
            +'<div class="progress w300 mr20">'
            +'<div class="progress-bar progress-bar-striped active" id="'+sequence+'_process" '
            	+'role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">'
            +'0%'
            +'</div>'
            +'</div>'
            +'<p>上传中</p>'
            +'</div>'
            +'<div class="inb">'
            +'<img src="" width="140" height="80" class="mr20 vab" id="'+sequence+'_show_img">'
            +'<button type="button" class="upbtn sys-img mr20" >选择系统截图</button>'
            +'<button type="button" class="btn fileup-button mr20" style="position: relative;width: 125px;height: 30px;" >'
            +'上传本地图片'
            +'<input type="file" value="" class="input-fileup local-img" style="width: 125px;" accept="image/png,image/jpeg" >'
            +'</button>'
            +'</div>'
            +'<i class="iconfont icon-delete del-fileup"></i>'
            +'</div>';
            return htmlStr;
	}
	/**
	 * 点击可以修改上传文件的名称
	**/
	$("#show_fileup_detail").on("click",".showfile-name",function(){
		var oldName = $(this).html();
		var topDom = $(this).parents(".up-item").get(0);
		var seq = topDom.id;
		$("#"+seq+"_name_input").val(oldName);
		$("#"+seq+"_name").hide();
		$("#"+seq+"_name_input").show();
	});
	/**
	 * 输入名称后移出焦点确定名称
	 */
	$("#show_fileup_detail").on("blur",".showfile-name-input",function(){
		var newName = $(this).val();
		var topDom = $(this).parents(".up-item").get(0);
		var seq = topDom.id;
		$("#"+seq+"_name").html(newName);
		$("#"+seq+"_name_input").hide();
		$("#"+seq+"_name").show();
	});
	/**
	 * 使用系统截图作为封面事件
	**/
	$("#show_fileup_detail").on("click",".sysprint-img",function(){
		
	});
	/**
	 * 使用本地图片作为封面事件
	**/
	$("#show_fileup_detail").on("change",".local-img",function(){
		var file = this.files[0];
		var sequence = H5fileup.getSequence();
		var topDom = $(this).parents(".up-item").get(0);
		var seq = topDom.id;
		/*H5fileup.startFileup(file,ROOT_SERVER+"/image/upload",sequence,function(retVO){
		
		});*/
		H5fileup.showImgAuto(file,seq+"_show_img");
	});
	/**
	 * 删除当前上传的文件
	**/
	$("#show_fileup_detail").on("click",".del-fileup",function(){
		var topDom = $(this).parents(".up-item").get(0);
		$(topDom).remove();
	});
});