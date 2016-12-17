/**
* 定义系统中使用的评论组件
* 
* 描述：创建包含评论模块，配置每条评论的简单操作
* Create By: Liang.Vm
* 组件版本：V1.0.0
* 依赖：jQuery, jquery.qqFace, Paging, ValueCheck 
**/
//;(function(window, document) {
//修改成AMD模式加载的组件
;define(function() {
	//需要用new创建的对象
	function Comment() {
		return this.init(arguments);
	}
	Comment.fn = Comment.prototype = {
		init: function() {
			console.log("初始化---Comment");
			this.objectName = "Comment";
			return this;
		},
		testInit: function() {
			// 直接打印对象
			console.log(this.objectName);
			return this;
		}
	};
	
	//默认的全部配置，以及注释说明
	Comment.def_config = {
		
	};
	
	
	
	Comment.addStaticMethod = function(nmSpace, obj, ftn) {
	};
	Comment.addObjectMethod = function(nmSpace, obj, ftn) {
	};
	
	return Comment;
});
//window.Comment = Comment;
//})(window, document,undefined);