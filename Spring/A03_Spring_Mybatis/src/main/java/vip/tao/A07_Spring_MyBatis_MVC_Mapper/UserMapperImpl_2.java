package vip.tao.A07_Spring_MyBatis_MVC_Mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import vip.tao.Spring_MyBatis_MVC_Oom.User;

import java.util.List;

/**
 * 实现方法2 不建议使用
 */
public class UserMapperImpl_2 extends SqlSessionDaoSupport implements UserMapper {


    @Override
    public List<User> SelectUser() {
        return getSqlSession().getMapper(UserMapper.class).SelectUser();
    }

    @Override
    public void InsretUser() {

    }

    @Override
    public void DeleteUser() {

    }

    @Override
    public void UpdateUser() {

    }
}
