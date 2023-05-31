package com.it.xiaodongbei.binding;

import com.it.xiaodongbei.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author cxc
 * @Date 2023/5/31 12:25 AM
 * @Version 1.0
 * @Description:映射器代理类
 */

public class MapperProxy<T> implements InvocationHandler, Serializable {


    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else {
            return sqlSession.selectOne(method.getName(),args);
        }
    }
}
