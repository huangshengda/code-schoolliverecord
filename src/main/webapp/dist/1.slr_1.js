webpackJsonp([1,6],[
/* 0 */,
/* 1 */,
/* 2 */,
/* 3 */,
/* 4 */,
/* 5 */,
/* 6 */,
/* 7 */,
/* 8 */,
/* 9 */,
/* 10 */,
/* 11 */,
/* 12 */
/***/ function(module, exports, __webpack_require__) {

	var map = {
		"./basic.vue": 13,
		"./basic/context/comment.vue": 39,
		"./basic/context/component.vue": 42,
		"./basic/context/default.vue": 47,
		"./basic/context/management.vue": 50,
		"./basic/context/platform.vue": 55,
		"./basic/context/server.vue": 58,
		"./basic/context/source.vue": 63,
		"./basic/context/upload.vue": 66,
		"./demand.vue": 69,
		"./home.vue": 74,
		"./mySubject.vue": 80
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
	webpackContext.id = 12;


/***/ },
/* 13 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(14)

	/* script */
	__vue_exports__ = __webpack_require__(16)

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
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(26)
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
/* 14 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(15);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(15, function() {
				var newContent = __webpack_require__(15);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 15 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\nbody{background-color: #f5f8fa;\n}\n.left{width:240px;border:1px solid #ddd;margin-right:10px;background-color: #fff;padding:0 15px;text-align: center;margin-top:40px;min-height: 600px;\n}\n.right{width:880px;\n}\n.main{margin-top:10px;\n}\n.subBtn{height:40px;\n}\n.dashboard{border:1px solid #ddd;background-color: #fff;padding: 20px;\n}\n.layBox{display: none;\n}\r\n", ""]);

	// exports


/***/ },
/* 16 */
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

	var Sidebar = __webpack_require__(17);
	var Levelbar = __webpack_require__(28);
	exports.default = {
	  name: 'app',
	  components: {
	    Sidebar: Sidebar,
	    Levelbar: Levelbar
	  }
	};

/***/ },
/* 17 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(18)

	/* script */
	__vue_exports__ = __webpack_require__(20)

	/* template */
	var __vue_template__ = __webpack_require__(27)
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
	  var hotAPI = __webpack_require__(26)
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
/* 18 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(19);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(19, function() {
				var newContent = __webpack_require__(19);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 19 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.menu[data-v-56246de2]{\n    position: fixed;\n    z-index: 1;\n    left: 0;\n    top: 90px;\n    bottom: 0;\n    width: inherit;\n    border-right: 1px solid #e7e7e7;\n    background-color: #ddd;\n    padding-top: 20px;\nul{\n      margin: 0;\n      list-style: none;\n}\n}\n.menu-list[data-v-56246de2]{\n    padding-left: 0;\nul{\n      padding-left: 0;\n}\na{\n      display: block;\n      line-height: 2;\n      color: #333;\n      text-decoration: none;\n}\n}\n.menu-level1[data-v-56246de2]{\n    height: 32px;\n    line-height: 32px;\n    margin-top:20px;\n& .is-active, .menu-level2 .router-link-active{\n      background-color: #00d1b2;\n      color: #fff !important;\n}\n&.has-chlidren{\n      position: relative;\n&:after{\n        content: '\\E080';\n        font-family: 'Glyphicons Halflings';\n        position: absolute;\n        top: 0;\n        right: 10px;\n        transition: transform .5s ease-in;\n}\n.menu-level2{\n        display: none;\n}\n&.unfold{\n&:after{\n          transform: rotate(90deg);\n}\n.menu-level2{\n          display: block;\n          padding-left: 40px;\na{\n            padding-left: 10px;\n            margin-right: 10px;\n}\n}\n}\n}\n}\n.menu-level1 a.router-link-active[data-v-56246de2]{\n  color:#34a150;\n}\n.menu-level1[data-v-56246de2]:hover,.menu-level1[data-v-56246de2]:visited,.menu-level1[data-v-56246de2]:active{\n  background-color: #f0f0f0;\na{color:#34a150;\n}\n}\n.menu-list li.active div[data-v-56246de2]{background-color: #f0f0f0;\n}\n", ""]);

	// exports


/***/ },
/* 20 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _menu = __webpack_require__(11);

	var _menu2 = _interopRequireDefault(_menu);

	var _Expanding = __webpack_require__(21);

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
	    toggle: function toggle(item, event) {
	      item.meta.expanded = !item.meta.expanded;
	      $(event.target).parent().parent().addClass("active");
	      $(event.target).parent().parent().siblings().removeClass("active");
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
/* 21 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(22)

	/* script */
	__vue_exports__ = __webpack_require__(24)

	/* template */
	var __vue_template__ = __webpack_require__(25)
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
	  var hotAPI = __webpack_require__(26)
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
/* 22 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(23);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(23, function() {
				var newContent = __webpack_require__(23);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 23 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.collapse[data-v-459e4273] {\n  display: none;\n&.in {\n    display: block;\n}\n}\n.collapsing[data-v-459e4273] {\n  position: relative;\n  height: 0;\n  overflow: hidden;\n  transition: height .3s ease;\n}\n", ""]);

	// exports


/***/ },
/* 24 */
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
/* 25 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('transition', {
	    on: {
	      "beforeEnter": _vm.beforeEnter,
	      "afterEnter": _vm.afterEnter,
	      "beforeLeave": _vm.beforeLeave,
	      "afterLeave": _vm.afterLeave
	    }
	  }, [_vm._t("default")], true)
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-459e4273", module.exports)
	  }
	}

/***/ },
/* 26 */,
/* 27 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('aside', [_c('ul', {
	    staticClass: "menu-list"
	  }, _vm._l((_vm.menu), function(item, index) {
	    return _c('li', {
	      staticClass: "menu-level1",
	      class: {
	        'has-chlidren': item.children && item.children.length, 'unfold': item.meta.expanded, 'active': !index
	      }
	    }, [_c('div', {
	      on: {
	        "click": function($event) {
	          _vm.toggle(item, $event)
	        }
	      }
	    }, [_c('router-link', {
	      class: {
	        'is-active': _vm.isActive(item.path)
	      },
	      attrs: {
	        "to": _vm.$route.matched[0].path + '/' + item.path
	      }
	    }, [_vm._v(_vm._s(item.meta.showName))])]), _vm._v(" "), (item.children && item.children.length) ? _c('expanding', [_c('ul', {
	      directives: [{
	        name: "show",
	        rawName: "v-show",
	        value: (item.children),
	        expression: "item.children"
	      }],
	      staticClass: "menu-level2"
	    }, _vm._l((item.children), function(subItem) {
	      return _c('li', [_c('router-link', {
	        attrs: {
	          "to": _vm.$route.matched[0].path + '/' + item.path + '/' + subItem.path
	        }
	      }, [_vm._v(_vm._s(subItem.meta && subItem.meta.showName || subItem.name))])])
	    }))]) : _vm._e()])
	  }))])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-56246de2", module.exports)
	  }
	}

/***/ },
/* 28 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(29)

	/* script */
	__vue_exports__ = __webpack_require__(31)

	/* template */
	var __vue_template__ = __webpack_require__(37)
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
	  var hotAPI = __webpack_require__(26)
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
/* 29 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(30);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(30, function() {
				var newContent = __webpack_require__(30);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 30 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.levelbar .title[data-v-d257c128]{\n  height: 32px;\n  line-height: 32px;\n  font-size: 22px;\n  margin: 0;\n}\n.levelbar[data-v-d257c128]{\n  margin: 10px 0;\n}\n", ""]);

	// exports


/***/ },
/* 31 */
/***/ function(module, exports, __webpack_require__) {

	'use strict';

	Object.defineProperty(exports, "__esModule", {
	  value: true
	});

	var _Breadcrumb = __webpack_require__(32);

	var _Breadcrumb2 = _interopRequireDefault(_Breadcrumb);

	var _menu = __webpack_require__(11);

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
/* 32 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(33)

	/* script */
	__vue_exports__ = __webpack_require__(35)

	/* template */
	var __vue_template__ = __webpack_require__(36)
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
	  var hotAPI = __webpack_require__(26)
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
/* 33 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(34);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(34, function() {
				var newContent = __webpack_require__(34);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 34 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.breadcrumb{margin-bottom: 0;\n}\n", ""]);

	// exports


/***/ },
/* 35 */
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

	exports.default = {
	  props: {
	    list: {
	      default: []
	    }
	  }
	};

