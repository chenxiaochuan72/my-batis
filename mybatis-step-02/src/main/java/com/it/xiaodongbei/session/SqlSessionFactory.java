package com.it.xiaodongbei.session;

/**
 * @Author cxc
 * @Date 2023/5/31 12:30 AM
 * @Version 1.0
 * @Description:
 */

public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
