document.write('<script language=javascript src="swfobect.js"></script>');
;(function(window, document) {
//修改成AMD模式加载的组件
//;define(function() {
	//需要用new创建的对象
	function Evideo() {
		return this.init(arguments);
	}
	Evideo.fn = Evideo.prototype = {
		init: function() {
			console.log("初始化---Evideo");
			this.objectName = "Evideo";
			return this;
		},
		testInit: function() {
			// 直接打印对象
			console.log(this.objectName);
			return this;
		}
	};
	Evideo.initPlayer = function(_config){
		
	};
	Evideo.clearPlayer = function(_config){
		
	};
	Evideo.changePlayer = function(_config){
		
	};
	//默认全属性配置，仅做参考
	Evideo.def_config = {};
	//return Evideo;
//});
	window.Evideo = Evideo;
})(window, document, undefined);