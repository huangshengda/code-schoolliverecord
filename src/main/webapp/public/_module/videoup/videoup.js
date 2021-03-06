/**
 * 视频的编辑和新增页面
 * 
 * 使用resourceId用来区分是编辑or新增视频的逻辑
 */
$(function(){
	var laryIndex = null ;
	var resourceId = sessionStorage.getItem("resourceId");
	CDUtil.ajaxPost("/base/subject/list",{},function(retVO){
		var dataVO = retVO.data;
		var allChose = '<option value="';
		var htmlStr = '';
		$(dataVO).each(function(i,data){
			if(i>0){
				allChose += ","+data.subjectId;
			}else{
				allChose += data.subjectId;
			}
			htmlStr += '<option value="'+data.subjectId+'">'+data.subjectName+'</option>';
		});
		allChose += ' >全部</option>';
		$(htmlStr).appendTo("#subjectId");
		if(resourceId != undefined && resourceId != ""){
			CDUtil.ajaxPost("/resource/get",{resourceId: resourceId},function(retVO){
				var data = retVO.data;
				if (retVO.code == 1) {
					$("#subjectId").val(data.subjectId);
				}
			});
		}
	});
	
	CDUtil.ajaxPost("/base/classlevel/list",{},function(retVO){
		$("#classlevelIds").val("");
		var dataVO = retVO.data;
		var allChose = '<span><input type="checkbox" class="chose-grade all" value="';
		var htmlStr = '';
		$(dataVO).each(function(i,data){
			if(i>0){
				allChose += ","+data.classlevelId;
			}else{
				allChose += data.classlevelId;
			}
			htmlStr += '<span><input type="checkbox" class="chose-grade others" value="'+data.classlevelId+'">'+data.classlevelName+'</span>';
		});
		allChose += '" data-type="all">全部</span>';
		$(allChose+htmlStr).appendTo("#show_chose_grade");
		if(resourceId != undefined && resourceId != ""){
			CDUtil.ajaxPost("/resource/get",{resourceId:sessionStorage.getItem("resourceId")},function(retVO){
				var data = retVO.data;
				if (retVO.code == 1) {
					var classlevelIds = data.classlevelId;
					$("#classlevelIds").val(classlevelIds);
					$(".chose-grade.others").each(function(i,dom){
						var classlevelId = $(dom).val();
						if(classlevelIds.indexOf(classlevelId)>-1){
							$(dom).prop("checked",true);
						}
					});
				}
			});
		}
	});
	
	/**编辑上传信息--start**/
	if(resourceId != undefined && resourceId != ""){
		$(".fileup-button").hide();
		$("#resourceId").val(resourceId);
		CDUtil.ajaxPost("/resource/get",{resourceId:sessionStorage.getItem("resourceId")},function(retVO){
			var data = retVO.data;
			if (retVO.code == 1) {
				$('#res_name').val(retVO.data.resourceName);
				$("#auth").val(retVO.data.author);
				$("#video_resourceId").val(data.resourceId);
				$("#video_name").val(data.resourceName);
				$("#video_size").val(data.size);
				$("#video_img_resourceId").val(data.thumbName);
				
				var sequence = H5fileup.getSequence();
				var  htmlStr ='<div class="up-item" id="'+sequence+'" data-resourceid="'+data.resourceId+'">'
					+'<div class="inb vat"><p>'
						+'<span class="showfile-name substr" id="'+sequence+'_name">'+data.resourceName+'</span>'
						+'<input class="showfile-name-input" type="text" id="'+sequence+'_name_input" value="'+data.thumbName+'">'
						+'<span id="'+sequence+'_type">.'+data.type+'</span>'
						+'<span class="ml10">'+(Math.round(data.size * 100 / (1024 * 1024)) / 100)+'M</span>'
						+'</p>'
						+'<div class="progress w300 mr20"><div class="progress-bar progress-bar-striped active" id="'+sequence+'_process" '
							+'role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">100%</div>'
					+'</div>'
					+'</div>'
					+'<div class="inb"><img src="'+data.thumbPath+'" width="140" height="80" class="mr20 vab" id="'+sequence+'_show_img">'
					+'<div type="button" class="btn fileup-button mr20" style="position: relative;width: 125px;height: 30px;">上传本地图片<input type="file" value="" class="input-fileup local-img" style="width: 125px;" accept="image/png,image/jpeg"></div></div></div>';
				$("#show_fileup_detail").html(htmlStr);
			}
		});
	}
	/**编辑上传信息--end**/
	
	/**
	 * 控制选择年级的逻辑
	 */
	$("#show_chose_grade").on("click",".all",function(){
			    if(this.checked){ 
			    	$(".chose-grade.others").prop("checked",true);
			    }else{ 
			    	$(".chose-grade.others").prop("checked",false);
			    } 
			  });
	$("#show_chose_grade").on("click",".chose-grade",function(){
		var checked = $(this).prop("checked");
		if(checked){
			var value = $(this).val();
			$("#classlevelIds").val(value);
			/*if($(this).hasClass("all")){
				$(".chose-grade.others").prop("checked",true);
			}*/
		}else{
			$(".chose-grade.all").prop("checked",false);
		}
		var value = "";
		$(".chose-grade.others").each(function(i,dom){
			$("#classlevelIds").val(value);
			if($(dom).prop("checked")){
				if(value != ""){
					value += ","+$(dom).val();
				}else{
					value += $(dom).val();
				}
			}
		});
		$("#classlevelIds").val(value);
	});
	
	/**
	 * 当点击上传按钮，选中文件发生改变激活重新上传
	 */
	$("#fileup_video").change(function(){
		$("#show_fileup_detail").html("");
		var file = this.files[0];
		var sequence = H5fileup.getSequence();
		var size = (Math.round(file.size * 100 / (1024 * 1024)) / 100);
		var filename = file.name;
		var ldot = filename.lastIndexOf(".");
		var name = filename.substring(0,ldot);
		var type = filename.substring(ldot+1).toLowerCase();
		var refuseType = "$flv$mp4$";
		if(refuseType.indexOf("$"+type+"$")<0){
			layer.msg("选择文件格式不正确");
			return;
		}
		if(size>2048){
			layer.msg("视频太大，请小于2G");
			return;
		}
		var htmlStr = spellShowFileup(sequence,size,name,type);
		$("#video_name").val(filename);
		$("#show_fileup_detail").html(htmlStr);
		var fileupUrl = ROOT_SERVER+"/video/upload?token="+sessionStorage.getItem("token");
		H5fileup.startFileup(file,fileupUrl,sequence,function(retVO){
			retVO = eval('(' + retVO + ')');
			var dataVO = retVO.data;
			var resourceId = dataVO.resourceId;
			$("#"+sequence).attr("data-resourceId",resourceId);
			$("#video_resourceId").val(resourceId);
			$("#video_size").val(file.size);
			$("#"+sequence).find(".sysprint-img-button").show();
			$("#"+sequence+"_status").html("上传成功！");
		});
		var fileupProUrl = ROOT_SERVER+"/getUploadProgress?token="+sessionStorage.getItem("token");
		H5fileup.progressFileup(sequence,fileupProUrl,function(retVO){
			
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
            	+'<span id="'+sequence+'_type" >.'+type+'</span>'
            	+'<span class="ml10">'+size+'M</span></p>'
            +'<div class="progress w300 mr20">'
            +'<div class="progress-bar progress-bar-striped active" id="'+sequence+'_process" '
            	+'role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 0%">'
            +'0%'
            +'</div>'
            +'</div>'
            +'<p id="'+sequence+'_status" >上传中</p>'
            +'</div>'
            +'<div class="inb">'
            +'<img src="'+ROOT_UI+'/public/_module/images/video.png" width="140" height="80" class="mr20 vab" id="'+sequence+'_show_img">'
            +'<button type="button" class="upbtn sysprint-img-button mr20" >选择系统截图</button>'
            +'<div type="button" class="btn fileup-button mr20" style="position: relative;width: 125px;height: 30px;" >'
            +'上传本地图片'
            +'<input type="file" value="" class="input-fileup local-img" style="width: 125px;" accept="image/png,image/jpeg" >'
            +'</div>'
            +'</div>'
            +'<i class="iconfont icon-delete del-fileup"></i>'
            +'</div>'
			+'<p class="ft12 c9">注：图片格式支持png、jpg，最大5M。</p>';
            return htmlStr;
	}
	/**
	 * 显示选择系统截图作为封面事件
	**/
	$("#show_fileup_detail").on("click",".sysprint-img-button",function(){
		var index = layer.load(2);
		$("#show_sysprint_img").html("");
		var topDom = $(this).parents(".up-item").get(0);
		var seq = topDom.id;
		$("#chose_sysimg").attr("data-squence",seq);
		var resourceId = $(topDom).attr("data-resourceid");
		var params = {resourcePath: resourceId};
		CDUtil.ajaxPost("/resource/sysscreenshot/get",params,function(retVO){
			if(retVO.code == 0){
				layer.close(index);
				layer.msg(retVO.msg);
				return;
			}
			var dataVO = retVO.data;
			var len = dataVO.length;
			var rows = Math.ceil(len/3);
			var larH = 150+150*rows;
			$(dataVO).each(function(i,data){
				var resourceId = data.imgId,
				imgSrc = data.imgPath,
				htmlStr = "";
				htmlStr += '<div class="col-md-4 p10" >'
						+ '<img class="img-thumbnail sysprint-img" src="'+imgSrc+'" data-resourceId="'+resourceId+'" >'
						+ '</div>';
				$(htmlStr).appendTo("#show_sysprint_img");
			});
			laryIndex = layer.open({
		          type: 1,
		          title: '选择系统截图作为视频封面',
		          skin: 'layui-layer-rim', //加上边框
		          area: ['700px',larH+'px'], //宽高
		          content: $("#chose_sysimg")
		      });
			layer.close(index); 
		});
	});
	/**
	 * 选择系统返回的视频截图
	 */
	$("#chose_sysimg").on("click",".sysprint-img",function(){
		$("#chose_sysimg .sysprint-img").removeClass("active");
		$(this).addClass("active");
	});
	/**
	 * 选择系统截图做封面，点击确认
	 */
	$("#chose_sysimg_sure").click(function(){
		layer.close(laryIndex);
		var seq = $("#chose_sysimg").attr("data-squence");
		var activeDom = $("#chose_sysimg").find(".active").get(0);
		var resourceId = $(activeDom).attr("data-resourceId");
		$("#"+seq+"_show_img").attr("src", $(activeDom).attr("src"));
		$("#video_img_resourceId").val(resourceId);
	});
	/**
	 * 选择系统截图做封面，点击取消
	 */
	$("#chose_sysimg_cancel").click(function(){
		layer.close(laryIndex);
	});
	/**
	 * 使用本地图片作为封面事件
	**/
	$("#show_fileup_detail").on("change",".local-img",function(){
		var file = this.files[0];
		var sequence = H5fileup.getSequence();
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
		var topDom = $(this).parents(".up-item").get(0);
		var seq = topDom.id;
		var fileupUrl = ROOT_SERVER+"/image/upload?token="+sessionStorage.getItem("token");
		H5fileup.startFileup(file,fileupUrl,sequence,function(retVO){
			retVO = eval('(' + retVO + ')');
			var dataVO = retVO.data;
			var resourceId = dataVO.resourceId;
			H5fileup.showImgAuto(file,seq+"_show_img");
			$("#video_img_resourceId").val(resourceId);
			$("#video_img_flag").val("1");
		});
	});
	/**
	 * 删除当前上传的文件
	**/
	$("#show_fileup_detail").on("click",".del-fileup",function(){
		var topDom = $(this).parents(".up-item").get(0);
		$(topDom).remove();
	});
	/**
	 * 点击保存按钮，保存信息到后台
	 */
	$("#save_video_info").click(function(){
		var params = $('#form_save_videoup').serializeJSON();
		var result = Validation.validation({
			containerId: "form_save_videoup"
		});
		if(!result){return;}
		if(resourceId != undefined && resourceId != ""){
			CDUtil.ajaxPost("/resource/update",params,function(retVO){
				if(retVO.code == 0){
					layer.msg(retVO.msg);
					return;
				}
				layer.msg('修改视频信息成功');
				if(sessionStorage.getItem("upload")=="source"){
					setTimeout(function(){
						window.location.href = ROOT_SERVER+"/#/basic/source";
					},1000);
					sessionStorage.removeItem("upload");
				}else{
					setTimeout(function(){
						window.location.href = ROOT_SERVER+"/#/basic/upload";
					},1000);
				}
			});
		}else{
			CDUtil.ajaxPost("/resource/addresource",params,function(retVO){
				if(retVO.code == 0){
					layer.msg(retVO.msg);
					return;
				}
				layer.msg('上传视频成功！');
				if(sessionStorage.getItem("mysub")=="subject"){
					setTimeout(function(){
						window.location.href = ROOT_SERVER+"/#/mySubject";
					},1000);
				}else{
					setTimeout(function(){
						window.location.href = ROOT_SERVER+"/#/basic/upload";
					},1000);
				}
			});
		}
	});
});