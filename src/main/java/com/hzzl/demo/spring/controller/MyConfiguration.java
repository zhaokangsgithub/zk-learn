package com.hzzl.demo.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */

@PropertySource("classpath:jdbc.properties")
public class MyConfiguration
{

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;


    @Bean(name="DataSource")
    public DataSource getDatasource(){
        System.out.println(driver);
        return null;
    }

    public static void main(String[] args)
    {
        ApplicationContext ac =
            new AnnotationConfigApplicationContext(MyConfiguration.class);
    }

}
