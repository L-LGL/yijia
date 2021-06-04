$(function () {
    // 点击菜单栏
    $("#left-nav").children("li").click(function () {
        $("#left-nav").children("li").each(function () {
           $(this).removeClass("active");
        });
       $(this).addClass("active");
       var action = $(this).attr("name");
       console.log(action);
       switch (action){
           case "custom":{/*用户*/
               $("iframe").attr("src","acustom.jsp");
               break;
           }
           case "admin":{/*管理员*/
               $("iframe").attr("src","admin.jsp");
               break;
           }
           case "merchant":{/*商家*/
               $("iframe").attr("src","trader.jsp");
               break;
           }
           case "store" :{/*商店*/
               $("iframe").attr("src","store.jsp");
               break;
           }
           case "goods":{/*商品*/
               $("iframe").attr("src","agoods.jsp");
               break;
           }
           case "recommend":{
               $("iframe").attr("src","arecommend.jsp");
               break;
           }
           case "sort":{/*种类*/
               $("iframe").attr("src","asort.jsp");
               break;
           }
           case "cart":{/*购物车*/
               $("iframe").attr("src","acart.jsp");
               break;
           }
           case "order":{/*订单*/
               $("iframe").attr("src","aorder.jsp");
               break;
           }
           case "comment":{/*todo 评价管理未写*/
               $("iframe").attr("src","/sppj");
               break;
           }
           case "statistics":{/* todo 数据统计 */
               $("iframe").attr("src","/spsjfx");
               break;
           }
           case "exit":{/*退出*/
               window.location.href="alogin.jsp";
               break;
           }
           default:break;
       }
    });
})