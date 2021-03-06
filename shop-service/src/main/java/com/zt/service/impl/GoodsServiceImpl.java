package com.zt.service.impl;

import com.zt.dao.GoodsDao;
import com.zt.dao.StoreDao;
import com.zt.pojo.goods;
import com.zt.service.GoodsService;
import com.zt.util.JsonUtil;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao dao;
    @Resource
    private StoreDao storeDao;

    @Override
    public goods selectService(String id) {
        goods p = null;
        try{
            p = dao.selectGoodsById(id);
            p.setStore(storeDao.selectById(p.getS_id()));
        }catch (Exception e){
            e.printStackTrace();
            return p;
        }finally {}
        return p;
    }

    @Override
    public boolean addGoodsService(goods goods) {
        try{
            dao.insertGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {}
        return true;
    }

    @Override
    public boolean deleteGoodsService(String id) {
        try{
            dao.deleteGoods(id);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {}
        return true;
    }

    @Override
    public boolean updateGoodsService(goods goods) {
        try{
            dao.deleteGoods(goods.getId());
            dao.insertGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {}
        return true;
    }

    @Override
    public List<goods> selectByTitle(String type) {
        List<goods> goodsList = null;
        try{
            goodsList = dao.selectGoodsByTitle(type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return goodsList;
    }
    public List<goods> lookGoodo(String name){
        List<goods> goods = dao.lookGoodo(name);
        return  goods;
    }
    public List<goods> look(){
        List<goods> look = dao.look();
        return look;
    }

    @Override
    public void updateGoods(goods goods) {
        dao.updateGoods(goods);
    }

}