/***/ },
/* 36 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('ol', {
	    staticClass: "breadcrumb"
	  }, _vm._l((_vm.list), function(item, index) {
	    return _c('li', [(index !== _vm.list.length - 1) ? [_c('router-link', {
	      staticClass: "red",
	      attrs: {
	        "to": item.path
	      }
	    }, [_vm._v(_vm._s(item.meta && item.meta.showName || item.name))])] : [_vm._v("\n        " + _vm._s(item.meta && item.meta.showName || item.name) + "\n      ")], _vm._v(" ")], true)
	  }))
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-f26093c0", module.exports)
	  }
	}

/***/ },
/* 37 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "levelbar clearfix"
	  }, [_c('h2', {
	    staticClass: "pull-left title"
	  }, [_vm._v("hello  " + _vm._s(_vm.name) + " ")]), _vm._v(" "), _c('div', {
	    staticClass: "pull-right"
	  }, [_c('breadcrumb', {
	    attrs: {
	      "list": _vm.list
	    }
	  }, [_c('breadcrumb')])])])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-d257c128", module.exports)
	  }
	}

/***/ },
/* 38 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "main"
	  }, [_c('div', {
	    staticClass: "left fl"
	  }, [_c('sidebar')]), _vm._v(" "), _c('div', {
	    staticClass: "right fl"
	  }, [_c('router-view')])])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-743091b2", module.exports)
	  }
	}

/***/ },
/* 39 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(40)

	/* template */
	var __vue_template__ = __webpack_require__(41)
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
	  var hotAPI = __webpack_require__(26)
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
/* 40 */
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
					layer.msg(retVO.msg);
					layer.close(index);
				}
				if (retVO.code == 0) {
					layer.msg(retVO.msg);
				}
			});
		});
	};
	/**
	 * 进行查询评论信息的方法
	**/
	var comSearch = function comSearch(newPage) {
		if (newPage == "undefined") {
			newPage = 1;
		}
		var cParams = {
			curPage: newPage,
			pageSize: 20,
			keywords: $("#search_keywords").val(),
			realname: $("#search_realname").val()
		};
		CDUtil.ajaxPost("/base/resource/comment/list", cParams, function (retVO) {
			cParams.curPage = retVO.curPage;
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};
	/**
	 * 表格中的操作---进行表格分页的配置
	**/
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{ name: "评论", valuekey: "commentContent", css: "width:300px" }, { name: "来源", valuekey: "resourceName", css: "width:200px" }, { name: "评论人", valuekey: "realName" }, { name: "操作", valuekey: "opt", type: "opt" }],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: comSearch,
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["resourceCommentId", "commentUserId", "parentCommentId", "commentContent", "resourceName", "realName"],
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
	 * Vue组件对象
	**/
	exports.default = {
		created: function created() {
			this.commentSearch();
		},

		methods: {
			commentSearch: comSearch
		}
	};

/***/ },
/* 41 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), _vm._v(" "), _vm._m(1), _vm._v(" "), _c('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": function($event) {
	        _vm.commentSearch(1)
	      }
	    }
	  }, [_vm._v("查询")])])]), _vm._v(" "), _vm._v(" "), _vm._v(" "), _c('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("关键词:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "keywords",
	      "id": "search_keywords",
	      "data-vali": "notnull"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("评论人:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "id": "search_realname",
	      "data-vali": "notnull"
	    }
	  })])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-55a337f0", module.exports)
	  }
	}

/***/ },
/* 42 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(43)

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
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\component.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(26)
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
/* 43 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(44);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(44, function() {
				var newContent = __webpack_require__(44);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 44 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.colorTd{color:#03a9f4\n}\n.colorTd span{cursor: pointer;\n}\n#sort td {\r\n    white-space: nowrap;\r\n    overflow: hidden;\r\n    white-space: nowrap;\r\n    -o-text-overflow: ellipsis;\r\n    text-overflow: ellipsis;\n}\r\n", ""]);

	// exports


/***/ },
/* 45 */
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

	/*vue组件*/
	exports.default = {
	  data: function data() {
	    return {
	      grades: ""
	    };
	  },
	  created: function created() {
	    this.show();
	  },

	  methods: {
	    /*显示表单数据*/
	    show: function show() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
	        _self.grades = retVO;
	      });
	    },
	    /*编辑年级*/
	    manEdit: function manEdit(classlevelName, classlevelId) {
	      var _self = this;
	      $('#edit-classlevelName').val(classlevelName);
	      $('#edit-classlevelId').val(classlevelId);
	      layer.open({
	        type: 1,
	        title: '编辑年级',
	        skin: 'layui-layer-rim',
	        //加上边框
	        area: ['450px', '240px'],
	        //宽高
	        content: $("#editgrade"),
	        btn: ['确定', '取消'],
	        yes: function yes(index, layero) {
	          //添加表单验证--Validation
	          var result = Validation.validation({
	            containerId: "editgrade"
	          });
	          if (result == true) {
	            var editparams = $('#editgrade').serialize();
	            CDUtil.ajaxPost("/base/classlevel/update", editparams, function (retVO) {
	              if (retVO.code == 1) {
	                _self.show();
	                layer.msg(retVO.msg);
	                layer.close(index);
	              }
	              if (retVO.code == 0) {
	                layer.msg(retVO.msg);
	              }
	            });
	          }
	        }
	      });
	    },
	    /*删除年级*/
	    manDel: function manDel(classlevelId) {
	      var _self = this;
	      layer.alert('确定删除该行数据?', function (index) {
	        var nanidParams = {
	          classlevelId: classlevelId
	        };
	        CDUtil.ajaxPost("/base/classlevel/delete", nanidParams, function (retVO) {
	          if (retVO.code == 1) {
	            _self.show();
	            layer.msg(retVO.msg);
	            layer.close(index);
	          }
	          if (retVO.code == 0) {
	            layer.msg(retVO.msg);
	          }
	        });
	      });
	    },
	    /*添加年级*/
	    addgrd: function addgrd() {
	      var _self = this;
	      layer.open({
	        type: 1,
	        title: '添加年级',
	        skin: 'layui-layer-rim', //加上边框
	        area: ['450px', '240px'], //宽高
	        content: $("#addgrade"),
	        btn: ['确定', '取消'],
	        yes: function yes(index, layero) {
	          //添加表单验证--Validation
	          var result = Validation.validation({
	            containerId: "addgrade"
	          });
	          if (result == true) {
	            var addparams = $('#addgrade').serialize();
	            CDUtil.ajaxPost("/base/classlevel/add", addparams, function (retVO) {
	              if (retVO.code == 1) {
	                _self.show();
	                layer.msg(retVO.msg);
	                layer.close(index);
	                $('#addgrade')[0].reset();
	              }
	              if (retVO.code == 0) {
	                layer.msg(retVO.msg);
	              }
	            });
	          }
	        }
	      });
	    },
	    /**上移**/
	    upbtn: function upbtn(event) {
	      var el = event.target;
	      var $this = $(el);
	      var tr = $this.parents('tr');
	      var _index = tr.index();
	      var _str = "";
	      tr.prev().before(tr);
	      $("#sort tr").each(function () {
	        _str += $(this).find('td').attr("data-id") + ",";
	        CDUtil.ajaxPost("/base/classlevel/sort", { classlevelIds: _str }, function (retVO) {
	          console.log(retVO);
	        });
	      });
	    },
	    /**下移**/
	    downbtn: function downbtn(event) {
	      var el = event.target;
	      var $this = $(el);
	      var tr = $this.parents('tr');
	      var _index = tr.index();
	      var _str = "";
	      tr.next().after(tr);
	      $("#sort tr").each(function () {
	        _str += $(this).find('td').attr("data-id") + ",";
	        CDUtil.ajaxPost("/base/classlevel/sort", { classlevelIds: _str }, function (retVO) {});
	      });
	    }
	  }
	};

