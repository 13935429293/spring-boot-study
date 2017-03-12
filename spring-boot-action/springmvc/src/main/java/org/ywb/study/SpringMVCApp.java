package org.ywb.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ywb.study.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
@SpringBootApplication
@Controller
public class SpringMVCApp {

    @RequestMapping(value = "/")
    public String index(Model model){
        Person single = new Person("aa", 11);
        List<Person> person = new ArrayList<>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        person.add(p1);
        person.add(p2);
        person.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("person", person);

        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMVCApp.class, args);
    }
}
