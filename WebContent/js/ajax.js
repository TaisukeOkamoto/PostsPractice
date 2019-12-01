function ajax(type,url,request) {
   return $.ajax({
	   	data:request,
		type: type,
		url: url,
		async: true,
	})
}