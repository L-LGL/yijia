package com.zt.service.impl;

import com.zt.dao.GoodsDao;
import com.zt.dao.RecommendDao;
import com.zt.pojo.goods;
import com.zt.service.RecommendService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private RecommendDao recommendDao;

    @Override
    // 执行推荐业务
    public String recommendService() {
        String json = "";
        try{
            // todo 清空推荐表 recommend
            recommendDao.clearRecommend();
            // todo 从商品表（goods）中取出所有商品
            List<goods> list = goodsDao.selectGoodsAll();
            // 对查询的商品进行排序
            Collections.sort(list, new Comparator<goods>() {
                public int compare(goods o1, goods o2) {
                    if(o1.getWeight()<o2.getWeight()) return 1;
                    if(o1.getWeight()>o2.getWeight()) return -1;
                    return 0;
                }
            });

            List<goods> newlist = new LinkedList<goods>();
            for(int i=0;i<4;i++){
                newlist.add(list.get(i));
            }
            // 把查询到的商品添加到推荐表 recommend 中
            // todo 断点打印查询到的商品表
            for (goods goods : newlist) {
                System.out.print(goods + ":::\t");
            }
            recommendDao.insertRecommend(newlist);
            // 将从推荐表 recommend 中查询到的数据以 json 字符串的格式返回
            json = JSONArray.fromObject(newlist).toString();
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }finally {}
        return json;
    }
}
