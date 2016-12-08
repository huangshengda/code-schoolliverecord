webpackJsonp([1,3,4],[
/* 0 */,
/* 1 */,
/* 2 */,
/* 3 */,
/* 4 */,
/* 5 */,
/* 6 */,
/* 7 */
/***/ function(module, exports, __webpack_require__) {

	var map = {
		"./basic.vue": 8,
		"./basic/context/comment.vue": 36,
		"./basic/context/component.vue": 39,
		"./basic/context/default.vue": 44,
		"./basic/context/management.vue": 47,
		"./basic/context/platform.vue": 50,
		"./basic/context/server.vue": 53,
		"./basic/context/source.vue": 56,
		"./basic/context/upload.vue": 61,
		"./demand.vue": 64,
		"./home.vue": 67
	};
	function webpackContext(req) {
		return __webpack_require__(webpackContextResolve(req));
	};
	function webpackContextResolve(req) {
		return map[req] || (function() { throw new Error("Cannot find module '" + req + "'.") }());
	};
	webpackContext.keys = function webpackContextKeys() {
		return Object.keys(map);
	};
	webpackContext.resolve = webpackContextResolve;
	module.exports = webpackContext;
	webpackContext.id = 7;


/***/ },
/* 8 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(9)

	/* script */
	__vue_exports__ = __webpack_require__(13)

	/* template */
	var __vue_template__ = __webpack_require__(35)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-743091b2", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-743091b2", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] basic.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 9 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(10);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(10, function() {
				var newContent = __webpack_require__(10);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 10 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n.left{width:240px;border:1px solid #ddd;margin-right:10px;background-color: #fff;padding:0 15px;text-align: center;margin-top:40px;min-height: 600px;\n}\n.right{width:880px;\n}\n.main{margin-top:10px;\n}\n.subBtn{height:40px;\n}\n.dashboard{border:1px solid #ddd;background-color: #fff;padding: 20px;\n}\n.layBox{display: none;\n}\n", ""]);

	// exports


/***/ },
/* 11 */
/***/ function(module, exports) {

	/*
		MIT License http://www.opensource.org/licenses/mit-license.php
		Author Tobias Koppers @sokra
	*/
	// css base code, injected by the css-loader
	module.exports = function() {
		var list = [];

		// return the list of modules as css string
		list.toString = function toString() {
			var result = [];
			for(var i = 0; i < this.length; i++) {
				var item = this[i];
				if(item[2]) {
					result.push("@media " + item[2] + "{" + item[1] + "}");
				} else {
					result.push(item[1]);
				}
			}
			return result.join("");
		};

		// import a list of modules into the list
		list.i = function(modules, mediaQuery) {
			if(typeof modules === "string")
				modules = [[null, modules, ""]];
			var alreadyImportedModules = {};
			for(var i = 0; i < this.length; i++) {
				var id = this[i][0];
				if(typeof id === "number")
					alreadyImportedModules[id] = true;
			}
			for(i = 0; i < modules.length; i++) {
				var item = modules[i];
				// skip already imported module
				// this implementation is not 100% perfect for weird media query combinations
				//  when a module is imported multiple times with different media queries.
				//  I hope this will never occur (Hey this way we have smaller bundles)
				if(typeof item[0] !== "number" || !alreadyImportedModules[item[0]]) {
					if(mediaQuery && !item[2]) {
						item[2] = mediaQuery;
					} else if(mediaQuery) {
						item[2] = "(" + item[2] + ") and (" + mediaQuery + ")";
					}
					list.push(item);
				}
			}
		};
		return list;
	};


/***/ },
/* 12 */
/***/ function(module, exports, __webpack_require__) {

	/*
		MIT License http://www.opensource.org/licenses/mit-license.php
		Author Tobias Koppers @sokra
	*/
	var stylesInDom = {},
		memoize = function(fn) {
			var memo;
			return function () {
				if (typeof memo === "undefined") memo = fn.apply(this, arguments);
				return memo;
			};
		},
		isOldIE = memoize(function() {
			return /msie [6-9]\b/.test(window.navigator.userAgent.toLowerCase());
		}),
		getHeadElement = memoize(function () {
			return document.head || document.getElementsByTagName("head")[0];
		}),
		singletonElement = null,
		singletonCounter = 0,
		styleElementsInsertedAtTop = [];

	module.exports = function(list, options) {
		if(false) {
			if(typeof document !== "object") throw new Error("The style-loader cannot be used in a non-browser environment");
		}

		options = options || {};
		// Force single-tag solution on IE6-9, which has a hard limit on the # of <style>
		// tags it will allow on a page
		if (typeof options.singleton === "undefined") options.singleton = isOldIE();

		// By default, add <style> tags to the bottom of <head>.
		if (typeof options.insertAt === "undefined") options.insertAt = "bottom";

		var styles = listToStyles(list);
		addStylesToDom(styles, options);

		return function update(newList) {
			var mayRemove = [];
			for(var i = 0; i < styles.length; i++) {
				var item = styles[i];
				var domStyle = stylesInDom[item.id];
				domStyle.refs--;
				mayRemove.push(domStyle);
			}
			if(newList) {
				var newStyles = listToStyles(newList);
				addStylesToDom(newStyles, options);
			}
			for(var i = 0; i < mayRemove.length; i++) {
				var domStyle = mayRemove[i];
				if(domStyle.refs === 0) {
					for(var j = 0; j < domStyle.parts.length; j++)
						domStyle.parts[j]();
					delete stylesInDom[domStyle.id];
				}
			}
		};
	}

	function addStylesToDom(styles, options) {
		for(var i = 0; i < styles.length; i++) {
			var item = styles[i];
			var domStyle = stylesInDom[item.id];
			if(domStyle) {
				domStyle.refs++;
				for(var j = 0; j < domStyle.parts.length; j++) {
					domStyle.parts[j](item.parts[j]);
				}
				for(; j < item.parts.length; j++) {
					domStyle.parts.push(addStyle(item.parts[j], options));
				}
			} else {
				var parts = [];
				for(var j = 0; j < item.parts.length; j++) {
					parts.push(addStyle(item.parts[j], options));
				}
				stylesInDom[item.id] = {id: item.id, refs: 1, parts: parts};
			}
		}
	}

	function listToStyles(list) {
		var styles = [];
		var newStyles = {};
		for(var i = 0; i < list.length; i++) {
			var item = list[i];
			var id = item[0];
			var css = item[1];
			var media = item[2];
			var sourceMap = item[3];
			var part = {css: css, media: media, sourceMap: sourceMap};
			if(!newStyles[id])
				styles.push(newStyles[id] = {id: id, parts: [part]});
			else
				newStyles[id].parts.push(part);
		}
		return styles;
	}

	function insertStyleElement(options, styleElement) {
		var head = getHeadElement();
		var lastStyleElementInsertedAtTop = styleElementsInsertedAtTop[styleElementsInsertedAtTop.length - 1];
		if (options.insertAt === "top") {
			if(!lastStyleElementInsertedAtTop) {
				head.insertBefore(styleElement, head.firstChild);
			} else if(lastStyleElementInsertedAtTop.nextSibling) {
				head.insertBefore(styleElement, lastStyleElementInsertedAtTop.nextSibling);
			} else {
				head.appendChild(styleElement);
			}
			styleElementsInsertedAtTop.push(styleElement);
		} else if (options.insertAt === "bottom") {
			head.appendChild(styleElement);
		} else {
			throw new Error("Invalid value for parameter 'insertAt'. Must be 'top' or 'bottom'.");
		}
	}

	function removeStyleElement(styleElement) {
		styleElement.parentNode.removeChild(styleElement);
		var idx = styleElementsInsertedAtTop.indexOf(styleElement);
		if(idx >= 0) {
			styleElementsInsertedAtTop.splice(idx, 1);
		}
	}

	function createStyleElement(options) {
		var styleElement = document.createElement("style");
		styleElement.type = "text/css";
		insertStyleElement(options, styleElement);
		return styleElement;
	}

	function addStyle(obj, options) {
		var styleElement, update, remove;

		if (options.singleton) {
			var styleIndex = singletonCounter++;
			styleElement = singletonElement || (singletonElement = createStyleElement(options));
			update = applyToSingletonTag.bind(null, styleElement, styleIndex, false);
			remove = applyToSingletonTag.bind(null, styleElement, styleIndex, true);
		} else {
			styleElement = createStyleElement(options);
			update = applyToTag.bind(null, styleElement);
			remove = function() {
				removeStyleElement(styleElement);
			};
		}

		update(obj);

		return function updateStyle(newObj) {
			if(newObj) {
				if(newObj.css === obj.css && newObj.media === obj.media && newObj.sourceMap === obj.sourceMap)
					return;
				update(obj = newObj);
			} else {
				remove();
			}
		};
	}

	var replaceText = (function () {
		var textStore = [];

		return function (index, replacement) {
			textStore[index] = replacement;
			return textStore.filter(Boolean).join('\n');
		};
	})();

	function applyToSingletonTag(styleElement, index, remove, obj) {
		var css = remove ? "" : obj.css;

		if (styleElement.styleSheet) {
			styleElement.styleSheet.cssText = replaceText(index, css);
		} else {
			var cssNode = document.createTextNode(css);
			var childNodes = styleElement.childNodes;
			if (childNodes[index]) styleElement.removeChild(childNodes[index]);
			if (childNodes.length) {
				styleElement.insertBefore(cssNode, childNodes[index]);
			} else {
				styleElement.appendChild(cssNode);
			}
		}
	}

	function applyToTag(styleElement, obj) {
		var css = obj.css;
		var media = obj.media;
		var sourceMap = obj.sourceMap;

		if (media) {
			styleElement.setAttribute("media", media);
		}

		if (sourceMap) {
			// https://developer.chrome.com/devtools/docs/javascript-debugging
			// this makes source maps inside style tags work properly in Chrome
			css += '\n/*# sourceURL=' + sourceMap.sources[0] + ' */';
			// http://stackoverflow.com/a/26603875
			css += "\n/*# sourceMappingURL=data:application/json;base64," + btoa(unescape(encodeURIComponent(JSON.stringify(sourceMap)))) + " */";
		}

		if (styleElement.styleSheet) {
			styleElement.styleSheet.cssText = css;
		} else {
			while(styleElement.firstChild) {
				styleElement.removeChild(styleElement.firstChild);
			}
			styleElement.appendChild(document.createTextNode(css));
		}
	}


/***/ },
/* 13 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var Sidebar = __webpack_require__(14);
	var Levelbar = __webpack_require__(25);
	exports.default = {
	  name: 'app',
	  components: {
	    Sidebar: Sidebar,
	    Levelbar: Levelbar
	  }
	};

/***/ },
/* 14 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(15)

	/* script */
	__vue_exports__ = __webpack_require__(17)

	/* template */
	var __vue_template__ = __webpack_require__(24)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\_commons\\layout\\Sidebar.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-56246de2"

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-56246de2", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-56246de2", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] Sidebar.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 15 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(16);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(16, function() {
				var newContent = __webpack_require__(16);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 16 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n.menu[data-v-56246de2]{\n    position: fixed;\n    z-index: 1;\n    left: 0;\n    top: 90px;\n    bottom: 0;\n    width: inherit;\n    border-right: 1px solid #e7e7e7;\n    background-color: #ddd;\n    padding-top: 20px;\nul{\n      margin: 0;\n      list-style: none;\n}\n}\n.menu-list[data-v-56246de2]{\n    padding-left: 0;\nul{\n      padding-left: 0;\n}\na{\n      display: block;\n      line-height: 2;\n      color: #333;\n      text-decoration: none;\n}\n}\n.menu-level1[data-v-56246de2]{\n    height: 32px;\n    line-height: 32px;\n    margin-top:20px;\n& .is-active, .menu-level2 .router-link-active{\n      background-color: #00d1b2;\n      color: #fff !important;\n}\n&.has-chlidren{\n      position: relative;\n&:after{\n        content: '\\E080';\n        font-family: 'Glyphicons Halflings';\n        position: absolute;\n        top: 0;\n        right: 10px;\n        transition: transform .5s ease-in;\n}\n.menu-level2{\n        display: none;\n}\n&.unfold{\n&:after{\n          transform: rotate(90deg);\n}\n.menu-level2{\n          display: block;\n          padding-left: 40px;\na{\n            padding-left: 10px;\n            margin-right: 10px;\n}\n}\n}\n}\n}\n.menu-level1 a.router-link-active[data-v-56246de2]{\n  background-color:#f0f0f0;\n  color:#34a150;\n}\n.menu-level1[data-v-56246de2]:hover,.menu-level1[data-v-56246de2]:visited,.menu-level1[data-v-56246de2]:active{\n  background-color: #f0f0f0;\na{color:#34a150;\n}\n}\n\n", ""]);

	// exports


/***/ },
/* 17 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _menu = __webpack_require__(6);

	var _menu2 = _interopRequireDefault(_menu);

	var _Expanding = __webpack_require__(18);

	var _Expanding2 = _interopRequireDefault(_Expanding);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	var filterRoute = function filterRoute(menu, map) {
	  var filterdMap = menu.filter(function (item) {
	    return item.path == map.path;
	  });
	  var value = filterdMap[0].children.filter(function (item) {
	    return item.path !== '/';
	  });
	  return value;
	};
	exports.default = {
	  data: function data() {
	    return {
	      menu: filterRoute(_menu2.default, this.$route.matched[0]),
	      subMenu: []
	    };
	  },

	  components: {
	    Expanding: _Expanding2.default
	  },
	  methods: {
	    shouldExpandMatchItem: function shouldExpandMatchItem(route) {
	      var matched = route.matched;
	      var lastMatched = matched[matched.length - 1];
	      var parent = lastMatched.parent || lastMatched;

	      if (parent === lastMatched) {
	        var p = this.findParentFromMenu(route);
	        if (p) {
	          parent = p;
	        }
	      }

	      if ('expanded' in parent.meta && parent !== lastMatched) {
	        parent.meta.expanded = true;
	      }
	    },
	    toggle: function toggle(item) {
	      item.meta.expanded = !item.meta.expanded;
	    },
	    findParentFromMenu: function findParentFromMenu(route) {
	      var menu = filterRoute(menu, this.$route.matched[1]);
	      for (var i = 0, l = menu.length; i < l; i++) {
	        var item = menu[i];
	        var k = item.children && item.children.length;
	        if (k) {
	          for (var j = 0; j < k; j++) {
	            if (item.children[j].name === route.name) {
	              return item;
	            }
	          }
	        }
	      }
	    },
	    isActive: function isActive(path) {
	      var matched = this.$route.matched;
	      var lastMatched = matched[matched.length - 1];
	      return lastMatched && path === lastMatched.path;
	    }
	  },
	  mounted: function mounted() {
	    var route = this.$route;
	    if (route.name) {
	      this.isReady = true;
	      this.shouldExpandMatchItem(route);
	    }
	  },

	  watch: {
	    $route: function $route(route) {
	      this.shouldExpandMatchItem(route);
	    }
	  }
	};

/***/ },
/* 18 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(19)

	/* script */
	__vue_exports__ = __webpack_require__(21)

	/* template */
	var __vue_template__ = __webpack_require__(22)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\_commons\\Expanding.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-459e4273"

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-459e4273", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-459e4273", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] Expanding.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 19 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(20);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(20, function() {
				var newContent = __webpack_require__(20);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 20 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n.collapse[data-v-459e4273] {\n  display: none;\n&.in {\n    display: block;\n}\n}\n.collapsing[data-v-459e4273] {\n  position: relative;\n  height: 0;\n  overflow: hidden;\n  transition: height .3s ease;\n}\n", ""]);

	// exports


/***/ },
/* 21 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  methods: {
	    beforeEnter: function beforeEnter(el) {
	      el.classList.remove('collapse');
	      el.style.display = 'block';
	      el.classList.add('collapsing');
	      el.style.height = el.scrollHeight + 'px';
	    },
	    afterEnter: function afterEnter(el) {
	      el.classList.remove('collapsing');
	      el.classList.add('collapse', 'in');
	    },
	    beforeLeave: function beforeLeave(el) {
	      el.classList.add('collapsing');
	      el.classList.remove('collapse', 'in');
	      el.style.height = 0;
	    },
	    afterLeave: function afterLeave(el) {
	      el.classList.remove('collapsing');
	      el.classList.add('collapse');
	      el.style.display = 'none';
	    }
	  }
	};

/***/ },
/* 22 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('transition', {
	    on: {
	      "beforeEnter": _vm.beforeEnter,
	      "afterEnter": _vm.afterEnter,
	      "beforeLeave": _vm.beforeLeave,
	      "afterLeave": _vm.afterLeave
	    }
	  }, [_vm._t("default")])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-459e4273", module.exports)
	  }
	}

/***/ },
/* 23 */,
/* 24 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('aside', [_h('ul', {
	    staticClass: "menu-list"
	  }, [_vm._l((_vm.menu), function(item, index) {
	    return _h('li', {
	      staticClass: "menu-level1",
	      class: {
	        'has-chlidren': item.children && item.children.length, 'unfold': item.meta.expanded, 'active': !index
	      }
	    }, [_h('div', {
	      on: {
	        "click": function($event) {
	          _vm.toggle(item)
	        }
	      }
	    }, [_h('router-link', {
	      class: {
	        'is-active': _vm.isActive(item.path)
	      },
	      attrs: {
	        "to": _vm.$route.matched[0].path + '/' + item.path
	      }
	    }, [_vm._s(item.meta.showName)])]), " ", (item.children && item.children.length) ? _h('expanding', [_h('ul', {
	      directives: [{
	        name: "show",
	        rawName: "v-show",
	        value: (item.children),
	        expression: "item.children"
	      }],
	      staticClass: "menu-level2"
	    }, [_vm._l((item.children), function(subItem) {
	      return _h('li', [_h('router-link', {
	        attrs: {
	          "to": _vm.$route.matched[0].path + '/' + item.path + '/' + subItem.path
	        }
	      }, [_vm._s(subItem.meta && subItem.meta.showName || subItem.name)])])
	    })])]) : _vm._e()])
	  })])])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-56246de2", module.exports)
	  }
	}

/***/ },
/* 25 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(26)

	/* script */
	__vue_exports__ = __webpack_require__(28)

	/* template */
	var __vue_template__ = __webpack_require__(34)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\_commons\\layout\\Levelbar.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns
	__vue_options__._scopeId = "data-v-d257c128"

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-d257c128", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-d257c128", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] Levelbar.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 26 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(27);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(27, function() {
				var newContent = __webpack_require__(27);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 27 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n.levelbar .title[data-v-d257c128]{\n  height: 32px;\n  line-height: 32px;\n  font-size: 22px;\n  margin: 0;\n}\n.levelbar[data-v-d257c128]{\n  margin: 10px 0;\n}\n", ""]);

	// exports


/***/ },
/* 28 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _Breadcrumb = __webpack_require__(29);

	var _Breadcrumb2 = _interopRequireDefault(_Breadcrumb);

	var _menu = __webpack_require__(6);

	var _menu2 = _interopRequireDefault(_menu);

	function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  components: {
	    Breadcrumb: _Breadcrumb2.default
	  },
	  data: function data() {
	    return {
	      list: null
	    };
	  },
	  created: function created() {
	    this.getList();
	  },


	  computed: {
	    name: function name() {
	      return this.$route.meta && this.$route.meta.showName || this.$route.name;
	    }
	  },

	  methods: {
	    getList: function getList() {
	      var matched = this.$route.matched;
	      var first = matched[0];

	      this.list = matched;
	    }
	  },

	  watch: {
	    $route: function $route() {
	      this.getList();
	    }
	  }
	};

/***/ },
/* 29 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(30)

	/* script */
	__vue_exports__ = __webpack_require__(32)

	/* template */
	var __vue_template__ = __webpack_require__(33)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\_commons\\layout\\Breadcrumb.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-f26093c0", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-f26093c0", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] Breadcrumb.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 30 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(31);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(31, function() {
				var newContent = __webpack_require__(31);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 31 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n.breadcrumb{\n  margin-bottom: 0;\n}\n", ""]);

	// exports


/***/ },
/* 32 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//


	exports.default = {
	  props: {
	    list: {
	      default: []
	    }
	  }
	};

/***/ },
/* 33 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('ol', {
	    staticClass: "breadcrumb"
	  }, [_vm._l((_vm.list), function(item, index) {
	    return _h('li', [(index !== _vm.list.length - 1) ? [_h('router-link', {
	      staticClass: "red",
	      attrs: {
	        "to": item.path
	      }
	    }, [_vm._s(item.meta && item.meta.showName || item.name)])] : ["\n        " + _vm._s(item.meta && item.meta.showName || item.name) + "\n      "], " "])
	  })])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-f26093c0", module.exports)
	  }
	}

/***/ },
/* 34 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "levelbar clearfix"
	  }, [_h('h2', {
	    staticClass: "pull-left title"
	  }, ["hello  " + _vm._s(_vm.name) + " "]), " ", _h('div', {
	    staticClass: "pull-right"
	  }, [_h('breadcrumb', {
	    attrs: {
	      "list": _vm.list
	    }
	  }, [_h('breadcrumb')])])])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-d257c128", module.exports)
	  }
	}

/***/ },
/* 35 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "main"
	  }, [_h('div', {
	    staticClass: "left fl"
	  }, [_h('sidebar')]), " ", _h('div', {
	    staticClass: "right fl"
	  }, [_h('router-view')])])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-743091b2", module.exports)
	  }
	}

/***/ },
/* 36 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(37)

	/* template */
	var __vue_template__ = __webpack_require__(38)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\comment.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-55a337f0", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-55a337f0", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] comment.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 37 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	/**
	 * 表格中的操作---删除评论
	**/
	var comDel = function comDel(params, dom) {
		layer.alert('确定删除该行数据?', function (index) {
			var comId = params.resourceCommentId;
			var comidParams = {
				resourceCommentId: comId
			};
			CDUtil.ajaxPost("/resource/comment/delete", comidParams, function (retVO) {
				if (retVO.code == 1) {
					comSearch();
				}
			});
			layer.close(index);
			layer.msg('删除成功!');
		});
	};
	//进行表格分页的配置
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{ name: "评论", valuekey: "commentContent" }, { name: "来源", valuekey: "resourceName" }, { name: "评论人", valuekey: "realName" }, { name: "操作", valuekey: "opt", type: "opt" }],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: comSearch,
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["resourceId", "commentUserId", "parentCommentId"],
		//表格中的行操作名称
		optName: {
			del_fun: "删除"
		},
		//表格中的行操作方法
		optFuns: {
			del_fun: comDel
		}
	};

	/**
	 * 进行查询评论信息的方法
	**/
	var comSearch = function comSearch() {
		var cParams = {
			keywords: $("#c-keywords").val(),
			realname: $("#c-realname").val()
		};
		CDUtil.ajaxPost("/base/resource/comment/list", cParams, function (retVO) {
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};
	/**
	 * Vue组件对象
	**/
	exports.default = {
		mounted: function mounted() {
			this.search_one();
		},

		methods: {
			search_one: comSearch
		}
	};

/***/ },
/* 38 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), " ", _vm._m(1), " ", _h('button', {
	    staticClass: "sBtn",
	    on: {
	      "click": _vm.search_one
	    }
	  }, ["查询"])])]), " ", " ", " ", _h('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), " "])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["关键词:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "keywords",
	      "id": "c-keywords",
	      "data-vali": "notnull"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["评论人:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "id": "c-realname",
	      "data-vali": "notnull"
	    }
	  })])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-55a337f0", module.exports)
	  }
	}

/***/ },
/* 39 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(40)

	/* script */
	__vue_exports__ = __webpack_require__(42)

	/* template */
	var __vue_template__ = __webpack_require__(43)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\component.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-3e2ab366", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-3e2ab366", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] component.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 40 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(41);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(41, function() {
				var newContent = __webpack_require__(41);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 41 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n.colorTd{color:#03a9f4\n}\n.colorTd span{cursor: pointer;\n}\n", ""]);

	// exports


/***/ },
/* 42 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {
	      grades: ""
	    };
	  },
	  mounted: function mounted() {
	    this.show();
	  },

	  methods: {
	    show: function show() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
	        _self.grades = JSON.parse(retVO);
	        console.log(_self.grades);
	      });
	    },
	    add: function add() {
	      layer.open({
	        type: 1,
	        title: '添加年级',
	        skin: 'layui-layer-rim', //加上边框
	        area: ['450px', '240px'], //宽高
	        content: $("#addgrade")
	      });
	    }

	  }
	};

/***/ },
/* 43 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }, [_h('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.add
	    }
	  }, ["添加年级"])]), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "grade"
	    }
	  }, [_h('table', [_vm._m(0), " ", _h('tbody', [_vm._l((_vm.grades), function(grade, index) {
	    return _h('tr', [_h('td', [_vm._s(grade.classlevelName)]), " ", (index === 0) ? _h('td', [_h('i', {
	      staticClass: "iconfont icon-movedown"
	    })]) : [(index === (_vm.grades.length - 1)) ? _h('td', [_h('i', {
	      staticClass: "iconfont icon-moveup"
	    })]) : _h('td', [_h('i', {
	      staticClass: "iconfont icon-moveup"
	    }), _h('i', {
	      staticClass: "iconfont icon-movedown"
	    })]), " "], " ", " ", _vm._m(1, true)])
	  })])])]), " "]), " ", " ", _vm._m(2), " ", " ", " ", _vm._m(3), " "])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('thead', [_h('th', ["年级"]), _h('th', ["排序"]), _h('th', ["操作"])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('td', {
	    staticClass: "colorTd"
	  }, [_h('span', ["编辑"]), "  ", _h('span', ["删除"])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "editgrade"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["年级:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "classlevelName"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " ", _h('span', [_h('button', {
	    staticClass: "lay-btn green-btn mr20"
	  }, ["确定"]), _h('button', {
	    staticClass: "lay-btn gray-btn"
	  }, ["取消"])])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "addgrade"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["年级:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "classlevelName"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " ", _h('span', [_h('button', {
	    staticClass: "lay-btn green-btn mr20"
	  }, ["确定"]), _h('button', {
	    staticClass: "lay-btn gray-btn"
	  }, ["取消"])])])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-3e2ab366", module.exports)
	  }
	}

/***/ },
/* 44 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(45)

	/* template */
	var __vue_template__ = __webpack_require__(46)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\default.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-3dc18aea", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-3dc18aea", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] default.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 45 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
		value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	/**
	 * 表格中的操作---编辑用户
	**/
	var userEdit = function userEdit(params, dom) {
		$('#userType').val(params.userType);
		$('#e-username').text(params.username);
		$('#realname').val(params.realname);
		//md5($('#e-password').val(params.password));
		layer.open({
			type: 1,
			title: '编辑用户',
			skin: 'layui-layer-rim',
			//加上边框
			area: ['450px', '375px'],
			//宽高
			content: $("#edituser"),
			btn: ['yes', 'no'],
			yes: function yes(index, layero) {
				var editparams = $('#edituser').serialize();
				CDUtil.ajaxPost("/base/user/update", editparams, function (retVO) {
					if (retVO.code == 1) {
						userSearch();
					}
				});
				layer.close(index);
				layer.msg('编辑成功!');
			}
		});
	};
	/**
	 * 表格中的操作---删除用户
	**/
	var userDel = function userDel(params, dom) {
		layer.alert('确定删除该行数据?', function (index) {
			var userId = params.userId;
			var useridParams = {
				userId: userId
			};
			CDUtil.ajaxPost("/base/user/delete", useridParams, function (retVO) {
				if (retVO.code == 1) {
					userSearch();
				}
			});
			layer.close(index);
			layer.msg('删除成功!');
		});
	};

	//进行表格分页的配置
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{
			name: "用户名",
			valuekey: "username",
			width: "100px"
		}, {
			name: "姓名",
			valuekey: "realname"
		}, {
			name: "角色",
			valuekey: "userType"
		}, {
			name: "操作",
			valuekey: "opt",
			type: "opt"
		}],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: userSearch,
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["userId", "username", "realname", "userType", "password"],
		//表格中的行操作名称
		optName: {
			edit_fun: "编辑",
			del_fun: "删除"
		},
		//表格中的行操作方法
		optFuns: {
			edit_fun: userEdit,
			del_fun: userDel
		}
	};

	/**
	 * 进行查询用户信息的方法
	**/
	var userSearch = function userSearch() {
		var params = {
			username: $("#s-username").val(),
			realname: $("#s-realname").val(),
			userType: $("#s-userType").val()
		};
		CDUtil.ajaxPost("/base/user/list", params, function (retVO) {
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};

	/**
	 * Vue组件对象
	**/
	exports.default = {
		mounted: function mounted() {
			this.search_one();
		},

		methods: {
			search_one: userSearch,
			addUser: function addUser() {
				layer.open({
					type: 1,
					title: '添加用户',
					skin: 'layui-layer-rim',
					//加上边框
					area: ['450px', '375px'],
					//宽高
					btn: ['yes', 'no'],
					content: $("#adduser"),
					yes: function yes(index, layero) {
						var addparams = $('#adduser').serialize();
						CDUtil.ajaxPost("/base/user/add", addparams, function (retVO) {
							if (retVO.code == 1) {
								userSearch();
							}
						});
						layer.close(index);
					}
				});
			}
		}
	};

/***/ },
/* 46 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }, [_h('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.addUser
	    }
	  }, ["添加用户"])]), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), " ", _vm._m(1), " ", _vm._m(2), " ", _h('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": _vm.search_one
	    }
	  }, ["查询"])])]), " ", " ", " ", _h('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), " "]), " ", " ", _vm._m(3), " ", " ", " ", _vm._m(4), " "])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["用户名:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "username",
	      "id": "s-username",
	      "data-vali": "notnull,username"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["姓名:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "id": "s-realname",
	      "data-vali": "notnull"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["角色:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('select', {
	    attrs: {
	      "name": "userType",
	      "id": "s-userType"
	    }
	  }, [_h('option', {
	    attrs: {
	      "value": "-1"
	    }
	  }, ["请选择"]), " ", _h('option', {
	    attrs: {
	      "value": "ADMIN"
	    }
	  }, ["管理员"]), " ", _h('option', {
	    attrs: {
	      "value": "TEACHER"
	    }
	  }, ["老师"]), " ", _h('option', {
	    attrs: {
	      "value": "STUDENT"
	    }
	  }, ["学生"])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "edituser"
	    }
	  }, [_h('input', {
	    attrs: {
	      "type": "hidden",
	      "name": "userId",
	      "id": "userId"
	    }
	  }), " ", _h('div', {
	    staticClass: "cd-f-row"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["用户名:"])]), " ", _h('span', {
	    staticClass: "cd-f-value",
	    attrs: {
	      "name": "username",
	      "id": "e-username"
	    }
	  })]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["姓名:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "data-vali": "notnull",
	      "id": "realname"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["密码:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "password",
	      "id": "e-password",
	      "data-vali": "notnull,password"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["角色:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('select', {
	    attrs: {
	      "name": "userType",
	      "id": "userType"
	    }
	  }, [_h('option', {
	    attrs: {
	      "value": "-1"
	    }
	  }, ["请选择"]), _h('option', {
	    attrs: {
	      "value": "ADMIN"
	    }
	  }, ["管理员"]), " ", _h('option', {
	    attrs: {
	      "value": "TEACHER"
	    }
	  }, ["老师"]), " ", _h('option', {
	    attrs: {
	      "value": "STUDENT"
	    }
	  }, ["学生"])])])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "adduser"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["用户名:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "username",
	      "data-vali": "notnull,username"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["姓名:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "data-vali": "notnull"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["密码:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "password",
	      "data-vali": "notnull,password"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["角色:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('select', {
	    attrs: {
	      "name": "userType",
	      "data-vali": "notnull"
	    }
	  }, [_h('option', {
	    attrs: {
	      "value": "-1"
	    }
	  }, ["请选择"]), " ", _h('option', {
	    attrs: {
	      "value": "ADMIN"
	    }
	  }, ["管理员"]), " ", _h('option', {
	    attrs: {
	      "value": "TEACHER"
	    }
	  }, ["老师"]), " ", _h('option', {
	    attrs: {
	      "value": "STUDENT"
	    }
	  }, ["学生"])])])])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-3dc18aea", module.exports)
	  }
	}

/***/ },
/* 47 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(48)

	/* template */
	var __vue_template__ = __webpack_require__(49)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\management.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-20b0f12a", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-20b0f12a", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] management.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 48 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {
	      grades: ""
	    };
	  },
	  mounted: function mounted() {
	    this.show();
	  },

	  methods: {
	    show: function show() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/subject/list", params, function (retVO) {
	        _self.grades = retVO;
	      });
	    },
	    add: function add() {
	      layer.open({
	        type: 1,
	        title: '添加学科',
	        skin: 'layui-layer-rim', //加上边框
	        area: ['450px', '240px'], //宽高
	        content: $("#addsubject")
	      });
	    }
	  }
	};

