package com.hzzl.demo.mymvc;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.8
 */
@MyController
@MyRequestMapping("/myMvc/")
public class MyMvcTest {

	@MyRequestMapping("hello")
	public String helloController(){
		System.out.println("方法进入controller");
		return "hello";
	}

}
