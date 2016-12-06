/**
 * 功能描述：扩展部分用于全局的公共方法。
 * 组件类型：自定义JS方法
 * 
 * 依赖：jQuery.js ，服务器根目录ROOT_SERVER
 * 创建人：liangjifei
 */
//;(function(window,document,undefined){
//修改成AMD模式加载的组件
;define(function() {
	var CDUtil = function(){};
	CDUtil.EVENT_MANAGER = {};
	/**
	 * 异步请求，post类型。
	 * 
	 * 传入参数：
	 * url：请求链接，params：传递参数{key:value,key:value}，
	 * callback：请求结束后回调，isCrossDomain：是否跨域（非必填，默认不跨域）。
	 */
	CDUtil.ajaxPost = function(url,params,callback,isCrossDomain){
		var _config = {
			url: url,
			type: 'POST',
			dataType: "json",
			data: params,
			success: function(ret){
				if(typeof(callback) == "function" ){
					callback(ret);
				}
			}
		};
		if(url.substr(0,"/".length)=="/"){
			_config.url = ROOT_SERVER+url;
		}
		if(isCrossDomain){
			_config.crossDomain = isCrossDomain;
		}
		$.ajax(_config);
	};
	/**
	 * 异步请求，get类型。
	 * 
	 * 传入参数：
	 * url：请求链接，params：传递参数{key:value,key:value}，
	 * callback：请求结束后回调，isCrossDomain：是否跨域（非必填，默认不跨域）。
	 */
	CDUtil.ajaxGet = function(url,params,callback,isCrossDomain){
		var _config = {
			url: ROOT_SERVER+url,
			type: 'GET',
			dataType: "json",
			data: params,
			success: function(ret){
				if(typeof(callback) == "function" ){
					callback(ret);
				}
			}
		};
		if(url.substr(0,"/".length)=="/"){
			_config.url = ROOT_SERVER+url;
		}
		if(isCrossDomain){
			_config.crossDomain = isCrossDomain;
		}
		$.ajax(_config);
	};
	
	/**
	 * 事件操作拦截器
	 * 
	 * 传入参数：
	 * callback：请求结束后回调。
	 */
	CDUtil.eventMng = function(callback){
		if(typeof(callback) == "function" ){
			var times = new Date().getTime();
			var key = "EVENT_"+times;
			this.EVENT_MANAGER.key = callback;
			callback(function(){
				delete this.EVENT_MANAGER[key];
			});
		}
	};
	

	/***
	 * 将字符串中的标签结构<解析为&lt;的方式
	 * 
	 * 传入参数：有< >的字符串
	 * 返回：替换成它的实体编号转义字符的字符串
	 */
	CDUtil.html2Escape = function(str) {
		if(typeof(str)=="string"){
		    return str.replace(/[<>&"']/g, function(c) {
		        return {
		            '<': '&lt;',
		            '>': '&gt;',
		            '&': '&amp;',
		            '"': '&quot;',
		            "'":'&apos;'
		        }[c];
		    });
		}else{
			return str;
		}
	};
	/***
	 * 将包含实体编号转义字符的字符串解析成html方式
	 * 
	 * 传入参数：有实体编号转义字符的字符串
	 * 返回：替换成它的< >等的hmlt字符串
	 */
	CDUtil.escape2Html = function(str) {
		if(typeof(str)=="string"){
		    return str.replace(/&(lt|gt|amp|quot);/g, function(c) {
		        return {
		        	'&lt;': '<',
		        	'&gt;':'>' ,
		        	'&amp;':'&',
		        	'&quot;': '"',
		        	'&apos;':"'"
		        }[c];
		    });
		}else{
			return str;
		}
	};
	return CDUtil;
});	
//window.CDUtil = CDUtil;
//})(window,document);