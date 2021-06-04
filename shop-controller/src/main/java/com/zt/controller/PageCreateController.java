package com.zt.controller;

import com.zt.model.orderv;
import com.zt.pojo.*;
import com.zt.model.pay;
import com.zt.service.*;
import com.zt.util.JsonUtil;
import com.zt.util.PayUtil;
import com.zt.util.TypeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// 页面生成部分控制器
@Controller
public class PageCreateController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private SortService sortService;
    @Resource
    private GoodsIndexService goodsIndexService;
    @Resource
    private RecommendService recommendService;
    @Resource
    private GoodsListService goodsListService;
    @Resource
    private CartService cartService;
    @Resource
    private CustomService customService;
    @Resource
    private OrderService orderService;

    // 首页侧边栏，根据商品类型查询商品
    @RequestMapping(value = "/sortTitle.action",method = RequestMethod.POST)
    public void sortTitle(@RequestParam(name = "action") String action,
                         HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
//        HttpSession session = null;
        try{
            out = response.getWriter();// 获取响应的输出流
//            session = request.getSession();
            List<goods> goodsList = goodsService.selectByTitle(action);// 查询商品类型表，找到想要的商品类型，将查询到的商品存放到 sort 表里面
/*session.setAttribute("type",action);// 通过前端传送过来的 action 来获取相应类型的商品
            out.print("success");*/
            // 将查询出来的商品插入到 sort 表中
            sortService.insertService(goodsList);
            out.write("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    /* 导航栏的查询请求，请求结果数据放在 goodslist 表中 */
    @RequestMapping(value = "/sortPage.action",method = RequestMethod.POST)
    public void sortPage(@RequestParam(name = "action") String action,
                         HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();// 获取响应的输出流
            session = request.getSession();//
            goodsIndexService.goodsindexService(action); // 查询商品类型表，找到想要的商品类型，将查询到的商品存放到 sort 表里面
            session.setAttribute("type",TypeUtil.changeType(action));// 通过前端传送过来的 action 来获取相应类型的商品
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 页面推荐
    @RequestMapping(value = "/recommendPage.action",method = RequestMethod.POST)
    public void recommendPage(HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            // result ： 从推荐表 recommend 中查询到的 json 字符串
            String result = recommendService.recommendService();
            out.print(result);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求打开商品列表
    @RequestMapping(value = "/goodslistPage.action",method = RequestMethod.POST)
    public void goodslistPage(@RequestParam(value = "title") String title,
                              HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            System.out.println("打桩：：\tPageCreateController" + title);
            goodsListService.goodsListService(title);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 处理搜索、侧边栏查询操作请求
    @RequestMapping(value = "/search.action",method = RequestMethod.POST)
    public void search(@RequestParam(value = "action") String action,
                       HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            // 通过模糊查询查询到搜索的商品
            goodsListService.goodsListServiceByLike(action);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求打开商品页面
    @RequestMapping(value = "/goodsPage.action",method = RequestMethod.POST)
    public void goodsPage(@RequestParam(value = "id") String id,
                          HttpServletResponse response,
                          HttpServletRequest request){
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            goods p = goodsService.selectService(id);
            System.out.println("00000000000000000000000000000000000000000000000000000000" + p);
            session.setAttribute("goods",p);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求生成查看购物车页面
    @RequestMapping(value = "/cartPage.action",method = RequestMethod.POST)
    public void cartPage(HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            String cname = session.getAttribute("cname").toString();
            List<cart> list = cartService.selectCartService(cname);
            session.setAttribute("mycart",list);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求生成用户信息页面
    @RequestMapping(value = "/infoPage.action",method = RequestMethod.POST)
    public void infoPage(HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            String cname = session.getAttribute("cname").toString();
            custom c = customService.getCustomService(cname);
            session.setAttribute("custom",c);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求生成支付页面
    @RequestMapping(value = "/payPage.action",method = RequestMethod.POST)
    public void payPage(@RequestParam(value = "ids") String ids,
                         @RequestParam(value = "imgs") String imgs,
                         @RequestParam(value = "names") String names,
                         @RequestParam(value = "numbers") String numbers,
                         @RequestParam(value = "prices") String prices,
                         @RequestParam(value = "allprice") String allprice,
                         HttpServletRequest request,HttpServletResponse response){
        System.out.println("打桩测试 ：：\t" + ids + "-" + imgs + "-" + names + "-" + numbers + "-" + prices + "-" + allprice);
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            String cname = session.getAttribute("cname").toString();// 当前登录用户名
            custom c = customService.getCustomService(cname);// 当前登录的用户信息
            session.setAttribute("custom",c);

            List<pay> list = PayUtil.createList(ids,imgs,names,numbers,prices);//支付类的集合
            // todo 将用户生成的商品订单信息存储到 list 集合中
            session.setAttribute("pay",list);
            session.setAttribute("allprice",allprice);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求生成订单页面
    @RequestMapping(value = "/orderPage.action",method = RequestMethod.POST)
    public void openOrder(HttpServletRequest request,
                          HttpServletResponse response){
        /*todo 待完成订单信息处理 订单号 ，订单数量 */
//        System.out.println(id + "::" + number);
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            String cname = session.getAttribute("cname").toString();
            List<orderv> list = orderService.getOrderService(cname);
            session.setAttribute("orderv",list);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 请求生成订单对话框
    @RequestMapping(value = "/orderInfo.action",method = RequestMethod.POST)
    public void orderDialog(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            String cname = session.getAttribute("cname").toString();
            custom custom = customService.getCustomService(cname);
            String c = JsonUtil.JsonObject(custom);
            out.print(c);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }
}
