package com.hzzl.demo.imybatis;

/**
 *  mybatis 逻辑梳理
 *
 * @author
 * @since JDK 1.8
 */
public class Readme
{

    /**
     *
     * 1.读取配置文件  sqlMapperConfig.xml  拿到inputStream
     *
     *   创建configuration对象封装driver  username  password等jdbc连接信息
     *
     * 2.SqlSessionFactoryBuilder build(inputStream)
     *
     *
     * 2.自定义sqlsessionFactory  工厂模式
     *
          public DefaultSqlSessionFactory(Configuration configuration) {
     *         this.configuration = configuration;
     *     }
     *
     *     oppensession()  拿到session对象
     *
     *     session对象里面存放具体的conn连接,getMapper(动态代理拿到代理类对象)
     *
     *
     *     Executor  用来执行sql
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args)
    {

       final  int a = 10;
       final int b =20;
       final int c =20;
       final int d =50;
       Object str= a|b|c|d;
        /**
         *  10  20                  30
         *  10  20  20              30
         *  10  20  20  50          62
         *
         *
         */



       System.out.println(str);

    }

}