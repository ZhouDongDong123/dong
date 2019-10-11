document.write("<script src='javascript/jQuery-1.12.4.js'></script>");
// updateProduct 时使用
function checkProductName(obj){
	//根据不同浏览器加载xmlhttp对象
	var xmlhttp;
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	//发送到服务器servlet处理数据
	xmlhttp.open("GET","productsManager?op=doCheckNameForAjax&product_name=" + obj.value + "&productID="+$("input[name=productID]").val(),true);
	//接收返回来的数据并操作
	xmlhttp.onreadystatechange=function()
	{
	  if (xmlhttp.readyState==4 && xmlhttp.status==200){
	     
	     if(xmlhttp.responseText == "true"){
	    	 document.getElementById("messProductCheckForName").innerHTML="<font color='red'>不允许重名</font>";

	     }else{
	    	 document.getElementById("messProductCheckForName").innerHTML="<font color='green'>检测通过</font>";
	     }
	    }
	}
	//发送
	xmlhttp.send();
}
function checkProductNameForJQuery(obj){
	$.ajax({
		url:"productsManager",
		type:"get",
		data:{
			"op":"doCheckDataForAjax",
			//向url中传值也就就是input中的值 只要一个就行了
			"product_data":obj.value,
			"productID":$("input[name=productID]").val(),
			"updateOp":obj.name
		},
		success: function(responseText){
			//这个是名字验证
			if(responseText == "true"){
		    	document.getElementById("messProductCheckForName").innerHTML="<font color='red'>不允许重名</font>";
		    }else if(responseText == "false"){
		    	document.getElementById("messProductCheckForName").innerHTML="<font color='green'>检测通过</font>";
		    }
		    //这个是进价验证
		    else if(responseText == "income_priceFalse"){
		    	document.getElementById("messProductCheckForIncome_price").innerHTML="<font color='green'>请正确输入</font>";
		    }else if(responseText == "income_priceTrue"){
		    	document.getElementById("messProductCheckForIncome_price").innerHTML="<font color='green'>检测通过</font>";
		    }
		    //这个是数量验证
		    else if(responseText == "quantityFalse"){
		    	document.getElementById("messProductCheckForQuantity").innerHTML="<font color='green'>请正确输入</font>";
		    }else if(responseText == "quantityTrue"){
		    	document.getElementById("messProductCheckForQuantity").innerHTML="<font color='green'>检测通过</font>";
		    }
		    //这个是售价验证
		    else if(responseText == "sales_priceFalse"){
		    	document.getElementById("messProductCheckForSales_price").innerHTML="<font color='green'>请正确输入</font>";
		    }else if(responseText == "sales_priceTrue"){
		    	document.getElementById("messProductCheckForSales_price").innerHTML="<font color='green'>检测通过</font>";
		    }

		}
	})
	
}