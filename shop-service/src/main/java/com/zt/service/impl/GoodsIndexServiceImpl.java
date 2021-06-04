package com.zt.service.impl;

import com.zt.dao.GoodsIndexDao;
import com.zt.dao.GoodsListDao;
import com.zt.dao.SortDao;
import com.zt.pojo.goods;
import com.zt.pojo.goodsindex;
import com.zt.service.GoodsIndexService;
import com.zt.util.TypeUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsIndexServiceImpl implements GoodsIndexService {
    @Resource
    private GoodsIndexDao goodsIndexDao;
    @Resource
    private SortDao sortDao;
    @Resource
    private GoodsListDao goodsListDao;

    @Override
    public List<goodsindex> goodsindexService(String type) {
        List<goodsindex> list = null;
        try{
            sortDao.clearSort();// 清空 sort 数据库
            String t = TypeUtil.changeType(type); // 通过工具类获取前端想要的商品类型
            list = goodsIndexDao.selectByType( t ); // 通过类型从商品类型表中查找到相应的商品
            sortDao.insertSort(list); // 往 sort 中添加查询到的商品
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return list;
    }

    @Override
    public List<goods> goodsindexServiceType(String type) {
        List<goods> list = null;
        try{
            sortDao.clearSort();// 清空 sort 数据库
            list = goodsIndexDao.selectByTitle("%" + type + "%"); // 通过类型从商品类型表中查找到相应的商品
            System.out.println("----------------->");
            for (goods g:list) {
                System.out.println(g);
            }
            System.out.println("==================================");
            sortDao.insertGoods(list); // 往 sort 中添加查询到的商品
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return list;
    }
}