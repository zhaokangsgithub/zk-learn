package com.hzzl.demo.base.classdemo;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person {

    static {
        System.out.println("我是static代码块");
    }

    Person() {
        System.out.println("Person..构造函数");
    }

    Person(String name,String age) {
        this.name=name;

        System.out.println("Person..构造函数");
    }

    {
        System.out.println("构造代码块");
    }

    private static String say(String param){
        System.out.println("say方法调用..."+param);
        return param;
    }

    public String getName() {
        System.out.println("getName");
        return "22";
    }

    private void setName(String name) {
        this.name = name;
        System.out.println("setName : " + name);
    }

    public void getAge() {
        System.out.println("getAge");
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String name;
    public String age;
}

/**
 * @ClassName: ClassDemo1
 * @Description: TODO
 * @Auther: Administrator
 * @Date: 2019/4/10 18:55
 */
public class ClassDemo1 {

    static Class clazz;

    static{
        try {
            clazz = Class.forName("com.hzzl.demo.base.classdemo.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取class对象的三种方式
     */
    public static void main(String[] args) throws Exception {
//      getClass(args);

//      getLink();

//      getInfo();

        getMethod();
    }

    private static void getMethod() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        Object o = clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //成员方法
       /* Method method = clazz.getDeclaredMethod("setName",String.class);
        method.setAccessible(true);
        Object zhansgan = method.invoke(o,"zhangsan" );
        System.out.println(zhansgan);*/

        //静态 私有 ,无参数  无返回值
        Method say = clazz.getDeclaredMethod("say",String.class);
        say.setAccessible(true);
        //静态方法是类调用,不需要对象
        Object invoke = say.invoke(null,"hello java");
        System.out.println("return   "+invoke);


    }

    private static void getClass(String[] args) throws ClassNotFoundException {
        //object类的一个成员变量
        Class<String> stringClass = String.class;

        //object的一个方法,获取
        Class<? extends String> aClass1 = "zhangsan".getClass();

        //Class类的方法,参数是所需class类的全路径
        Class<?> aClass = Class.forName("java.lang.String");
    }

    public static void getLink() throws ClassNotFoundException {

        //Person.class;
       /* Class clazz1 = Person.class;
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getSimpleName());*/

        //方式2:Class. forName("全路径")
        /*Class clazz3 = Class.forName("com.hzzl.demo.base.classdemo.Person");
        System.out.println(clazz3.getName());
        System.out.println(clazz3.getSimpleName());*/

        //方式3: 创建对象
        Class clazz2 = new Person().getClass();
        System.out.println(clazz2.getName());
        System.out.println(clazz2.getSimpleName());

    }

    public static void getInfo() throws ClassNotFoundException {


        //获取对象
       /* try {
            Person person = (Person) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

        //获取构造方法
        //Constructor[] cons = clazz.getConstructors();
        //Constructor[] decCons = clazz.getDeclaredConstructors();
        try {
            Constructor con = clazz.getDeclaredConstructor(String.class, String.class);
            Person p = (Person)con.newInstance("zhangsan","18");
            System.out.println();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}