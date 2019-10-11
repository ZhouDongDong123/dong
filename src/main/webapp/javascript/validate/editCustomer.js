/*var form = $('#customForm');*/
/*$(document).ready(function () {
	$('#customForm').bootstrapValidator({
        message: '输入值不合法',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	cusname: {
                message: '用户名不合法',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: '请输入3到30个字符'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '用户名只能由字母、数字、点、下划线和汉字组成 '
                    }
                   
                }
            },
            address:{
            	message: '地址不合法',
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: '请输入1到30个字符'
                    },
                    
                }
            },
            contact:{
            	message: '联系人不合法',
                validators: {
                    notEmpty: {
                        message: '联系人不能为空'
                    },
                    stringLength: {
                        max: 10,
                        message: '最大10个字符'
                    },
                }
            },
            tel:{
            	message: '联系人不合法',
                validators: {
                    notEmpty: {
                        message: '联系人不能为空'
                    },
                    regexp: {
                        regexp:  /(^(\d{3,4}-)?\d{6,8}$)|(^(\d{3,4}-)?\d{6,8}(-\d{1,5})?$)|(\d{11})/,
                        message: '手机号码'
                    }
                }
            }
            , email: {
                validators: {
                    notEmpty: {
                        message: 'email不能为空'
                    },
                    emailAddress: {
                        message: '请输入正确的邮件地址如：123@qq.com'
                    }
                }
            }
        }
    });
});*/
/*$("#submitBtn").click(function () {
    //进行表单验证
    var bv = form.data('bootstrapValidator');
    bv.validate();
    if (bv.isValid()) {
        console.log(form.serialize());
        //发送ajax请求
        $.ajax({
            url: 'javascript/validate/validator.json',
            async: false,//同步，会阻塞操作
            type: 'GET',//PUT DELETE POST
            data: form.serialize(),
            complete: function (msg) {
                console.log('完成了');
            },
            success: function (result) {
                console.log(result);
                if (result) {
                    window.location.reload();
                } else {
                    $("#returnMessage").hide().html('<label class="label label-danger">修改失败!</label>').show(300);
                }
            }, error: function () {
                $("#returnMessage").hide().html('<label class="label label-danger">修改失败!</label>').show(300);
            }
        })
    }
});*/







