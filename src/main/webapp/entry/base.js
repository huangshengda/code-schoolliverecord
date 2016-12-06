console.log("这是基础组件打包的js入口");
console.log(ROOT_UI);

/*require(['jquery'],function($){
	window.$ = $;
	window.jquery = $;
	window.jQuery = $;
});*/

window.jquery = $;
window.jQuery = $;
//console.log($);

/**  加载接口开发的前端Mock  **/
window.Mock = require('../public/mock/dist/mock-min');
require('../public/_module/js/slr_mockjs');

/**  加载基础CSS文件  **/
require('../public/_compnents/v1/css/base.css');
require('../public/_compnents/v1/css/compnents.css');
require('../public/bootstrap/css/bootstrap.css');
require('../public/jquery-ui/jquery-ui.css');
require('../public/jquery-ui/jquery-ui.theme.css');
/*require('../public/myLayer/layer/skin/layer.css');*/

/**  加载本系统的基础样式   **/
require('../public/_module/css/slr_base.css');
/**  加载本系统的图标库  **/
require('../public/_module/icon/iconfont.css');

/**  加载编码加密工具  **/
window.md5 = require('../public/md5/md5');

/**  加载自定义JS组件  **/
window.CDUtil = require('../public/_tools/CDUtil');
window.ValueCheck = require('../public/_tools/ValueCheck');
window.Grid = require('../public/_compnents/v1/js/Grid');
window.H5fileup = require('../public/_compnents/v1/js/H5fileup');
window.Paging = require('../public/_compnents/v1/js/Paging');
window.Validation = require('../public/_compnents/v1/js/Validation');
/**  加载依赖于jQuery的JS组件  **/
/*require('imports?$=jquery!../public/jquery/jquery.dotdotdot');
require('imports?$=jquery!../public/jquery-ui/jquery-ui');*/
/*require('imports?$=jquery!../public/myLayer/layer/layer');*/

/**  示例  **/
/*$( "#datepicker" ).datepicker({
	dateFormat: "yy-mm-dd",
	gotoCurrent: true
});
$("#test_dot").dotdotdot({height: 20 });*/