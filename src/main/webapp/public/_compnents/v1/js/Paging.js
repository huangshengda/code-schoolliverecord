/**
 * 初始化文字表格
 * 
 * @param window
 * @param document
 */
//;(function(window, document) {
//修改成AMD模式加载的组件
;define(function() {
	//需要用new创建的对象
	function Paging() {
		return this.init(arguments);
	}
	Paging.fn = Paging.prototype = {
		init: function() {
			console.log("初始化---Paging");
			this.objectName = "Paging";
			return this;
		},
		testInit: function() {
			// 直接打印对象
			console.log(this.objectName);
			return this;
		}
	};
	//默认全属性配置，仅做参考
	Paging.def_config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {totalDatas:66,totalPages:7,curPage:1,
			data:[{id:"8867854",title:"111",context:"",datetime:""},
			      {id:"8867854",title:"222",context:"",datetime:""},
			      {id:"8867854",title:"333",context:"",datetime:""},
			      {id:"8867854",title:"444",context:"",datetime:""},
			      {id:"8867854",title:"555",context:"",datetime:""},
			      {id:"8867854",title:"666",context:"",datetime:""},
			      {id:"8867854",title:"777",context:"",datetime:""},
			      {id:"8867854",title:"888",context:"",datetime:""},
			      {id:"8867854",title:"999",context:"",datetime:""},
			      {id:"8867854",title:"000",context:"",datetime:""},
			      {id:"8867854",title:"111",context:"",datetime:""},
			      {id:"8867854",title:"111",context:"",datetime:""},
			      {id:"8867854",title:"111",context:"",datetime:""}]
		},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//用来拼接单个循环体的回调方法。
		spellHtmlFun: function(){},
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["id","title"],
		//执行页面查询的方法
		searchFun: function(){}
	};
	Paging.initPaging = function(_config,callback){

		var containerId = _config.containerId,
		gData = _config.gData,
		pagingFlag = (_config.pagingFlag==null || _config.pagingFlag == undefined )?true:_config.pagingFlag,
		spellHtmlFun = _config.spellHtmlFun,
		searchFun = _config.searchFun,
		optParams = _config.optParams;
		var totalDatas = ValueCheck.getNumber(gData.totalDatas,0),
		totalPages = ValueCheck.getNumber(gData.totalPages,0),
		curPage = ValueCheck.getNumber(gData.curPage,1),
		data = gData.data;
		var htmlStr = '<div class="cd-g-context" ></div>';
		htmlStr += '<div class="cd-g-paging" ></div>';
		$("#"+containerId).html(htmlStr);
		Paging.initPagingContext(containerId,data,spellHtmlFun,optParams);
		if(pagingFlag){
			Paging.initPagingHtml(containerId,totalPages,curPage);
			Paging.initPagingEvent(containerId,searchFun);
		}
		if(typeof callback == "function"){
			callback(gData);
		}
	};
	Paging.initPagingContext = function(containerId,data,spellHtmlFun,optParams){
		var context = $("#"+containerId).children(".cd-g-context").get(0);
		var htmlStr = '';
		$(data).each(function(){
			htmlStr += spellHtmlFun(this,optParams);
		});
		$(context).html(htmlStr);
	};
	Paging.initPagingHtml = function(containerId,totalPages,curPage){
		if(totalPages<2)return;
		var pagingDom = $("#"+containerId).children(".cd-g-paging").get(0);
		$(pagingDom).attr("data-totalPages",totalPages);
		$(pagingDom).attr("data-curPage",curPage);
		var htmlStr = '<ul><li><i class="iconfont icon-arrow-left"></i></li></ul>';
		htmlStr += '<ul>'
		if(totalPages<9){
			for(var i=1;i<(totalPages+1);i++){
				if(i==curPage){
					htmlStr += '<li class="active" data-pagenum="'+i+'" >'+i+'</li>';
				}else{
					htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
				}
			}
		}else{
			if(curPage<4){
				for(var i=1;i<(totalPages+1);i++){
					if(i==curPage){
						htmlStr += '<li class="active" data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i<5){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i == (totalPages-2)){
						htmlStr += '...'
					}else if(i>(totalPages-2)){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}
				}
			}else if(curPage==4){
				for(var i=1;i<(totalPages+1);i++){
					if(i==curPage){
						htmlStr += '<li class="active" data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i<6){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i == (totalPages-2)){
						htmlStr += '...'
					}else if(i>(totalPages-2)){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}
				}
			}else if(curPage==(totalPages-3)){
				for(var i=1;i<(totalPages+1);i++){
					if(i==curPage){
						htmlStr += '<li class="active" data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i<3){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i == 3){
						htmlStr += '...'
					}else if(i>(totalPages-5)){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}
				}
			}else if(curPage>(totalPages-3)){
				for(var i=1;i<(totalPages+1);i++){
					if(i==curPage){
						htmlStr += '<li class="active" data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i<3){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i == 3){
						htmlStr += '...'
					}else if(i>(totalPages-4)){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}
				}
			}else{
				for(var i=1;i<(totalPages+1);i++){
					if(i==curPage){
						htmlStr += '<li class="active" data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i<3){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i>(curPage-2) &&i<(curPage+2)){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}else if(i==3){
						htmlStr += ' ... ';
					}else if(i == (totalPages-2)){
						htmlStr += ' ... '
					}else if(i>(totalPages-2)){
						htmlStr += '<li data-pagenum="'+i+'" >'+i+'</li>';
					}
				}
			}
		}
		htmlStr += '</ul>';
		htmlStr += '<ul><li><i class="iconfont icon-arrow-right"></i></li></ul>'
			+'<ul>去第<input type="number" min="1" max="'+totalPages+'" class="" value="1" />'
			+'页&nbsp;&nbsp;<button class="smp-button one">确定</button></ul>';
		$(pagingDom).html(htmlStr);
		$(pagingDom).show();
	};
	Paging.initPagingEvent = function(containerId,searchFun){
		var pagingDom = $("#"+containerId).children(".cd-g-paging").get(0);
		var curPage = parseInt($(pagingDom).attr("data-curpage"));
		var totalPages = parseInt($(pagingDom).attr("data-totalpages"));
		var ulDoms = $(pagingDom).children("ul");
		var prevUl = ulDoms.get(0);
		var numUl = ulDoms.get(1);
		var nextUl = ulDoms.get(2);
		var gotoUl = ulDoms.get(3);
		var newPage = curPage;
		$(prevUl).delegate("li","click",function(){
			if(curPage==1)return;
			newPage -= 1;
			searchFun(newPage);
		});
		$(numUl).delegate("li","click",function(){
			newPage =  parseInt($(this).attr("data-pagenum"));
			searchFun(newPage);
		});
		$(nextUl).delegate("li","click",function(){
			if(curPage==totalPages)return;
			newPage += 1;
			searchFun(newPage);
		});
		$(gotoUl).delegate("button","click",function(){
			newPage = $($(gotoUl).children("input").get(0)).val();
			if(newPage<1 || newPage>totalPages)return;
			searchFun(newPage);
		});
	};
	Paging.addStaticMethod = function(nmSpace, obj, ftn) {
	};
	Paging.addObjectMethod = function(nmSpace, obj, ftn) {
	};
	return Paging;
});
//window.Paging = Paging;
//})(window, document, undefined);