$(function(){
	var $addEmployeeForm = $("#addEmployeeId");
	$.validator.addMethod('noSpace',function(value,element){
		return value == '' || value.trim().length != 0
	},"Spaces Are not allowed!");//
	
	$.validator.addMethod("isTel", function(value, element) {
        var length = value.length;
        var phone = /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/;
        return this.optional(element) || (phone.test(value));
       }, "Please fill in the correct tel");//可以自定义默认提示信息

	if($addEmployeeForm.length){
		$addEmployeeForm.validate({
			rules:{
				username:{
					required:true,
					noSpace:true
				},
				password:{
					required:true,
					noSpace:true
				},
				tel:{
					required:true,
					isTel:true
				},
				name:{
					required:true,
				},email:{
					required:true,
					email: true
				},
				emptype: {
					min:1
				}
				
			},
			messages:{
				username:{
					noSpace:'请输入有效用户名'
				},
				
				password:{
					noSpace:'请输入有效密码'
				},
				
				tel:{
					isTel:'请输入有效手机号'
				},
				name:{
					noSpace:'请输入有效密码'
				},
				email:{
					required:'This field is required.',
					email: 'email invalid!'
				},
				emptype: {
					min:'请选择员工类型'
				}
	
			}
		})
	}
	
	
})