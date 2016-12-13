/**
* 定义简单的字符串帮助方法
* Create By: Liang.Vm
* 依赖jQuery
* 组件版本：V0.1
**/
//;(function(window, document) {
//修改成AMD模式加载的组件
;define(function() {
	//需要用new创建的对象
	function ValueCheck() {
		return this.init(arguments);
	}
	ValueCheck.fn = ValueCheck.prototype = {
		init: function() {
			console.log("初始化---ValueCheck");
			this.objectName = "ValueCheck";
			return this;
		},
		testInit: function() {
			// 直接打印对象
			console.log(this.objectName);
			return this;
		}
	};
	/**
	 * value是否未定义
	 */
	ValueCheck.isUndefined = function(value){
		return typeof(value) == "undefined";
	};
	/**
	 * value是否为空null,"",''
	 */
	ValueCheck.isNull = function(value){
		if(value == null){
			return true;
		}else{
			return false;
		}
	};
	/**
	 * value是否为空null,"",''
	 */
	ValueCheck.isNullStr = function(value){
		if(value == null){
			return true;
		}
		if(value == ""){
			return true;
		}
	};
	/**
	 * value是否可以转成数字,可以转返回数字，不可以返回false
	 */
	ValueCheck.isNumber = function(value){
		if(ValueCheck.isNull(value)){
			return false;
		}
		if(typeof(value) == "number"){
			return true;
		}else if(typeof(value) == "string"){
			value = value.replace(/[\s]/g,"");
			var tempStr = value.replace(/[0-9]/g,"");
			//console.log(tempStr);
			if(tempStr!=""){
				return false;
			}else{
				return true;
			}
		}
	}
	
	//验证浮点型
	ValueCheck.isFloat = function(value){
		if(ValueCheck.isNull(value)){
			return false;
		}
		if(typeof(value) == "number"){
			return true;
		}else if(typeof(value) == "string"){
			return !isNaN(value);
		} else {
			return false;
		}
	}
	/**
	 * 提取value转成数字，无法转换返回deff，没有deff返回false
	 * 88 = 88
	 * fda88dd = 88
	 */
	ValueCheck.getNumber = function(value,deff){
		var ref = false;
		if(!ValueCheck.isNull(deff)){
			ref = deff;
		}
		if(ValueCheck.isNull(value)){
			return ref;
		}
		if(typeof(value) == "number"){
			return value;
		}
		value = value.replace(/[\s]/g,"");
		var tempStr = value.replace(/[^0-9]/g,"");
		//console.log(tempStr);
		if(tempStr == ""){
			return ref;
		}else{
			return parseInt(tempStr);
		}
	}
	/**
	 * value判断字符串，undefined,null
	 * 返回：''
	 */
	ValueCheck.isNullRe = function(value){
		if(ValueCheck.isNull(value)){
			return '';
		}
		return value;
	};
	/**
	 * 一个英文字符为1，一个汉字为2
	 */
	ValueCheck.mountChar = function(value){
		if(ValueCheck.isNull(value)){
			return 0;
		}
		var len = value.length;
		var chStr = value.replace(/[^\u4e00-\u9fa5 ， 。 ！；“”‘’（）【】？《》：]/gi,"");
		//console.log(chStr);
		var chLen = chStr.length;
		return chLen*2+(len-chLen);
	}
	/**
	 * 一个英文字符为1，一个汉字为2，检查字符串是否太长
	 */
	ValueCheck.isMountChar = function(value,limit){
		var len = ValueCheck.mountChar(value);
		if(len>limit){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 字符个数
	 */
	ValueCheck.lengthStr= function(value){
		if(ValueCheck.isNull(value)){
			return 0;
		}
		return value.length;
	}
	/**
	 * 字符个数，检查字符个数是否太多
	 */
	ValueCheck.isLengthStr = function(value,limit){
		var len = ValueCheck.lengthStr(value);
		if(len>limit){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 检查输入的学校名称是否合法。
	 * 接受：中文数字字母()-_
	 */
	ValueCheck.isSchoolName = function(value){
		value = value.replace(/[\s]/g,"");
		value = value.replace(/[\u4e00-\u9fa5]/g,"");
		value = value.replace(/[\d]/g,"");
		value = value.replace(/[\w]/g,"");
		value = value.replace(/[\(\)\-\_]/g,"");
		if(value==""){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 检查输入的学校名称是否合法。
	 * 接受：中文数字字母()-_
	 */
	ValueCheck.isRoomName = function(value){
		value = value.replace(/[\s]/g,"");
		value = value.replace(/[\u4e00-\u9fa5]/g,"");
		value = value.replace(/[\d]/g,"");
		value = value.replace(/[\w]/g,"");
		value = value.replace(/[\(\)\-\_]/g,"");
		if(value==""){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	// 对Date的扩展，将 Date 转化为指定格式的String   
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
	// 例子：   
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
	Date.prototype.Format = function(fmt){ 
		var o = {   
			"M+" : this.getMonth()+1,                 //月份   
			"d+" : this.getDate(),                    //日   
			"h+" : this.getHours(),                   //小时   
			"m+" : this.getMinutes(),                 //分   
			"s+" : this.getSeconds(),                 //秒   
			"q+" : Math.floor((this.getMonth()+3)/3), //季度   
			"S"  : this.getMilliseconds()             //毫秒   
		};   
		if(/(y+)/.test(fmt))   
			fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		for(var k in o)   
			if(new RegExp("("+ k +")").test(fmt))   
		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		return fmt;   
	}
	/**
	 * 之间转换方法
	 * 将long转成YYY-MM-DD
	 */
	ValueCheck.longToDateYMD = function(times){
		var d = new Date(parseInt(times));
		var dateStr = d.Format("yyyy-MM-dd");
		return dateStr;
	}
	/**
	 * 之间转换方法
	 * 将long转成YYY-MM-DD hh:mm
	 */
	ValueCheck.longToDateYMDHM = function(times){
		var d = new Date(parseInt(times));
		var dateStr = d.Format("yyyy-MM-dd hh:mm");
		return dateStr;
	}
	
	/** 
	* json对象转字符串形式 
	*/ 
	ValueCheck.jsonTostr = function(o){ 
		var arr = [];
		var fmt = function(s) {
		if (typeof s == 'object' && s != null) return json2str(s);
			return /^(string|number)$/.test(typeof s) ? "'" + s + "'" : s; 
		}
		for (var i in o) arr.push("'" + i + "':" + fmt(o[i]));
		return '{' + arr.join(',') + '}';
	} 
	
	/**
	 * 手机号格式验证，返回ture表示为手机号
	 * @param str
	 */
	ValueCheck.isPhoneNumber = function(str){
		if(!(/^1[34578]\d{9}$/.test(str))){
			result = false;
	    }else{
	    	return true;
	    }
	}
	/**
	 * 身份证格式验证，返回ture表示为手机号
	 * @param str
	 */
	ValueCheck.isIden = function(str){
		if(!str || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(str)){
			result = false;
        }else{
        	return true;
        }
	}
	/**
	 * 邮箱格式验证，返回ture表示为手机号
	 * @param str
	 */
	ValueCheck.isEmail = function(str){
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!myreg.test(str)){
			result = false;
		}else{
			return true;
		}
	}
	
	/**
	 * 本方法适用于使用data-vs-*做规则验证的代码。
	 * form表单/div等有模块顶层入口的dom为入口，校验固定的配置规则
	 * 参数：
	 * id == #idStr，顶层元素id
	 * passNull: true表示需要对data-vs-null=1的元素做空值校验，空或者false表示不需要
	 * 
	 * result，返回结果，true表示通过校验，false未通过。
	 */
	ValueCheck.valiByDataVs = function(id,passNull){
		var result = false;
		var topDom = $(id);
		var errorIds = new Array();
		var errorDoms = new Array();
		var nullDoms = $(topDom).find("[data-vs-null=1]");
		var idenDoms = $(topDom).find("[data-vs-iden=1]");
		var emailDoms = $(topDom).find("[data-vs-email=1]");
		var telDoms = $(topDom).find("[data-vs-tel=1]");
		var fileDoms = $(topDom).find("[data-vs-file=1]");
		if(passNull){
			$.each(nullDoms,function(i,dom){
				var value = $.trim($(dom).val());
				if(value == undefined || value == null || value == "" || value.toLowerCase() == "null"){
					$(dom).addClass("boder-vs-error");
					$(dom).data("data-vs-error",true);
					result = false;
					errorDoms.push(dom);
				}
			});
		}
		
		$.each(idenDoms,function(i,dom){
			if($(dom).data("data-vs-error"))return;
			var value = $.trim($(dom).val());
			if(value == undefined || value == null || value == "" || value.toLowerCase() == "null"){
			}else{
				if(!value || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
					$(dom).addClass("boder-vs-error");
					$(dom).data("data-vs-error",true);
					result = false;
					errorDoms.push(dom);
	            }
			}
		});
		
		$.each(emailDoms,function(i,dom){
			if($(dom).data("data-vs-error"))return;
			var value = $.trim($(dom).val());
			if(value == undefined || value == null || value == "" || value.toLowerCase() == "null"){
			}else{
				var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
				if(!myreg.test(value)){
					$(dom).addClass("boder-vs-error");
					$(dom).data("data-vs-error",true);
					result = false;
					errorDoms.push(dom);
				}
			}
		});
		
		$.each(telDoms,function(i,dom){
			if($(dom).data("data-vs-error"))return;
			var value = $.trim($(dom).val());
			if(value == undefined || value == null || value == "" || value.toLowerCase() == "null"){
			}else{
				if(!(/^1[34578]\d{9}$/.test(phone))){
					$(dom).addClass("boder-vs-error");
					$(dom).data("data-vs-error",true);
					result = false;
					errorDoms.push(dom);
			    }
			}
		});
		
		$.each(fileDoms,function(i,dom){
			if($(dom).data("data-vs-error"))return;
			var value = $.trim($(dom).val());
			if(value == undefined || value == null || value == "" || value.toLowerCase() == "null"){
				$(dom).addClass("boder-vs-error");
				$(dom).data("data-vs-error",true);
				result = false;
				errorDoms.push(dom);
			}
		});
		
		$.each(errorDoms,function(i,dom){
			$(dom).focusout(function(){
				$(dom).removeClass("boder-vs-error");
			});
		});
		
		return result;
	}
	
	/**
	 * 通过后台返回的数据，展示验证信息。
	 * 参数：data：domId：输入数据的domId,msg作为错误信息。prefix：用来区分一个页面，有多个相同key作为验证id的字段前缀。
	 */
	ValueCheck.valiByClient = function(domId,msg,prefix){
		var data = {};
		data[domId] = [msg]
		ValueCheck.valiByServer(data,prefix);
	}
	
	/**
	 * 通过后台返回的数据，展示验证信息。
	 * 参数：data：输错信息的数组。prefix：用来区分一个页面，有多个相同key作为验证id的字段前缀。
	 * data: {id:["是数字"]}
	 */
	ValueCheck.valiByServer = function(data,prefix){
		if(this.isNullStr(prefix)){
			prefix = "";
		}
		$.each(data,function(key,values){
			//var name = $("#"+key+"_n").html();
			//var indexStart = name.indexOf(">");
			//name = name.substring(indexStart,name)
			/*var htmlStr = '';
			$.each(values,function(i,v){
				if(i>0){
					htmlStr += '，';
				}
				htmlStr += v;
			});*/
			//$(htmlStr).insertAfter("#"+key+"_n_v");
			//$('<div class="smp-error-tips" ></div>').insertBefore("#"+key)
			$('<div class="smp-error-tips" ></div>').appendTo("#"+prefix+key+"_n_v");
			var errorDom = $("#"+prefix+key+"_n_v").find(".smp-error-tips").get(0);
			var nameDom = $("#"+prefix+key+"_n");
			var left = 0;
			if(nameDom != undefined && nameDom.length>0){
				left = $(nameDom).width();
			}
			var heightThis = $("#"+prefix+key).height();
			$(errorDom).css({"left": left+"px","top":(heightThis)+"px"});
			$(errorDom).html(values[0]);
		});
	}
	/**
	 * 用于清除验证提示信息。
	 */
	ValueCheck.valiClear = function(){
		$(".data-vs-error").remove();
		$(".smp-error-tips").remove();
	}
	
	
	/**
	 * 获取在dom元素里，应该显示的不换行内容+...
	 * width需要是页面要显示的动态计算长度。
	 * 多行，需要计算行数*每行的长度。
	 * 
	 * @param str  width
	 * @returns
	 */
	ValueCheck.subStrForShow = function(str,width){
		width = width - 25;
		var temId = new Date().getTime();
		var temHtml = '<font id="'+temId+'" style="font-size: 14px;" ></font>';
		$(temHtml).appendTo("body");
		$("#"+temId).html(str);
		String.prototype.visualLength = function(){
			var ruler = $("#"+temId);
			ruler.text(this);
			return ruler[0].offsetWidth;
		};
		for(var i = 1; i < str.length; i++){ 
			var data = str.substr(0, i) + '...';
			if(data.visualLength() >= width){ 
				return data; 
			}
		}
		$("#"+temId).remove();
		return str;
	}
		/*String.prototype.visualLength = function(){
			var ruler = $("#ruler"); 
			ruler.text(this); 
			return ruler[0].offsetWidth; 
		};
		var sub = function(str, n){
			for(var i = 1; i < str.length; i++){ 
				var data = str.substr(0, i) + '...';
				if(data.visualLength() >= n){ 
					return data; 
				} 
			}
			return str; 
		};*/
		

	
	ValueCheck.addStaticMethod = function(nmSpace, obj, ftn) {
	};
	ValueCheck.addObjectMethod = function(nmSpace, obj, ftn) {
	};
	return ValueCheck;
});
//window.ValueCheck = ValueCheck;
//})(window, document, undefined);
