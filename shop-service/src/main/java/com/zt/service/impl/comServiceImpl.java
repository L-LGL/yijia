package com.zt.service.impl;

import com.zt.dao.comdao;
import com.zt.pojo.comments;
import com.zt.service.comService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class comServiceImpl implements comService {
    @Autowired
    private com.zt.dao.comdao comdao;
    public void addpl(String cname,String name,String com,Integer nub){

      comdao.addpl(cname,name,com,nub);

    }
    public List<comments> lookpl(){

        List<comments> lookpl = comdao.lookpl();
        return  lookpl;
    }
    public void up(Integer id,String admincom){
        comdao.up(id,admincom);
    }
    public void de(Integer id){
        comdao.de(id);
    }
    public List<comments> lookid(Integer id){
        List<comments> lookid = comdao.lookid(id);
        return lookid;

    }
    public  List<comments> one(String name){
        List<comments> one = comdao.one(name);
        return one;
    }
    public  List<Integer> tow(String name){
        List<Integer> tow = comdao.tow(name);
        return tow;
    }
    public void setx(Integer nub,String name){
        comdao.setx(nub,name);
    }
}
