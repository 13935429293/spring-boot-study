package org.ywb.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ywb.study.entity.Study;

@SpringBootApplication
@RestController
public class SpringBootActionCh6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActionCh6Application.class, args);
	}

	@Autowired
    private Study study;

	@RequestMapping("/index")
	public String index() {
	    return study.getName() + ", " + study.getAge() + ".";
    }
}
