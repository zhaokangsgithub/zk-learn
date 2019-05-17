package com.hzzl.demo;

import com.hzzl.demo.mymvc.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: Application
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 20190404 10:13
 */
@SpringBootApplication
@ServletComponentScan
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(Application.class);
        /*app.setWebEnvironment(true);*/
       /* Set<Object> set = new HashSet<Object>();
        set.add("classpath:spring-application.xml");
        set.add("classpath:spring-mvc.xml");
        app.setSources(set);*/
//        app.run(args);
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    public ServletRegistrationBean MyServlet() {
        return new ServletRegistrationBean(new MyServlet(), "/*");
    }*/

}
