$(function () {
    // 取消商店添加
    $("input[name='store_cancel']").click(function () {
        $("#addcustom").modal("hide");
    });
    // 商店添加
    $("input[name='store_add']").click(function () {
        var sname = $("input[name='sname']").val();
        var boss = $("input[name='boss']").val();
        var info = $("input[name='info']").val();
        var license = $("input[name='license']").val();

        var data = {"sname":sname,"boss":boss,"info":info,"license":license,};
        if(sname==""||boss==""||info==""||license==""){
            alert("输入框不能为空！");
            return;
        }
        addStore(data);
    });
    // 商店修改关闭弹框
    $("input[name='store_cancel1']").click(function () {
        $("#updatecustom").modal('hide');
    });
    // 商店修改
    $("input[name='store_add1']").click(function () {
        var sname = $("input[name='sname']").val();
        var boss = $("input[name='boss']").val();
        var info = $("input[name='info']").val();
        var license = $("input[name='license']").val();
        var status = $("input[name='status']").val();
        var data = {"sname":sname,"boss":boss,"info":info,"license":license,"status":status};
        console.log(data);
        if(sname==""||boss==""||info==""||license==""||status==""){
            /*status==""||create==""||update==""||del==""*/
            alert("输入框不能为空！");
            return;
        }
        updateStore(data);
    });
})