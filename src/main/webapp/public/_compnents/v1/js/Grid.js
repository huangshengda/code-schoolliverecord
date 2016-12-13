/**
 * 初始化文字表格
 * 
 * @param window
 * @param document
 * 依赖：jquery，_compnents.css
 */
//;(function(window, document) {
//修改成AMD模式加载的组件
;define(function() {
	//需要用new创建的对象
	function Grid() {
		return this.init(arguments);
	}
	Grid.fn = Grid.prototype = {
		init: function() {
			console.log("初始化---Grid对象");
			this.objectName = "Grid";
			return this;
		},
		testInit: function() {
			// 直接打印对象
			console.log(this.objectName);
			return this;
		}
	};
	//默认全属性配置，仅做参考
	Grid.def_config = {
		//用来展示表格控件的div的id
		containerId: "use_to_load_grid",
		//用来展示表格的表头数据
		thead: [{name:"编号",valuekey:"num1",width: "60px"},
		        {name:"立项号",valuekey:"num2",width: "100px"},
		        {name:"课题名称",valuekey:"num3"},
		        {name:"负责人",valuekey:"num4",width: "80px"},
		        {name:"所属活动",valuekey:"num5"},
		        {name:"审核级别",valuekey:"num6",width: "80px"},
		        {name:"状态",valuekey:"num7",width: "120px"},
		        {name:"操作",valuekey:"opt",type:"opt"}
		],
		//用来展示表格的数据
		//这个应该是后台返回的部分
		gData: {totalDatas:66,totalPages:7,curPage:1,
			data:[{num1:"111",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"222",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"333",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"444",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"555",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"666",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"777",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"888",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"999",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]},
			      {num1:"000",num2:"",num3:"",num4:"",num5:"num5",num6:"",num7:"",opt:["add_fun","del_fun"]}]
		},
		//是否需要分页，true：需要，不写默认需要
		pagingFlag: true,
		//执行页面查询的方法
		searchFun: function(){},
		//需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
		optParams: ["num1","num5"],
		//表格中的行操作名称
		optName: {add_fun:"新增",del_fun:"删除"},
		//表格中的行操作方法
		optFuns: {add_fun:function(params,dom){
				console.log(params);
				console.log(dom);
			},del_fun:function(params,dom){
				console.log(params);
				console.log(dom);
			}
		}
	};
	Grid.initGrid = function(_config,callback){
		var containerId = _config.containerId,
		thead = _config.thead,
		gData = _config.gData,
		pagingFlag = (_config.pagingFlag==null || _config.pagingFlag == undefined )?true:_config.pagingFlag,
		searchFun = _config.searchFun,
		optParams = _config.optParams==undefined?false:_config.optParams,
		optName = _config.optName==undefined?false:_config.optName,
		optFuns = _config.optFuns==undefined?false:_config.optFuns;
		var totalDatas = ValueCheck.getNumber(gData.totalDatas,0),
		totalPages = ValueCheck.getNumber(gData.totalPages,0),
		curPage = ValueCheck.getNumber(gData.curPage,1),
		data = gData.data;
		var htmlStr = '<div class="cd-g-header">共<span class="totalnums" >'+totalDatas+'</span>条数据。</div>';
		htmlStr += '<div class="cd-g-context" ></div>';
		htmlStr += '<div class="cd-g-paging" ></div>';
		$("#"+containerId).html(htmlStr);
		Grid.initGridHeader();
		Grid.initGridTable(containerId,thead,data,optName,optFuns,optParams);
		Grid.initGridOptEvent(containerId,optFuns,optParams);
		if(pagingFlag){
			Grid.initGridPaging(containerId,totalPages,curPage);
			Grid.initGridPagingEvent(containerId,searchFun);
		}
	};
	Grid.initGridHeader = function(){
		
	};
	Grid.initGridTable = function(containerId,thead,data,optName,optFuns,optParams){
		var context = $("#"+containerId).find(".cd-g-context").get(0);
		var htmlStr = '';
		htmlStr += '<table class="cd-g-table" ><thead></thead><tbody></tbody></table>';
		$(context).html(htmlStr);
		Grid.initGridTableHeader(containerId,thead);
		if(data == null || data.length == 0){
			var htmlStr = '<div style="width: 100%;text-align: center;line-height: 300px;" >'+'<img src="'+ROOT_UI_PUBLIC+'/_compnents/v1/images/grid_have_nodata.png" /></div>';
			$(htmlStr).appendTo(context);
		}else{
			Grid.initGridTableBody(containerId,thead,data,optName,optFuns,optParams);
		}
	};
	Grid.initGridTableHeader = function(containerId,thead){
		var theadDom = $("#"+containerId).find("thead").get(0);
		var htmlStr = '<tr>';
		$(thead).each(function(){
			htmlStr += '<th data-valuekey="'+this.valuekey+'"';
			if(this.width != "" && typeof(this.width) != "undefined"){
				htmlStr += ' style="width: '+this.width+';"';
			}
			htmlStr += ' >'+this.name+'</th>';
		});
		htmlStr += '</tr>';
		$(theadDom).html(htmlStr);
	};
	Grid.initGridTableBody = function(containerId,thead,data,optName,optFuns,optParams){
		var tbodyDom = $("#"+containerId).find("tbody").get(0);
		var htmlStr = '';
		$(data).each(function(){
			var dataRow = this;
			htmlStr += '<tr';
			//console.log(typeof(optParams));
			if(optParams !=null ){
				$(optParams).each(function(){
					if(dataRow[this] == null){
						dataRow[this] = "";
					}
					htmlStr += ' data-'+this+'="'+dataRow[this]+'" ';
				});
			}
			htmlStr += '>';
			$(thead).each(function(){
				htmlStr += '<td';
				if(this.css != "" && typeof(this.css) != "undefined"){
					htmlStr += ' style="'+this.css+'"';
					htmlStr += ' title="'+dataRow[this.valuekey]+'" ';
				}
				htmlStr += '>';
				if(this.type == "opt"){
					var opts = dataRow[this["valuekey"]];
					if(!opts){
						$.each(optName,function(type,text){
							htmlStr += '<span data-opttype="'+type+'" >'+text+'</span>';
						});
					}else{
						$(opts).each(function(){
							if(optName[this] == undefined){
								htmlStr += '<span data-opttype="'+this+'" >操作配置错误</span>';
							}else{
								htmlStr += '<span data-opttype="'+this+'" >'+optName[this]+'</span>';
							}
						});
					}
				}else if(this.type == "clickable"){
					htmlStr += '<span ' ;
					if(typeof(this.optCode) == "string"){
						htmlStr += ' style="cursor: pointer;" data-opttype="'+this.optCode+'" ' ;
					}
					htmlStr += '>'+dataRow[this.valuekey]+'</span>';
					
				}else{
					//给字段提供自定义convertor转换的方法
					if(typeof(this.convertor)=="function"){
						htmlStr += ''+this.convertor.call(this,dataRow[this.valuekey],dataRow)+'';
					}else{
						htmlStr += ' '+dataRow[this.valuekey]+' ';
					}
				}
				htmlStr += '</td>';
			});
			htmlStr += '</tr>';
		});
		$(tbodyDom).html(htmlStr);
	};
	Grid.initGridOptEvent = function(containerId,optFuns,optParams,thead){
		var thisWindowUsed= $("#"+containerId).data("thisWindowUsed");
		if(!thisWindowUsed){
			$.each(optFuns,function(name,value) {
				//console.log(name);
				$("#"+containerId).delegate("[data-opttype='"+name+"']","click",function(){
					var trDom = $(this).parents("tr").get(0);
					var params = {};
					$.each(optParams,function(index,value){
						params[value]=$(trDom).attr('data-'+value) ;
					});
					if(typeof(value)=="function"){
						value.call(this,params,trDom);
					}
					//将调用的tr dom对象作为最后一个参数传递给方法，可以选择接收或是不接收
				});
			});
			$("#"+containerId).data("thisWindowUsed",true);
		}
	}
	Grid.initGridPaging = function(containerId,totalPages,curPage){
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
			+'<ul>去第<input type="number" min="1" max="'+totalPages+'" class="" style="height: 24px" value="1" />'
			+'页&nbsp;&nbsp;<button class="smp-button one">确定</button></ul>';
		$(pagingDom).html(htmlStr);
		$(pagingDom).show();
	};
	Grid.initGridPagingEvent = function(containerId,searchFun){
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
			//console.log($("gotoUl").children("input"));
			newPage = $(this).siblings("input").val();
			// newPage = $($("gotoUl").children("input").get(0)).val();
			//console.log(newPage);
			if(newPage<1 || newPage>totalPages)return;
			searchFun(newPage);
		});
		//$("#"+containerId).html("");
	};
	Grid.addStaticMethod = function(nmSpace, obj, ftn) {
	};
	Grid.addObjectMethod = function(nmSpace, obj, ftn) {
	};
	return Grid;
});
//window.Grid = Grid;
//})(window, document, undefined);