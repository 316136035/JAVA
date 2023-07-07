package vip.tao.Mapper.Mapeer1;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import vip.tao.Mapper.Mapper1.MyBatis_User_Mapper1;
import vip.tao.Oom.Oom1.Mybatis_User1;
import vip.tao.Utils.MybatisUtils_Complex_type;

import java.util.List;
import java.util.function.Consumer;

public class MyBatis_User_Mapper1_Test {
    //     通过查询查询用户和对应的部门
    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils_Complex_type.getSqlSession();
        MyBatis_User_Mapper1 mapper = sqlSession.getMapper(MyBatis_User_Mapper1.class);
        List<Mybatis_User1> userList = mapper. getSonUserRole_List();
        userList.forEach(new Consumer<Mybatis_User1>() {
            @Override
            public void accept(Mybatis_User1 mybatis_user) {
                System.out.println(mybatis_user.toString());
            }
        });
    }


//     通过链表查询查询用户和对应的部门
    @Test
    public void getLinkedUserRole_List() {
        /**获取sql会话*/
        SqlSession sqlSession = MybatisUtils_Complex_type.getSqlSession();
        /**通过映射器获取对象*/
        MyBatis_User_Mapper1 mapper = sqlSession.getMapper(MyBatis_User_Mapper1.class);
        /**执行sql并返回*/
        List<Mybatis_User1> userList = mapper. getSonUserRole_List();
        userList.forEach(new Consumer<Mybatis_User1>() {
            @Override
            public void accept(Mybatis_User1 mybatis_user) {
                System.out.println(mybatis_user.toString());
            }
        });
    }
}
