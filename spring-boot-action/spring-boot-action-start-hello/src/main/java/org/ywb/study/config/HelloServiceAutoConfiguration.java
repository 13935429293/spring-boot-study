package org.ywb.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ywb.study.properties.HelloServiceProperties;
import org.ywb.study.service.HelloService;

/**
 * date: 2017/5/17 18:56
 * description:
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)// 开启属性注入
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello", value = "enable", matchIfMissing = true)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService(){
        HelloService service = new HelloService();
        service.setMsg(properties.getMsg());
        return service;
    }

}
