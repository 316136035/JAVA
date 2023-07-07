package vip.tao.Spring_Mybatis_Affairs.mapper;

import vip.tao.Spring_Mybatis_Affairs.oom.User;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserMapperImpl implements UserMapper {

    /***SqlSessionTemplate会话模板是线程安全的*/
    private org.mybatis.spring.SqlSessionTemplate SqlSessionTemplate;

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
    public int InsretUser(User user) {

        UserMapper mapper = SqlSessionTemplate.getMapper(UserMapper.class);
        /**把一组业务当成一个业务来做;要么都成功，要么都失败!
         * 同时执行2个sql 一个出错就全回滚*/
        mapper.InsretUser(new User(1001, "周先生", "123", (int) (4.0 * Math.random()), new Date(System.currentTimeMillis()), null, null));
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mapper.DeleteUser(1001);
        return 0;
    }

    @Override
    public int DeleteUser(int id) {
        return SqlSessionTemplate.getMapper(UserMapper.class).DeleteUser(id);
    }

    @Override
    public int UpdateUser() {
        return 0;
    }
}
