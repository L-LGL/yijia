$(function () {
    // 单击立即支付
    $("input[name='payment']").click(function () {
       $("#myModal3").modal();
    });
    $("#pay-submit").click(function () {
       var password = getPassword();
       if(password==""){
           alert("输入框不能为空！");
           return;
       }
       else{
           submitOrder();
           clearPassword();
       }
    });

    // 单击取消支付
    $("#pay-restart").click(function () {
        $("#myModal3").modal("hide");
    });

    // 支付成功，单击确定
    $("input[name='cancel1']").click(function () {
        $("#myModal4").modal("hide");
        /*获取数据*/
        var id = $("#pay_id").val();
        var number = $("#pay_number").val();
        var data = {id:id,num:number};
        console.log(data);
        /*createOrderPage(data);*/
    });

    $("input[name='cancel2']").click(function () {
        $("#myModal5").modal("hide");
    });
    $("input[name='cancel3']").click(function () {
        $("#myModal6").modal("hide");
    });

    // 获取支付框的密码
    function getPassword() {
        var paw = $("input[name='pass']");
        var n="";
        for(var i=0;i<6;i++){
            n+=paw[i].value;
        }
        return n;
    }

    // 清除支付框的密码
    function clearPassword() {
        var paw = $("input[name='pass']");
        for(var i=0;i<6;i++){
            paw.val("");
        }
    }
})