/***/ },
/* 49 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }, [_h('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.add
	    }
	  }, ["添加学科"])]), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "grade"
	    }
	  }, [_h('table', [_vm._m(0), " ", _h('tbody', [_vm._l((_vm.grades), function(grade, index) {
	    return _h('tr', [_h('td', [_vm._s(grade.subjectName)]), " ", (index === 0) ? _h('td', [_h('i', {
	      staticClass: "iconfont icon-movedown"
	    })]) : [(index === (_vm.grades.length - 1)) ? _h('td', [_h('i', {
	      staticClass: "iconfont icon-moveup"
	    })]) : _h('td', [_h('i', {
	      staticClass: "iconfont icon-moveup"
	    }), _h('i', {
	      staticClass: "iconfont icon-movedown"
	    })]), " "], " ", " ", _h('td', [_vm._s(grade.editfun) + " " + _vm._s(grade.delfun)])])
	  })])])]), " ", " ", " ", _h('div', {
	    staticClass: "grade",
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), " "]), " ", " ", _vm._m(1), " ", " ", " ", _vm._m(2), " "])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('thead', [_h('th', ["学科"]), _h('th', ["排序"]), _h('th', ["操作"])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "editsubject"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["学科:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "subjectName"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " ", _h('span', [_h('button', {
	    staticClass: "lay-btn green-btn mr20"
	  }, ["确定"]), _h('button', {
	    staticClass: "lay-btn gray-btn"
	  }, ["取消"])])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "addsubject"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', ["学科:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "subjectName"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " ", _h('span', [_h('button', {
	    staticClass: "lay-btn green-btn mr20"
	  }, ["确定"]), _h('button', {
	    staticClass: "lay-btn gray-btn"
	  }, ["取消"])])])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-20b0f12a", module.exports)
	  }
	}

/***/ },
/* 50 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(51)

	/* template */
	var __vue_template__ = __webpack_require__(52)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\platform.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-a5d01dcc", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-a5d01dcc", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] platform.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 51 */
