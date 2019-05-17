package com.hzzl.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/paramTest/")
@Controller
public class TestController {

    @RequestMapping(value = "param/{id}/{name")
    @ResponseBody
    public String getParam(@PathVariable("id") String id, @PathVariable("name")String name) {
        StringBuffer append = new StringBuffer().append(id).append(name);
        System.out.println(append.toString());
        return "111";
    }


    public static void main(String[] args) {
        System.out.println("test");
    }

}