/***/ },
/* 46 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }, [_c('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.addgrd
	    }
	  }, [_vm._v("添加年级")])]), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "grade"
	    }
	  }, [_c('table', [_vm._m(0), _vm._v(" "), _c('tbody', {
	    attrs: {
	      "id": "sort"
	    }
	  }, _vm._l((_vm.grades.data), function(grade, index) {
	    return _c('tr', [_c('td', {
	      attrs: {
	        "data-id": grade.classlevelId,
	        "title": grade.classlevelName
	      }
	    }, [_vm._v(_vm._s(grade.classlevelName))]), _vm._v(" "), _c('td', [_c('i', {
	      staticClass: "iconfont icon-moveup upbtn",
	      on: {
	        "click": _vm.upbtn
	      }
	    }), _c('i', {
	      staticClass: "iconfont icon-movedown downbtn",
	      on: {
	        "click": _vm.downbtn
	      }
	    })]), _vm._v(" "), _c('td', {
	      staticClass: "colorTd"
	    }, [_c('span', {
	      on: {
	        "click": function($event) {
	          _vm.manEdit(grade.classlevelName, grade.classlevelId)
	        }
	      }
	    }, [_vm._v("编辑")]), _vm._v("   "), _c('span', {
	      on: {
	        "click": function($event) {
	          _vm.manDel(grade.classlevelId)
	        }
	      }
	    }, [_vm._v("删除")])])])
	  }))])]), _vm._v(" "), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "grade",
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")]), _vm._v(" "), _vm._v(" "), _vm._m(1), _vm._v(" "), _vm._v(" "), _vm._v(" "), _vm._m(2), _vm._v(" ")])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('thead', [_c('th', [_vm._v("年级")]), _c('th', [_vm._v("排序")]), _c('th', [_vm._v("操作")])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "editgrade"
	    }
	  }, [_c('input', {
	    attrs: {
	      "type": "hidden",
	      "name": "classlevelId",
	      "id": "edit-classlevelId"
	    }
	  }), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("年级:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "classlevelName",
	      "id": "edit-classlevelName",
	      "data-vali": "notnull",
	      "maxlength": "10"
	    }
	  })])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "addgrade"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("年级:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "classlevelName",
	      "maxlength": "10",
	      "data-vali": "notnull"
	    }
	  })])])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-3e2ab366", module.exports)
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
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\basic\\context\\default.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(26)
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
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
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
		$("#edit_userType option[value='" + params.userType + "']").prop("selected", true);
		$('#edit_username').text(params.username);
		$('#edit_realname').val(params.realname);
		$('#edit_userId').val(params.userId);
		layer.open({
			type: 1,
			title: '编辑用户',
			skin: 'layui-layer-rim',
			//加上边框
			area: ['450px', '375px'],
			//宽高
			content: $("#edituser"),
			btn: ['确定', '取消'],
			yes: function yes(index, layero) {
				//添加表单验证--Validation
				var result = Validation.validation({
					containerId: "edituser"
				});
				if (result == true) {
					/*var editparams = $('#edituser').serialize();*/
					var editparams = {
						userType: $("#edit_userType").val(),
						password: md5($("#edit_password").val()),
						realname: $("#edit_realname").val()
					};
					CDUtil.ajaxPost("/base/user/update", editparams, function (retVO) {
						if (retVO.code == 1) {
							userSearch();
							layer.msg(retVO.msg);
							layer.close(index);
						}
						if (retVO.code == 0) {
							layer.msg(retVO.msg);
						}
					});
				}
			}
		});
	};
	/**
	 * 表格中的操作---删除用户
	**/
	var userDel = function userDel(params, dom) {
		layer.alert('确定删除该用户?', function (index) {
			var userId = params.userId;
			var useridParams = {
				userId: userId
			};
			CDUtil.ajaxPost("/base/user/delete", useridParams, function (retVO) {
				if (retVO.code == 1) {
					userSearch();
					layer.msg(retVO.msg);
					layer.close(index);
				}
				if (retVO.code == 0) {
					layer.msg(retVO.msg);
				}
			});
		});
	};

	/**
	 * 进行查询用户信息的方法
	**/
	var userSearch = function userSearch(newPage) {
		if (newPage == "undefined") {
			newPage = 1;
		}
		var params = {
			curPage: newPage,
			pageSize: 20,
			username: $("#search_username").val(),
			realname: $("#search_realname").val(),
			userType: $("#search_userType").val()
		};
		CDUtil.ajaxPost("/base/user/list", params, function (retVO) {
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};

	/**
	 * 表格中的操作--进行表格分页的配置
	**/
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{
			name: "用户名",
			valuekey: "username",
			css: "width: 130px;"
		}, {
			name: "姓名",
			valuekey: "realname",
			css: "width: 130px;"
		}, {
			name: "角色",
			valuekey: "userType_chinese"
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
		optParams: ["userId", "username", "realname", "userType", "userType_chinese", "password"],
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
	 * Vue组件对象
	**/
	exports.default = {
		created: function created() {
			this.userSear();
		},

		methods: {
			userSear: userSearch,
			/*** 添加用户**/
			addUser: function addUser() {
				layer.open({
					type: 1,
					title: '添加用户',
					skin: 'layui-layer-rim',
					//加上边框
					area: ['450px', '375px'],
					//宽高
					btn: ['确定', '取消'],
					content: $("#adduser"),
					yes: function yes(index, layero) {
						//添加表单验证--Validation
						var result = Validation.validation({
							containerId: "adduser"
						});
						if (result == true) {
							var addparams = {
								userType: $("#add_userType").val(),
								password: md5($("#add_password").val()),
								username: $("#add_username").val(),
								realname: $("#add_realname").val()
							};
							CDUtil.ajaxPost("/base/user/add", addparams, function (retVO) {
								if (retVO.code == 1) {
									userSearch();
									layer.msg(retVO.msg);
									layer.close(index);
									$('#adduser')[0].reset();
								}
								if (retVO.code == 0) {
									layer.msg(retVO.msg);
								}
							});
						}
					}
				});
			}
		}
	};

/***/ },
/* 49 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }, [_c('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.addUser
	    }
	  }, [_vm._v("添加用户")])]), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), _vm._v(" "), _vm._m(1), _vm._v(" "), _vm._m(2), _vm._v(" "), _c('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": function($event) {
	        _vm.userSear(1)
	      }
	    }
	  }, [_vm._v("查询")])])]), _vm._v(" "), _vm._v(" "), _vm._v(" "), _c('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")]), _vm._v(" "), _vm._v(" "), _vm._m(3), _vm._v(" "), _vm._v(" "), _vm._v(" "), _vm._m(4), _vm._v(" ")])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("用户名:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "username",
	      "id": "search_username",
	      "data-vali": "notnull,username",
	      "maxlength": "18"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("姓名:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "id": "search_realname",
	      "data-vali": "notnull",
	      "maxlength": "10"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("角色:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('select', {
	    attrs: {
	      "name": "userType",
	      "id": "search_userType"
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": "-1"
	    }
	  }, [_vm._v("请选择")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "ADMIN"
	    }
	  }, [_vm._v("管理员")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "TEACHER"
	    }
	  }, [_vm._v("教师")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "STUDENT"
	    }
	  }, [_vm._v("学生")])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "edituser"
	    }
	  }, [_c('input', {
	    attrs: {
	      "type": "hidden",
	      "name": "userId",
	      "id": "edit_userId"
	    }
	  }), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-row"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("用户名:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value",
	    attrs: {
	      "name": "username",
	      "id": "edit_username",
	      "maxlength": "18"
	    }
	  })]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("姓名:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "data-vali": "notnull",
	      "id": "edit_realname",
	      "maxlength": "10"
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("密码:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "password",
	      "name": "password",
	      "id": "edit_password",
	      "value": "666666"
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("角色:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('select', {
	    attrs: {
	      "name": "userType",
	      "id": "edit_userType"
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": "-1"
	    }
	  }, [_vm._v("请选择")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "ADMIN"
	    }
	  }, [_vm._v("管理员")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "TEACHER"
	    }
	  }, [_vm._v("教师")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "STUDENT"
	    }
	  }, [_vm._v("学生")])])])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "adduser"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("用户名:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "username",
	      "id": "add_username",
	      "data-vali": "notnull,username",
	      "value": ""
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("姓名:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "realname",
	      "data-vali": "notnull",
	      "id": "add_realname",
	      "value": ""
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("密码:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "password",
	      "name": "password",
	      "data-vali": "notnull,password",
	      "id": "add_password",
	      "value": ""
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("角色:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('select', {
	    attrs: {
	      "name": "userType",
	      "data-vali": "notnull",
	      "id": "add_userType",
	      "value": ""
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": "-1"
	    }
	  }, [_vm._v("请选择")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "ADMIN"
	    }
	  }, [_vm._v("管理员")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "TEACHER"
	    }
	  }, [_vm._v("教师")]), _vm._v(" "), _c('option', {
	    attrs: {
	      "value": "STUDENT"
	    }
	  }, [_vm._v("学生")])])])])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-3dc18aea", module.exports)
	  }
	}

/***/ },
/* 50 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(51)

	/* script */
	__vue_exports__ = __webpack_require__(53)

	/* template */
	var __vue_template__ = __webpack_require__(54)
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
	  var hotAPI = __webpack_require__(26)
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
/* 51 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(52);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(52, function() {
				var newContent = __webpack_require__(52);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 52 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.colorTd{color:#03a9f4\n}\n.colorTd span{cursor: pointer;\n}\n#sort td {\r\n    white-space: nowrap;\r\n    overflow: hidden;\r\n    white-space: nowrap;\r\n    -o-text-overflow: ellipsis;\r\n    text-overflow: ellipsis;\n}\r\n", ""]);

	// exports


/***/ },
/* 53 */
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

	/*vue组件*/
	exports.default = {
	  data: function data() {
	    return {
	      grades: ""
	    };
	  },
	  created: function created() {
	    this.show();
	  },

	  methods: {
	    /*显示表单数据*/
	    show: function show() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/subject/list", params, function (retVO) {
	        _self.grades = retVO;
	      });
	    },
	    /*编辑学科*/
	    manEdit: function manEdit(subjectName, subjectId) {
	      var _self = this;
	      $('#edit-subjectName').val(subjectName);
	      $('#edit-subjectId').val(subjectId);
	      layer.open({
	        type: 1,
	        title: '编辑学科',
	        skin: 'layui-layer-rim',
	        //加上边框
	        area: ['450px', '240px'],
	        //宽高
	        content: $("#editsubject"),
	        btn: ['确定', '取消'],
	        yes: function yes(index, layero) {
	          //添加表单验证--Validation
	          var result = Validation.validation({
	            containerId: "editsubject"
	          });
	          if (result == true) {
	            var editparams = $('#editsubject').serialize();
	            CDUtil.ajaxPost("/base/subject/update", editparams, function (retVO) {
	              if (retVO.code == 1) {
	                _self.show();
	                layer.msg(retVO.msg);
	                layer.close(index);
	              }
	              if (retVO.code == 0) {
	                layer.msg(retVO.msg);
	              }
	            });
	          }
	        }
	      });
	    },
	    /*删除学科*/
	    manDel: function manDel(subjectId) {
	      var _self = this;
	      layer.alert('确定删除该行数据?', function (index) {
	        var nanidParams = {
	          subjectId: subjectId
	        };
	        CDUtil.ajaxPost("/base/subject/delete", nanidParams, function (retVO) {
	          if (retVO.code == 1) {
	            _self.show();
	            layer.msg(retVO.msg);
	            layer.close(index);
	          }
	        });
	      });
	    },
	    /*添加学科*/
	    add: function add() {
	      var _self = this;
	      layer.open({
	        type: 1,
	        title: '添加学科',
	        skin: 'layui-layer-rim', //加上边框
	        area: ['450px', '240px'], //宽高
	        content: $("#addsubject"),
	        btn: ['确定', '取消'],
	        yes: function yes(index, layero) {
	          //添加表单验证--Validation
	          var result = Validation.validation({
	            containerId: "addsubject"
	          });
	          if (result == true) {
	            var addparams = $('#addsubject').serialize();
	            CDUtil.ajaxPost("/base/subject/add", addparams, function (retVO) {
	              if (retVO.code == 1) {
	                _self.show();
	                layer.close(index);
	                layer.msg(retVO.msg);
	                $('#addsubject')[0].reset();
	              }
	              if (retVO.code == 0) {
	                layer.msg(retVO.msg);
	              }
	            });
	          }
	        }
	      });
	    },
	    /**上移**/
	    upbtn: function upbtn(event) {
	      var el = event.target;
	      var $this = $(el);
	      var tr = $this.parents('tr');
	      var _index = tr.index();
	      var _str = "";
	      /*if (_index != 0) {*/
	      tr.prev().before(tr);
	      $("#sort tr").each(function () {
	        _str += $(this).find('td').attr("data-id") + ",";
	      });
	      CDUtil.ajaxPost("/base/subject/sort", { subjectIds: _str }, function (retVO) {});
	      /*}*/
	    },
	    /**下移**/
	    downbtn: function downbtn(event) {
	      var el = event.target;
	      var $this = $(el);
	      var tr = $this.parents('tr');
	      var trLength = $this.length;
	      var _index = tr.index();
	      var _str = "";
	      /*	if (_index != trLength - 1){ */
	      tr.next().after(tr);
	      $("#sort tr").each(function () {
	        _str += $(this).find('td').attr("data-id") + ",";
	      });
	      CDUtil.ajaxPost("/base/subject/sort", { subjectIds: _str }, function (retVO) {});
	      /*}*/
	    }
	  }
	};

