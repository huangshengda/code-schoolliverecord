<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">添加学科</button></div>
 <div class="dashboard">
  <!-- 表单 start -->
    <form action="" id="grade">
    <table>
      <thead><th>学科</th><th>排序</th><th>操作</th></thead>
      <tbody>
        <tr v-for="(grade,index) in grades">
        <td>{{grade.subjectName}}</td>
        <td v-if="index===0"><i class="iconfont icon-movedown"></i></td>
        <template v-else> 
         <td v-if="index===(grades.length-1)"><i class="iconfont icon-moveup"></i></td>
         <td v-else><i class="iconfont icon-moveup"></i><i class="iconfont icon-movedown"></i></td>
        </template>
        <td>{{grade.editfun}}&nbsp;{{grade.delfun}}</td></tr>
      </tbody>
    </table>
  </form> 
  <!-- 表单 start -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" class="grade"></div>
    <!-- 表单 end --> 
  </div>
      <!-- 编辑用户弹窗表单 start -->
  <form action="" id="editsubject" class="layBox">
   <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn mr20">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>
        </div>
    </div>
  </form>
    <!-- 编辑用户弹窗表单 end -->
    <!-- 添加用户弹窗表单 start -->
  <form action="" id="addsubject" class="layBox">
    <div class="cd-f-row mt20">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>学科:</label></span>
          <span class="cd-f-value">
            <input type="text" name="subjectName">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn mr20">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>
        </div>
    </div>
  </form>
    <!-- 添加用户弹窗表单 end -->
</div>
</template>
<script>
   export default {
    data() {
      return {
       grades:"",
      }
    },
     mounted () {    
      this.show()
    },
         methods: {
       show: function(){
       var _self = this;
        var params = {};
        CDUtil.ajaxPost("/base/subject/list",params,function(retVO){
        	_self.grades = retVO;  
        });
      },
      add: function(){
          layer.open({
              type: 1,
              title: '添加学科',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '240px'], //宽高
              content: $("#addsubject")
           });
      }
    }
   }
</script>
