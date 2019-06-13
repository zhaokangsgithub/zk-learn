package com.hzzl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName:  <br/>
    springmvc  册数
 *
 * @author
 * @since JDK 1.6
 */
@Controller
@RequestMapping("/TestController3/")
public class TestController3
{

    @RequestMapping("getTestCon3")
    @ResponseBody
    public String getTestCon3(String accountId){

        System.out.println(accountId);
        return "success";
    }




}
