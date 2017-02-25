package org.ywb.study.dao;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/24
 * Time: 14:29
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static String getContext() {
        return contextHolder.get();
    }

    public static void setContext(String dataSource) {
        contextHolder.set(dataSource);
    }

}
