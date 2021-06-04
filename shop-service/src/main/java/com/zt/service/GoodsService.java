package com.zt.service;

import com.zt.pojo.goods;

import java.util.List;

public interface GoodsService {
    // 商品信息查询业务
    public goods selectService(String id);
    // 添加商品信息业务
    public boolean addGoodsService(goods goods);
    // 删除商品信息业务
    public boolean deleteGoodsService(String id);
    // 更新商品信息业务
    public boolean updateGoodsService(goods goods);
    // 根据商品类型查询商品
    public List<goods> selectByTitle(String type);
    public List<goods> lookGoodo(String name);
    public List<goods> look();
    public void updateGoods(goods goods);
}
