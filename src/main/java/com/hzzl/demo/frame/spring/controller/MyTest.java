package com.hzzl.demo.frame.spring.controller;

import com.hzzl.demo.base.Annotation.CheckCach;
import com.hzzl.demo.frame.spring.service.AccountService;
import com.hzzl.demo.frame.spring.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
@Controller
public class MyTest
{
    public static void main(String[] args)
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

//        ApplicationContext context =  new AnnotationConfigApplicationContext("com.hzzl.demo.frame.spring");
        ApplicationContext context =  new AnnotationConfigApplicationContext(AccountServiceImpl.class);
        //new AnnotationConfigApplicationContext("AccountServiceImpl");

        AccountService service = (AccountService)context.getBean("accountService");
        service.saveAccount();
        System.out.println(service);
    }
}

@Controller
@RequestMapping("/test2019/")
class test2{

    @Autowired
    private  MyTest bean;

    @ResponseBody
    @RequestMapping("test")
    @CheckCach
    public  String test2()
    {
        AnnotationConfigApplicationContext anno =  new AnnotationConfigApplicationContext();
        System.out.println(bean);
        return  "test2...run...";
    }

}
