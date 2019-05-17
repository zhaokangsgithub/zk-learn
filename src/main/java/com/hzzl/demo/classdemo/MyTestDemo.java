package com.hzzl.demo.classdemo;

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
public class MyTestDemo {


    public static void main(String[] args) {

        List<People> pLists = new ArrayList();

        for (int i = 0; i <=10000000 ; i++) {

            People p = new People();
            p.setcId(i);
            p.setcType("type"+i);
            pLists.add(p);
        }

        List<Student> sLists = new ArrayList();
        for (int i = 0; i <=1000 ; i++) {
            Student s = new Student();
            s.setcId(i);
            s.setcType("type"+i);
            sLists.add(s);
        }



        long start = System.currentTimeMillis();


        //方案1: 双重迭代循环
        /*for(Iterator<People> p = pLists.iterator(); p.hasNext();)
        {
            People people = p.next();
            String pId = people.getcId()+"";
            String pType = people.getcType();

            
            for(Iterator<Student> s = sLists.iterator(); s.hasNext();)
            {
                Student student=s.next();
                String sId = student.getcId()+"";
                String sType = student.getcType();
                if((sId+"-"+sType).equals((pId+"-"+pType))){
                    System.out.println(pId+"-"+pType);
                    p.remove();
                }
            }
        }*/

        //方案2:set+单循环
        Set set=new HashSet();
        for(Iterator<Student> s = sLists.iterator(); s.hasNext();)
        {
            Student student = s.next();
            String sId = student.getcId()+"";
            String sType = student.getcType();
            set.add(sId+"-"+sType);
        }
        for(Iterator<People> p = pLists.iterator(); p.hasNext();)
        {
            People people = p.next();
            String pId = people.getcId()+"";
            String pType = people.getcType();
            if(set.contains((pId+"-"+pType))){
                System.out.println(pId+"-"+pType);
                p.remove();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start));
    }
}


class People {

    private String name;

    private int cId;

    private String cType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", cId='" + cId + '\'' +
                ", cType='" + cType + '\'' +
                '}';
    }
}


class Student {

    private String name;

    private int cId;

    private String cType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cId='" + cId + '\'' +
                ", cType='" + cType + '\'' +
                '}';
    }
}