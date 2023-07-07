

// 获取选中的checkbox的索引
function daluser(){
    var arr = new Array();

    /*获取选中*/
    var checkboxs=$("input[type='checkbox']:checked")
    if (checkboxs.length>0){
        checkboxs.each(function () {
                arr.push($(this).attr("id"))

            }
        )
        if (confirm("确定删除???")){
            alert(arr.length)
            /*调用删除*/
            location.href = "/A02_DaleUserServlet?arr="+arr;


        }

    }


}

function adduser(){
        location.href="../jsp/addUser.jsp"







}
