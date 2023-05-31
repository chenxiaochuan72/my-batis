package com.it.xiaodongbei.binding;

import cn.hutool.core.lang.ClassScanner;
import com.it.xiaodongbei.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author cxc
 * @Date 2023/5/31 12:33 AM
 * @Version 1.0
 * @Description:
 */

public class MapperRegistry {
    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers=new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory==null){
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }
    public <T> void addMapper(Class<T> type){
        /* Mapper 必须是接口才会注册 */
        if (type.isInterface()){
            if(hasMapper(type)){
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type,new MapperProxyFactory<>(type));
        }
    }
    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass:mapperSet){
            addMapper(mapperClass);
        }
    }
}
