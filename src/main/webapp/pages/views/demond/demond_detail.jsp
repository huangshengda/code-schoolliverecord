<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>点播详情</title>
  <meta name="viewport" content="width=device-width">
  <script type="text/javascript" src="../../../../public/_config/sys_front_config.js" ></script>
  <script type="text/javascript" src="../../../../public/jquery/jquery-2.2.4.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_manifest.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_common.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_base.js" ></script>
  <style type="text/css">
    /* ç¹æ­è¯¾ç¨è¯¦æ  start*/
    /* å¬å± */
 .c4{color:#444;}
 .c6{color:#666;}
 .c9{color:#999;}
 .l-left{
  display: inline-block;
  width: 918px; 
  height:562px;
 }
 .l-right{
    width: 281px;
    border-right:1px solid #ececec;
    border-bottom:1px solid #ececec;
    border-top:1px solid #34a150;
    
  }
  .right-head{
      height:45px;
      line-height: 45px;
      color:#34a150;
      padding: 0 15px;
     }
   .l-title{
      font-size:20px;
      color:#222;
      line-height: 35px;
    }
    .l-title span{
        margin:0 25px;
        color:#666;
      }
     .l-title small{
        color:#666;
      }
    .l-title i {
    font-style: normal;
}
  /* å¬å± end*/
 .vod{margin-top:50px;}
.l-right {background-color: #fff;}
 .right-head{border-bottom:1px solid #ececec;}
 .v-recommend{height:495px;}
    .v-recommend li{
      margin-top:20px;
      cursor: pointer;
      padding:10px;
      
    }
    .media-left,.media-right{
        display: table-cell;
        vertical-align: top;
        padding-right: 1px;
      }
    .v-recommend li:hover{
        background-color:#f5f8fa;
      }
  
     /*  ç¨æ·è¯è®ºä¸»ä½é¨å  start*/
  .comment{
    width:918px;
    display: inline-block;
    border: 1px solid #ececec;
    margin-top:30px;
  }
    .c-title{
      height:40px;
      line-height: 40px;
      border-bottom: 1px solid #ececec;
      padding-left:20px;
      background-color:#f7f7f7;
    }
    .c-main{
      padding:20px;
      background-color: #fff;}
      .edit-wb-frame {
        width: 877px;
        height: 120px;
        border: 1px solid #ececec;
      }
      .c-item{border-bottom: 1px solid #ececec;}
      .com-button.orange-btn {
    background-color: #FF9C00;
    color: #fff;
    padding: 2px 17px;
}
.textarea-ft-cont-pos {
    font-size: 12px;
    color: #999;
    float: right;
    margin-top: 3px;
}
.orange {
    color: #FE9B00;
}
.icon-face{color:#f1b93c;font-size:20px;}
.all-list{line-height: 30px;border-bottom: 1px solid #ececec;}
.replay{
    background-color: #f7f7f7;
    padding: 20px;
    margin-left: 10px;
  }
  .replay textarea{
      width:823px;
      height:40px;
    }
  
.item-Head{clear: both;margin:20px 0;

}
.item-Head a{color:#999;}
      /*  c-main  end*/
 /*  ç¨æ·è¯è®ºä¸»ä½é¨å  end*/
 .more{border-top:1px solid #ececec;height:40px;line-height: 40px;text-align: center;}
 
/* ç¹æ­è¯¾ç¨è¯¦æ  end*/
  </style>
</head>
<body>
<nav data-v-c4f038aa="" role="navigation" class="navbar navbar-default"><div data-v-c4f038aa="" class="wamp">
  <img data-v-c4f038aa="" src="../../../public/_module/images/logo.png" class="inb"> 
  <div data-v-c4f038aa="" class="head inb"><div data-v-c4f038aa="" class="navHead">
    <span data-v-c4f038aa=""><a href="/#/index" class="router-link-active" data-v-c4f038aa="">
              é¦é¡µ
             </a></span><span data-v-c4f038aa=""><a href="/#/onDemand" class="" data-v-c4f038aa="">
              ç¹æ­
             </a></span><span data-v-c4f038aa=""><a href="/#/basic" class="" data-v-c4f038aa="">
              åºç¡ç®¡ç
             </a></span></div> </div> <div data-v-c4f038aa="" class="out fr"><button data-v-c4f038aa="" class="fr">ç»å½</button></div></div>  <form data-v-c4f038aa="" action="" id="login" class="layBox mt40"><div data-v-c4f038aa="" class="cd-f-row"><div data-v-c4f038aa="" class="cd-f-eve"><span data-v-c4f038aa="" class="cd-f-name"><label data-v-c4f038aa="">ç¨æ·å:</label></span> <span data-v-c4f038aa="" class="cd-f-value"><input data-v-c4f038aa="" type="text" name="username" data-vali="notnull,username"></span></div> <div data-v-c4f038aa="" class="cd-f-eve"><span data-v-c4f038aa="" class="cd-f-name"><label data-v-c4f038aa="">å¯ç :</label></span> <span data-v-c4f038aa="" class="cd-f-value"><input data-v-c4f038aa="" type="text" name="password" data-vali="notnull,password"></span></div> <div data-v-c4f038aa="" class="cd-f-eve"><input data-v-c4f038aa="" type="checkbox" name="auto" class="ml30">èªå¨ç»å½
      </div> <div data-v-c4f038aa="" class="cd-f-eve"><button data-v-c4f038aa="" class="lay-btn gray-btn">ç»å½</button></div></div></form> </nav>
<!-- ç¹æ­è¯¾ç¨è¯¦æ  start-->
<div class="wamp">
  <div class="vod">
     <p class="l-title">æ±è¯­è¨æå­¦ï¼ç¬¬ä¸èï¼
     <span class="ft12"><i class="iconfont icon-play-times"></i>123</span>
     <small class="ft12">ä¸å¹´çº§/è¯­æ/è°¢æ¥å</small>
     </p>
    <div class="l-left">
        <div class="vedio"></div>
      </div>
      <div class="l-right fr">
        <div class="right-head ft16">è¯¾ç¨æ¨è</div>
        <div class="v-recommend">
          <ul>
            <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">å°å­¦å®æ¯ä¸åå¼</p>
                <p class="ft12 c6">ä¸å¹´çº§&nbsp;è¯­æ&nbsp;è°¢æ¥å</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
             <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">å°å­¦å®æ¯ä¸åå¼</p>
                <p class="ft12 c6">ä¸å¹´çº§&nbsp;è¯­æ&nbsp;è°¢æ¥å</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
             <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">å°å­¦å®æ¯ä¸åå¼</p>
                <p class="ft12 c6">ä¸å¹´çº§&nbsp;è¯­æ&nbsp;è°¢æ¥å</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
             <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">å°å­¦å®æ¯ä¸åå¼</p>
                <p class="ft12 c6">ä¸å¹´çº§&nbsp;è¯­æ&nbsp;è°¢æ¥å</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
          </ul>
          <div class="clear"></div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="comment mt40">
        <div class="c-title ft16 c4">ç¨æ·è¯ä»·</div>
        <!-- ç¨æ·è¯è®ºä¸»ä½é¨å start-->

<!-- è¯è®ºå¬å±ç»ä»¶ -->
<div class="container mt20">
  <div class="com-comments w920 mb20">
    <h2 class="com-comments-h2">è¯ä»·</h2>
    <div class="com-commonts-area clearfix" id="">
      <div class="counterBox">
        <textarea name="" id="saytext" limit-len="150" limit="1,150" limitmsg="å¾æ±æ­ï¼è¾å¥å­æ°è¶åºæå¤§é¿åº¦150ä¸ªå­ç¬¦" class="mb10 edit-wb-frame"></textarea>
        <div class="clearfix">
          <span onclick="" id="" class="e-xpression">
            <i class="iconfont icon-face"></i>
          </span>
          <a href="#a" class="fr mt10 com-button orange-btn ml10" onclick="">è¯è®º</a>
          <span class="textarea-ft-cont-pos"><i class="limitCount orange">150</i>/150</span>
        </div>
      </div>
      <h3 class="com-comments-h3">å¨é¨è¯è®º(20æ¡)</h3>
      <div class="clearfix com-comments-level1">
        <div class="com-comments-img-r">
  <p>æèå¸ï¼ä¸éªäºï¼çæ¯å¤ªæ¿å¨äºï¼å¯ä»¥æå¨åæ¹ãæ¬£èµä¸å°éªæ¯...æ³åæåä»¬ä¸èµ·å»ç´«èåï¼æ¬£èµéªæ¯å»ãä½ä¸ºæå®«æ§çé»é»çååä¸éï¼æå¹´ä¸å®è¦çº¦ä¸æ¬¡æå®«çéªï¼</p>
  <p class="clearfix"><span class="com-comments-time">2015-02-03 12:00</span><span class="commtent-text-btn fr level1-btn" data-show="0">åå¤</span></p>
</div>
<div class="com-comments-level2 hide">
  <div class="level1-comments">
    <textarea name="" id=""  limit-len="150" limit="1,150" limitmsg="å¾æ±æ­ï¼è¾å¥å­æ°è¶åºæå¤§é¿åº¦150ä¸ªå­ç¬¦" class="mb10 edit-wb-frame"></textarea>
    <div class="clearfix">
      <span onclick="" id="" class="e-xpression">
        <i class="iconfont icon-face"></i>
      </span>
      <a href="javascript:void(0);" class="fr mt10 com-button orange-btn ml10" onclick="">æäº¤</a>
    </div>
  </div>
  <div class="clearfix mt20 comments-level2-each">
    <div class="com-comments-img-r">
      <p>å¼ å°éåå¤æèå¸ï¼ä¸éªäºï¼çæ¯å¤ªæ¿å¨äºï¼å¯ä»¥æå¨åæ¹ãæ¬£èµä¸å°éªæ¯...æ³åæåä»¬ä¸èµ·å»ç´«èåï¼æ¬£èµéªæ¯å»ãä½ä¸ºæå®«æ§çé»é»çååä¸éï¼æå¹´ä¸å®è¦çº¦ä¸æ¬¡æå®«çéªï¼</p>
      <p class="clearfix"><span class="com-comments-time">2015-02-03 12:00</span><span class="commtent-text-btn fr level2-btn" data-show="0">åå¤</span><span class="commtent-remove fr">å é¤</span></p>
    </div>
    <div class="level2-comments mt20 hide">
      <textarea name="" id="" limit-len="1,150" limitmsg="å¾æ±æ­ï¼è¾å¥å­æ°è¶åºæå¤§é¿åº¦150ä¸ªå­ç¬¦" class="mb10 edit-wb-frame"></textarea>
      <div class="clearfix">
        <span onclick="" id="" class="e-xpression">
          <i class="iconfont icon-face"></i>
        </span>
        <a href="javascript:void;" class="fr mt10 com-button orange-btn ml10" onclick="">æäº¤</a>
      </div>
    </div>
  </div>
  <div class="clearfix mt20 comments-level2-each">
    <div class="com-comments-img-r">
      <p>å¼ å°éåå¤æèå¸ï¼ä¸éªäºï¼çæ¯å¤ªæ¿å¨äºï¼å¯ä»¥æå¨åæ¹ãæ¬£èµä¸å°éªæ¯...æ³åæåä»¬ä¸èµ·å»ç´«èåï¼æ¬£èµéªæ¯å»ãä½ä¸ºæå®«æ§çé»é»çååä¸éï¼æå¹´ä¸å®è¦çº¦ä¸æ¬¡æå®«çéªï¼</p>
      <p class="clearfix"><span class="com-comments-time">2015-02-03 12:00</span><span class="commtent-text-btn fr level2-btn" data-show="0">åå¤</span><span class="commtent-remove fr">å é¤</span></p>
    </div>
    <div class="level2-comments mt20 hide">
      <textarea name="" id=""  limit-len="150" limit="1,150" limitmsg="å¾æ±æ­ï¼è¾å¥å­æ°è¶åºæå¤§é¿åº¦150ä¸ªå­ç¬¦" class="mb10 edit-wb-frame"></textarea>
      <div class="clearfix">
        <span onclick="" id="" class="e-xpression">
          <i class="iconfont icon-face"></i>
        </span>
        <a href="javascript:void;" class="fr mt10 com-button orange-btn ml10" onclick="">æäº¤</a>
      </div>
    </div>
  </div>
  
</div> 
      </div>
      
    </div>
  </div>
    </div>
        <!-- ç¨æ·è¯è®ºä¸»ä½é¨å end-->
        <div class="more"><a href="#a" class="ft12 c9">ç¹å»æ¥çæ´å¤è¯è®º</a></div>
      </div>
  </div>
  </div>
<!-- ç¹æ­è¯¾ç¨è¯¦æ  end-->
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
  <script src="../../../public/qqFace/js/jquery.qqFace.js"></script>
   <script src="../../..//public/_compnents/v1/js/comment.js"></script>
  <script type="text/javascript">
$(function(){

  $("#locationToDemond").click(function(){
    window.location.href = ROOT_UI+"/#/onDemand";
  });

  $('.e-xpression').qqFace({
    id : 'facebox', 
    assign:'saytext', 
    path:'src/public/qqFace/arclist/' //è¡¨æå­æ¾çè·¯å¾
  });

  $(".com-button").click(function(){
    var str = $(this).parent().prev('textarea').val();
    var myDate = new Date();
    var now = myDate.toLocaleString();
    var html = '<div class="clearfix com-comments-level1">'
    +'<div class="com-comments-img-r">'
    +'<p>'+replace_em(str)+'</p>'
      + '<p class="clearfix"><span class="com-comments-time">'+ now +'</span><span class="commtent-text-btn fr level1-btn" data-show="0">åå¤</span></p>'
          +'</div>'
          +'</div>'
      $(this).parent().parent().append(html);
  });

//æ¥çç»æ

function replace_em(str){

  str = str.replace(/\</g,'&lt;');

  str = str.replace(/\>/g,'&gt;');

  str = str.replace(/\n/g,'<br/>');

  str = str.replace(/\[em_([0-9]*)\]/g,'<img src="src/public/qqFace/arclist/$1.gif" border="0" />');

  return str;

}

      function caculateLength(str){
  if(str == null || str == ''){
    return 0;
  }
  var len = str.match(/[^ -~]/g) == null ? str.length : str.length + str.match(/[^ -~]/g).length;
  return len;
}
      //å­æ°ç»è®¡
    $("body").on("keyup input propertychange focus blur",".counterBox textarea",function(){
      var realValue = String.trim ? this.value.trim() : this.value.replace(/(^\s*)|(\s*$)/g, "");
      var len = realValue.length;
      var chineseCountTwo = this.getAttribute("chinese-count-two");
      if(chineseCountTwo){
        len = caculateLength(realValue);
      }
      var limit = this.getAttribute("limit-len");
      if(len>=limit){
        //len = limit;
      }
      $(this).parent(".counterBox").find(".limitCount").html(limit-len);
    })
//å¾®åè¯è®ºåºå//
  $(".com-comments-level1").each(function(){
    var $this = $(this).find(".level1-btn");
    var $_this = $(this).find(".com-comments-level2");
    $this.click(function(){
      var showFlag = $(this).attr("data-show");
      if(showFlag == 0){
        $_this.removeClass("hide");
        $this.html("æ¶èµ·").parents(".com-comments-img-r").addClass("showbtn");
        var showFlag = $this.attr("data-show",1);
      }else{
        $_this.addClass("hide");
        $this.html("åå¤").parents(".com-comments-img-r").removeClass("showbtn");
        var showFlag = $this.attr("data-show",0);
      }
    });
  });
  $(".comments-level2-each").each(function(){
    var $this = $(this).find(".level2-btn");
    var $_this = $(this).find(".level2-comments");
    
    $this.click(function(){
      var showFlag = $(this).attr("data-show");
      if(showFlag == 0){
        $_this.removeClass("hide");
        var showFlag = $this.attr("data-show",1);
      }else{
        $_this.addClass("hide");
        var showFlag = $this.attr("data-show",0);
      }
    })
  });
  $('.commtent-remove').click(function(){
      $(this).parent().parent().parent().remove();
  });
})
  </script>
</body>
</html>
