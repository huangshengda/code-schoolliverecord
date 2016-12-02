<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ROOT_UI = "http://localhost:8080/SchoolLiveRecord";
	String ROOT_UI_PUBLIC = ROOT_UI+"/public";
	String ROOT_UI_DIST = ROOT_UI+"/dist";
	String ROOT_SERVER = "http://localhost:8080/SchoolLiveRecord";
%>
<script type="text/javascript">
/**
 * 前端资源文件的根目录
 */
ROOT_UI = "<%=ROOT_UI%>";
ROOT_UI_PUBLIC = ROOT_UI+"/public";
ROOT_UI_MODULE = ROOT_UI_PUBLIC+"/_module";
ROOT_UI_PAGES = ROOT_UI+"/pages";
/**
 * 服务端的根目录（可以有多个服务端
 */
ROOT_SERVER = "<%=ROOT_SERVER%>";
/**
 * 文件上传服务端的根目录（可以有多个服务端
 */
ROOT_SERVER_FILEUP = "";
/**  
 * TEST服务端的根目录（注意别复制代码不看备注
 */
ROOT_SERVER_TEST = "";
</script>
<link rel="stylesheet" type="text/css" href="./public/myLayer/layer/skin/layer.css">