/***/ function(module, exports) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {
	      name: 'codyy'
	    };
	  },

	  methods: {
	    upimg: function upimg() {
	      //Validation
	      var result = Validation.validation({
	        containerId: "platform"
	      });
	      if (result == true) {
	        var data = {
	          title: $('[name="title"]').val(),
	          logoPath: $('[name="logoPath"]').val(),
	          buttomMsg: $('[name="buttomMsg"]').val()
	        };
	        $.post("", data, function (result) {});
	      }
	    }
	  }
	};

/***/ },
/* 52 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "platform"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(1), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('img', {
	    staticClass: "show",
	    attrs: {
	      "src": "",
	      "width": "360",
	      "height": "70",
	      "id": "thispage_fileup_img",
	      "file-name": "",
	      "file-path": ""
	    }
	  }), " ", _h('div', {
	    staticClass: "btn btn-default smp-fileupshow mt10"
	  }, ["上传logo\r\n              ", _h('input', {
	    staticClass: "smp-fileupinput",
	    attrs: {
	      "type": "file",
	      "id": "thispage_fileup",
	      "name": "logoPath",
	      "data-vali": "notnull"
	    },
	    on: {
	      "click": _vm.upimg
	    }
	  })])])]), " ", _vm._m(2), " ", _vm._m(3)])])])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["网站title:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    staticClass: "w730",
	    attrs: {
	      "type": "text",
	      "name": "title",
	      "data-vali": "notnull"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('span', {
	    staticClass: "cd-f-name vat"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["网站logo:"])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["网站底部:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    staticClass: "w730",
	    attrs: {
	      "type": "text",
	      "name": "buttomMsg",
	      "data-vali": "notnull"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve mt40"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " ", _h('span', [_h('button', {
	    staticClass: "lay-btn green-btn mr20"
	  }, ["保存"]), _h('button', {
	    staticClass: "lay-btn green-btn"
	  }, ["恢复默认"])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-a5d01dcc", module.exports)
	  }
	}

/***/ },
/* 53 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(54)

	/* template */
	var __vue_template__ = __webpack_require__(55)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\server.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-921130ac", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-921130ac", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] server.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 54 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {};
	  },
	  mounted: function mounted() {
	    this.server();
	  },

	  methods: {
	    server: function server() {
	      var params = {};
	      CDUtil.ajaxPost("/base/dmsserver/list", params, function (retVO) {
	        var config = {
	          //用来展示表格控件的div的id
	          containerId: "use_to_load_grid",
	          //用来展示表格的表头数据
	          thead: [{ name: "序号", valuekey: "sort" }, { name: "服务器名称", valuekey: "serverName" }, { name: "DMS 地址", valuekey: "serverValue" }, { name: "操作", valuekey: "opt", type: "opt" }],
	          //用来展示表格的数据
	          //这个应该是后台返回的部分
	          gData: retVO,
	          //是否需要分页，true：需要，不写默认需要
	          pagingFlag: true,
	          //执行页面查询的方法
	          searchFun: function searchFun() {},
	          //需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
	          optParams: ["serverId"],
	          //表格中的行操作名称
	          optName: { edit_fun: "编辑", del_fun: "删除" },
	          //表格中的行操作方法
	          optFuns: {
	            edit_fun: function edit_fun(params, dom) {
	              alert(params);
	              var serId = params.serverId;
	              var server = params;
	              layer.open({
	                type: 1,
	                title: '编辑服务器',
	                skin: 'layui-layer-rim', //加上边框
	                area: ['450px', '375px'], //宽高
	                content: $("#editserver"),
	                btn: ['yes', 'no'],
	                yes: function yes(index, layero) {
	                  var editparams = $('#editserver').serialize();
	                  CDUtil.ajaxPost("/base/dmsserver/update", { "serverId": serId }, function (retVO) {});
	                  layer.close(index);
	                }
	              });
	            },
	            del_fun: function del_fun(params, dom) {
	              layer.alert('确定删除该行数据?', function (index) {
	                var serverId = params.serverId;
	                CDUtil.ajaxPost("/base/dmsserver/delete", { "serverId": serverId }, function (retVO) {});
	                layer.close(index);
	                layer.msg('删除成功!');
	              });
	            }
	          }
	        };
	        Grid.initGrid(config, function () {});
	      });
	    },
	    add: function add() {
	      layer.open({
	        type: 1,
	        title: '添加服务器',
	        skin: 'layui-layer-rim', //加上边框
	        area: ['450px', '375px'], //宽高
	        btn: ['yes', 'no'],
	        content: $("#addserver"),
	        yes: function yes(index, layero) {
	          var addparams = $('#addserver').serialize();
	          CDUtil.ajaxPost("/base/dmsserver/add", addparams, function (retVO) {});
	          layer.close(index);
	        }
	      });
	    }
	  }

	};

