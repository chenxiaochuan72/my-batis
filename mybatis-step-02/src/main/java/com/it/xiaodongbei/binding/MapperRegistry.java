package com.it.xiaodongbei.binding;

import java.util.HashMap;
import java.util.Map;

public class MapperRegistry {
    /**
     * 将已添加的映射器代理加入到 HashMap
     */
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers=new HashMap<>();


}
