<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="base"  scope="request">${pageContext.request.contextPath} </c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"></meta>
  <title>test UI</title>
  <style type="text/css">
  	.hide{display: none;}
  /**	.attribute{display:block;}*/
  </style>
  <link href='//fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>  
  <link href="${base}/testUI/reset.css" media="screen" rel="stylesheet" type="text/css">
  <link href="${base}/testUI/screen.css" media="screen" rel="stylesheet" type="text/css">
  <link href="${base}/testUI/reset.css" media="print" rel="stylesheet" type="text/css">
  <link href="${base}/testUI/screen.css" media="print" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="${base}/testUI/shred.js"></script>
  <script src="${base}/testUI/jquery-1.js" type="text/javascript"></script>
  <script src="${base}/testUI/jquery.js" type="text/javascript"></script>
  <script src="${base}/testUI/jquery_003.js" type="text/javascript"></script>
  <script src="${base}/testUI/jquery_002.js" type="text/javascript"></script>
  <script src="${base}/testUI/handlebars-1.js" type="text/javascript"></script>
  <script src="${base}/testUI/underscore-min.js" type="text/javascript"></script>
  <script src="${base}/testUI/backbone-min.js" type="text/javascript"></script>
  <%--
  	  <script src="${base}/testUI/swagger-ui.js" type="text/javascript"></script>
   --%>
  <script src="${base}/testUI/highlight.js" type="text/javascript"></script>

  <!-- enabling this will enable oauth2 implicit scope support -->
  <script type="text/javascript">
  var base= '${base}';
    $(function () {
    //模塊點擊事件	
    $("li.resource a.toggleEndpointList").bind("click",function(){
    	var $this = $(this);
    	var module = $this.attr("data-id");
    	if($this.hasClass("active")){
    		$this.removeClass("active");
    		$("#"+module+"_endpoint_list").addClass("hide");
    	}else{
    		$("#"+module+"_endpoint_list").removeClass("hide");
    		$this.addClass("active");
    	}
    })	;
    // 点击事件
    $("a.toggleOperation").bind("click",function(){
    	var $this =$(this);
    	var $content = $("#"+$this.text().replace(".do",'').replace(/\//g,'_')+"_content");
    	if($content.hasClass("hide")){
    		$content.removeClass("hide");
    	}else{
    		$content.addClass("hide");
    	}
    });	
    //提交事件
    $("div.sandbox_header button").on("click",function(){
    	var $this=$(this);
    	var $form = $this.parents("form");
    	var enable=true;
    	//验证必填
    	$form.find("input[data-required='true']").each(function(){
    		if($.trim($(this).val())==""){
    			enable=false;
    			$(this).addClass("error");
    		}else{
    			$(this).removeClass("error");
    		}
    	});
    	if(!enable){
    		return ;
    	}
    	var type = $form.attr("data-type")=="GET"?"GET":"POST";
    	var url = base+$form.attr("data-url")+"?_v="+new Date().getTime();
    	var formData = new FormData();
    	$form.find("input").each(function(){
    		if($(this).attr("type")=="text"){
    			formData.append($(this).attr("name"),$(this).val()); 
    		}else if($(this).attr("type")=="file"){
    			formData.append($(this).attr("name"),this.files[0]);
    		}
    	});
    	$.ajax({
   				url: url,
   				type: type,
   				dataType:"json",
   				success: function(result){
   					var responseDiv = $form.next();
   					responseDiv.find(".request_url").html(
   					"<pre>"+url+"</pre>"
   					);
   					var responseContent = responseDiv.find(".response_body");
   					responseContent.html(
 		   				"<pre><code class='json'> "+ JSON.stringify(result,null,2)+"</code></pre>"
 		   			//"<pre><code class='json'> "+ JSON.stringify(result).replace(/,/g,',<br>').replace(/\[/g,'[<br>').replace(/\]/g,']<br>')+"</code></pre>"
 		   			);
   					//高亮js 
   					hljs.highlightBlock(responseContent[0]);
   				},
   				// Form data
   				data: formData,
   				//准许发起跨域
   				crossDomain: true,
   				//Options to tell jQuery not to process data or worry about content-type.  
   				cache: false,
   				contentType: false,
   				processData: false,
   				error: function(){
   					
   				}
   			});
    });
    
    $("#clickBtn").bind("click",function(){
    	$("#currentTimeMillis").val(new Date().getTime());
    });
  });
    function formatJson(Obj){
    	 for(var item in Obj	){
    		 
    		  alert("person中"+item+"的值="+person[item]);
    	}
    }
  </script>
  
  <style type="text/css">
  	.fontFamily{
  		font-family: "Hiragino Sans GB","Microsoft YaHei",\9ED1\4F53,\5b8b\4f53,sans-serif;
  		font-size:20px;
  	}
  	
  	#fixed{
  		z-index:900;
  		bottom:0px;
  		position:fixed;
  		width:100%;
  		height:50px;
  		background-color: rgba(0,0,0,0.6);
  		box-shadow: 0 0 30px rgba(0,0,0,0.6);
  		border-radius: 3px;
  	}
  	
  	#fixed input[type='text']#currentTimeMillis{
  		float: left;
  		padding:15px 10px 15px 10px;
  		background-color: #ffffff;
  		
  		box-shadow: 0 0 3px rgba(0,0,0,0.6);
  		border:none;
  		margin-right:10px;
  	}
  	
  	#fixed input#clickBtn{
  		  	float: left;
			width: 100px;
			height: 30px;
			margin: 10px 20px 10px 0px;
			border: 0;
			background: rgb(96, 207, 66);
			cursor: pointer;
			box-shadow: 0 0 15px rgba(0,0,0,0.5);
			border-radius: 3px;
			text-align: center;
  	}

  
  </style>
