<template>
<div class="content">
  <div class="subBtn"><button class="btn fr" @click="add">添加用户</button></div>
  <div class="dashboard">
  <!-- 条件 start -->
    <form action="" id="condition">
      <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>用户名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>姓名:</label></span>
          <span class="cd-f-value ">
            <input type="text" name="realname" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label class="cd-f-notnull">*</label><label>角色:</label></span>
          <span class="cd-f-value ">
            <select name="userType" data-vali="notnull"><option>学校</option></select>
          </span>
        </div>   
        <button class="sBtn" type="button" @click="search_one">查询</button>
      </div>
    </form>
  <!-- 条件 end -->
    <!-- 表单 start -->
    <div id="use_to_load_grid" ></div>
    <!-- 表单 end -->
  </div>
    <!-- 编辑用户弹窗表单 start -->
  <form action="" id="edituser" class="layBox">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value" name="username">
            
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull,password">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType"><option>教师</option></select>
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn">确定</button><button class="lay-btn gray-btn">取消</button>
          </span>
        </div>
    </div>
  </form>
    <!-- 编辑用户弹窗表单 end -->
    <!-- 添加用户弹窗表单 start -->
  <form action="" id="adduser" class="layBox">
   <div class="cd-f-row">
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>用户名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="username" data-vali="notnull,username">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>姓名:</label></span>
          <span class="cd-f-value">
            <input type="text" name="realname" data-vali="notnull">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>密码:</label></span>
          <span class="cd-f-value">
            <input type="text" name="password" data-vali="notnull,password">
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label>角色:</label></span>
          <span class="cd-f-value">
            <select name="userType"><option>教师</option></select>
          </span>
        </div>
        <div class="cd-f-eve">
          <span class="cd-f-name"><label></label></span>
          <span>
            <button class="lay-btn green-btn" @click="addsb">确定</button><button class="lay-btn gray-btn">取消</button>
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
      this.search_one()
    },
     methods: {
       search_one: function(){
        //Validation
        var result = Validation.validation({
          containerId: "condition",
        });
        if(result==true){}
        var params = $('#condition').serialize();
        CDUtil.ajaxPost("/base/user/list",params,function(retVO){
        console.log(retVO);
            var config = {
              //用来展示表格控件的div的id
              containerId: "use_to_load_grid",
              //用来展示表格的表头数据
              thead: [{name:"用户名",valuekey:"username",width: "100px"},
                      {name:"姓名",valuekey:"realname"},
                      {name:"角色",valuekey:"userType"},
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
              optParams: ["userId","token"],
              //表格中的行操作名称
              optName: {edit_fun:"编辑",del_fun:"删除"},
              //表格中的行操作方法
              optFuns: {
                edit_fun:function(params,dom){
                   var userId = params.userId;
                   var useridParams = {'userId':userId};
                      $.post("mockjs_edit_data.json", useridParams, function(data){
                             console.log(data.code); 
                             if(data.code == 1){
                                $('[name="userType"]').val(data.data.userType);
                                $('[name="username"]').val(data.data.username);
                                $('[name="realname"]').val(data.data.realname);
                                $('[name="password"]').val(data.data.password);
                              }
                            });
                   layer.open({
                        type: 1,
                        title: '编辑用户',
                        skin: 'layui-layer-rim', //加上边框
                        area: ['450px', '375px'], //宽高
                        content: $("#edituser")
                    });

                },del_fun:function(params,dom){
                     var userId = params.userId;
                    var useridParams = {'userId' : userId};
                    layer.alert('确定删除该行数据?',function(index){
                      $.ajax({
                        type: "post",
                        url: "/base/user/delete",//action==url
                        dataType: "json",//json
                        data: useridParams,//传到后台的参数
                        success: function(data){
                          layer.close(index);
                          layer.msg('删除成功!')
                        }
                      });
                    
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
              title: '添加用户',
              skin: 'layui-layer-rim', //加上边框
              area: ['450px', '375px'], //宽高
              content: $("#adduser")
           });
    
      },
      addsb:function(){
         var result = Validation.validation({
          containerId: "adduser",
        });
        var params = $('#adduser').serialize();
            CDUtil.ajaxPost("/base/user/add",params,function(retVO){
            Grid.initGrid(config,function(){});  
          });
          }
    }

   }
</script>
