/**
* 定义系统中使用的HTML5做文件上传
* 
* Create By: Liang.Vm
* 组件版本：smp（因为互动学习平台的后端代码不能支持前端调整，所以，在V530中，上传组件绑定了业务。
* 表示在smp项目下的分支，尽可能抽取最少代码做成跨平台的公用上传组件。
* 升级目标：保留基本的，上传，进度，过滤方法，去除业务相关部分。
* 
**/

//;(function(window, document) {
//修改成AMD模式加载的组件
;define(function() {
	//需要用new创建的对象
	function H5fileup() {
		return this.init(arguments);
	}
	H5fileup.fn = H5fileup.prototype = {
		init: function() {
			console.log("初始化---H5fileup");
			this.objectName = "H5fileup";
			return this;
		},
		testInit: function() {
			// 直接打印对象
			console.log(this.objectName);
			return this;
		}
	};
	
	//默认的全部配置，以及注释说明
	H5fileup.def_config = {
		allow_type: "$png$,$doc$,$docx$",//只接受的文件类型，大小写不敏感，非必填
		refuse_type: "$png$,$doc$,$docx$",//只拒绝的文件类型，大小写不敏感，非必填
		auto_up: true,//true选中后自动发起上传，非必填
		multi_up: true,//true是支持多次文件累计上传，非必填
		show_fun: function(){},//上传后设置显示上传文件的回调方法，非必填
		show_container: "",//长传完成后显示的区域，非必填，这里的业务相对复杂，暂不展开讲，遇到可以问我，需要和后台协调。
		max_size: 10,//上传的单个文件最大，单位M，非必填，默认值：10
		max_count: 10,//最多上传文件大小，非必填，这里的业务相对复杂，暂不展开讲，遇到可以问我，依赖show_container。
		success: function(){},//文件上传成功的回调方法，非必填
		error: function(){},//文件上传失败的回调方法，非必填
		loading: function(){}//文件上传过程中调用的方法，非必填
	};
	
	/**
	 * 初始化选中文件的方法
	 * 
	 * @param _config
	 * @param fileupDom
	 */
	H5fileup.initFileupChange = function(_config,fileupDom){
		//初始化配置项
		var allow_type = _config.allow_type==undefined?false:_config.allow_type.toLowerCase(),
		refuse_type = _config.refuse_type==undefined?false:_config.refuse_type.toLowerCase(),
		auto_up = _config.auto_up == undefined?true:_config.multi_up,
		multi_up = _config.multi_up == undefined?true:_config.multi_up,
		show_fun = _config.show_fun,
		show_container = _config.show_container,
		max_size = _config.max_size == undefined?false:_config.max_size,
		max_count = _config.max_count,
		callback = _config.callback;
		fileList = fileupDom;
		var length = fileList.files.length;
		//判断是否支持累计上传
		if(!multi_up){
			$("#"+show_container).html("");
		}
		for (var i = 0; i < length; i++) {
			var file = fileList.files[i];
			if (file) {
				//获取全局唯一标示
				var sequence = H5fileup.getSequence();
				//过滤文件大小，名称，类型属性
				var size = (Math.round(file.size * 100 / (1024 * 1024)) / 100);
				var filename = file.name;
				var ldot = filename.lastIndexOf(".");
				var name = filename.substring(0,ldot);
				var type = filename.substring(ldot+1).toLowerCase();
				//显示上传文件过程的回调方法。
				if(typeof show_fun === "function"){
					this.fileup_loading(true);
					show_fun(file,{size: size,name: name,type: type,sequence: sequence,i: i});
				}
			}
		}
		//console.log(new Date().getTime());
	};
	
	/**
	 * 上传过程中的等待方法。
	 * @param type true:显示等待，false取消等待。
	 */
	H5fileup.fileup_loading = function(type){
		if(type){
			var htmlStr = '<div class="h5filepu-load-wap" >'
				+'<span style="color: #ffffff;font-size: 18px;font-weight: 900;">正在上传...</span>'
				+'<img src="'+ROOT+'/public/smpui/v1/images/file_loading.gif" /><lable>X</lable></div>';
			$(htmlStr).appendTo("body");
			$(".h5filepu-load-wap>lable").click(function(){
				$($(this).parent()).remove();
			});
		}else{
			$(".h5filepu-load-wap").remove();
		}
	}
	
	/**
	 * 为每个上传文件添加唯一标识
	 */
	H5fileup.getSequence = function(){
		function fRandomBy(under, over) {
			switch (arguments.length) {
			case 1:
				return parseInt(Math.random() * under + 1);
			case 2:
				return parseInt(Math.random() * (over - under + 1) + under);
			default:
				return 0;
			}
		}
		return new Date().getTime()+"_"+fRandomBy(1,100);
	}
	
	/**
	 * 用来判断文件是否可以进行上传
	 * 
	 * @param fileList
	 */
	H5fileup.canFileup = function(file_attr,_config){
		var type = file_attr.type;
		var allow_type = _config.allow_type;
		var refuse_type = _config.refuse_type;
		if(allow_type.indexOf("$")>-1 && allow_type.indexOf("$"+type+"$")<0){
			return false;//过滤不包含在可使用的类型。
		}
		if(refuse_type.indexOf("$")>-1 && refuse_type.indexOf("$"+type+"$")>-1){
			return false;//过滤禁止使用的类型。
		}
		return true;
	}
	
	/**
	 * 用来判断文件是否属于支持上传的文件类型
	 * 
	 * @param fileList
	 */
	H5fileup.isFileup = function(file_attr,_config){
		var type = file_attr.type;
		var allow_type = _config.allow_type;
		var refuse_type = _config.refuse_type;
		if(allow_type.indexOf("$")>-1 && allow_type.indexOf("$"+type+"$")<0){
			return false;//过滤不包含在可使用的类型。
		}
		if(refuse_type.indexOf("$")>-1 && refuse_type.indexOf("$"+type+"$")>-1){
			return false;//过滤禁止使用的类型。
		}
		return true;
	}
	
	/**
	 * 用来得到需要过滤的有效上传换文件数组
	 * 
	 * @param fileList
	 */
	H5fileup.filterFileup = function(fileList,allow_type,refuse_type){
		var upFileList = new Array();
		var k = 0;
		for(var i=0;i<fileList.files.length;i++){
			var file = fileList.files[i];
			var filename = file.name;
			var ldot = filename.lastIndexOf(".");
			var name = filename.substring(0,ldot);
			var type = filename.substring(ldot).toLowerCase();
			if(allow_type.indexOf("$")>-1 && allow_type.indexOf("$"+type+"$")>-1){
				upFileList[k] = file;
				k++;
			}
			if(refuse_type.indexOf("$")>-1 && refuse_type.indexOf("$"+type+"$")<0){
				upFileList[k] = file;
				k++;
			}
		}
		return upFileList;
	}
	
	/**
	 * 进行文件上传的方法
	 * 
	 * @param file
	 * @param sequence
	 */
	H5fileup.startFileup = function(file,fileupUrl,sequence,callback){
		var longS = new Date().getTime();
		var formData = new FormData();//构造空对象，下面用append 方法赋值。  
		//formData.append("sequence", sequence);
		formData.append("file", file);
		$.ajax({
			//Server script to process data
			url: fileupUrl+"&sequence="+sequence,
			type: 'POST',
			// Form data
			data: formData,
			//准许发起跨域
			crossDomain: true,
			//Options to tell jQuery not to process data or worry about content-type.  
			cache: false,
			contentType: false,
			processData: false,
			//Ajax events
			//beforeSend: beforeSendHandler,
			success: function(ret){
				if(typeof(callback) == "function"){
					callback(ret);
				}
			}
		});
	};

	/**
	 * 轮训得到唯一标识的方法
	 * callback：上传完成后回调方法。
	 * 
	 * @param sequence
	 */
	H5fileup.progressFileup = function(sequence,fileupProUrl,callback){
		//var interval = setInterval(function(){
			var reValue = H5fileup.getProgress(sequence,fileupProUrl);
			//console.log(reValue);
			var value = 0 ;
			if(reValue == "error"){
				
			}else{
				value = parseInt(reValue);
				$("#"+sequence+"_process").html(""+value+"%");
				$("#"+sequence+"_process").css({
					"width": value+"%"
				});
				if(value < 100){
					//clearInterval(interval);
					setTimeout(function(){
						H5fileup.progressFileup(sequence,fileupProUrl);
					},1000);
				}
			}
			if(value == 100){
				//clearInterval(interval);
				if(typeof(callback) == "function"){
					callback();
				}
			}
		//}, 1000);
	};
	
	/**
	 * 进行获得已上传文件大小的方法
	 * 
	 * @param sequence
	 */
	H5fileup.getProgress = function(sequence,fileupProUrl){
		var value = "" ;
		$.ajax({
			type: "post",
			async: false,
			url: fileupProUrl+"&sequence="+sequence,
			cache: false,
			dataType: "json",
			jsonp: "jsonpCallback",
			success: function(retVO) {
				value = retVO.data;
			},
			error: function(e) {
				value = "error" ;
			}
			//complete: function(){}
		});
		return value;
	};
	
	/**
	 * 将大文件分割成小块
	 * 
	 * @param file
	 * @param eveSize
	 * @returns {Array}
	 */
	H5fileup.splitFile = function(file,eveSize){
		var splitFiles = [];
		var size = file.size;
		var len = Math.ceil(size/eveSize);
		var start = 0;
		var end = eveSize;
		for(var i=0;i<len;i++){
			start = i*eveSize;
			end = (i+1)*eveSize;
			if(end>size){
				end = size;
			}
			splitFiles[i] = file.slice(start,end);
		}
		return splitFiles;
	}
	
	/**
	 * 生成上传的图片预览
	 * 
	 * @param file ,imgId
	 */
	H5fileup.showImgAuto = function(file,imgId){
		var reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = function(evt) {
			document.getElementById(imgId).src = evt.target.result;
		}
	}
	
	/**
	 * 静态方法拓展区
	 */
	H5fileup.addStaticMethod = function(nmSpace, obj, ftn) {
	};
	/**
	 * 对象方法拓展区
	 */
	H5fileup.addObjectMethod = function(nmSpace, obj, ftn) {
	};

	return H5fileup;
});
//window.H5fileup = H5fileup;
//})(window, document,undefined);