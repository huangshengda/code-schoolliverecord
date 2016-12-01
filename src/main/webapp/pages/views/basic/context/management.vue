<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">添加年级</button></div>
 <div class="dashboard">
  <!-- 表单 start -->
  <!--   <form action="" id="grade">
    <table>
      <thead><th>年级</th><th>排序</th><th>操作</th></thead>
      <tbody>
        <tr v-for="(grade,index) in grades"><td>{{grade.name}}</td>
        <td v-if="index===0"><i class="iconfont icon-movedown"></i></td>
        <template v-else> 
         <td v-if="index===(grades.length-1)"><i class="iconfont icon-moveup"></i></td>
         <td v-else><i class="iconfont icon-moveup"></i><i class="iconfont icon-movedown"></i></td>
        </template>
        <td>{{grade.editfun}}&nbsp;{{grade.delfun}}</td></tr>
      </tbody>
    </table>
  </form> -->
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
      }
    },
     mounted () {    
      this.show()
    },
         methods: {
       show: function(){
        var params = {};
        CDUtil.ajaxPost("mockjs_subject.json",params,function(retVO){
            var config = {
              //用来展示表格控件的div的id
              containerId: "use_to_load_grid",
              //用来展示表格的表头数据
              thead: [{name:"学科",valuekey:"subjectName",width: "100px"},
                      {name:"排序",valuekey:"sort"},
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
              optParams: ["subjectId","sort"],
              //表格中的行操作名称
              optName: {edit_fun:"编辑",del_fun:"删除"},
              //表格中的行操作方法
              optFuns: {edit_fun:function(params,dom){
                   layer.open({
                        type: 1,
                        title: '编辑学科',
                        skin: 'layui-layer-rim', //加上边框
                        area: ['450px', '240px'], //宽高
                        content: $("#editsubject")
                    });

                },del_fun:function(params,dom){
                    layer.alert('确定删除该行数据?',function(index){
                    layer.close(index);
                    layer.msg('删除成功!')
                   });
                  /* ajaxCallPost("mockjs_grid_data.json",{"num1":params.num1},callback);*/
                }
              }
          };
          Grid.initGrid(config,function(){});
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
