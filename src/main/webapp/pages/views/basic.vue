<template>
		<div class="main">
			<div class="left fl">
			  <!-- 左侧的二级菜单 -->
			  <sidebar></sidebar>
			</div>
			<div class="right fl">
			  <!-- <levelbar></levelbar> -->
			  <router-view></router-view>
			</div>
		</div>
</template>
<script>
	var Sidebar = require('../_commons/layout/Sidebar.vue')
	var Levelbar = require('../_commons/layout/Levelbar.vue')
	export default {
	  name: 'app',
	  components: {
	    Sidebar,
	    Levelbar
	  },
	}
</script>
<style>
	.left{width:240px;border:1px solid #ddd;margin-right:10px;background-color: #fff;padding:0 15px;text-align: center;margin-top:40px;min-height: 600px;}
	.right{width:880px;}
	.main{margin-top:10px;}
	.subBtn{height:40px;}
  	.dashboard{border:1px solid #ddd;background-color: #fff;padding: 20px;}
.layBox{display: none;}
</style>