</head>

<body class="swagger-section">
<div id="header">
  <div class="swagger-ui-wrap">
    <a id="logo" href="http://swagger.wordnik.com/">testUI</a>
    <form id="api_selector">
      <div class="input icon-btn">
        <img id="show-pet-store-icon" src="pet_store_api.png" title="Show Swagger Petstore Example Apis">
      </div>
      <div class="input icon-btn">
        <img id="show-wordnik-dev-icon" src="wordnik_api.png" title="Show Wordnik Developer Apis">
      </div>
      <div class="input"><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl" value="" type="text"></div>
      <div class="input"><input placeholder="api_key" id="input_apiKey" name="apiKey" type="text"></div>
      <div class="input"><a id="explore" href="#">Explore</a></div>
    </form>
  </div>
</div>

<div id="message-bar" class="swagger-ui-wrap message-success"></div>
<div id="swagger-ui-container" class="swagger-ui-wrap"><div class="info" id="api_info">
    <div class="info_title">Test Spring MVC  api</div>
     
</div>
<div class="container" id="resources_container">
    <ul id="resources">
       <c:forEach var="module" items="${testUiMap}">
       <li id="resource_index" class="resource active"><div class="heading">
		  <h2>
		    <a href="#!/index" class="toggleEndpointList" data-id="${module.key}">${module.key}</a>  : ${moduleMap[module.key]}
		  </h2>
		  <ul class="options">
		    <li>
		      <a href="#!/index" id="endpointListTogger_index" class="toggleEndpointList" data-id="index">Show/Hide</a>
		    </li>
		    <li>
		      <a href="#" class="collapseResource" data-id="${module.key}">
		        List Operations
		      </a>
		    </li>
		    <li>
		      <a href="#" class="expandResource" data-id="${module.key}">
		        Expand Operations
		      </a>
		    </li>
		    <li>
		      <a href="">Raw</a>
		    </li>
		  </ul>
		</div>
		<ul class="endpoints hide" id="${module.key}_endpoint_list"  >
		<li class="endpoint">
		  <ul class="operations">
		  	<c:forEach var="requestInfo" items="${module.value}">
		  		
		  	
		    <li
		     	<c:choose>
		  			<c:when test="${requestInfo.requestMethod}=='POST'">
		  				class="post operation "
		  			</c:when>
		  			<c:otherwise>
		  				class="get operation "
		  			</c:otherwise>
		  		</c:choose>
		      id="${requestInfo.urlId}">
		      <div class="heading">
		        <h3>
		          <span class="http_method">
		          <a href="#!${requestInfo.url}" class="toggleOperation">${requestInfo.requestMethod}</a>
		          </span>
		          <span class="path">
		          <a href="#!${requestInfo.url}" class="toggleOperation">${requestInfo.url}.do</a>
		          </span>
		        </h3>
		        <ul class="options">
		          <li>
		          <a href="#!${requestInfo.url}" class="toggleOperation">
		          	${requestInfo.decription}
		          </a>
		          </li>
		        </ul>
		      </div>
		      <div class="content hide" id="${requestInfo.urlId}_content">
		      <%--
		        <h4>Implementation Notes</h4>
		        <p> </p>
		        <div class="auth">
		        <span class="api-ic ic-error"></span>
		         <div id="api_information_panel hide" style="top: 526px; left: 776px;">
		            <div title="accessEverything">global</div>
		          </div>
		        </div>
		        <div class="access">
		          <span class="api-ic ic-off" title="click to authenticate"></span>
		        </div>
		          <h4>Response Class</h4>
		          <p><span class="model-signature"><div><div>
		<ul class="signature-nav">
		    <li><a class="description-link" href="#">Model</a></li>
		    <li><a class="snippet-link selected" href="#">Model Schema</a></li>
		</ul>
		<div>
		
		<div class="signature-container">
		    <div class="description" style="display: none;">
		        <span class="strong">JsonResult«Map«string,Collection«object»»» {</span><div><span class="propName propOpt">content</span> (<span class="propType">array[Entry«string,Collection«object»»]</span>, <span class="propOptKey">optional</span>): <span class="propDesc">请求成功后的返回内容体</span>,</div><div><span class="propName propOpt">code</span> (<span class="propType">integer</span>, <span class="propOptKey">optional</span>): <span class="propDesc">请求失败的错误代码</span>,</div><div><span class="propName propReq">success</span> (<span class="propType">boolean</span>): <span class="propDesc">请求是否成功受理</span>,</div><div><span class="propName propOpt">msg</span> (<span class="propType">string</span>, <span class="propOptKey">optional</span>): <span class="propDesc">请求失败的中文说明</span></div><span class="strong">}</span><br><span class="strong">Entry«string,Collection«object»» {</span><div><span class="propName propOpt">key</span> (<span class="propType">Collection«object»</span>, <span class="propOptKey">optional</span>)</div><span class="strong">}</span><br><span class="strong">Collection«object» {</span><div></div><span class="strong">}</span>
		    </div>
		
		    <div class="snippet" style="display: block;">
		        <pre>
		        <code class="json">
		         </code>
		         </pre>
		        <small class="notice"></small>
		    </div>
		</div>
		</div></div></div></span></p>
		 --%>
		          <br>
		          <div class="response-content-type"><div><label for="responseContentType">Response Content Type</label>
		<select name="responseContentType">
		  <option value="application/json">application/json</option>
		  <option value="application/xml">application/xml</option>
		</select>
		</div></div>
		        
		        <form autocomplete="off" accept-charset="UTF-8" class="sandbox" data-url="${requestInfo.url}.do" data-type="${requestInfo.requestMethod}">
		          <div style="margin:0;padding:0;display:inline"></div>
		          <h4>Parameters</h4>
		          <table class="fullwidth">
		          <thead>
		            <tr>
		            <th style="width: 100px; max-width: 100px">Parameter</th>
		            <th style="width: 310px; max-width: 310px">Value</th>
		            <th style="width: 200px; max-width: 200px">Description</th>
		            <th style="width: 100px; max-width: 100px">Parameter Type</th>
		            <th style="width: 220px; max-width: 230px">Data Type</th>
		            </tr>
		          </thead>
		          <tbody class="operation-params">
				  <c:forEach var="requestParam" items="${requestInfo.params}">
				  	  <tr>
		          		<td class="code">${requestParam.name}</td>
				       <td>
							<input class="parameter" minlength="0" name="${requestParam.name}" data-required="${requestParam.required}" 
							<c:if test="${requestParam.required}">placeholder="required"</c:if>
							 value="" 
							 	<c:choose>
						  			<c:when test="${fn:indexOf(requestParam.type,'File')>0}">
						  				type='file'
						  			</c:when>
						  			<c:otherwise>
						  				type='text'
						  			</c:otherwise>
						  		</c:choose>
							 >
						</td>
						<td>${requestParam.description}</td>
						<td>query</td>
						<td>
							<span class="model-signature">${requestParam.type}</span>
						</td>
					</tr>
				  </c:forEach>	
		        
			</tbody>
		          </table>
		          <div style="margin:0;padding:0;display:inline"></div>
		          <h4>Response Messages</h4>
		           <table class="fullwidth">
		            <thead>
		            <tr>
		              <th>HTTP Status Code</th>
		              <th>Reason</th>
		              <th>Response Model</th>
		            </tr>
		            </thead>
		            <tbody class="operation-status">
		            
		            <tr><td class="code" width="15%">200</td>
		<td></td>
		<td width="50%">
	
		<span class="model-signature"><div>
		<div>
		<ul class="signature-nav">
		    <li><a class="description-link selected" href="#">Model</a></li>
		    <%--<li><a class="snippet-link" href="#">Model Schema</a></li> --%>
		    
		</ul>
		<div>
		<div class="signature-container">
		 <div class="description" style="">
			<c:forEach varStatus="varStatus" items="${requestInfo.returnClass}" var="returnClass">
				<span class="strong">${varStatus.index==0?requestInfo.returnType:returnClass.name}
				${returnClass.description==null?'':'('.concat(returnClass.description).concat(')')}
		        {</span>
		        <c:forEach var="property" varStatus="count" items="${returnClass.properties}">
		        	 <div>
				        <span class="propName ">
				        ${property.name}
				        </span> 
				        (<span class="propType">${property.type}${property.ref==null?'':'&lt;'.concat(fn:replace(fn:replace(property.ref,'<','&lt;'),'>','&gt;')).concat('&gt;')}
				        </span> ): <span class="propDesc">${property.description}</span>
				        <c:if test="${!count.last}">
				        </c:if>
				      </div>
		        	
		        </c:forEach>
		        <span class="strong">}
		         </span>
		         <br>   
			</c:forEach>
		    </div>
			<%--
		    <div class="snippet" style="display: block;">
		        <pre><code class="json">{
		  "<span class="attribute">content</span>": <span class="value">[
		    {
		      "<span class="attribute">key</span>": <span class="value">{}
		    }</span>
		  ]</span>,
		  "<span class="attribute">code</span>": <span class="value"><span class="number">0</span></span>,
		  "<span class="attribute">success</span>": <span class="value"><span class="literal">false</span></span>,
		  "<span class="attribute">msg</span>": <span class="value"><span class="string">""</span>
		}</span></code></pre>
		        <small class="notice"></small>
		    </div> --%>
		</div>
		</div></div></div>
		</span>
		
		</td>
		</tr>
		</tbody>
		          </table>   
		          <div class="sandbox_header">
		            <button class="button" name="commit"   type="button" >调试</button>
		            <a href="#" class="response_hider" class="hide">Hide Response</a>
		            <span class="response_throbber" class="hide"></span>
		          </div>
		        </form>
		        <div class="response" class="hide">
		          <h4>Request URL</h4>
		          <div class="block request_url"></div>
		          <h4>Response Body</h4>
		          <div class="block response_body"></div>
		          <%--
		          <h4>Response Code</h4>
		          <div class="block response_code"></div>
		          <h4>Response Headers</h4>
		          <div class="block response_headers"></div>
		           --%>
		        </div>
		      </div>
		    </li>
		    </c:forEach>
		  </ul>
		</li>
		</ul>
		</li>
		</c:forEach>	
 	</ul>

    <div class="footer">
        <br>
        <br>
        <h4 style="color: #999">[<span style="font-variant: small-caps">base url</span>: 
        , <span style="font-variant: small-caps">api version</span>: 1.0
        ]</h4>
    </div>
</div>
</div>

<div id="fixed">
	<input class="fontFamily" id="currentTimeMillis" placeholder="生成当前时间戳" type="text">
	<input class="fontFamily" id="clickBtn" value="生成" type="button">
</div>


</body></html>