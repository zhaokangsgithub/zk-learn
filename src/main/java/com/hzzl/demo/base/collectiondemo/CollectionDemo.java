package com.hzzl.demo.base.collectiondemo;

import java.util.*;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class CollectionDemo {


	public static void main(String[] args) {

//		clooectionTest();

//		genericDemo();

//		linkedHashSetDemo();

		hashMapDemo();

//		CollectionsDemo();
	}

	private static void genericDemo() {
		EDemo<String> eDemo = new EDemo<String>();
//		eDemo.showName(111);
		/*eDemo.show("zhangsan");
		eDemo.show(111);*/

		/*String[] arr={"a","2","3"};
		eDemo.showArr(arr);*/

		eDemo.show2(eDemo);

		List list = new LinkedList<String>();
		((LinkedList) list).addFirst("");
	}

	private static void clooectionTest() {

		Collection col = new ArrayList<Object>();
		col.add(1);
		col.add("aa");
		col.add("bb");


		/*while (iterator.hasNext()){

			Object next = iterator.next();
			iterator.remove();
			System.out.println(next);
		}
		iterator=null;*/
		/*for (Iterator iterator = col.iterator();iterator.hasNext();){
			Object next = iterator.next();
			System.out.println(next);
		}*/
		Iterator iterator = col.iterator();
		for (Object o : col) {
			try {
				col.remove(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(o);
		}


	}

	public static void linkedHashSetDemo() {

		Set set = new LinkedHashSet();
		set.add("1");
		set.add("2");
		set.add("3");
/*

		for (Object o : set) {
			System.out.println(o);
		}
*/


		for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
			System.out.println(iterator.next());
		}

	}

	public static void hashMapDemo() {
		Map<String,String> map = new HashMap(8);

		map.put("1k","1v");
		map.put("2k","2v");
		map.put("3k","3v");
		map.put(null,"null2");
		Map<String,String> m =new HashMap(16);
		m.put("4K","4V");
		m.putAll(map);
		System.out.println(m.get(null));


	/*	map.put("1k","1v");
		map.put("2k","2v");
		map.put("3k","3v");
		Set<Map.Entry<String, String>>set = map.entrySet();

		for (Map.Entry<String, String> entry : set) {
			entry.getKey();
		}*/
	}

	public static void CollectionsDemo(){
		long begin = System.currentTimeMillis();
		List list=new ArrayList();
		for (int i = 0; i <100000 ; i++) {
			list.add(i);
		}

//		Collections.shuffle(list);

//		int i = Collections.binarySearch(list, 111);
		for (Object o : list) {
			if(o.equals(111)){
				System.out.println(o);
			}
		}
//		Object o = list.get(111);
//		Object o = list.get(i);
//		System.out.println("o:"+o);
		long end = System.currentTimeMillis();
		System.out.println("end:"+(begin-end));
	}
}

/**
 * 泛型的使用
 *
 * @param <E>
 */
class EDemo<E> {

	E name;

	public void showName(E name) {
		System.out.println(name);
	}

	public <Q> void show(Q name) {
		System.out.println(name);
	}

	public <T> void showArr(T[] arr) {
		for (T t : arr) {
			System.out.println(t);
		}
	}

	public void show2(EDemo<? super String> name) {
		System.out.println(name);
	}

}

class MyMap<T> extends HashMap{

}

class ProcessDemo<T> {

	/**
	 * 列出所有的进程信息
	 */
	public static void main(String[] args) {
		/*BufferedReader br = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("tasklist");
			br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
			String line = null;
			System.out.println("列出所有正在运行的进程信息：");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (process != null) {
				process.destroy();
			}
		}*/
        try
        {
            HashMap hashMap = new HashMap();
            hashMap.put("name","zhansgan");
            Map m = (HashMap)selectOne(hashMap);
            System.out.println(m.get("name"));
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }

    }


	public static <T> T selectOne(T name)
        throws IllegalAccessException, InstantiationException
    {
        Class<?> aClass = name.getClass();
        Object o = aClass.newInstance();


        return name;
	}
}

class Person{

	String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "person: name:"+name;
	}
}