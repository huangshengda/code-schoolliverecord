console.log(new Date().getTime());
$(function(){
	var ss = $(".sub-code").text().substr(0,7) + " ...";
	$(".sub-code").text(ss);
})

