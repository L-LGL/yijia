package com.zt.service;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.zt.pojo.comments;
@Transactional
public interface comService {
    public void addpl(String cname, String name, String com, Integer nub);
    public List<comments> lookpl();
    public void up(Integer id, String admincom);
    public void de(Integer id);
    public List<comments> lookid(Integer id);
    public  List<comments> one(String name);
    public  List<Integer> tow(String name);
    public void setx(Integer nub, String name);
}
