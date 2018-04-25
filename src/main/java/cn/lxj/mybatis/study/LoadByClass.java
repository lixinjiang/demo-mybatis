package cn.lxj.mybatis.study;

import cn.lxj.mybatis.bean.UserBean;
import cn.lxj.mybatis.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * LoadByClass
 * description TODO
 * create by lxj 2018/4/25
 **/
public class LoadByClass {
    public static void main(String[] args) {
        // BlogDataSourcesFactory未找到，使用下面
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/migo2?characterEncoding=utf-8");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development",transactionFactory,dataSource);
        Configuration configuration = new Configuration();
        configuration.addMapper(UserMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 不够安全，有可能会发生类型转换异常
            UserBean user = (UserBean)session.selectOne("cn.lxj.mybatis.mapper.UserMapper.selectUser",101);
            // 这种方式好点
            UserMapper mapper = session.getMapper(UserMapper.class);
            UserBean userBean = mapper.selectUserById(2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
