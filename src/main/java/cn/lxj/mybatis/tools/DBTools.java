package cn.lxj.mybatis.tools;

import cn.lxj.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * DBTools
 * description sqlsession工具类
 * create by lxj 2018/4/25
 **/
public class DBTools {
    public static SqlSessionFactory sessionFactory;

    static {
        try {
            // 使用mybatis提供的Resource类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
            // 构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sessionFactory.getConfiguration().addMapper(UserMapper.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建能够提供执行映射文件中的sql的sqlsession
    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }
}