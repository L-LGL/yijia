package com.zt.controller;

import com.zt.pojo.*;
import com.zt.model.pay;
import com.zt.service.*;
import com.zt.util.NumberUtil;
import com.zt.util.PayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class OperationController {
    @Resource
    private CartService cartService;
    @Resource
    private OrderService orderService;
    @Resource
    private CustomService customService;
    @Resource
    private comService comService;
    @Resource
    private GoodsService goodsService;

    // 加入购物车
    @RequestMapping(value = "/addCart.action",method = RequestMethod.POST)
    public void addCart(@RequestParam(value = "cname") String cname,
                        @RequestParam(value = "id") String id,
                        @RequestParam(value = "img") String img,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "price") String price,
                        @RequestParam(value = "number") String number,
                        HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            int p = new Integer(price);
            int n = new Integer(number);
            String result = cartService.addCartService(new cart(cname,id,img,name,p,n));
            out.print(result);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 删除购物车记录
    @RequestMapping(value = "/removeCart.action",method = RequestMethod.POST)
    public void removeCart(@RequestParam(value = "id") String id,
                           HttpServletRequest request,HttpServletResponse response){
        HttpSession session = null;
        PrintWriter out = null;
        try{
            session = request.getSession();
            out = response.getWriter();
            String cname = session.getAttribute("cname").toString();
            cartService.deleteCartService(cname,id);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }

    // 提交订单
    @RequestMapping(value = "/submitOrder.action",method = RequestMethod.POST)
    public void submitOrder(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = null;
        PrintWriter out = null;
        try{
            session = request.getSession();
            out = response.getWriter();
            String c_id = NumberUtil.createNumber();// 生成随机订单号
            String cname = session.getAttribute("cname").toString();
            List<pay> list = (List<pay>) session.getAttribute("pay");// 商品订单集合
            String price = session.getAttribute("allprice").toString();// 总价格
            order order = PayUtil.createOrder(c_id,list,cname,price);// 看看 order 是啥？
            System.out.println(order);
            orderService.addOrderService(order);// 添加订单信息
            for(pay e : list){
                cartService.deleteCartService(cname,e.getId());
            }
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
    }

    // 删除订单记录
    @RequestMapping(value = "/removeOrder.action",method = RequestMethod.POST)
    public void removeOrder(@RequestParam(value = "rid") String rid,
                            HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        try{
            out = response.getWriter();
            orderService.deleteOrderService(rid);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }
    //评论界面数据
    @RequestMapping("/a")
    public String a2(HttpSession session, String name){



         session.setAttribute("map",name);
        return "page/a.jsp";
    }

    @RequestMapping("/addpl2")
    public String addpl(comments comm, HttpSession session){
        // cname=(String) session.getAttribute("x");
        System.out.println("---------------------------------------------------------------"+comm);
        String cname=comm.getCname();
        String namex=comm.getName();
        String name= namex.substring(1, namex.length() - 1);
        String com=comm.getCom();
        int nub=comm.getNub();

        try {
            comService.addpl(cname,name,com,nub);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index.jsp";

    }

    //商品评论展示
    @RequestMapping("/one")
    public String one(HttpSession session,String good_name){
        System.out.println("**************************"+good_name);

        List<comments> one = comService.one(good_name);
       session.setAttribute("csgo" ,one);
        return "page/b.jsp";
    }


//后台评价管理
    @RequestMapping("/sppj")
    public String sppj(HttpSession session){

        List<comments> lookpl = comService.lookpl();
        session.setAttribute("cs" ,lookpl);
        System.out.println("**************************"+session.getAttribute("cs"));

        return "page/pjia.jsp";

    }

//删除评论
    @RequestMapping("/depl")
    public String depl(Integer id){
        comService.de(id);
        return "forward:/sppj";
    }

    @RequestMapping("/spsjfx")
    public String spsjfx(Model model,HttpSession session){
        List<comments> lookGood = comService.lookpl();
        List<List<Integer>> a=new ArrayList<>();
//        Map<String, String> tj = new TreeMap<String, String>(
//                new Comparator<String>() {
//                    public int compare(String obj1, String obj2) {
//                        // 降序排序
//                        return obj2.compareTo(obj1);
//                    }
//                });
        Double y=0.0;
        Double z=0.0;
        int k=0;
        Double [] o=new Double[1000];
        for (comments x:lookGood) {
            String name = x.getName();
            List<Integer> tow = comService.tow(name);
            a.add(tow);
        }
        for (List<Integer> x: a) {
            y=0.0;
            z=0.0;
            for(int i = 0 ; i < x.size() ; i++) {
                y+=x.get(i);

            }
            z = y/x.size();
            o[k]=(z);
            k++;
        }
        session.setAttribute("ery",lookGood);
       session.setAttribute("sz",o);
        return "forward:/page/ddsjfx.jsp";
    }

    @RequestMapping("/tujian")
    public String tjiansy(HttpSession session){

        List<goods> lookGood = goodsService.look();
        List<List<Integer>> a=new ArrayList<>();
        Map<String, String> tj = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        Double y=0.0;
        Double z=0.0;
        int k=0;
        Double [] o=new Double[1000];
        for (goods x:lookGood) {
            String name = x.getName();
            List<Integer> tow = comService.tow(name);
            a.add(tow);
        }
        for (List<Integer> x: a) {
            y=0.0;
            z=0.0;
            for(int i = 0 ; i < x.size() ; i++) {
                y+=x.get(i);

            }
            z = y/x.size();
            o[k]=(z);
            k++;
        }
        int l=0;
        for (goods x:lookGood) {

            String name = x.getName();
            Double aDouble = o[l];
            System.out.println(aDouble + "------:******************************"+name);
            String s = String.valueOf(aDouble);
            if (s.equals("NaN"))
                s="0";
            tj.put(s,name);
            l++;
        }
        List<goods> kox=new ArrayList<>();
        ArrayList<List<goods>> objects = new ArrayList<>();
        Set<String> keySet = tj.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            String ko=tj.get(key);
             kox = goodsService.lookGoodo(ko);
            if (iter.hasNext()==true){
                break;
            }

        }
        session.setAttribute("tjiana",kox);
        System.out.println("/////////////////////////////////////////////////" + session.getAttribute("tjiana"));

        return "forward:/index.jsp";
    }

    // 跟新用户信息
    @RequestMapping(value = "/updateCustom.action",method = RequestMethod.POST)
    public void updateCustom(@RequestParam(value = "name") String name,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "address") String address,
                             @RequestParam(value = "role") int role,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "question") String question,
                             @RequestParam(value = "answer") String answer,
                             HttpServletRequest request,HttpServletResponse response){
        PrintWriter out = null;
        HttpSession session = null;
        try{
            out = response.getWriter();
            session = request.getSession();
            String cname = session.getAttribute("cname").toString();
            custom custom = new custom(cname,password,name,phone,address,role,question,answer);
            customService.updateCustomService(custom);
            out.print("success");
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {}
        out.close();
    }
}
