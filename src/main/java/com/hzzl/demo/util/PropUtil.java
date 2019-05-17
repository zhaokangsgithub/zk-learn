package com.hzzl.demo.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * ClassName:  <br/>
 * Function:  ADD FUNCTION. <br/>
 * Reason:  ADD REASON(可选). <br/>
 * date:   <br/>
 *
 * @author
 * @since JDK 1.6
 */
public class PropUtil {

    private static final String PROP_ROOT_PATH = "src/main/config/";

    public static String getProp(String keyName,String propName){

        Properties prop = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(PROP_ROOT_PATH+propName);
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String property = prop.getProperty(keyName);
        return property;
    }

    public static void main(String[] args) {
        String prop = getProp("discounts.calc.super-vip",PROP_ROOT_PATH+"application.properties");
        System.out.println(prop);
    }



}