/***/ },
/* 55 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }, [_h('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.add
	    }
	  }, ["新增服务器"])]), " ", _vm._m(0), " ", " ", _vm._m(1), " ", " ", " ", _vm._m(2), " "])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "dashboard"
	  }, [_h('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), " "])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "editserver"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["服务器名称:"])]), " ", _h('span', {
	    staticClass: "cd-f-value",
	    attrs: {
	      "name": "serverName"
	    }
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverName",
	      "data-vali": "notnull"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["服务器地址:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverValue",
	      "data-vali": "notnull"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " ", _h('span', [_h('button', {
	    staticClass: "lay-btn green-btn"
	  }, ["确定"]), _h('button', {
	    staticClass: "lay-btn gray-btn"
	  }, ["取消"])])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "addserver"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["服务器名称:"])]), " ", _h('span', {
	    staticClass: "cd-f-value",
	    attrs: {
	      "name": "serverName"
	    }
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverName",
	      "data-vali": "notnull"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["服务器地址:"])]), " ", _h('span', {
	    staticClass: "cd-f-value"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverValue",
	      "data-vali": "notnull"
	    }
	  })])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label')]), " "])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-921130ac", module.exports)
	  }
	}

/***/ },
/* 56 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(57)

	/* script */
	__vue_exports__ = __webpack_require__(59)

	/* template */
	var __vue_template__ = __webpack_require__(60)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\source.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-3ce516fc", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-3ce516fc", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] source.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 57 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(58);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(58, function() {
				var newContent = __webpack_require__(58);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 58 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\n#condition .cd-f-eve{height:60px;\n}\r\n", ""]);

	// exports


/***/ },
/* 59 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {
	      classList: "",
	      subjectList: ""
	    };
	  },
	  mounted: function mounted() {
	    this.search_one(), this.showclass(), this.showsubject();
	  },

	  methods: {
	    search_one: function search_one() {
	      var params = {};
	      CDUtil.ajaxPost("/resource/list", params, function (retVO) {
	        var config = {
	          //用来展示表格控件的div的id
	          containerId: "use_to_load_grid",
	          //用来展示表格的表头数据
	          thead: [{ name: "资源名称", valuekey: "resourceName", width: "100px" }, { name: "年级", valuekey: "classlevelName" }, { name: "学科", valuekey: "subjectName" }, { name: "主讲教师", valuekey: "author" }, { name: "操作", valuekey: "opt", type: "opt" }],
	          //用来展示表格的数据
	          //这个应该是后台返回的部分
	          gData: retVO,
	          //是否需要分页，true：需要，不写默认需要
	          pagingFlag: true,
	          //执行页面查询的方法
	          searchFun: function searchFun() {},
	          //需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
	          optParams: ["resourceId", "resourceName"],
	          //表格中的行操作名称
	          optName: { view_fun: "查看", edit_fun: "编辑", del_fun: "删除" },
	          //表格中的行操作方法
	          optFuns: { edit_fun: function edit_fun(params, dom) {
	              window.open('up_subject.html');
	            }, del_fun: function del_fun(params, dom) {
	              layer.alert('确定删除该行数据?', function (index) {
	                layer.close(index);
	                layer.msg('删除成功!');
	              });
	              /* ajaxCallPost("/resource/delete",{"num1":params.num1},callback);*/
	            }
	          }
	        };
	        Grid.initGrid(config, function () {});
	      });
	    },
	    showclass: function showclass() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
	        _self.classList = retVO;
	      });
	    },
	    showsubject: function showsubject() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/subject/list", params, function (retVO) {
	        _self.subjectList = retVO;
	      });
	    }
	  }
	};

