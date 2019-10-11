$(function(){
	var $addCustomerForm = $("#addCustomerId");
	$.validator.addMethod('noSpace',function(value,element){
		return value == '' || value.trim().length != 0
	},"Spaces Are not allowed!");//
	
	$.validator.addMethod("isTel", function(value, element) {
        var length = value.length;
        var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
        return this.optional(element) || (phone.test(value));
       }, "Please fill in the correct tel");//可以自定义默认提示信息

	if($addCustomerForm.length){
		$addCustomerForm.validate({
			rules:{
				cusname:{
					required:true,
					noSpace:true
				},
				
				address:{
					required:true,
					noSpace:true
				},
				contact:{
					required:true,
					noSpace:true
				},
				tel:{
					required:true,
					isTel:true
				},email:{
					required:true,
					email: true
				}
				
				
				
			},
			messages:{
				cusname:{
					required:'This field is required.'
				},
				email:{
					required:'This field is required.',
					email: 'email invalid!'
				}
			}
		})
	}
	
	
})