/***/ },
/* 54 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }, [_c('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.add
	    }
	  }, [_vm._v("添加学科")])]), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "grade"
	    }
	  }, [_c('table', [_vm._m(0), _vm._v(" "), _c('tbody', {
	    attrs: {
	      "id": "sort"
	    }
	  }, _vm._l((_vm.grades.data), function(grade, index) {
	    return _c('tr', [_c('td', {
	      attrs: {
	        "data-id": grade.subjectId,
	        "title": grade.subjectName
	      }
	    }, [_vm._v(_vm._s(grade.subjectName))]), _vm._v(" "), _c('td', [_c('i', {
	      staticClass: "iconfont icon-moveup upbtn",
	      on: {
	        "click": _vm.upbtn
	      }
	    }), _c('i', {
	      staticClass: "iconfont icon-movedown downbtn",
	      on: {
	        "click": _vm.downbtn
	      }
	    })]), _vm._v(" "), _c('td', {
	      staticClass: "colorTd"
	    }, [_c('span', {
	      on: {
	        "click": function($event) {
	          _vm.manEdit(grade.subjectName, grade.subjectId)
	        }
	      }
	    }, [_vm._v("编辑")]), _vm._v("   "), _c('span', {
	      on: {
	        "click": function($event) {
	          _vm.manDel(grade.subjectId)
	        }
	      }
	    }, [_vm._v("删除")])])])
	  }))])]), _vm._v(" "), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "grade",
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")]), _vm._v(" "), _vm._v(" "), _vm._m(1), _vm._v(" "), _vm._v(" "), _vm._v(" "), _vm._m(2), _vm._v(" ")])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('thead', [_c('th', [_vm._v("学科")]), _c('th', [_vm._v("排序")]), _c('th', [_vm._v("操作")])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "editsubject"
	    }
	  }, [_c('input', {
	    attrs: {
	      "type": "hidden",
	      "name": "subjectId",
	      "id": "edit-subjectId"
	    }
	  }), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("学科:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "subjectName",
	      "id": "edit-subjectName",
	      "maxlength": "10",
	      "data-vali": "notnull"
	    }
	  })])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "addsubject"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row mt20"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("学科:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "subjectName",
	      "maxlength": "10",
	      "data-vali": "notnull"
	    }
	  })])])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-20b0f12a", module.exports)
	  }
	}

/***/ },
/* 55 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(56)

	/* template */
	var __vue_template__ = __webpack_require__(57)
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
	  var hotAPI = __webpack_require__(26)
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
/* 56 */
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

	/**
	 * Vue组件对象
	**/
	exports.default = {
	  created: function created() {
	    this.basic();
	  },

	  methods: {
	    /** 表单--内容获取**/
	    basic: function basic() {
	      CDUtil.ajaxPost("/base/basicinfo/get", {}, function (retVO) {
	        if (retVO.code == 1) {
	          $('#basic_tit').val(retVO.data.title);
	          $('#thispage_fileup_img').attr('src', retVO.data.logoPath);
	          console.log(retVO.data.logoPath);
	          $('#basic_btm').val(retVO.data.buttomMsg);
	        }
	      });
	    },
	    /** 表单操作--上传图片**/
	    impup: function impup() {
	      var fileDom = $("#thispage_fileup")[0];
	      var file = fileDom.files[0];
	      var fileupUrl = ROOT_SERVER + "/image/upload?token=" + sessionStorage.getItem("token");
	      var sequence = H5fileup.getSequence();
	      H5fileup.startFileup(file, fileupUrl, sequence, function (retVO) {
	        retVO = eval('(' + retVO + ')');
	        var dataVO = retVO.data;
	        var resourceId = dataVO.resourceId;
	        H5fileup.showImgAuto(file, "thispage_fileup_img");
	        $("#img_resourceId").val(resourceId);
	        $("#msg_img").val(true);
	      });
	    },
	    /** 表单操作--保存**/
	    subPlat: function subPlat() {
	      //添加表单验证--Validation
	      var result = Validation.validation({
	        containerId: "platform"
	      });
	      if (result == true) {
	        var platParams = $('#platform').serialize();
	        CDUtil.ajaxPost("/base/basicinfo/update", platParams, function (retVO) {
	          if (retVO.code == 1) {
	            layer.msg(retVO.msg);
	            $('#platform')[0].reset();
	            location.reload();
	          }
	          if (retVO.code == 0) {
	            layer.msg(retVO.msg);
	          }
	        });
	      }
	    }
	  }
	};

/***/ },
/* 57 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "platform"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(1), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('img', {
	    staticClass: "show",
	    attrs: {
	      "src": "",
	      "width": "360",
	      "height": "70",
	      "id": "thispage_fileup_img",
	      "file-name": "",
	      "file-path": ""
	    }
	  }), _vm._v(" "), _c('div', {
	    staticClass: "btn btn-default smp-fileupshow mt10"
	  }, [_vm._v("上传logo\r\n              "), _c('input', {
	    staticClass: "smp-fileupinput",
	    attrs: {
	      "type": "file",
	      "id": "thispage_fileup"
	    },
	    on: {
	      "change": function($event) {
	        _vm.impup();
	      }
	    }
	  }), _vm._v(" "), _c('input', {
	    attrs: {
	      "type": "hidden",
	      "id": "img_resourceId",
	      "name": "logoPath",
	      "value": ""
	    }
	  })])]), _vm._v(" "), _c('input', {
	    attrs: {
	      "type": "hidden",
	      "id": "msg_img",
	      "value": "false",
	      "name": "thumbFlag"
	    }
	  })]), _vm._v(" "), _vm._m(2), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve mt40"
	  }, [_vm._m(3), _vm._v(" "), _c('span', [_c('button', {
	    staticClass: "lay-btn green-btn mr20",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": _vm.subPlat
	    }
	  }, [_vm._v("保存")])])])])])])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', {
	    staticClass: "cd-f-notnull"
	  }, [_vm._v("*")]), _c('label', [_vm._v("网站title:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    staticClass: "w730",
	    attrs: {
	      "type": "text",
	      "name": "title",
	      "data-vali": "notnull",
	      "id": "basic_tit",
	      "maxlength": "50"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('span', {
	    staticClass: "cd-f-name vat"
	  }, [_c('label', {
	    staticClass: "cd-f-notnull"
	  }, [_vm._v("*")]), _c('label', [_vm._v("网站logo:")])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("网站底部:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    staticClass: "w730",
	    attrs: {
	      "type": "text",
	      "name": "buttomMsg",
	      "id": "basic_btm",
	      "maxlength": "100"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label')])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-a5d01dcc", module.exports)
	  }
	}

/***/ },
/* 58 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(59)

	/* script */
	__vue_exports__ = __webpack_require__(61)

	/* template */
	var __vue_template__ = __webpack_require__(62)
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
	  var hotAPI = __webpack_require__(26)
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
/* 59 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(60);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(60, function() {
				var newContent = __webpack_require__(60);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 60 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n#addServer input,#editServer input{width:249px;\n}\n\n", ""]);

	// exports


/***/ },
/* 61 */
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

	/**
	 * 表格中的操作---编辑服务器
	**/
	var servEdit = function servEdit(params, dom) {
		$('#search_serverName').val(params.serverName);
		$('#search_serverValue').val(params.serverValue);
		$('#search_serverId').val(params.serverId);
		layer.open({
			type: 1,
			title: '编辑服务器',
			skin: 'layui-layer-rim',
			//加上边框
			area: ['450px', '288px'],
			//宽高
			content: $("#editServer"),
			btn: ['确定', '取消'],
			yes: function yes(index, layero) {
				//添加表单验证--Validation
				var result = Validation.validation({
					containerId: "editServer"
				});
				if (result == true) {
					var editparams = $('#editServer').serialize();
					CDUtil.ajaxPost("/base/dmsserver/update", editparams, function (retVO) {
						if (retVO.code == 1) {
							servSearch();
							layer.msg(retVO.msg);
							layer.close(index);
							$('#editServer')[0].reset();
						}
						if (retVO.code == 0) {
							layer.msg(retVO.msg);
						}
					});
				}
			}
		});
	};
	/**
	 * 表格中的操作---删除服务器
	**/
	var servDel = function servDel(params, dom) {
		layer.alert('确认删除该服务器吗?', function (index) {
			var serverid = params.serverId;
			var servidParams = {
				serverId: serverid
			};
			CDUtil.ajaxPost("/base/dmsserver/delete", servidParams, function (retVO) {
				if (retVO.code == 1) {
					servSearch();
					layer.msg(retVO.msg);
					layer.close(index);
				}
				if (retVO.code == 0) {
					layer.msg(retVO.msg);
				}
			});
		});
	};
	/**
	 * 进行查询服务器信息的方法
	**/
	var servSearch = function servSearch(newPage) {
		if (newPage == "undefined") {
			newPage = 1;
		}
		var params = {
			curPage: newPage,
			pageSize: 20
		};
		CDUtil.ajaxPost("/base/dmsserver/list", params, function (retVO) {
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};
	/**
	 * 表格中的操作--进行表格分页的配置
	**/
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{ name: "序号", valuekey: "sort" }, { name: "服务器名称", valuekey: "serverName", css: "width: 130px;" }, { name: "DMS 地址", valuekey: "serverValue", css: "width: 130px;" }, { name: "操作", valuekey: "opt", type: "opt" }],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: servSearch,
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["serverId", "sort", "serverName", "serverValue"],
		//表格中的行操作名称
		optName: {
			edit_fun: "编辑",
			del_fun: "删除"
		},
		//表格中的行操作方法
		optFuns: {
			edit_fun: servEdit,
			del_fun: servDel
		}
	};
	/**
	 * Vue组件对象
	**/
	exports.default = {
		created: function created() {
			this.server();
		},

		methods: {
			server: servSearch,
			add: function add() {
				layer.open({
					type: 1,
					title: '添加服务器',
					skin: 'layui-layer-rim', //加上边框
					area: ['450px', '288px'], //宽高
					btn: ['确定', '取消'],
					content: $("#addServer"),
					yes: function yes(index, layero) {
						//添加表单验证--Validation
						var result = Validation.validation({
							containerId: "addServer"
						});
						if (result == true) {
							var addparams = $('#addServer').serialize();
							CDUtil.ajaxPost("/base/dmsserver/add", addparams, function (retVO) {
								if (retVO.code == 1) {
									servSearch();
									layer.msg(retVO.msg);
									layer.close(index);
									$('#addServer')[0].reset();
								}
								if (retVO.code == 0) {
									layer.msg(retVO.msg);
								}
							});
						}
					}
				});
			}
		}
	};

