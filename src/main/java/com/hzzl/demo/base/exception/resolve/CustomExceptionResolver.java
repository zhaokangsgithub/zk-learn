package com.hzzl.demo.base.exception.resolve;

import com.hzzl.demo.base.exception.CommonException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class CustomExceptionResolver implements HandlerExceptionResolver
{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex)
    {
        ex.printStackTrace();
        CommonException commonException = null;
        if (ex instanceof CommonException)
        {
            commonException = (CommonException)ex;
        }
        else
        {
            //如果抛出的不是系统自定义异常则重新构造一个系统错误异常。
            commonException = new CommonException("系统错误，请与系统管理 员联系！");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", commonException.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