/***/ },
/* 60 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), " ", _vm._m(1), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(2), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('select', {
	    attrs: {
	      "data-vali": "notnull"
	    }
	  }, [_vm._l((_vm.classList.data), function(grade) {
	    return _h('option', [_vm._s(grade.classlevelName)])
	  })])])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(3), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('select', {
	    attrs: {
	      "data-vali": "notnull"
	    }
	  }, [_vm._l((_vm.subjectList.data), function(subject) {
	    return _h('option', [_vm._s(subject.subjectName)])
	  })])])]), " ", _h('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": _vm.search_one
	    }
	  }, ["查询"])])]), " ", " ", _h('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), " "])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["资源名称:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "resourceName"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["主讲教师:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "author"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["年级:"])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["学科:"])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-3ce516fc", module.exports)
	  }
	}

/***/ },
/* 61 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(62)

	/* template */
	var __vue_template__ = __webpack_require__(63)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\upload.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-154fb768", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-154fb768", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] upload.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 62 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//


	exports.default = {
	  data: function data() {
	    return {
	      classList: "",
	      subjectList: ""
	    };
	  },
	  mounted: function mounted() {
	    this.search_one(), this.showclass(), this.showsubject();
	  },

	  methods: {
	    search_one: function search_one() {
	      //Validation
	      var result = Validation.validation({
	        containerId: "condition"
	      });
	      if (result == true) {}
	      var params = {};
	      CDUtil.ajaxPost("/resource/list", params, function (retVO) {
	        var config = {
	          //用来展示表格控件的div的id
	          containerId: "use_to_load_grid",
	          //用来展示表格的表头数据
	          thead: [{ name: "资源名称", valuekey: "resourceName", width: "100px" }, { name: "年级", valuekey: "classlevelName" }, { name: "学科", valuekey: "subjectName" }, { name: "主讲教师", valuekey: "author" }, { name: "上传人", valuekey: "creatName" }, { name: "操作", valuekey: "opt", type: "opt" }],
	          //用来展示表格的数据
	          //这个应该是后台返回的部分
	          gData: retVO,
	          //是否需要分页，true：需要，不写默认需要
	          pagingFlag: true,
	          //执行页面查询的方法
	          searchFun: function searchFun() {},
	          //需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
	          optParams: ["resourceId", "creatName"],
	          //表格中的行操作名称
	          optName: { view_fun: "查看", edit_fun: "编辑", del_fun: "删除" },
	          //表格中的行操作方法
	          optFuns: { edit_fun: function edit_fun(params, dom) {
	              window.open('up_subject.html');
	            }, del_fun: function del_fun(params, dom) {
	              layer.alert('确定删除该行数据?', function (index) {
	                layer.close(index);
	                layer.msg('删除成功!');
	              });
	              /* ajaxCallPost("/resource/delete",{"num1":params.num1},callback);*/
	            },
	            view_fun: function view_fun() {}
	          }
	        };
	        Grid.initGrid(config, function () {});
	      });
	    },
	    showclass: function showclass() {
	      var _self = this;
	      $.ajax({
	        type: 'POST',
	        url: 'mockjs_class_list.json',
	        success: function success(data) {
	          _self.classList = JSON.parse(data);
	        }
	      });
	    },
	    showsubject: function showsubject() {
	      var _self = this;
	      $.ajax({
	        type: 'POST',
	        url: 'mockjs_subject_list.json',
	        success: function success(data) {
	          _self.subjectList = JSON.parse(data);
	        }
	      });
	    },
	    openFileup: function openFileup() {
	      CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
	        if (retVO.code == 1) {
	          window.open(ROOT_UI + "/front/path/upload");
	        } else {
	          alert("用户信息失效");
	          sessionStorage.clear();
	          window.href.location = "/#/index";
	        }
	      });
	    }
	  }
	};