/***/ },
/* 62 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }, [_c('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.add
	    }
	  }, [_vm._v("新增服务器")])]), _vm._v(" "), _vm._m(0), _vm._v(" "), _vm._v(" "), _vm._m(1), _vm._v(" "), _vm._v(" "), _vm._v(" "), _vm._m(2), _vm._v(" ")])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "dashboard"
	  }, [_c('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "editServer"
	    }
	  }, [_c('input', {
	    attrs: {
	      "type": "hidden",
	      "name": "serverId",
	      "id": "search_serverId"
	    }
	  }), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-row"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', {
	    staticClass: "cd-f-notnull"
	  }, [_vm._v("*")]), _c('label', [_vm._v("服务器名称:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value",
	    attrs: {
	      "name": "serverName"
	    }
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverName",
	      "id": "search_serverName",
	      "data-vali": "notnull"
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', {
	    staticClass: "cd-f-notnull"
	  }, [_vm._v("*")]), _c('label', [_vm._v("服务器地址:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverValue",
	      "id": "search_serverValue",
	      "data-vali": "notnull"
	    }
	  })])])])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('form', {
	    staticClass: "layBox",
	    attrs: {
	      "action": "",
	      "id": "addServer"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', {
	    staticClass: "cd-f-notnull"
	  }, [_vm._v("*")]), _c('label', [_vm._v("服务器名称:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value",
	    attrs: {
	      "name": "serverName"
	    }
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverName",
	      "data-vali": "notnull"
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', {
	    staticClass: "cd-f-notnull"
	  }, [_vm._v("*")]), _c('label', [_vm._v("服务器地址:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "name": "serverValue",
	      "data-vali": "notnull"
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label')]), _vm._v(" ")])])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-921130ac", module.exports)
	  }
	}

/***/ },
/* 63 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(64)

	/* template */
	var __vue_template__ = __webpack_require__(65)
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
	  var hotAPI = __webpack_require__(26)
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
/* 64 */
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

	var data = { newPage: 1 };
	/**
	 * 表格中的操作---删除上传资源
	**/
	var uploadDel = function uploadDel(params, dom) {
		layer.alert('确定删除该行数据?', function (index) {
			var resourceId = params.resourceId;
			var reidParams = {
				resourceId: resourceId
			};
			CDUtil.ajaxPost("/resource/delete", reidParams, function (retVO) {
				if (retVO.code == 1) {
					uploadSearch();
					layer.msg(retVO.msg);
					layer.close(index);
				}
				if (retVO.code == 0) {
					layer.msg(retVO.msg);
				}
			});
		});
	};
	/**
	 * 表格中的操作---查看上传资源
	**/
	var uploadView = function uploadView(params, dom) {
		sessionStorage.setItem("resourceId", params.resourceId);
		window.open(ROOT_UI + "/front/path/demond?token=" + sessionStorage.getItem("token"));
	};
	/**
	 * 表格中的操作---编辑上传资源
	**/
	var uploadEdit = function uploadEdit(params, dom) {
		sessionStorage.setItem("resourceId", params.resourceId);
		window.open(ROOT_UI + "/front/path/upload?token=" + sessionStorage.getItem("token"));
	};
	/**
	 * 进行查询上传信息的方法
	**/
	var uploadSearch = function uploadSearch(newPage) {
		if (newPage == "undefined") {
			newPage = 1;
		}
		var params = {
			curPage: newPage,
			pageSize: 20,
			resourceNameKey: $("#search_resourceName").val(),
			authorKey: $("#search_author").val(),
			classlevelName: $("#search_classlevelName").val(),
			subjectName: $("#search_subjectName").val(),
			sourceType: "RECORD"
		};
		CDUtil.ajaxPost("/resource/list", params, function (retVO) {
			params.curPage = retVO.curPage;
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};

	/**
	 * 进行表格分页的配置
	**/
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{ name: "资源名称", valuekey: "resourceName" }, { name: "年级", valuekey: "classlevelName", css: "width: 130px;" }, { name: "学科", valuekey: "subjectName" }, { name: "主讲教师", valuekey: "author" }, { name: "操作", valuekey: "opt", type: "opt" }],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: uploadSearch,
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["resourceId", "classlevelName", "resourceName", "subjectName", "author", "creatName"],
		//表格中的行操作名称
		optName: {
			view_fun: "查看",
			edit_fun: "编辑",
			del_fun: "删除"
		},
		//表格中的行操作方法
		optFuns: {
			view_fun: uploadView,
			edit_fun: uploadEdit,
			del_fun: uploadDel
		}
	};

	/**
	 * Vue组件对象
	**/
	exports.default = {
		data: function data() {
			return {
				classList: "",
				subjectList: ""
			};
		},
		created: function created() {
			this.search_one(), this.showclass(), this.showsubject();
		},

		methods: {
			/*查询列表数据*/
			search_one: uploadSearch,
			/*获取年级列表*/
			showclass: function showclass() {
				var _self = this;
				var params = {};
				CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
					_self.classList = retVO;
				});
			},
			/*获取学科列表*/
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
/* 65 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), _vm._v(" "), _vm._m(1), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(2), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('select', {
	    attrs: {
	      "data-vali": "notnull",
	      "name": "classlevelName",
	      "id": "search_classlevelName"
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": ""
	    }
	  }, [_vm._v("请选择年级")]), _vm._l((_vm.classList.data), function(grade) {
	    return _c('option', [_vm._v(_vm._s(grade.classlevelName))])
	  })], true)])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(3), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('select', {
	    attrs: {
	      "data-vali": "notnull",
	      "name": "subjectName",
	      "id": "search_subjectName"
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": ""
	    }
	  }, [_vm._v("全部")]), _vm._l((_vm.subjectList.data), function(subject) {
	    return _c('option', [_vm._v(_vm._s(subject.subjectName))])
	  })], true)])]), _vm._v(" "), _c('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": function($event) {
	        _vm.search_one(1)
	      }
	    }
	  }, [_vm._v("查询")])])]), _vm._v(" "), _vm._v(" "), _c('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("资源名称:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "resourceName",
	      "id": "search_resourceName",
	      "maxlength": "30"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("主讲教师:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "author",
	      "id": "search_author"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("年级:")])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("学科:")])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-3ce516fc", module.exports)
	  }
	}

/***/ },
/* 66 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* script */
	__vue_exports__ = __webpack_require__(67)

	/* template */
	var __vue_template__ = __webpack_require__(68)
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
	  var hotAPI = __webpack_require__(26)
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
/* 67 */
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

	/**
	 * 表格中的操作---删除上传资源
	**/
	var uploadDel = function uploadDel(params, dom) {
		layer.alert('确定删除该行数据?', function (index) {
			var resourceId = params.resourceId;
			var reidParams = {
				resourceId: resourceId
			};
			CDUtil.ajaxPost("/resource/delete", reidParams, function (retVO) {
				if (retVO.code == 1) {
					uploadSearch();
					layer.msg(retVO.msg);
					layer.close(index);
				}
				if (retVO.code == 0) {
					layer.msg(retVO.msg);
				}
			});
		});
	};
	/**
	 * 表格中的操作---查看上传资源
	**/
	var uploadView = function uploadView(params, dom) {
		sessionStorage.setItem("resourceId", params.resourceId);
		window.open(ROOT_UI + "/front/path/demond?token=" + sessionStorage.getItem("token"));
	};
	/**
	 * 表格中的操作---编辑上传资源
	**/
	var uploadEdit = function uploadEdit(params, dom) {
		sessionStorage.setItem("resourceId", params.resourceId);
		window.open(ROOT_UI + "/front/path/upload?token=" + sessionStorage.getItem("token"));
	};
	/**
	 * 进行查询上传信息的方法
	**/
	var uploadSearch = function uploadSearch(newPage) {
		if (newPage == "undefined") {
			newPage = 1;
		}
		var params = {
			curPage: newPage,
			pageSize: 20,
			resourceNameKey: $("#search_resourceName").val(),
			authorKey: $("#search_author").val(),
			classlevelName: $("#search_classlevelName").val(),
			subjectName: $("#search_subjectName").val(),
			sourceType: "UPLOAD"
		};
		CDUtil.ajaxPost("/resource/list", params, function (retVO) {
			params.curPage = retVO.curPage;
			config.gData = retVO;
			Grid.initGrid(config, function () {});
		});
	};
	//进行表格分页的配置
	var config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{ name: "资源名称", valuekey: "resourceName" }, { name: "年级", valuekey: "classlevelName", css: "width: 130px;" }, { name: "学科", valuekey: "subjectName" }, { name: "主讲教师", valuekey: "author" }, { name: "上传人", valuekey: "creatName" }, { name: "操作", valuekey: "opt", type: "opt" }],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: uploadSearch,
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["resourceId", "classlevelName", "resourceName", "subjectName", "author", "creatName"],
		//表格中的行操作名称
		optName: {
			view_fun: "查看",
			edit_fun: "编辑",
			del_fun: "删除"
		},
		//表格中的行操作方法
		optFuns: {
			view_fun: uploadView,
			edit_fun: uploadEdit,
			del_fun: uploadDel
		}
	};

	/**
	 * Vue组件对象
	**/
	exports.default = {
		data: function data() {
			return {
				classList: "",
				subjectList: ""
			};
		},
		created: function created() {
			this.search_one(), this.showclass(), this.showsubject();
		},

		methods: {
			/*查询列表数据*/
			search_one: uploadSearch,
			/*获取年级列表*/
			showclass: function showclass() {
				var _self = this;
				var params = {};
				CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
					_self.classList = retVO;
				});
			},
			/*获取学科列表*/
			showsubject: function showsubject() {
				var _self = this;
				var params = {};
				CDUtil.ajaxPost("/base/subject/list", params, function (retVO) {
					_self.subjectList = retVO;
				});
			},
			/*跳转到上传资源页面*/
			openUploadup: function openUploadup() {
				sessionStorage.removeItem("resourceId");
				window.open(ROOT_UI + "/front/path/upload?token=" + sessionStorage.getItem("token"));
			}
		}
	};

