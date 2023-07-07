package vip.tao.A07_Spring_MyBatis_MVC_Mapper;

import org.mybatis.spring.SqlSessionTemplate;
import vip.tao.Spring_MyBatis_MVC_Oom.User;

import java.util.List;

public class UserMapperImpl_1 implements UserMapper {

    /***SqlSessionTemplate会话模板是线程安全的*/
    private SqlSessionTemplate SqlSessionTemplate;

    /**
     * xml文件注入SQL会话模板
     **/
    public void setSqlSessionTemplate(org.mybatis.spring.SqlSessionTemplate sqlSessionTemplate) {
        SqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<User> SelectUser() {
        UserMapper mapper = SqlSessionTemplate.getMapper(UserMapper.class);
        List<User> users = mapper.SelectUser();
        return users;
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
