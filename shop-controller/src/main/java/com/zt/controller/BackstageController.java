package com.zt.controller;

import com.zt.pojo.*;
import com.zt.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class BackstageController {
    @Resource
    private AdminService adminService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private OrderService orderService;
    @Resource
    private CustomService customService;
    @Resource
    private CartService cartService;
    @Resource
    private StoreService storeService;

    // 管理员后台界面跳转
    @RequestMapping(value = "/admin")
    public ModelAndView toBackstage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/alogin.jsp");
        return modelAndView;
    }

    // 处理管理员登录
    @RequestMapping(value = "/alogin.action",method = RequestMethod.POST)
    public void alogin(@RequestParam(value = "cname") String cname,
                       @RequestParam(value = "password") String password,
                       HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            String result = adminService.loginService(cname,password);
            out.print(result);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 添加商品信息 todo 添加 priority 字段，需要前端传参
    @RequestMapping(value = "/addGoods.action",method = RequestMethod.POST)
    public void addGoods(@RequestParam(value = "id") String id,
                         @RequestParam(value = "img") String img,
                         @RequestParam(value = "title") String title,
                         @RequestParam(value = "info") String info,
                         @RequestParam(value = "name") String name,
                         @RequestParam(value = "price") String price,
                         @RequestParam(value = "stock") String stock,/*库存*/
                         @RequestParam(value = "para") String para,
                         @RequestParam(value = "type") String type,
                         @RequestParam(value = "weight") String weight,
                         @RequestParam(value = "priority")String priority,
                         HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
	        goods goods = new goods(id,img,title,info,name,new Double(price).intValue(),new Integer(stock),para,type,new Integer(weight),new Integer(priority));
            goodsService.addGoodsService(goods);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 添加订单信息
    @RequestMapping(value = "/addOrder.action",method = RequestMethod.POST)
    public void addOrder(@RequestParam(value = "rid") String rid,
                         @RequestParam(value = "cname") String cname,
                         @RequestParam(value = "ids") String ids,
                         @RequestParam(value = "names") String names,
                         @RequestParam(value = "price") String price,
                         HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            order order = new order(rid,cname,ids,names,new Integer(price));
            orderService.addOrderService(order);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 删除单个字段
    @RequestMapping(value = "/deleteItem.action",method = RequestMethod.POST)
    public void deleteItem1(@RequestParam("table") String table,
                            @RequestParam("id") String id,
                            HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            switch (table){
                case "custom":{
                    customService.deleteCustomService(id);
                    break;
                }
                case "goods":{
                    goodsService.deleteGoodsService(id);
                    break;
                }
                case "cart":{
                    String[] s = id.split("_");
                    cartService.deleteCartService(s[0],s[1]);
                    break;
                }
                case "order":{
                    orderService.deleteOrderService(id);
                    break;
                }
                default:break;
            }
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 修改客户信息
    @RequestMapping(value = "/updateCustom2.action",method = RequestMethod.POST)
    public void updateCustom2(@RequestParam(value = "cname") String cname,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "address") String address,
                             @RequestParam(value = "role") int role,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "question") String question,
                             @RequestParam(value = "answer") String answer,
                             HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            custom c = new custom(cname,password,name,phone,address,role,question,answer);
            customService.updateCustomService(c);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 修改商品信息 todo 添加了priority字段，需要前端传参
    @RequestMapping(value = "/updateGoods.action",method = RequestMethod.POST)
    public void updateGoods(@RequestParam(value = "id") String id,
                            @RequestParam(value = "img") String img,
                            @RequestParam(value = "title") String title,
                            @RequestParam(value = "info") String info,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "price") String price,
                            @RequestParam(value = "stock") String stock,/*库存*/
                            @RequestParam(value = "para") String para,
                            @RequestParam(value = "type") String type,
                            @RequestParam(value = "weight") String weight,
                            @RequestParam(value = "priority")String priority,
                            HttpServletResponse response){
        PrintWriter out = null;
        int s_id=100001;
        try{
            out = response.getWriter();
            goods goods = new goods(id,img,title,info,name,new Integer(price),new Integer(stock),para,type,new Integer(weight),new Integer(priority));
            goodsService.updateGoods(goods);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 修改购物车信息
    @RequestMapping(value = "/updateCart.action",method = RequestMethod.POST)
    public void updateCart(@RequestParam(value = "cname") String cname,
                           @RequestParam(value = "id") String id,
                           @RequestParam(value = "img") String img,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "price") String price,
                           @RequestParam(value = "number") String number,
                           HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            cart cart = new cart(cname,id,img,name,new Integer(price),new Integer(number));
            cartService.updateCartService(cart);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 修改订单信息
    @RequestMapping(value = "/updateOrder.action",method = RequestMethod.POST)
    public void updateCart(@RequestParam(value = "rid") String rid,
                           @RequestParam(value = "cname") String cname,
                           @RequestParam(value = "ids") String ids,
                           @RequestParam(value = "names") String names,
                           @RequestParam(value = "price") String price,
                           HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            order order = new order(rid,cname,ids,names,new Integer(price));
            orderService.updateOrderService(order);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 添加商店信息
    @RequestMapping(value = "addstore.action",method = RequestMethod.POST)
    public void addStore(@RequestParam(value = "sname")String sname,
                         @RequestParam(value = "boss")String boss,
                         @RequestParam(value = "info")String info,
                         @RequestParam(value = "license")String license,
                         HttpServletResponse response){
        PrintWriter pw = null;
        try{
            pw = response.getWriter();
            store store = new store(sname, boss, 0, info, license, 1, new Date(),new Date());
            storeService.addStore(store);
            pw.print("success");
            pw.flush();
        }catch (IOException i){
            i.printStackTrace();
        }finally {
            pw.close();
        }
    }

    // 修改商店信息
    @RequestMapping(value = "updateStore.action",method = RequestMethod.POST)
    public void updateStore(@RequestParam("sname")String sname,
                            @RequestParam("boss")String boss,
                            @RequestParam("info")String info,
                            @RequestParam("license")String license,
                            @RequestParam("status")String status,
                            HttpServletResponse response){
        PrintWriter pw = null;
        try{
            pw = response.getWriter();
            store s = new store(sname,boss,info,license, Integer.valueOf(status),new Date());
            storeService.update(s);
            pw.print("success");
            pw.flush();
        }catch (IOException e){
            e.printStackTrace();

        }finally {
            pw.close();
        }
    }
}
