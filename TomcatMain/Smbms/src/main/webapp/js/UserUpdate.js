var oldpassword = null;
var newpassword = null;
var rnewpassword = null;
var UserUpdateform = null;


$(function () {
    oldpassword = $("#oldpassword");
    newpassword = $("#newpassword");
    rnewpassword = $("#rnewpassword");
    UserUpdateform = $("#UserUpdateform");

    oldpassword.next().html("***").css('color', 'red');
    newpassword.next().html("***").css('color', 'red');
    rnewpassword.next().html("***").css('color', 'red');

    //鼠标获取焦点方法
    oldpassword.focus(function () {
        oldpassword.next().html("请输入旧密码").css('color', 'red');

    })
    //鼠标失去焦点方法
    oldpassword.blur(function () {

        //发送ajax请求
        $.ajax({
            //设置get请求
            type: 'POST',
            //设置请求的地址  url 和参数
            url: '${pageContext.request.contextPath}' + '/' + "A03_UserUpdateServlet",
            //pose请求要设置date
            data:{"method":"pwdmodify","oldpassword":oldpassword.val()},
            //设置超时时间（单位毫秒）`
            //timeout:1,
            //预期服务器返回数据类型
            dataType: 'json',
            // success代表回调  date代表服务器返回的参数
            success: function (date) {
                if (date != null) {
                   if (date.result=="ture"){
                       oldpassword.next().html("旧密码正确").css('color', '#00FF00')
                       oldpassword.attr("oldpassword",true)}

                    if (date.result=="false"){
                        oldpassword.next().html("旧密码不正确")
                        oldpassword.attr("oldpassword",false)}

                    if (date.result=="sessionereeor"){
                        oldpassword.next().html("回话失效")
                        oldpassword.attr("oldpassword",false)}

                    if (date.result=="ereeor"){
                        oldpassword.next().html("不能为空")
                        oldpassword.attr("oldpassword",false)}

                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                 alert(XMLHttpRequest.status);
                 alert(XMLHttpRequest.readyState);
                 alert(textStatus);
            }
        })

    })
    //鼠标获取焦点方法
    newpassword.focus(function () {
        newpassword.next().html("请输入新密码").css('color', 'red');


    })
//鼠标失去焦点方法
    newpassword.blur(function () {
        if (newpassword.val() != null && newpassword.val().length >= 6 && newpassword.val().length <= 20) {
            newpassword.next().html("密码可用!").css('color', '#00FF00');
            newpassword.attr("newpassword", true)
        }else {
            newpassword.next().html("密码格式不对! 必须大于6个字符").css('color', 'red');
            newpassword.attr("newpassword", false)

        }
    })

    //鼠标获取焦点方法
    rnewpassword.focus(function () {
        rnewpassword.next().html("请输入与上面一致的密码").css('color', 'red');


    })
//鼠标失去焦点方法
    rnewpassword.blur(function () {
        if (newpassword.val() == rnewpassword.val()) {
            rnewpassword.next().html("与上面密码一致").css('color', '#00FF00');
            rnewpassword.attr("rnewpassword", true)
        } else {
            rnewpassword.next().html("密码不一致").css('color', 'red');
            rnewpassword.attr("rnewpassword", false)

        }


    })

    //form表单提交事件（ // true表示可以正常提交 // false表示不可以提交）
    UserUpdateform.submit(function () {
        //判断3个输入框
        if (
            oldpassword.attr("oldpassword")=="true"&&
            newpassword.attr("newpassword") == 'true' &&
            rnewpassword.attr("rnewpassword") == 'true') {
           //询问框 (true表示可以正常提交 )
         if (confirm("确定修改密码？")){
             return true
         }
         else {
             //false表示不可以提交
             return false
        }

        } else {
            // false表示不可以提交
            return false
        }


    })


})
