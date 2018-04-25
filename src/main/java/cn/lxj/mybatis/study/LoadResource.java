package cn.lxj.mybatis.study;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * LoadResource
 * description TODO
 * create by lxj 2018/4/25
 **/
public class LoadResource {
    public static void main(String[] args) {
        // 从xml中构建sqlsessionfactory
        String resource = "org/mybatis/example/mybatis-config.xml";
        try {
            SqlSessionFactory sqlSessionFactory;
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
