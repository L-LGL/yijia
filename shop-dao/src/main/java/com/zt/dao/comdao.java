package com.zt.dao;

import com.zt.pojo.comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface comdao {

    public void addpl(@Param("cname") String cname, @Param("name") String name, @Param("com") String com, @Param("nub") Integer nub);
    public List<comments> lookpl();
    public void up(@Param("id") Integer id, @Param("admincom") String admincom);
    public void de(Integer id);
    public List<comments> lookid(Integer id);
    public  List<comments> one(String name);
    public  List<Integer> tow(String name);
    public void setx(@Param("nub") Integer nub, @Param("name") String name);

}
