webpackJsonp([4,6],{

/***/ 0:
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	/**  加载基础CSS文件  **/
	__webpack_require__(130);
	/*window.Vue = require('vue');
	window.VueResource = require('vue-resource');*/

/***/ },

/***/ 130:
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(131);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(86)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(131, function() {
				var newContent = __webpack_require__(131);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },

/***/ 131:
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "@charset \"utf-8\";\r\n    /* 直播课程详情 start*/\r\n.live{\r\n  margin-top:50px;\r\n}\r\n.l-left{\r\n  display: inline-block;\r\n  width: 918px; }\r\n  .chat-bland{\r\n    background-color: #fff;}\r\n    ul{\r\n      color:#444;\r\n      padding:0 10px;\r\n      height: 326px;\r\n      overflow-y: auto;}\r\n      .c-content{\r\n        display: inline-block;\r\n        width:195px;}\r\n        .c-time {color:#999;margin-left:10px;}\r\n\r\n      .c-del{color:#999;margin-top:10px;cursor: pointer;}\r\n\r\n .l-title{\r\n      font-size:20px;\r\n      color:#222;\r\n      line-height: 35px;\r\n    }\r\n.l-title small{\r\n        color:#666;\r\n      }\r\n.vedio{\r\n      width: 100%;\r\n    height: 562px;\r\n    position: relative;\r\n\r\n}\r\n.l-right{\r\n  width: 281px;\r\n  border:1px solid #ececec;\r\n  border-top:1px solid #34a150;\r\n  }\r\n  .right-head{\r\n    height:45px;\r\n    line-height: 45px;\r\n    color:#34a150;\r\n    padding: 0 15px;\r\n    border-bottom:1px solid #ececec;\r\n  }\r\n  .bar{\r\n    margin-top:20px;\r\n    border-radius: 1px;\r\n    box-shadow: 0 1px 1px rgba(0,0,0,.05);\r\n    background-color: #f5f5f5;\r\n    height:23px;\r\n    border: 1px solid #DDDDDD;\r\n  }\r\n\r\n.c-text{\r\n  padding: 10px;\r\n  background-color: #f5f5f5;}\r\n  .c-text textarea{\r\n    width:258px;\r\n    height:80px;\r\n  }\r\n.c-text button{ margin-right: 9px;padding:2px 14px;margin-top:8px;margin-bottom:4px;}\r\n", ""]);

	// exports


/***/ }

});