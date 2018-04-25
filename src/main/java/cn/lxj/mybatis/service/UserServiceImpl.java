package cn.lxj.mybatis.service;

import cn.lxj.mybatis.bean.UserBean;
import cn.lxj.mybatis.mapper.UserMapper;
import cn.lxj.mybatis.tools.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * UserServiceImpl
 * description 测试curd
 * create by lxj 2018/4/25
 **/
public class UserServiceImpl {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            insertUser();
        }
    }
    /**
     * 新增用户
     */
    public static void insertUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean user = new UserBean("懿", "123456", 7000.0);
        try {
            mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 删除用户
     */
    public static void deleteUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 根据用户id查找用户
     */
    public static void selectUserById() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.selectUserById(1);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    /**
     * 修改用户
     */
    public static void updateUser() {
        SqlSession session = DBTools.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<UserBean> user = mapper.selectAllUser();
            System.out.println(user.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