/***/ },
/* 68 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "content"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }, [_c('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": function($event) {
	        _vm.openUploadup()
	      }
	    }
	  }, [_vm._v("上传课程视频")])]), _vm._v(" "), _c('div', {
	    staticClass: "dashboard"
	  }, [_c('form', {
	    attrs: {
	      "action": "",
	      "id": "condition"
	    }
	  }, [_c('div', {
	    staticClass: "cd-f-row"
	  }, [_vm._m(0), _vm._v(" "), _vm._m(1), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(2), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('select', {
	    attrs: {
	      "data-vali": "notnull",
	      "name": "classlevelName",
	      "id": "search_classlevelName"
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": ""
	    }
	  }, [_vm._v("请选择年级")]), _vm._l((_vm.classList.data), function(grade) {
	    return _c('option', [_vm._v(_vm._s(grade.classlevelName))])
	  })], true)])]), _vm._v(" "), _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_vm._m(3), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('select', {
	    attrs: {
	      "data-vali": "notnull",
	      "name": "subjectName",
	      "id": "search_subjectName"
	    }
	  }, [_c('option', {
	    attrs: {
	      "value": ""
	    }
	  }, [_vm._v("全部")]), _vm._l((_vm.subjectList.data), function(subject) {
	    return _c('option', [_vm._v(_vm._s(subject.subjectName))])
	  })], true)])]), _vm._v(" "), _c('button', {
	    staticClass: "sBtn",
	    attrs: {
	      "type": "button"
	    },
	    on: {
	      "click": function($event) {
	        _vm.search_one(1)
	      }
	    }
	  }, [_vm._v("查询")])])]), _vm._v(" "), _vm._v(" "), _c('div', {
	    attrs: {
	      "id": "use_to_load_grid"
	    }
	  }), _vm._v(" ")])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("资源名称:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "resourceName",
	      "id": "search_resourceName",
	      "maxlength": "30"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "cd-f-eve"
	  }, [_c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("主讲教师:")])]), _vm._v(" "), _c('span', {
	    staticClass: "cd-f-value "
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "data-vali": "notnull",
	      "name": "author",
	      "id": "search_author"
	    }
	  })])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("年级:")])])
	},function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('span', {
	    staticClass: "cd-f-name"
	  }, [_c('label', [_vm._v("学科:")])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-154fb768", module.exports)
	  }
	}

/***/ },
/* 69 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(70)

	/* script */
	__vue_exports__ = __webpack_require__(72)

	/* template */
	var __vue_template__ = __webpack_require__(73)
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
	  var hotAPI = __webpack_require__(26)
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
/* 70 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(71);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(71, function() {
				var newContent = __webpack_require__(71);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 71 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\nbody{background-color: #f5f8fa;\n}\r\n", ""]);

	// exports


/***/ },
/* 72 */
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

	/****点击进入点播详情页****/
	window.openDemondDetail = function (resourceId) {
	  CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
	    if (retVO.code == 1) {
	      sessionStorage.setItem("resourceId", resourceId);
	      window.open(ROOT_UI + "/front/path/demond?token=" + sessionStorage.getItem("token"));
	    } else {
	      //alert("用户信息失效");
	      layerIndex = layer.confirm('未登录暂无权限访问', {
	        btn: ['确定']
	      }, function () {
	        layer.close(layerIndex);
	        sessionStorage.clear();
	        window.location.href = ROOT_SERVER + "/#/index";
	      });
	    }
	  });
	};
	/**
	 * Vue组件对象
	**/
	exports.default = {
	  data: function data() {
	    return {
	      courseList: "",
	      classList: "",
	      subjectList: "",
	      pages: "",
	      params: {
	        orderType: "desc",
	        pageSize: 16

	      }
	    };
	  },
	  created: function created() {
	    this.showdemand(), this.showclass(), this.showsubject();
	  },

	  methods: {
	    /** 查询点播列表 **/
	    showdemand: function showdemand(newPage) {
	      if (newPage == "undefined") {
	        newPage = 1;
	      }
	      var _self = this;
	      _self.params.curPage = newPage;
	      var params = this.params;
	      CDUtil.ajaxPost("/demand/list", params, function (retVO) {
	        _self.courseList = retVO;
	        _self.pages = retVO.totalDatas;
	        var config = {
	          //用来展示表格控件的div的id
	          containerId: "de_list",
	          //这个应该是后台返回的部分
	          gData: retVO,
	          //是否需要分页，true：需要，不写默认需要
	          pagingFlag: true,
	          //用来拼接单个循环体的回调方法。
	          spellHtmlFun: function spellHtmlFun(data) {
	            if (data.classlevelName.length > 7) {
	              var classLevelName = data.classlevelName.substr(0, 7) + "...";
	            } else {
	              var classLevelName = data.classlevelName;
	            }
	            var htmlStr = '<div class="col-4" onClick="openDemondDetail(\'' + data.resourceId + '\')">';
	            htmlStr += '<div class="demandImg">';
	            htmlStr += '<img src=' + data.thumbPath + ' width="280" height="157">';
	            htmlStr += '<div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>' + data.viewCnt + '</span></div> ';
	            htmlStr += '</div>';
	            htmlStr += '<p class="c4 tel">' + data.resourceName + '</p>';
	            htmlStr += '<p class="ft12 c9 tel"><span class="sub-code" title=' + data.classlevelName + '>' + classLevelName + '</span>&nbsp;' + data.subjectName + '&nbsp;' + data.author + '</p>';
	            htmlStr += ' </div>';
	            /*  无消息显示 */
	            if (data.resourceId == "") {
	              htmlStr += '<div id="de_list"><p>暂无相关数据</p></div>';
	            }
	            return htmlStr;
	          },
	          //执行页面查询的方法
	          searchFun: _self.showdemand
	        };
	        Paging.initPaging(config, function () {});
	      });
	    },
	    /** 获取选择的年级参数**/
	    gradesearch: function gradesearch(classlevelName, event) {
	      $(event.target).addClass("active").siblings().removeClass("active");
	      console.log(classlevelName);
	      this.params = Object.assign({}, this.params, { classlevelName: classlevelName });
	      if (classlevelName == '') {
	        $('.grade-tit').text('全部');
	      } else {
	        $('.grade-tit').text(classlevelName);
	      }
	      this.showdemand();
	    },
	    /** 获取选择的学科参数**/
	    subjectsearch: function subjectsearch(subjectName, event) {
	      $(event.target).addClass("active").siblings().removeClass("active");
	      this.params = Object.assign({}, this.params, { subjectName: subjectName });
	      if (subjectName == '') {
	        $('.sub-tit').text('全部');
	      } else {
	        $('.sub-tit').text(subjectName);
	      }
	      this.showdemand();
	    },
	    /** 根据时间排序**/
	    sortByTime: function sortByTime(e) {
	      $(e.target).toggleClass("arrow");
	      if ($(e.target).hasClass("arrow")) {
	        $(e.target).find("i").removeClass("icon-low").addClass("icon-up");
	      } else {
	        $(e.target).find("i").removeClass("icon-up").addClass("icon-low");
	      }
	      $(e.target).addClass("active").siblings().removeClass("active");
	      e.stopPropagation();
	      var $sortType = $(e.target).attr("data-sort");
	      if ($sortType === "desc") {
	        $(e.target).attr("data-sort", "asc");
	        this.params.orderType = "asc";
	      } else {
	        $(e.target).attr("data-sort", "desc");
	        this.params.orderType = "desc";
	      }
	      this.params = Object.assign({}, this.params, { orderBy: "createTime" });
	      this.showdemand();
	    },
	    /** 根据热度排序**/
	    sortByHot: function sortByHot(e) {
	      e.stopPropagation();
	      $(e.target).toggleClass("arrow");
	      if ($(e.target).hasClass("arrow")) {
	        $(e.target).find("i").removeClass("icon-low").addClass("icon-up");
	      } else {
	        $(e.target).find("i").removeClass("icon-up").addClass("icon-low");
	      }
	      $(e.target).addClass("active").siblings().removeClass("active");
	      var $sortType = $(e.target).attr("data-sort");
	      if ($sortType === "desc") {
	        $(e.target).attr("data-sort", "asc");
	        this.params.orderType = "asc";
	      } else {
	        $(e.target).attr("data-sort", "desc");
	        this.params.orderType = "desc";
	      }
	      this.params = Object.assign({}, this.params, { orderBy: "viewCnt" });
	      this.showdemand();
	    },
	    /** 根据关键字排序**/
	    searchKey: function searchKey() {
	      var sourceName = $('#s_resource').val();
	      this.params = Object.assign({}, this.params, { resourceNameKey: sourceName });
	      if (sourceName == '') {
	        $('.key').text('');
	      } else {
	        $('.key').text(sourceName);
	      }
	      this.showdemand();
	    },
	    /** 获取年级列表 **/
	    showclass: function showclass() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/base/classlevel/list", params, function (retVO) {
	        _self.classList = retVO;
	      });
	    },
	    /** 获取学科列表 **/
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
/* 73 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "demand"
	  }, [_c('div', {
	    staticClass: "d-search"
	  }, [_c('div', [_c('label', [_vm._v("年级 :")]), _c('div', {
	    staticClass: "itemList"
	  }, [_c('span', {
	    staticClass: "active",
	    on: {
	      "click": function($event) {
	        _vm.gradesearch('', $event)
	      }
	    }
	  }, [_vm._v("全部")]), _vm._l((_vm.classList.data), function(grade) {
	    return _c('span', {
	      on: {
	        "click": function($event) {
	          _vm.gradesearch(grade.classlevelName, $event)
	        }
	      }
	    }, [_vm._v(_vm._s(grade.classlevelName))])
	  })], true)]), _vm._v(" "), _c('div', [_c('label', [_vm._v("学科 :")]), _c('div', {
	    staticClass: "itemList"
	  }, [_c('span', {
	    staticClass: "active",
	    on: {
	      "click": function($event) {
	        _vm.subjectsearch('', $event)
	      }
	    }
	  }, [_vm._v("全部")]), _vm._l((_vm.subjectList.data), function(subject) {
	    return _c('span', {
	      on: {
	        "click": function($event) {
	          _vm.subjectsearch(subject.subjectName, $event)
	        }
	      }
	    }, [_vm._v(_vm._s(subject.subjectName))])
	  })], true)])]), _vm._v(" "), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "d-main"
	  }, [_c('div', {
	    staticClass: "search"
	  }, [_c('div', {
	    staticClass: "s-left"
	  }, [_vm._v("\""), _c('i', {
	    staticClass: "sub-tit"
	  }, [_vm._v("全部")]), _vm._v(" "), _c('i', {
	    staticClass: "grade-tit"
	  }, [_vm._v("全部")]), _vm._v(" "), _c('i', {
	    staticClass: "key"
	  }), _vm._v("\"相关课程  共" + _vm._s(_vm.pages) + "条\r\n\t\t\t\t"), _c('span', {
	    staticClass: "active",
	    attrs: {
	      "data-sort": "desc"
	    },
	    on: {
	      "click": _vm.sortByTime
	    }
	  }, [_vm._v("按时间"), _c('i', {
	    staticClass: "iconfont icon-low"
	  })]), _vm._v(" "), _c('span', {
	    attrs: {
	      "data-sort": "desc"
	    },
	    on: {
	      "click": _vm.sortByHot
	    }
	  }, [_vm._v("按热门"), _c('i', {
	    staticClass: "iconfont icon-low"
	  })])]), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "s-right fr"
	  }, [_c('input', {
	    attrs: {
	      "type": "text",
	      "placeholder": "输入课程或老师",
	      "name": "resourceNameKey",
	      "id": "s_resource"
	    },
	    on: {
	      "keyup": function($event) {
	        if (_vm._k($event.keyCode, "enter", 13)) { return; }
	        _vm.searchKey($event)
	      }
	    }
	  }), _vm._v(" "), _c('i', {
	    staticClass: "iconfont icon-search",
	    on: {
	      "click": _vm.searchKey
	    }
	  })])]), _vm._v(" "), _c('div', {
	    staticClass: "clear"
	  }), _vm._v(" "), _vm._v(" "), _vm._m(0), _vm._v(" ")])])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "list mt30",
	    attrs: {
	      "id": "de_list"
	    }
	  }, [_c('div', {
	    staticClass: "clear"
	  }), _vm._v(" ")])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-4aaaeaf7", module.exports)
	  }
	}

/***/ },
/* 74 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(75)

	/* script */
	__vue_exports__ = __webpack_require__(77)

	/* template */
	var __vue_template__ = __webpack_require__(78)
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
	  var hotAPI = __webpack_require__(26)
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
/* 75 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(76);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(76, function() {
				var newContent = __webpack_require__(76);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 76 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\nbody{background-color: #fff;\n}\n.s-title .demanCour{margin:0;\n}\n", ""]);

	// exports


/***/ },
/* 77 */
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

	/**
	 * 弹出框的层信息
	**/
	var laryIndex = null;
	/**
	 * Vue组件对象
	**/
	exports.default = {
	  data: function data() {
	    return {
	      posts: "",
	      courseList: ""
	    };
	  },
	  created: function created() {
	    this.show(), this.showdemand();
	  },

	  filters: {
	    cutStr: function cutStr(value) {
	      if (value.length > 7) {
	        return value.substr(0, 7) + "...";
	      } else {
	        return value;
	      }
	    }
	  },
	  methods: {
	    isShow: function isShow() {
	      return this.data.length;
	    },
	    /** 获取列表的方法 alert($('.sub-code').text());**/
	    show: function show() {
	      var _self = this;
	      var params = {};
	      CDUtil.ajaxPost("/home/live/list", params, function (retVO) {
	        _self.posts = retVO;
	      }, false);
	    },
	    /** 获取点播列表的方法 **/
	    showdemand: function showdemand() {
	      var _self = this;
	      var params = { pageSize: 8 };
	      CDUtil.ajaxPost("/demand/list", params, function (retVO) {
	        _self.courseList = retVO; //JSON.parse(retVO);
	      }, false);
	    },
	    /** 跳转到直播详情页 **/
	    openLiveDetail: function openLiveDetail(resourceId) {
	      CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
	        if (retVO.code == 1) {
	          sessionStorage.setItem("resourceId", resourceId);
	          //window.open(ROOT_SERVER+"/pages/views/live/live_detail.jsp?token="+sessionStorage.getItem("token"));
	          window.open(ROOT_SERVER + "/front/path/live?token=" + sessionStorage.getItem("token"));
	        } else {
	          //alert("用户信息失效");
	          laryIndex = layer.confirm('未登录暂无权限访问', {
	            btn: ['确定']
	          }, function () {
	            layer.close(laryIndex);
	            sessionStorage.clear();
	            window.location.href = ROOT_SERVER + "/#/index";
	            window.location.reload();
	          });
	        }
	      });
	    },
	    /** 跳转到点播详情页 **/
	    openDemondDetail: function openDemondDetail(resourceId) {
	      CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
	        if (retVO.code == 1) {
	          sessionStorage.setItem("resourceId", resourceId);
	          window.open(ROOT_UI + "/front/path/demond?token=" + sessionStorage.getItem("token"));
	        } else {
	          //alert("用户信息失效");
	          layerIndex = layer.confirm('未登录暂无权限访问', {
	            btn: ['确定']
	          }, function () {
	            layer.close(layerIndex);
	            sessionStorage.clear();
	            window.location.href = ROOT_SERVER + "/#/index";
	            window.location.reload();
	          });
	        }
	      });
	    },
	    openMore: function openMore() {
	      window.location.href = ROOT_SERVER + "/#/onDemand";
	      window.location.reload();
	    }
	  }
	};

