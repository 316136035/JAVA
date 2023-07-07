// 点击上一页或者下一页时，执行的方法，给隐藏域赋值，然后提交表单
function to_page(num) {

    // 如果传入了数字
    if (num > 0) {
        // 给隐藏域赋值
        $("#pageNo").val(num);
        // 提交form表单
        document.form.submit();
    } else {
        num = 1;
    }


}
