package com.zt.service;

import com.zt.pojo.goods;
import com.zt.pojo.goodsindex;

import java.util.List;

public interface GoodsIndexService {
    // 处理分类索引业务
    public List<goodsindex> goodsindexService(String type);

    // 处理导航栏的索引业务
    public List<goods> goodsindexServiceType(String type);
}
