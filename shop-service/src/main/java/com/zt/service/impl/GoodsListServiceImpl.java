package com.zt.service.impl;

import com.zt.dao.GoodsDao;
import com.zt.dao.GoodsListDao;
import com.zt.pojo.goods;
import com.zt.service.GoodsListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsListServiceImpl implements GoodsListService {
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private GoodsListDao goodsListDao;

    @Override
    public boolean goodsListService(String title) {
        try{//todo 到这
            goodsListDao.clearGoodslist();//清空 goodslist 数据库表
            List<goods> list = goodsDao.selectGoodsByTitle(title);
            goodsListDao.insertGoodslist(list);// 往 goodslist 表中添加数据
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean goodsListServiceByLike(String info) {
        try{
            // 清空 goodslist 表中的数据
            goodsListDao.clearGoodslist();
            List<goods> list = goodsDao.selectGoodsLike("%"+info+"%");
            goodsListDao.insertGoodslist(list);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
