$.ajax({
    url: "/err/getAjaxerror",
    type: "POST",
    async: false,
    success: function(data) {
        // debugger;
        // if(data.status == 200 && data.msg == "OK") {
        if(data.code == 200) {
            alert("success");
        } else {
            alert("发生异常：" + data.msg);
        }
    },
    error: function (response, ajaxOptions, thrownError) {
        // debugger;
        alert("error");
    }
});