/***/ },
/* 63 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "content"
	  }, [_h('div', {
	    staticClass: "subBtn"
	  }, [_h('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": function($event) {
	        _vm.openFileup()
	      }
	    }
	  }, ["上传课程视频"])]), " ", _h('div', {
	    staticClass: "dashboard"
	  }, [_h('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_h('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), " ", _vm._m(1), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(2), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('select', {
	    attrs: {
	      "data-vali": "notnull"
	    }
	  }, [_vm._l((_vm.classList.data), function(grade) {
	    return _h('option', [_vm._s(grade.classlevelName)])
	  })])])]), " ", _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(3), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('select', {
	    attrs: {
	      "data-vali": "notnull"
	    }
	  }, [_vm._l((_vm.subjectList.data), function(subject) {
	    return _h('option', [_vm._s(subject.subjectName)])
	  })])])]), " ", _h('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": _vm.search_one
	    }
	  }, ["查询"])])]), " ", " ", _h('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), " "])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["资源名称:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "resourceName"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "cd-f-eve"
	  }, [_h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["主讲教师:"])]), " ", _h('span', {
	    staticClass: "cd-f-value "
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "author"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["年级:"])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('span', {
	    staticClass: "cd-f-name"
	  }, [_h('label', {
	    staticClass: "cd-f-notnull"
	  }, ["*"]), _h('label', ["学科:"])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-154fb768", module.exports)
	  }
	}

/***/ },
/* 64 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(65)

	/* template */
	var __vue_template__ = __webpack_require__(66)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\demand.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-4aaaeaf7", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-4aaaeaf7", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] demand.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 65 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {
	      courseList: "",
	      classList: "",
	      subjectList: ""
	    };
	  },
	  mounted: function mounted() {
	    this.showdemand(), this.showclass(), this.showsubject();
	  },

	  methods: {
	    showdemand: function showdemand() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/demand/list", params, function (retVO) {
	        _self.courseList = retVO;
	        var config = {
	          //这个应该是后台返回的部分
	          gData: retVO,
	          //是否需要分页，true：需要，不写默认需要
	          pagingFlag: true

	        };
	        Grid.initGrid(config, function () {});
	      });
	    },
	    showclass: function showclass() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
	        _self.classList = retVO;
	      });
	    },
	    showsubject: function showsubject() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/subject/list", params, function (retVO) {
	        _self.subjectList = retVO;
	      });
	    }
	  }
	};

