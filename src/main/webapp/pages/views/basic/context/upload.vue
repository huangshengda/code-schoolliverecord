<template>
<div class="content">
  <div class="subBtn"><button class="btn fr">上传课程视频</button></div>
  <div class="dashboard">
  <!-- 条件 start -->
    <form action="" id="condition">
       <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>资源名称:</label></span>
          <span class="cd-f-value ">
            <input type="text" data-vali="notnull" name="resourceName">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>主讲教师:</label></span>
          <span class="cd-f-value ">
            <input type="text" data-vali="notnull" name="author">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>年级:</label></span>
          <span class="cd-f-value ">
            <select data-vali="notnull"><option v-for="grade in classList.data">{{grade.classlevelName}}</option></select>
          </span>
        </div>   
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>学科:</label></span>
          <span class="cd-f-value ">
            <select data-vali="notnull"><option v-for="subject in subjectList.data">{{subject.subjectName}}</option></select>
          </span>
        </div>   
        <button class="sBtn" type="button" @click="search_one">查询</button>
      </div>
    </form>
    <!-- 表单 start -->
    <div id="use_to_load_grid" ></div>
    <!-- 表单 end -->
  </div>
</div>
</template>
<script>

export default { 
  data() {
    return {
       classList:"",
       subjectList:""
    }
  },
  mounted () {    
    this.search_one(),
    this.showclass(),
    this.showsubject()
    },
  methods: {
    search_one: function(){
      //Validation
        var result = Validation.validation({
          containerId: "condition",
        });
        if(result==true){}
    var params = {};
    CDUtil.ajaxPost("/resource/list",params,function(retVO){
        var config = {
          //用来展示表格控件的div的id
          containerId: "use_to_load_grid",
          //用来展示表格的表头数据
          thead: [{name:"资源名称",valuekey:"resourceName",width: "100px"},
                  {name:"年级",valuekey:"classlevelName"},
                  {name:"学科",valuekey:"subjectName"},
                  {name:"主讲教师",valuekey:"author"},
                  {name:"上传人",valuekey:"creatName"},
                  {name:"操作",valuekey:"opt",type:"opt"}
          ],
          //用来展示表格的数据
          //这个应该是后台返回的部分
          gData: retVO,
          //是否需要分页，true：需要，不写默认需要
          pagingFlag: true,
          //执行页面查询的方法
          searchFun: function(){

          },
          //需要用来配合表格行操作的属性，不写默认不做任何数据缓存。
          optParams: ["resourceId","creatName"],
          //表格中的行操作名称
          optName: {view_fun:"查看",edit_fun:"编辑",del_fun:"删除"},
          //表格中的行操作方法
          optFuns: {edit_fun:function(params,dom){
              window.open('up_subject.html');
            },del_fun:function(params,dom){
                layer.alert('确定删除该行数据?',function(index){
                layer.close(index);
                layer.msg('删除成功!')
               });
              /* ajaxCallPost("/resource/delete",{"num1":params.num1},callback);*/
            },
            view_fun:function(){
            	
            },
          }
      };
      Grid.initGrid(config,function(){});
    });
  },
  showclass:function(){
        var _self = this;
        $.ajax({
          type:'POST',
          url:'mockjs_class_list.json',
          success:function(data){
            _self.classList = JSON.parse(data);
          }
        });
      },
      showsubject:function(){
        var _self = this;
        $.ajax({
          type:'POST',
          url:'mockjs_subject_list.json',
          success:function(data){
            _self.subjectList = JSON.parse(data);
          }
        });
      }
}
}
</script>
