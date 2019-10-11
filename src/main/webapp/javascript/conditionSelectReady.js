//按条件查询页面只要加载ok就在select中显示所有的



$(function(){
	$.ajax({
		url:"productsManager",
		type:"get",
		data:{
			"op":"doRadyForSearchProduct",
		},
		success: function(responseText){
			var msg = JSON.parse(responseText);
			//得到provider select元素
			var s_provider = $("#s_providerID");
			//确保刷新页面option不会一直增加
			var childs = s_provider.children();
			for(var i=1;i<childs.length;i++){
				childs[i].remove();
			}
			//这个msg[0]是供应商的名字数组
			for(var i=0;i<msg[0].length;i++){
				var option = new Option();
				option.setAttribute("value",i+1);
				option.innerHTML = msg[0][i];
				s_provider.append(option);
			}
			//得到s_categoryID select元素
			var s_categoryID = $("#s_categoryID");
			//确保刷新页面option不会一直增加
			var childs = s_categoryID.children();
			for(var i=1;i<childs.length;i++){
				childs[i].remove();
			}
			//这个msg[1]是类别的名字数组
			for(var i=0;i<msg[1].length;i++){
				var option = new Option();
				option.setAttribute("value",i+1);
				option.innerHTML = msg[1][i];
				s_categoryID.append(option);
			}
			
		}
	})
})



function doSearch(obj){
	$.ajax({
		url:"productsManager",
		type:"get",
		data:{
			"op":"doRadyForSearchProduct",
		},
		success: function(responseText){
			alert("");
		}
	});
}