/***/ },
/* 78 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "wamp",
	    attrs: {
	      "id": "home"
	    }
	  }, [_vm._m(0), _vm._v(" "), _vm._v(" "), _c('div', {
	    attrs: {
	      "id": "courseList"
	    }
	  }, [(_vm.posts.data != '') ? _c('div', _vm._l((_vm.posts.data), function(post) {
	    return _c('div', {
	      staticClass: "row"
	    }, [_c('div', {
	      staticClass: "col-md-4 tel c4"
	    }, [_vm._v(_vm._s(post.resourceName))]), _vm._v(" "), _c('div', {
	      staticClass: "col-md-4 tel"
	    }, [_c('span', {
	      staticClass: "sub-code",
	      attrs: {
	        "title": post.classlevelName
	      }
	    }, [_vm._v(_vm._s(_vm._f("cutStr")(post.classlevelName)))]), _vm._v("/" + _vm._s(post.subjectName) + "/" + _vm._s(post.author))]), _vm._v(" "), _c('div', {
	      staticClass: "col-md-4",
	      on: {
	        "click": function($event) {
	          _vm.openLiveDetail(post.resourceId)
	        }
	      }
	    }, [_c('i', {
	      staticClass: "iconfont icon-avpic"
	    }), _vm._v("进入直播")])])
	  })) : _c('div', {
	    staticClass: "tac"
	  }, [_c('img', {
	    attrs: {
	      "src": __webpack_require__(79)
	    }
	  })]), _vm._v(" ")]), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "s-title demanBtm"
	  }, [_c('span'), _c('h3', {
	    staticClass: "demanCour fb fl"
	  }, [_vm._v("点播课程")]), _c('div', {
	    staticClass: "movede fr",
	    on: {
	      "click": _vm.openMore
	    }
	  }, [_vm._v("更多")])]), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "demand"
	  }, _vm._l((_vm.courseList.data), function(course) {
	    return _c('div', {
	      staticClass: "col-4",
	      on: {
	        "click": function($event) {
	          _vm.openDemondDetail(course.resourceId)
	        }
	      }
	    }, [_c('div', {
	      staticClass: "home-img"
	    }, [_c('img', {
	      attrs: {
	        "src": course.thumbPath,
	        "width": "285",
	        "height": "160"
	      }
	    }), _vm._v(" "), _c('div', {
	      staticClass: "home-times"
	    }, [_c('span', {
	      staticClass: "fr"
	    }, [_c('i', {
	      staticClass: "iconfont icon-play-times"
	    }), _vm._v(_vm._s(course.viewCnt))])])]), _vm._v(" "), _c('p', {
	      staticClass: "c4 tel",
	      attrs: {
	        "title": course.resourceName
	      }
	    }, [_vm._v(_vm._s(course.resourceName))]), _vm._v(" "), _c('p', {
	      staticClass: "ft12 c9 tel"
	    }, [_c('span', {
	      staticClass: "sub-code",
	      attrs: {
	        "title": course.classlevelName
	      }
	    }, [_vm._v(_vm._s(_vm._f("cutStr")(course.classlevelName)))]), _vm._v(" " + _vm._s(course.subjectName) + " " + _vm._s(course.author))])])
	  })), _vm._v(" ")])
	},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "s-title"
	  }, [_c('span'), _c('h3', {
	    staticClass: "fb"
	  }, [_vm._v("直播课程")])])
	}]}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-5553608b", module.exports)
	  }
	}

/***/ },
/* 79 */
/***/ function(module, exports, __webpack_require__) {

	module.exports = __webpack_require__.p + "8bed79dd627549783788bf671a45567f.png";

/***/ },
/* 80 */
/***/ function(module, exports, __webpack_require__) {

	var __vue_exports__, __vue_options__
	var __vue_styles__ = {}

	/* styles */
	__webpack_require__(81)

	/* script */
	__vue_exports__ = __webpack_require__(83)

	/* template */
	var __vue_template__ = __webpack_require__(84)
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
	__vue_options__.__file = "E:\\CodyyWorkspace\\slrSpace\\SchoolLiveRecord\\src\\main\\webapp\\pages\\views\\mySubject.vue"
	__vue_options__.render = __vue_template__.render
	__vue_options__.staticRenderFns = __vue_template__.staticRenderFns

	/* hot reload */
	if (true) {(function () {
	  var hotAPI = __webpack_require__(26)
	  hotAPI.install(__webpack_require__(1), false)
	  if (!hotAPI.compatible) return
	  module.hot.accept()
	  if (!module.hot.data) {
	    hotAPI.createRecord("data-v-5849b738", __vue_options__)
	  } else {
	    hotAPI.reload("data-v-5849b738", __vue_options__)
	  }
	})()}
	if (__vue_options__.functional) {console.error("[vue-loader] mySubject.vue: functional components are not supported and should be defined in plain js files using render functions.")}

	module.exports = __vue_exports__


/***/ },
/* 81 */
/***/ function(module, exports, __webpack_require__) {

	// style-loader: Adds some css to the DOM by adding a <style> tag

	// load the styles
	var content = __webpack_require__(82);
	if(typeof content === 'string') content = [[module.id, content, '']];
	// add the styles to the DOM
	var update = __webpack_require__(9)(content, {});
	if(content.locals) module.exports = content.locals;
	// Hot Module Replacement
	if(true) {
		// When the styles change, update the <style> tags
		if(!content.locals) {
			module.hot.accept(82, function() {
				var newContent = __webpack_require__(82);
				if(typeof newContent === 'string') newContent = [[module.id, newContent, '']];
				update(newContent);
			});
		}
		// When the module is disposed, remove the <style> tags
		module.hot.dispose(function() { update(); });
	}

/***/ },
/* 82 */
/***/ function(module, exports, __webpack_require__) {

	exports = module.exports = __webpack_require__(7)();
	// imports


	// module
	exports.push([module.id, "\n.mysubject .search{line-height:37px;\n}\n.mysubject .subBtn{height: 70px;padding-top: 30px;\n}\r\n", ""]);

	// exports


/***/ },
/* 83 */
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

	var _data = { mycourceList: "", pages: "" };
	/****点击进入点播详情页****/
	window.openDemondDetail = function (resourceId) {
		CDUtil.ajaxPost("/token/hasexpire", {}, function (retVO) {
			if (retVO.code == 1) {
				sessionStorage.setItem("resourceId", resourceId);
				window.open(ROOT_UI + "/front/path/demond?token=" + sessionStorage.getItem("token"));
			} else {
				//alert("用户信息失效");
				layerIndex = layer.confirm('未登录暂无权限访问', {
					btn: ['确定']
				}, function () {
					layer.close(layerIndex);
					sessionStorage.clear();
					window.location.href = ROOT_SERVER + "/#/index";
				});
			}
		});
	};
	window.mySub = function (newPage) {
		if (newPage == "undefined") {
			newPage = 1;
		}
		var _self = this;
		var params = { curPage: newPage, pageSize: 2 };
		CDUtil.ajaxPost("/resource/myresource/list", params, function (retVO) {
			_data.mycourceList = retVO;
			_data.pages = retVO.totalDatas;
			var htmlStr = "";
			var config = {
				//用来展示表格控件的div的id
				containerId: "sub_list",
				//这个应该是后台返回的部分
				gData: retVO,
				//是否需要分页，true：需要，不写默认需要
				pagingFlag: true,
				//用来拼接单个循环体的回调方法。
				spellHtmlFun: function spellHtmlFun(data) {
					if (data.classlevelName.length > 7) {
						var classLevelName = data.classlevelName.substr(0, 7) + "...";
					} else {
						var classLevelName = data.classlevelName;
					}
					var htmlStr = '<div class="col-4">';
					htmlStr += '<div class="demandImg" onClick="openDemondDetail(\'' + data.resourceId + '\')">';
					htmlStr += '<img src=' + data.thumbPath + ' width="280" height="157">';
					htmlStr += '<div class="times"><span class="fr"><i class="iconfont icon-play-times"></i>' + data.viewCnt + '</span></div> ';
					htmlStr += '</div>';
					htmlStr += '<p class="c4 tel">' + data.resourceName + '</p>';
					htmlStr += '<p class="ft12 c9 tel"><span class="sub-code" title=' + data.classlevelName + '>' + classLevelName + '</span>&nbsp;' + data.subjectName + '&nbsp;' + data.author + '</p>';
					htmlStr += '<div class="sub-del" onClick="mysubjectDel(\'' + data.resourceId + '\')"><i class="iconfont icon-delete"></i></div>';
					htmlStr += ' </div>';
					/*  无消息显示 */
					if (data.resourceId == "") {
						htmlStr += '<div id="sub_list"><p>暂无相关数据</p></div>';
					}
					return htmlStr;
				},
				//执行页面查询的方法
				searchFun: mySub
			};
			Paging.initPaging(config, function () {});
		});
	};
	window.mysubjectDel = function (resourceId) {
		layer.alert('删除后则该资源在点播列表同步删除?', function (index) {
			var reidParams = { resourceId: resourceId };
			CDUtil.ajaxPost("/resource/delete", reidParams, function (retVO) {
				if (retVO.code == 1) {
					mySub();
					layer.msg(retVO.msg);
					layer.close(index);
				}
			});
		});
	};
	exports.default = {
		data: function data() {
			return _data;
		},
		created: function created() {
			this.showdemand();
		},

		methods: {
			showdemand: mySub,
			/*跳转到上传资源页面*/
			openUploadup: function openUploadup() {
				window.open(ROOT_UI + "/front/path/upload?token=" + sessionStorage.getItem("token"));
			}
		}
	};

