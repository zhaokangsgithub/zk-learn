package com.hzzl.demo.common;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginInterceptor
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 2019/4/4 16:03
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println("进入preHandle"+session.getId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入 postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入 afterCompletion");
    }

    public static void main(String[] args)
    {
        String a = "123";String b = "123";
        int i = System.identityHashCode("123");
        System.out.println(i);
        int i2 = System.identityHashCode(a);
        System.out.println(i2);
        int i3 = System.identityHashCode(b);
        try
        {
            System.out.println(i3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
