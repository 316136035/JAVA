package vip.tao.Mapper.Mapeer1;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import vip.tao.Mapper.Mapper1.MyBatis_Role_Mapper1;
import vip.tao.Oom.Oom1.Mybatis_Role1;
import vip.tao.Utils.MybatisUtils_Complex_type;

public class MyBatis_Role_Mapper1_Test {
    @Test
    public void role() {

        /**获取sql会话*/
        SqlSession sqlSession = MybatisUtils_Complex_type.getSqlSession();
        /**通过映射器获取对象*/
        MyBatis_Role_Mapper1 mapper = sqlSession.getMapper(MyBatis_Role_Mapper1.class);
        /**执行sql并返回*/
        Mybatis_Role1 selectRole = mapper.getSelectRole(1);
        System.out.println(selectRole.toString());

    }
}
