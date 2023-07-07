

function form() {
    var Boolean = true;
    var userCode = $("#userCode").val();
    var password = $("#password").val();
    var item = $(":radio:checked").length;
    if (userCode == "" && password == ""&&item<=0) {
        Boolean = false;
    }
    return Boolean;
}
