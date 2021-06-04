package com.zt.service.impl;

import com.zt.dao.AdminDao;
import com.zt.pojo.admin;
import com.zt.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao dao;

    @Override
    public String loginService(String cname,String password) {
        admin a = null;
        try{
           a = dao.selectAdmin(cname);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }finally {}
        /*
        *   case "pno":{
                    prompt("密码错误！");

                case "ano":{
                    prompt("用户名不存在！");

                case "error":{
                    prompt("后台出现异常！");

        * */
        if(a==null) return "ano";
        if(a.getPassword().equals(password)) return "success";
        else return "pno";
    }
}
