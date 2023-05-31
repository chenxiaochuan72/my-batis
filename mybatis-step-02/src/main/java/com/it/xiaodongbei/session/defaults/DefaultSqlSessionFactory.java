package com.it.xiaodongbei.session.defaults;

import com.it.xiaodongbei.binding.MapperRegistry;
import com.it.xiaodongbei.session.SqlSession;
import com.it.xiaodongbei.session.SqlSessionFactory;

/**
 * @Author cxc
 * @Date 2023/5/31 12:41 AM
 * @Version 1.0
 * @Description:
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
