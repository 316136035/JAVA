

$(function () {
    //发送ajax请求
        $.ajax({
            //设置get请求
            type: 'get',
            //设置请求的地址  url 和参数
            url: '${pageContext.request.contextPath}' + '/' + "A01_RoleServlet",
            //pose请求要设置date
            // data:{"method":"pwdmodify"},
            //设置超时时间（单位毫秒）`
            //timeout:1,
            //预期服务器返回数据类型
            dataType: 'json',
            // success代表回调  date代表服务器返回的参数
            success: function (date) {
                if (date != null) {
                    for (let i = 0; i < date.length; i++) {
                        $("#select").append('" <option value='+date[i].id+'>'+date[i].roleName+'</option>"');
                    }


                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        })
})


