package com.it.xiaodongbei.binding;

import com.it.xiaodongbei.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @Author cxc
 * @Date 2023/5/31 12:31 AM
 * @Version 1.0
 * @Description:
 */

public class MapperProxyFactory<T>{

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
