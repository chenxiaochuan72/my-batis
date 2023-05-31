package cn.bugstack.mybatis.test;

import cn.bugstack.mybatis.test.dao.IUserDao;
import com.it.xiaodongbei.binding.MapperRegistry;
import com.it.xiaodongbei.session.SqlSession;
import com.it.xiaodongbei.session.SqlSessionFactory;
import com.it.xiaodongbei.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

/**
 * @Author cxc
 * @Date 2023/5/31 12:43 AM
 * @Version 1.0
 * @Description:
 */

public class ApiTest {
    @Test
    public void test_MapperProxyFactory(){
        // 1. 注册 Mapper
        MapperRegistry registry=new MapperRegistry();
        registry.addMappers("cn.bugstack.mybatis.test.dao");
        SqlSessionFactory sqlSessionFactory=new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(userDao);
        String integer = userDao.queryUserName("10001");
        System.out.println(integer);

    }
}
