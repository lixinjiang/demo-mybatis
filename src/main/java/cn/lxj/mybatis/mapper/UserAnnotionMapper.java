package cn.lxj.mybatis.mapper;

import cn.lxj.mybatis.bean.UserBean;
import org.apache.ibatis.annotations.Select;

/**
 * 使用注解来解放xml配置
 */
public interface UserAnnotionMapper {
    @Select("select * from t_user where id = #{id}")
    public UserBean selectById(int id);
}
