package cn.lxj.mybatis;

import java.io.InputStream;
import java.util.Properties;

/**
 * Test
 * description TODO
 * create by lxj 2018/4/25
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        getStreamByClass("mysql.properties");
        getStreamByClassLoader("mysql.properties");
        getStreamByClassLoader("cn.lxj.mybatis.mapper.UserMapper.xml");
    }
    public static void getStreamByClass(String filePath) throws Exception {
        //通过Class的getResourceAsStream()获取properties文件输入流
        InputStream in = Test.class.getResourceAsStream(filePath);
        //当然,也可以通过实例获取Class对象
        InputStream in1 = new Test().getClass().getResourceAsStream(filePath);
        printProperties(in);
        printProperties(in1);
    }
    public static void getStreamByClassLoader(String filePath) throws Exception {
        //通过ClassLoader的getResourceAsStream()获取输入流
        InputStream in = Test.class.getClassLoader().getResourceAsStream(filePath);
        //同样的,通过实例也可以获取ClassLoader对象
        InputStream in1 = new Test().getClass().getClassLoader().getResourceAsStream(filePath);
        printProperties(in);
        printProperties(in1);
    }
    public static void printProperties(InputStream in) throws Exception {
        Properties pro = new Properties();
        pro.load(in);
        System.out.println("url: " + pro.getProperty("url")
                + "user: " + pro.getProperty("user")
                + "password: " + pro.getProperty("password"));
    }
}
