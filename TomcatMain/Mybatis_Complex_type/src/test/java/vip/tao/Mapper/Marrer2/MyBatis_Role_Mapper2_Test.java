package vip.tao.Mapper.Marrer2;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import vip.tao.Utils.MybatisUtils_Complex_type;

public class MyBatis_Role_Mapper2_Test {

    @Test
    public void  getMybatis_Role2_List() {

        /**获取sql会话*/
        SqlSession sqlSession = MybatisUtils_Complex_type.getSqlSession();
        /**通过映射器获取对象*/
        MyBatis_Role_Mapper2 mapper = sqlSession.getMapper(MyBatis_Role_Mapper2.class);
        /**执行sql并返回*/
        System.out.println(mapper.getMybatis_Role2_List(1).toString());


    }

    @Test
    public void getMybatis_Linked_Role2_List() {

        /**获取sql会话*/
        SqlSession sqlSession = MybatisUtils_Complex_type.getSqlSession();
        /**通过映射器获取对象*/
        MyBatis_Role_Mapper2 mapper = sqlSession.getMapper(MyBatis_Role_Mapper2.class);
        /**执行sql并返回*/
        System.out.println(mapper.getMybatis_Linked_Role2_List(1).toString());


    }


}
