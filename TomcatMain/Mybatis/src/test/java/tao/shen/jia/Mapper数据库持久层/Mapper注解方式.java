package tao.shen.jia.Mapper数据库持久层;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tao.shen.jia.Pojo.User;
import tao.shen.jia.Utils.Log4jMybatisUtils;

import java.sql.Date;

public class Mapper注解方式 {

    @Test
    public void   UserMapper注解方式() {

        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = Log4jMybatisUtils.getSqlSession();
            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper注解方式 mapper = sqlSession.getMapper(UserMapper注解方式.class);

            /**执行sql并返回 */
            User user = mapper.getid_User注解方式(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            /**上面代码异常就回滚*/
            sqlSession.rollback();

        } finally {
            if (sqlSession != null) {
                /**关闭sql会话*/
                sqlSession.close();
            }
        }


    }
    @Test
    public void insert_User注解方式() {
        for (int i = 1; i <= 1; i++) {
            SqlSession sqlSession = null;
            try {
                /**获取sql会话*/
                sqlSession = Log4jMybatisUtils.getSqlSession();
                /**方式一**/
                /**通过映射器获取对象*/
                UserMapper注解方式 mapper = sqlSession.getMapper(UserMapper注解方式.class);

                /**执行sql并返回 */
                int number = mapper.insert_User注解方式(new User(i, "周先生", "12456", 6, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
                System.out.println(number);
                if (number > 0) {
                    /**上面代码正常运行就提交*/
                    System.out.println("插入成功");
                    sqlSession.commit();
                    sqlSession.close();
                }
            } catch (Exception e) {
                System.out.println("代码异常:" + i);
                e.printStackTrace();
                /**上面代码异常就回滚*/
                sqlSession.rollback();

            } finally {
                if (sqlSession != null) {
                    /**关闭sql会话*/
                    sqlSession.close();
                }
            }


        }

    }

}