/***/ },
/* 84 */
/***/ function(module, exports, __webpack_require__) {

	module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._c;
	  return _c('div', {
	    staticClass: "mysubject"
	  }, [_c('div', {
	    staticClass: "subBtn"
	  }, [_c('button', {
	    staticClass: "btn fr",
	    on: {
	      "click": _vm.openUploadup
	    }
	  }, [_vm._v("上传资源")])]), _vm._v(" "), _c('div', {
	    staticClass: "demand"
	  }, [_c('div', {
	    staticClass: "d-main"
	  }, [_c('div', {
	    staticClass: "search"
	  }, [_vm._v("\n\t\t\t\t共" + _vm._s(_vm.pages) + "个资源\n\t\t\t")]), _vm._v(" "), _c('div', {
	    staticClass: "clear"
	  }), _vm._v(" "), _vm._v(" "), _c('div', {
	    staticClass: "list mt40",
	    attrs: {
	      "id": "sub_list"
	    }
	  }), _vm._v(" "), _c('div', {
	    staticClass: "clear"
	  }), _vm._v(" ")]), _vm._v(" ")])])
	},staticRenderFns: []}
	if (true) {
	  module.hot.accept()
	  if (module.hot.data) {
	     __webpack_require__(26).rerender("data-v-5849b738", module.exports)
	  }
	}

/***/ }
]);