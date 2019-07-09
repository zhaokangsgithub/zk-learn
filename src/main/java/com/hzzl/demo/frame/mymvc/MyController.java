package com.hzzl.demo.frame.mymvc;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {

	String value() default "";;
}