/***/ },
/* 66 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "demand"
	  }, [_h('div', {
	    staticClass: "d-search"
	  }, [_h('div', [_h('label', ["年级 :"]), _h('div', {
	    staticClass: "itemList"
	  }, [_vm._l((_vm.classList.data), function(grade) {
	    return _h('span', [_vm._s(grade.classlevelName)])
	  })])]), " ", _h('div', [_h('label', ["学科 :"]), _h('div', {
	    staticClass: "itemList"
	  }, [_vm._l((_vm.subjectList.data), function(subject) {
	    return _h('span', [_vm._s(subject.subjectName)])
	  })])])]), " ", " ", _h('div', {
	    staticClass: "d-main"
	  }, [_vm._m(0), " ", _h('div', {
	    staticClass: "clear"
	  }), " ", " ", _h('div', {
	    staticClass: "list"
	  }, [_vm._l((_vm.courseList.data), function(course) {
	    return _h('div', {
	      staticClass: "col-4"
	    }, [_h('div', {
	      staticClass: "demandImg"
	    }, [_vm._m(1, true), " ", _h('div', {
	      staticClass: "times"
	    }, [_h('span', {
	      staticClass: "fr"
	    }, [_h('i', {
	      staticClass: "iconfont icon-play-times"
	    }), _vm._s(course.viewCnt)])])]), " ", _h('p', {
	      staticClass: "c4 tel"
	    }, [_vm._s(course.resourceName)]), " ", _h('p', {
	      staticClass: "ft12 c9 tel"
	    }, [_vm._s(course.classlevelName) + " " + _vm._s(course.subjectName) + " " + _vm._s(course.author)])])
	  })]), " ", _h('div', {
	    staticClass: "clear"
	  }), " "]), " "])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "search"
	  }, [_h('div', {
	    staticClass: "s-left"
	  }, ["\n\t\t\t\t\"语文\" 相关课程  共26条\n\t\t\t\t", _h('span', ["按时间", _h('i', {
	    staticClass: "iconfont icon-low"
	  })]), " ", _h('span', ["按热门", _h('i', {
	    staticClass: "iconfont icon-low"
	  })])]), " ", _h('div', {
	    staticClass: "s-right fr"
	  }, [_h('input', {
	    attrs: {
	      "type": "text",
	      "placeholder": "输入课程或老师"
	    }
	  }), " ", _h('i', {
	    staticClass: "iconfont icon-search"
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('a', {
	    attrs: {
	      "href": "#a"
	    }
	  }, [_h('img', {
	    attrs: {
	      "src": "",
	      "width": "280",
	      "height": "157"
	    }
	  })])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-4aaaeaf7", module.exports)
	  }
	}

/***/ },
/* 67 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(68)

	/* script */
	__vue_exports__ = __webpack_require__(70)

	/* template */
	var __vue_template__ = __webpack_require__(71)
	__vue_options__ = __vue_exports__ = __vue_exports__ || {}
	if (
	  typeof __vue_exports__.default === "object" ||
	  typeof __vue_exports__.default === "function"
	) {
	if (Object.keys(__vue_exports__).some(function (key) { return key !== "default" && key !== "__esModule" })) {console.error("named exports are not supported in *.vue files.")}
	__vue_options__ = __vue_exports__ = __vue_exports__.default
	}
	if (typeof __vue_options__ === "function") {
	  __vue_options__ = __vue_options__.options
	}
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\home.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(23)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-5553608b", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-5553608b", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] home.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 68 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(69);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(12)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(69, function() {
				var newContent = __webpack_require__(69);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 69 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(11)();
	// imports


	// module
	exports.push([module.id, "\nbody{background-color:#fff;\n}\n.s-title .demanCour{margin:0;\n}\n", ""]);

	// exports


/***/ },
/* 70 */
/***/ function(module, exports) {

	"use strict";

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	exports.default = {
	  data: function data() {
	    return {
	      posts: "",
	      courseList: ""
	    };
	  },
	  mounted: function mounted() {
	    this.show(), this.showdemand();
	  },

	  methods: {
	    isShow: function isShow() {
	      return this.data.length;
	    },
	    show: function show() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/home/live/list", params, function (retVO) {
	        _self.posts = retVO; //JSON.parse(retVO);
	      });
	    },
	    showdemand: function showdemand() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/demand/list", params, function (retVO) {
	        _self.courseList = retVO; //JSON.parse(retVO);
	      });
	    },
	    openLiveDetail: function openLiveDetail(resourceId) {
	      CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
	        if (retVO.code == 1) {
	          sessionStorage.setItem("resourceId", resourceId);
	          window.open(ROOT_UI + "/front/path/live?token=" + sessionStorage.getItem("token"));
	        } else {
	          alert("用户信息失效");
	          sessionStorage.clear();
	          window.href.location = "/#/index";
	        }
	      });
	    },
	    openDemondDetail: function openDemondDetail(resourceId) {
	      CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
	        if (retVO.code == 1) {
	          sessionStorage.setItem("resourceId", resourceId);
	          window.open(ROOT_UI + "/front/path/demond?token=" + sessionStorage.getItem("token"));
	        } else {
	          alert("用户信息失效");
	          sessionStorage.clear();
	          window.href.location = "/#/index";
	        }
	      });
	    },
	    openMore: function openMore() {
	      window.open(ROOT_UI + '#/onDemand');
	    }
	  }
	};

