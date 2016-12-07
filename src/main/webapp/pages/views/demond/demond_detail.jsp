<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="renderer" content="webkit">  
  <title>点播详情</title>
  <meta name="viewport" content="width=device-width">
  <!-- <script type="text/javascript" src="../../../../public/_config/sys_front_config.js" ></script>
  <script type="text/javascript" src="../../../../public/jquery/jquery-2.2.4.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_manifest.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_common.js" ></script>
  <script type="text/javascript" src="../../../../dist/slr_base.js" ></script> -->
  <%@ include file="../../_commons/meta.jsp"%>
  <script type="text/javascript" src="<%=ROOT_UI_PUBLIC%>/evideo/swfobject.js" ></script>
  <style type="text/css">
    /* 点播详情页  start*/
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
 /*  用户评论主体部分  end*/
 .more{border-top:1px solid #ececec;height:40px;line-height: 40px;text-align: center;}
/* 点播课程详情  end*/
  </style>
</head>
<body>
<%@ include file="../../_commons/navbar.jsp"%>
<!-- 点播课程详情  start-->
<div class="wamp">
  <div class="vod">
     <p class="l-title">汉语言文学（第一节）
     <span class="ft12"><i class="iconfont icon-play-times"></i>123</span>
     <small class="ft12">一年级/语文/谢春华</small>
     </p>
    <div class="l-left">
        <div class="vedio" id="video_player_content" ></div>
      </div>
      <div class="l-right fr">
        <div class="right-head ft16">课程推荐</div>
        <div class="v-recommend">
          <ul>
            <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">小学定是与变式</p>
                <p class="ft12 c6">一年级&nbsp;语文&nbsp;谢春华</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
             <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">小学定是与变式</p>
                <p class="ft12 c6">一年级&nbsp;语文&nbsp;谢春华</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
             <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">小学定是与变式</p>
                <p class="ft12 c6">一年级&nbsp;语文&nbsp;谢春华</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
             <li>
              <div class="media-left"><a href="#"><img class="media-object" src="http://reserver.demo.codyy.cn/images/7f2a4f4d-c45f-42f6-82a2-4a4327b81e6d.jpg" data-holder-rendered="true" style="width: 149px; height:84px;"></a></div>
              <div class="media-right">
                <p class="c4">小学定是与变式</p>
                <p class="ft12 c6">一年级&nbsp;语文&nbsp;谢春华</p>
                <p class="ft12 c6"><i class="iconfont icon-play-times"></i>&nbsp;546757</p>
              </div>
            </li>
          </ul>
          <div class="clear"></div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="comment mt40">
        <div class="c-title ft16 c4">用户评价</div>
        <!-- 用户评论主体部分 start-->

<!-- 评论公共组件 -->
<div class="container mt20">
  <div class="com-comments w920 mb20">
    <h2 class="com-comments-h2">评价</h2>
    <div class="com-commonts-area clearfix" id="">
      <div class="counterBox">
        <textarea name="" id="saytext" limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame"></textarea>
        <div class="clearfix">
          <span onclick="" id="" class="e-xpression">
            <i class="iconfont icon-face"></i>
          </span>
          <a href="#a" class="fr mt10 com-button orange-btn ml10" onclick="">评论</a>
          <span class="textarea-ft-cont-pos"><i class="limitCount orange">150</i>/150</span>
        </div>
      </div>
      <h3 class="com-comments-h3">全部评论(20条)</h3>
      <div class="clearfix com-comments-level1">
        <div class="com-comments-img-r">
  <p>李老师：下雪了，真是太激动了，可以我在南方。欣赏不到雪景...想和朋友们一起去紫荆城，欣赏雪景去。作为故宫控的默默的又喊一遍，明年一定要约一次故宫的雪！</p>
  <p class="clearfix"><span class="com-comments-time">2015-02-03 12:00</span><span class="commtent-text-btn fr level1-btn" data-show="0">回复</span></p>
</div>
<div class="com-comments-level2 hide">
  <div class="level1-comments">
    <textarea name="" id=""  limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame"></textarea>
    <div class="clearfix">
      <span onclick="" id="" class="e-xpression">
        <i class="iconfont icon-face"></i>
      </span>
      <a href="javascript:void(0);" class="fr mt10 com-button orange-btn ml10" onclick="">提交</a>
    </div>
  </div>
  <div class="clearfix mt20 comments-level2-each">
    <div class="com-comments-img-r">
      <p>张小雅回复李老师：下雪了，真是太激动了，可以我在南方。欣赏不到雪景...想和朋友们一起去紫荆城，欣赏雪景去。作为故宫控的默默的又喊一遍，明年一定要约一次故宫的雪！</p>
      <p class="clearfix"><span class="com-comments-time">2015-02-03 12:00</span><span class="commtent-text-btn fr level2-btn" data-show="0">回复</span><span class="commtent-remove fr">删除</span></p>
    </div>
    <div class="level2-comments mt20 hide">
      <textarea name="" id="" limit-len="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame"></textarea>
      <div class="clearfix">
        <span onclick="" id="" class="e-xpression">
          <i class="iconfont icon-face"></i>
        </span>
        <a href="javascript:void;" class="fr mt10 com-button orange-btn ml10" onclick="">提交</a>
      </div>
    </div>
  </div>
  <div class="clearfix mt20 comments-level2-each">
    <div class="com-comments-img-r">
      <p>张小雅回复李老师：下雪了，真是太激动了，可以我在南方。欣赏不到雪景...想和朋友们一起去紫荆城，欣赏雪景去。作为故宫控的默默的又喊一遍，明年一定要约一次故宫的雪！</p>
      <p class="clearfix"><span class="com-comments-time">2015-02-03 12:00</span><span class="commtent-text-btn fr level2-btn" data-show="0">回复</span><span class="commtent-remove fr">删除</span></p>
    </div>
    <div class="level2-comments mt20 hide">
      <textarea name="" id=""  limit-len="150" limit="1,150" limitmsg="很抱歉，输入字数超出最大长度150个字符" class="mb10 edit-wb-frame"></textarea>
      <div class="clearfix">
        <span onclick="" id="" class="e-xpression">
          <i class="iconfont icon-face"></i>
        </span>
        <a href="javascript:void;" class="fr mt10 com-button orange-btn ml10" onclick="">提交</a>
      </div>
    </div>
  </div>
  
</div> 
      </div>
      
    </div>
  </div>
    </div>
        <!-- 用户评论主体部分 end-->
        <div class="more"><a href="#a" class="ft12 c9">点击查看更多评论</a></div>
      </div>
  </div>
  </div>
<%@ include file="../../_commons/footer.jsp"%>
<!-- 点播课程详情  end-->
<script src="http://code.jquery.com/jquery-migrate-1.2.1.js"></script>
<script src="../../../public/qqFace/js/jquery.qqFace.js"></script>
<script src="../../../public/_module/js/comment.js"></script>
<script type="text/javascript">

$(function(){
	var SWF_ID = "evideo_"+new Date().getTime();
	var SWF_NAME = ROOT_UI_PUBLIC+"/evideo/KwVideo.swf";
	function EmbedSWF_SWF(divId, mp4Url) {
		var flashvars = {
			url: mp4Url
		};
		var params = {
			allowFullscreen: "true",
			allowScriptAccess: "always",
			wmode: "transparent" // can cause issues with FP settings & webcam
		};
		var attributes = {
			id: SWF_ID,
			name: SWF_ID
		};
		swfobject.embedSWF(
		SWF_NAME,
		//这里可以设置播放设置播放视频宽高
		divId, "910", "570", "10.0.0", 
		"expressInstall.swf",
		flashvars, params, attributes);
	}
	//playflashmv("http://media.cdn.kuwo.cn/resource/m1/webkge/2015/7/10/201507101126_4.mp4");
	//var vedioUrl = "http://10.5.52.11:8080/ResourceServer/res/view/viewClassVideo/b44df33e8f7c4b6c83dce776b98e5504/a2bdba448412457fadb64e7636734e4f.do" ;
	var vedioUrl = "http://media.cdn.kuwo.cn/resource/m1/webkge/2015/7/10/201507101126_4.mp4" ;
	//playflashmv(vedioUrl);
	EmbedSWF_SWF("video_player_content", vedioUrl);
	
$('.e-xpression').qqFace({
  id : 'facebox', 
  assign:'saytext', 
  path:'src/public/qqFace/arclist/' //表情存放的路径
});
$(".com-button").click(function(){
  var str = $(this).parent().prev('textarea').val();
  var myDate = new Date();
  var now = myDate.toLocaleString();
  var html = '<div class="clearfix com-comments-level1">'
  +'<div class="com-comments-img-r">'
  +'<p>'+replace_em(str)+'</p>'
    + '<p class="clearfix"><span class="com-comments-time">'+ now +'</span><span class="commtent-text-btn fr level1-btn" data-show="0">回复</span></p>'
        +'</div>'
        +'</div>'
    $(this).parent().parent().append(html);
	
   	
});


//查看结果

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
      //字数统计
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
//微博评论区域//
  $(".com-comments-level1").each(function(){
    var $this = $(this).find(".level1-btn");
    var $_this = $(this).find(".com-comments-level2");
    $this.click(function(){
      var showFlag = $(this).attr("data-show");
      if(showFlag == 0){
        $_this.removeClass("hide");
        $this.html("收起").parents(".com-comments-img-r").addClass("showbtn");
        var showFlag = $this.attr("data-show",1);
      }else{
        $_this.addClass("hide");
        $this.html("回复").parents(".com-comments-img-r").removeClass("showbtn");
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