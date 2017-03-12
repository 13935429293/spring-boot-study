package org.ywb.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ywb.study.config.AuthorSetting;

/**
 * Created by Administrator on 2017/3/12.
 */
@SpringBootApplication
@RestController
@PropertySource({"author.properties"})
public class PropertiesApp {

    @Autowired
    private AuthorSetting authorSetting;

    @RequestMapping(value = "/")
    public String index(){
        return "author name is " + authorSetting.getName() + " and age is " + authorSetting.getAge();
    }


    public static void main(String[] args) {
        SpringApplication.run(PropertiesApp.class, args);
    }

}
