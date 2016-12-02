<template>
	<div class="cd-f w1200 pa10" id="container" >
	<form id="use_form" action="">
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve" >
				<span class="cd-f-name" >
					<label class="cd-f-notnull" >*</label><label class="fz14">用户名：</label>
				</span>
				<span class="cd-f-value " >
					<input type="text" class="w150 h30" data-vali="notnull,username" />
					<i class="fz14">图标</i>
				</span>
			</div>
			<div class="cd-f-eve" >
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value " >
					<input type="text" class="w150 h30" />
				</span>
			</div>
			<div class="cd-f-eve" >
				<span class="cd-f-name" >
					<label class="cd-f-notnull" >*</label><label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value " >
					<input type="text" class="w150 h30" data-vali="notnull,email" data-vali-regex="正则表达式" data-vali-msg="错误信息" />
				</span>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve" >
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value " >
					<input type="text" class="w150 h30" />
				</span>
			</div>
			<div class="cd-f-eve" >
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value " >
					<input type="text" class="w150 h30" />
				</span>
			</div>
			<div class="cd-f-eve" >
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value " >
					<input type="text" class="w150 h30" />
				</span>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve" style="width: 100%;" >
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value banner" >
					<input type="text" class="w150 h30" />
					<input type="text" class="w150 h30 ml10" />
					<input type="text" class="w150 h30 ml10" />
				</span>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve" style="width: 100%;" >
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value banner" >
					<input type="text" class="w750 h30"/>
				</span>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve" style="width: 100%;" >
				<span class="cd-f-name vat " >
					<label class="cd-f-notnull" >*</label><label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value" >
					<textarea class="w750 h50" data-vali="notnull,email" ></textarea>
				</span>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve" style="width: 100%;" >
				<span class="cd-f-name up" >
					<label class="cd-f-notnull" >*</label><label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value down" >
					<textarea class="w850 h50" data-vali="notnull,email" ></textarea>
				</span>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" >
			<div class="cd-f-eve">
				<span class="cd-f-name" >
					<label class="fz14">这是名称：</label>
				</span>
				<span class="cd-f-value" >
					<input type="text" class="w150 h30"/>
				</span>
			</div>
			<div class="cd-f-eve">
				<button type="button" id="use_search" >查询</button>
			</div>
		</div>
		<!-- 表单中的行对象 -->
		<div class="cd-f-row" style="text-align: center;" >
			<button type="button" id="use_save" >保存</button>
			<button type="button" style="margin-left: 20px;" >取消</button>
		</div>
	</form>
	</div>
</template>
<script>
  export default {
    props:{},
    mounted () {  	
		this.check()
    },
    methods:{
    	check () {
		     $(this.$el).on("click", "#use_search", function(){
				CDUtil.eventMng(function(){
					var url = "url"
					var params= {name: "zhangsan"}
					CDUtil.ajaxPost(url,params,function(ret){
						alert("异步操作成功")
					})
				})
			})
			var submitFun = function(){
				//form.submit()
			}
			$(this.$el).on("click", "#use_save",function(){
				var config = {
					//包含元素的Top容器id
					containerId: "container",
					formId: "use_form",
					submitFun: submitFun
				}
				Validation.validation(config,function(){
					
				})
			})
    	}
    }
  }
</script>