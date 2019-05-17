package com.hzzl.demo.classdemo;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ObjectDemo {

	/**
	 * equals方法
	 */
	String name;
	int age;

	public ObjectDemo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {

		ObjectDemo o = null;
		if(obj instanceof ObjectDemo){
			o=(ObjectDemo)obj;
			return this.age==o.age;
		}

		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "student[name:"+this.name+",age:"+this.age+"]";
	}
}

class TestDemo {

	public static void main(String[] args) {
		ObjectDemo o1 = new ObjectDemo("zhangsan", 17);
		ObjectDemo o2 = new ObjectDemo("lisi", 18);
		/*System.out.println(o1.equals(o2));
		System.out.println(o1);
		System.out.println(o1.toString());*/

		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		ObjectDemo o3=o1;
		System.out.println(o3.hashCode());

		

	}

}
