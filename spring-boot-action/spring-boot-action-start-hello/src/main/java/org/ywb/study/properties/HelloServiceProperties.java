package org.ywb.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * date: 2017/5/17 18:53
 * description:
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
