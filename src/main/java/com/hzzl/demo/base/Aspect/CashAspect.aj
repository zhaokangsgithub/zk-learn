package com.hzzl.demo.base.Aspect;

import com.hzzl.demo.base.Annotation.CheckCach;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public aspect CashAspect {

    @Before("execution(* com.hzzl.demo.controller.TestControlelr2(..))")
//    @Before("controllerAspect()")
    public void getCash(JoinPoint joinPoint) {
        CheckCach annotation = joinPoint.getTarget().getClass().getAnnotation(CheckCach.class);
        String value = annotation.value();
        System.out.println("先查询了缓存");
    }


  /*  @Around("within(com.hzzl.demo.controller..*)")
    public Object getCash(ProceedingJoinPoint  joinPoint) throws Throwable {
        CheckCach annotation = joinPoint.getTarget().getClass().getAnnotation(CheckCach.class);
        String value = annotation.value();
        System.out.println("先查询了缓存"+value);
        Object proceed = joinPoint.proceed();
        System.out.println("方法执行完毕");
        return proceed;
    }*/

    /*@Pointcut("@annotation(CheckCach)")
    private void advice() {}*/

    //Controller层切点
   /* @Pointcut("@annotation(CheckCach)")
    public void controllerAspect() {
    }*/

    @Pointcut("execution(* com.hzzl.demo.controller.TestControlelr2(..))")
    public void controllerAspect() {
    }

    public static void main(String[] args)
    {
        System.out.println("-------");
    }

}
