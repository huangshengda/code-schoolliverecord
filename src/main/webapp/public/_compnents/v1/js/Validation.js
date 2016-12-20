/**
 * 功能描述：定义建议适用的验证框架。
 * 
 * 依赖：jQuery.js，表单模板（html结构和css）
 * 创建人：liangjifei
**/
/**
使用实例：
<input type="text" class="w150 h30" data-vali="notnull,email" data-vali-top="0px" data-vali-left="0px" data-vali-extend="umeditor" />

说明：在需要做验证的信息入口加上配置。
参数API：
data-vali:需要做验证的类型；
data-vali-left：验证结果显示的left位置。（可不填，默认相对父级0px
data-vali-top：验证结果显示的top位置。（可不填，默认相对父级的高度px
data-vali-extend: 扩展针对特殊输入组件的验证，比如富文本框umeditor，采用特殊的方式获取结果处理。（可不填，默认为input,select等表单元素
值域API：
data-vali的值域集合有：
"notnull"：不能为空
"username"：用户名
"password"：密码
"number"：整数
"float"：数字（包括整数和小数
"phone"：手机号码
"telphone"：固定电话
"email"：邮箱
"idcard"：身份证
"areacode"：邮编
**/

//;(function(window,document){
//修改成AMD模式加载的组件
;define(function() {
	'use strict';//发布时可注释

	var Validation = function(){};
	//默认的配置。
	Validation.def_config = {
		containerId: "use_to_load_grid",//包含元素的Top容器id
		formId: "",//form表单的id
		submitFun: function(){}//可为空，验证成功后，发起提交表单的方法
	};
	//匹配不通过时，对应的提示
	Validation.errorMsg = {
		notnull: "不能为空",
		username: "用户名有非法字符，请重输",
		password: "密码有非法字符，请重输",
		number: "必须是整数",
		float: "必须是数字",
		phone: "手机号不合法",
		telphone: "固定电话不合法",
		email: "邮箱不合法",
		idcard: "身份证不合法",
		areacode: "邮编不合法",
		special: "不能输入特殊字符"
	};
	/**
	 * 本方法适用于使用data-vali-*做规则验证。
	 * 发起验证
	 * 
	 * 参数：
	 * _config：激活验证的配置（参考Validation.def_config
	 * callback: 验证结束的回调方法
	 * 
	 * 返回结果：true表示通过校验，false未通过。
	 */
	Validation.validation = function(_config,callback){
		var containerId = _config.containerId;
		var formId = _config.formId;
		var submitFun = _config.submitFun;
		$("#"+containerId).find(".cd-f-vali").remove();
		var valiDoms = $("#"+containerId).find("[data-vali]");
		var result = true;
		//console.log(valiDoms);
		$.each(valiDoms,function(i,dom){
			var vali = $(dom).attr("data-vali");
			var valiEntend = $(dom).attr("data-vali-extend");
			var valueDom = $(dom).parents(".cd-f-value").get(0);
			var msg = "";
			var value = $(dom).val();
			if(valiEntend == "umeditor"){
				//关于富文本框的验证
			}
			msg = Validation.matchRule(vali,value);
			if(msg == ""){
				//console.log(msg+"：本次验证通过");
			}else{
				result = false;
				var idTemp = new Date().getTime();
				var htmlStr = '<div class="cd-f-vali" id="'+idTemp+'_vali" ';
				htmlStr += '>'+msg+'</div>';
				$(htmlStr).appendTo(valueDom);
				if ($(dom).attr("data-vali-top")) {
					$("#"+idTemp+"_vali").css("top",$(dom).attr("data-vali-top"));
				}
				if ($(dom).attr("data-vali-left")) {
					$("#"+idTemp+"_vali").css("left",$(dom).attr("data-vali-left"));
				}
			}
		});
		//验证通过，如果设置提交方法，自动发起，否则返回ture
		if(result){
			if(typeof(submitFun) === "function") {
				submitFun();
			}else{
				return result;
			}
		}else{//验证不通过，显示错误提示，返回ture
			return result;
		}
	};
	/**
	 * 本方法适用于使用data-vali-*做规则验证的方法。
	 * 
	 * 参数：
	 * vali：在dom元素上配置的验证规则
	 * value：dom元素对应的输入值
	 * 
	 * 返回结果：true表示通过校验，false未通过。
	 */
	Validation.matchRule = function(vali,value){
		var msg = "";
		var rgxStr = "" ;
		if(vali.indexOf("notnull")>-1){
			if($.trim(value) == ""){
				msg = Validation.errorMsg["notnull"];
			}
		}
		if(vali.indexOf("username")>-1){
			console.log(value);
			rgxStr = /^[,.;~!@#$%^&*()_+-=\/<>a-zA-Z0-9]{6,18}$/g;
			if(!rgxStr.test(value)){
				msg = Validation.errorMsg["username"];
			}
		}else if(vali.indexOf("password")>-1){
			console.log(value);
			rgxStr = /^[,.;~!@#$%^&*()_+-=\/<>a-zA-Z0-9]{6,18}$/g;
			if(!rgxStr.test(value)){
				msg = Validation.errorMsg["password"];
			}
		}else if(vali.indexOf("number")>-1){
			if(!ValueCheck.isNumber(value)){
				msg = Validation.errorMsg["number"];
			}
		}else if(vali.indexOf("float")>-1){
			if(!ValueCheck.isFloat(value)){
				msg = Validation.errorMsg["float"];
			}
		}else if(vali.indexOf("phone")>-1){
			if(!ValueCheck.isPhoneNumber(value)){
				msg = Validation.errorMsg["phone"];
			}
		}else if(vali.indexOf("telphone")>-1){
			if(!ValueCheck.isTelphone(value)){
				msg = Validation.errorMsg["telphone"];
			}
		}else if(vali.indexOf("email")>-1){
			if(!ValueCheck.isEmail(value)){
				msg = Validation.errorMsg["email"];
			}
		}else if(vali.indexOf("idcard")>-1){
			if(!ValueCheck.isIden(value)){
				msg = Validation.errorMsg["idcard"];
			}
		}else if(vali.indexOf("areacode")>-1){
			if(!ValueCheck.isAreacode(value)){
				msg = Validation.errorMsg["areacode"];
			}
		}else if(vali.indexOf("special")>-1){
			rgxStr = /[`~!@#$^&*()=|{}':;',\\[\\]/;
			if(rgxStr.test(value)){
				msg = Validation.errorMsg["special"];
			}
		}
		return msg;
	};
	return Validation;
});
//window.Validation = Validation;
//})(window,document,undefined);