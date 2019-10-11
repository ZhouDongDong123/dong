$(function(){
	var addCustomervisitId = $("#addCustomervisitId");
	$.validator.addMethod('noSpace',function(value,element){
		return value == '' || value.trim().length != 0
	},"Spaces Are not allowed!");//
	if(addCustomervisitId.length){
		addCustomervisitId.validate({
			rules:{
				contact:{
					required:true,
					noSpace:true
				},
				cid: {
					min:1
				},
				empId: {
					min:1
				}
			},
			messages:{
				contact:{
					required:'This field is required.'
				},
				cid: {
					min:'请选择一个顾客'
				},
				empId: {
					min:'请选择一个专员'
				}
			}
		})
	}
	
	
})