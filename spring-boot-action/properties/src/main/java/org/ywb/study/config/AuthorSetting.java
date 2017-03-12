package org.ywb.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/3/12.
 * 利用 ConfigurationProperties 注解， 1.5 + 版本移除了 locations 属性，需要在配置类中添加 PropertiesSources 注解
 * 指定配置文件的位置， 1.5- 版本中可以使用locations属性去指定配置文件的位置。
 *
 * 与 @Value 注解相比，可以将一个配置文件对应一个 POJO 类，但是不支持 SpringEl
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorSetting {
    private String name;
    private long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

}
