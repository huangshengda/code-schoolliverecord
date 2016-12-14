<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 * 前端资源文件的根目录
 */
ROOT_UI = "${ROOT_UI}";
ROOT_UI_PUBLIC = ROOT_UI+"/public";
ROOT_UI_MODULE = ROOT_UI_PUBLIC+"/_module";
ROOT_UI_PAGES = ROOT_UI+"/pages";
publicPath = ROOT_UI_PUBLIC;
/**
 * 服务端的根目录（可以有多个服务端
 */
ROOT_SERVER = "${ROOT_SERVER}";
/**  
 * 在线聊天后台地址根目录
 */
ROOT_SERVER_CHAT = "${ROOT_CHAT}/chat";
</script>
<link rel="stylesheet" type="text/css" href="${ROOT_UI}/public/myLayer/layer/skin/layer.css">
<script type="text/javascript" src="${ROOT_UI}/public/jquery/jquery-2.2.4.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/jquery/jquery.serializejson.min.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/public/myLayer/layer/layer.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_manifest.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_common.js" ></script>
<script type="text/javascript" src="${ROOT_UI}/dist/slr_base.js" ></script>