/***/ },
/* 71 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "wamp",
	    attrs: {
	      "id": "home"
	    }
	  }, [_vm._m(0), " ", _h('div', {
	    attrs: {
	      "id": "courseList"
	    }
	  }, [(_vm.posts.data != null) ? _h('div', [_vm._l((_vm.posts.data), function(post) {
	    return _h('div', {
	      staticClass: "row"
	    }, [_h('div', {
	      staticClass: "col-md-4 tel"
	    }, [_vm._s(post.resourceName)]), " ", _h('div', {
	      staticClass: "col-md-4 tel"
	    }, [_vm._s(post.classlevelName) + "/" + _vm._s(post.subjectName) + "/" + _vm._s(post.author)]), " ", _h('div', {
	      staticClass: "col-md-4",
	      on: {
	        "click": function($event) {
	          _vm.openLiveDetail(post.resourceId)
	        }
	      }
	    }, [_h('i', {
	      staticClass: "iconfont icon-avpic"
	    }), "进入直播"])])
	  })]) : _h('div', {
	    staticClass: "tac"
	  }, [_h('img', {
	    attrs: {
	      "src": __webpack_require__(72)
	    }
	  })]), " "]), " ", _h('div', {
	    staticClass: "s-title"
	  }, [_h('span'), _h('h3', {
	    staticClass: "demanCour fl"
	  }, ["点播课程"]), _h('a', {
	    staticClass: "fr",
	    attrs: {
	      "href": "javascript:;",
	      "target": "_blank"
	    },
	    on: {
	      "click": _vm.openMore
	    }
	  }, ["更多"])]), " ", _h('div', {
	    staticClass: "demand"
	  }, [_vm._l((_vm.courseList.data), function(course) {
	    return _h('div', {
	      staticClass: "col-4",
	      on: {
	        "click": function($event) {
	          _vm.openDemondDetail(course.resourceId)
	        }
	      }
	    }, [_h('div', {
	      staticClass: "home-img"
	    }, [_h('img', {
	      attrs: {
	        "src": course.thumbPath,
	        "width": "285",
	        "height": "160"
	      }
	    }), " ", _h('div', {
	      staticClass: "home-times"
	    }, [_h('span', {
	      staticClass: "fr"
	    }, [_h('i', {
	      staticClass: "iconfont icon-play-times"
	    }), _vm._s(course.viewCnt)])])]), " ", _h('p', {
	      staticClass: "c4 tel"
	    }, [_vm._s(course.resourceName)]), " ", _h('p', {
	      staticClass: "ft12 c9 tel"
	    }, [_vm._s(course.classlevelName) + " " + _vm._s(course.subjectName) + " " + _vm._s(course.author)])])
	  })])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;
	  return _h('div', {
	    staticClass: "s-title"
	  }, [_h('span'), _h('h3', ["直播课程"])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(23).rerender("data-v-5553608b", module.exports)
	  }
	}

/***/ },
/* 72 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__.p + "8bed79dd627549783788bf671a45567f.png";

/***/ }
]);