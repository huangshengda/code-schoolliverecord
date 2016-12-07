(function(global) {
	"use strict"

	var ownPlayer = null,
		receivePlayers = [],
		tool = global.vm.module["tool"],
		excludeKeys = ["wrap", "id", "swf", "type"],
		baseConfig = {
			nameSpace: "mySpeaker" + tool.random(),
			debug: 0 ,
			meetType : "mix",	//mix,video,audio
			swf : "",
			code: window.code,
			mid: window.mid,
			myid: window.userId,
			separator: "_",
			codec: 4,
			buffer: window.buffer || "0.5",
			bufferMax: window.bufferMax || "1",
			bgcolor: "0xAAC7EC",
			bgimg: publicPath + "/player_flash/images/speaker.png",	//背景图
			fullimg: publicPath + "/player_flash/images/fullBtn.png",	//全屏图标
			waterimg: publicPath + "/player_flash/images/logo.png"	//水印
			// echoPath : ECHO_PATH,
			// width : SPEAKER_RATIO,
			// quality : VIDEO_QUALITY,
			// frame : VIDEO_FRAME,
			// h264 : H264_SET,	//none:照顾移动端,可不启用h264
			// bgsize : "500,500",	//为空时自适应
			// fullpos : "2,20,20", 	//缺省为右上角，20*20的尺寸
		};

	var FlashBuilder = function(opts) {
		this.name = "FlashBuilder";
		var _baseConfig = tool.deepCopy(baseConfig, {});
		var opts = tool.deepCopy(opts||{}, _baseConfig);
		this.streamEvent = new tool.constructor.CustomerEvent();

		this.init = function() {
			var paramStr = "";
			for(var key in opts) {
				if(-1===excludeKeys.indexOf(key)) {
					paramStr += (key+"="+opts[key]) + "&";
				}
			}
			this.obj = tool.buildFlash(opts.wrap, opts.swf+"?"+paramStr, {id: opts.id});
		};

		this.getParams = function() {
			return opts;
		};

		this.init();
		window[opts.nameSpace] = this;
	};

	FlashBuilder.prototype = {
		constructor: FlashBuilder,
		onLoad: function(){	// flash加载完成时调用
			this.streamEvent.fire({type:"onLoad"});
		},
		onLinkup: function(){	// flash connect success时调用
			this.streamEvent.fire({type:"onLinkup"});
		},
		onLinkdown: function(){	//连接断开时
			this.streamEvent.fire({type:"onLinkdown"});
		},
		onMicWave: function(v){	// flash中麦克风音量 
			this.streamEvent.fire({type:"onMicWave", message:v});
		},
		onSoundWave: function(v){	// flash中扬声器音量 （未实现）
			this.streamEvent.fire({type:"onSoundWave", message:v});
		},
		onInsufficientBW: function(){	//提示接收端带宽不足
			this.streamEvent.fire({type:"onInsufficientBW"});
		},
		onMetaData: function(v){	//视频播放开始，返回metadata信息(通常只用于录播流)
			this.streamEvent.fire({type:"onMetaData", message:v});
		},
		onStop: function(){	//视频播放结束(录播流)
			this.streamEvent.fire({type:"onStop"});
		},
		connect: function(sUrl){
			this.obj.connect(sUrl);
		},
		publish: function(){ 
			var isAudio = (arguments[0] === "audio");	//若传入"audio"则只发布音频。
			this.obj.publish(isAudio);	//isAudio：可用于在视频模式下面发布音频流
		},
		rePublish: function(isAudioStream, meetType){	//mix 
			this.obj.rePublish(isAudioStream, meetType);	//isAudio：可用于在视频模式下面发布音频流
		},
		purePublish : function(){
			this.obj.purePublish();	//纯发布流，不在本地video显示
		},
		unPublish: function(){
			var isAudio = (arguments[0] === "audio");	//传入audio，只停止发布，不去除video显示
			this.obj.unPublish(isAudio);
		},
		play: function(uid, uname){
			this.obj.playStream(uid, uname);	//uname用于显示名字
		},
		playAudio: function(uid){
			this.obj.playStream(uid, '', true);	//接收音频流（不会放入video）
		},
		stop: function(uid){
			this.obj.stopStream(uid);
		},
		togglePause: function(){
			this.obj.togglePause();	//录播流的暂停/播放
		},
		seek: function(t){
			this.obj.seek(t);	//录播流跳播
		},
		selectCam: function(name){
			this.obj.selectCamera(name); 
		},
		setCamera: function(width, fps, quality, keyFrame){
			this.obj.setCamera(width, fps, quality, keyFrame);
		},
		setMicVolume: function(v){
			this.obj.setMicVolume(v/2); 
		},
		setSoundVolume: function(v){
			this.obj.setSoundVolume(v/2); 
		},
		applyH264: function(profile, level){
			this.obj.h264(profile, level); 
		},
		applyCodec: function(value){
			this.obj.codec(value); 
		},
		setRate: function(value){
			this.obj.setRate(value); 
		},
		applyEnhanced: function(value){
			this.obj.applyEnhanced(value); 
		},
		setEchoPath: function(value){
			this.obj.setEchoPath(value); 
		},
		recordSet: function(type){
			this.obj.recordSet(type); 
		},
		receiveSet: function(type){
			this.obj.receiveSet(type); 
		},
		getDeviceInfo: function(uid){
			return this.obj.getDeviceInfo();	//获取摄像头，麦克风设置的信息
		},
		getStreamInfo: function(uid){
			return this.obj.getStreamInfo(uid);	//接收方实时获取流信息，如果播的是主持人流或者录播流，不用传uid
		},
		quitFull: function(){	//退出flash全屏
			this.obj.quitFull();
		},
		getCameraNum: function() {
			return this.obj.getCameraNum();
		},
		getCameraNames: function() {
			return this.obj.getCameraNames();
		}
	};

	global.vm = global.vm || {};
	global.vm.module = global.vm.module || {};
	global.vm.module["playerBuilder"] = {
		init: function(opts, flag) {
			var playorObj = new FlashBuilder(opts);
			
			if("publish"===opts.type) {
				flag && (ownPlayer = playorObj);
			} else {
				false!==flag && receivePlayers.push(playorObj);
			}
			
			return playorObj;
		},
		getOwnPlayer: function() {
			return ownPlayer;
		},
		getReceivePlayers: function(index) {
			return ("undefined"!==typeof(index) && null!==index)?receivePlayers[index]:receivePlayers;
		}
	};
})(window)