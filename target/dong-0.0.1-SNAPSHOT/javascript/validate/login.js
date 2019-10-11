$(function(){
	var $loginForm = $("#loginCheck");
	$.validator.addMethod('noSpace',function(value,element){
		return value == '' || value.trim().length != 0
	},"Spaces Are not allowed!");//
	
	if($loginForm.length){
		$loginForm.validate({
			rules:{
				username:{
					required:true,
					noSpace:true
				},
				
				password:{
					required:true,
					noSpace:true
				},			
			},
			messages:{
				username:{
					required:'This field is required.'
				},
				password:{
					required:'This field is required.'
				}
			}
		})
	}
	
	
})