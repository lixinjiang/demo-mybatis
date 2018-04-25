package cn.lxj.mybatis.mapper;

import cn.lxj.mybatis.bean.UserBean;

import java.util.List;

/**
 * UserMapper
 * description
 * create by lxj 2018/4/25
 **/
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(UserBean user) throws Exception;

    /**
     * 修改用户
     * @param user
     * @param id
     * @return
     * @throws Exception
     */
    public int updateUser(UserBean user,int id) throws Exception;

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(int id) throws Exception;

    /**
     * 查找用户
     * @param id
     * @return
     * @throws Exception
     */
    public UserBean selectUserById(int id) throws Exception;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    public List<UserBean> selectAllUser() throws Exception;
}
