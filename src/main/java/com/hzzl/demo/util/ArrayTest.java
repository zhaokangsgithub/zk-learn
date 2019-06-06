package com.hzzl.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

/**
 * ClassName:  <br/>
 * Function:  不适用for循环和if,来实现
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class ArrayTest
{
    static Integer arr[] = {1, 4, 2, 5};

    static Integer result = 0;

    static LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(arr));

    public static Integer addArr(LinkedList<Integer> linkedList)
    {
        try
        {
            Integer s = linkedList.removeFirst();
            result = result + s;
            addArr(linkedList);
        }
        catch (Exception e)
        {
            System.out.println("执行结束 : " + result);
        }
        return result;
    }


    public static boolean isBeforeInvalidTime(String invalidTime)
    {
        // 对失效时间进行日期转换
        Date invalidDate = formdate(invalidTime, "yyyyMMddHHmmss");

        // 当前时间是否小于失效时间
        if (null != invalidDate
            && System.currentTimeMillis() < invalidDate.getTime())
        {
            return true;
        }
        return false;
    }


    /**
     * 把字符串格式化日期
     */
    public static Date formdate(String dateStr, String formater)
    {
        formater = (null == formater) ? "yyyy-MM-dd HH:mm:ss" : formater;
        DateFormat formatter = new SimpleDateFormat(formater);
        Date date = null;
        try
        {
            date = formatter.parse(dateStr);
        }
        catch (ParseException e)
        {
            // e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args)
    {
        String invalidTime = "99991230125959";
        boolean beforeInvalidTime = isBeforeInvalidTime(invalidTime);
        System.out.println(beforeInvalidTime);

    }

}
