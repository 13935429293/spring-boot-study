package org.ywb.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@SpringBootApplication
@Controller
public class SpringmvcThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcThymeleafApplication.class, args);
	}

	@RequestMapping("/index")
	public String index(Model model) {

	    return "index";
    }
}
