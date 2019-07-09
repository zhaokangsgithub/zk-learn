package com.hzzl.demo.frame.mymvc;

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
		try
		{
			System.out.println("方法进入controller");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "upload";
	}

}
