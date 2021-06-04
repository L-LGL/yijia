package com.zt.util;

import org.apache.commons.collections.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class TypeUtil {
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("clothe","服装");
        map.put("shiPin","饰品");
        map.put("food","食品");
        map.put("instrument","乐器");
        map.put("book","书籍");
    }

    public static String changeType(String type){
        return map.get(type);
    }
}
