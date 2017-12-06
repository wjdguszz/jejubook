function getParameterValues(){
	
	var command = "command="+$("#command").val();
	var tema = "tema="+encodeURIComponent($("#tema").val());
	var title = "title="+encodeURIComponent($("#title").val());
	
	return command+"&"+tema+"&"+title;
}

$(function(){
	$("#search").click(function(){
		load();
	});
});

var httpRequest= null;

function load(){
	var url = "controller.do?"+getParameterValues();
	
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange=callback;
	httpRequest.open("GET", url, true);
	httpRequest.send();
}

function callback () {
	if(httpRequest.readyState==4){
		if(httpRequest.status==200){
			var obj = JSON.parse(httpRequest.responseType);
			alert(obj.get(0).);
		}else{
			alert("200에러");
		}
	}
}