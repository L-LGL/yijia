package com.zt.service;

import com.zt.pojo.goods;

import java.util.List;

public interface SortService {
    // 执行商品分类业务
    public boolean sortService(String type);

    // 将查询到的商品插入到sort表
    public boolean insertService(List<goods> goodsList);
}
