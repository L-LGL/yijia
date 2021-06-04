/* 单击侧边栏，查询相应类型的商品 */
$(function () {
    $(".shop-index-left ul div a").click(function () {
        var title = $(this).text();
        var data = {"action" : title};
        search(data);
    });
})