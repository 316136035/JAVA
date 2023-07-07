package tao.shen.jia.Mapper数据库持久层;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tao.shen.jia.Mapper数据库持久层.UserMapper;
import tao.shen.jia.Pojo.User;
import tao.shen.jia.Utils.MybatisUtils;
import tao.shen.jia.Utils.MybatisUtils1;

import java.util.HashMap;
import java.util.List;

public class Mapper {

    /**
     * 可能出现的问题
     * 1.配置文件没有注册
     * 2.绑定接口错误。
     * 3.方法名不对
     * 4.返回类型不对
     * 5.Maven导出资源问题*
     */
    @Test
    public void getUserList() {
        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils.getSqlSession();

            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            /**执行sql并返回 */
            List<User> userList = mapper.getUserList();

            userList.forEach(new Consumer<User>() {
                @Override
                public void accept(User user) {
                    System.out.println(user.toString());
                }
            });
            /**方式二**/
//        List<User> list = sqlSession.selectList("tao.shen.jia.Mapper.UserMapper.getUserList");
//        list.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                System.out.println(user.toString());
//            }
//        });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                /**关闭sql会话*/
                sqlSession.close();
            }
        }


    }

   /*** 通过结果集(当数据库字段和实体类字段不同的时候使用) 查询全部用户**/
    @Test
    public void getUserList_resultMap() {
        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils.getSqlSession();

            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            /**执行sql并返回 */
            List<User> userList = mapper.getUserList_resultMap();

            userList.forEach(new Consumer<User>() {
                @Override
                public void accept(User user) {
                    System.out.println(user.toString());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                /**关闭sql会话*/
                sqlSession.close();
            }
        }


    }

    @Test
    public void getUserList_like() {
        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils1.getSqlSession();

            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper =  sqlSession.getMapper(UserMapper1.class);
            HashMap<String, Object> HashMap = new HashMap<>();
            HashMap.put("like", "周");
            HashMap.put("begin", 0);
            HashMap.put("end",5);

            /**执行sql并返回 */
            List<User> userList = mapper.getUserList_like_limit(HashMap);

            userList.forEach(new Consumer<User>() {
                @Override
                public void accept(User user) {
                    System.out.println(user.toString());
                }
            });
            /**方式二**/
//        List<User> list = sqlSession.selectList("tao.shen.jia.Mapper.UserMapper.getUserList");
//        list.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User user) {
//                System.out.println(user.toString());
//            }
//        });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                /**关闭sql会话*/
                sqlSession.close();
            }
        }


    }

    @Test
    public void getid_User() {
        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils.getSqlSession();

            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            /**执行sql并返回 */
            User user = mapper.getid_User(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                /**关闭sql会话*/
                sqlSession.close();
            }
        }


    }

    @Test
    public void getCount() {
        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils.getSqlSession();
            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            /**执行sql并返回 */
            int count = mapper.getCount();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                /**关闭sql会话*/
                sqlSession.close();
            }
        }


    }

    /**
     * 增删改要提交事务
     **/
    @Test
    public void insert_User() {
        for (int i = 0; i < 1000; i++) {
            SqlSession sqlSession = null;
            try {
                /**获取sql会话*/
                sqlSession = MybatisUtils.getSqlSession();
                /**方式一**/
                /**通过映射器获取对象*/
                UserMapper mapper = sqlSession.getMapper(UserMapper.class);

                /**执行sql并返回 */
                int number = mapper.insert_User(new User(i, "周先生", "12456",  (int)(4.0*Math.random()) , null, null, null));
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

    /**
     * 增删改要提交事务
     **/
    @Test
    public void update_User() {

        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils.getSqlSession();
            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            /**执行sql并返回 */
            int number = mapper.update_User(new User(2, "名字", "88888", 6, null, null, null));
            System.out.println(number);
            if (number > 0) {
                /**上面代码正常运行就提交*/
                System.out.println("修改成功");
                sqlSession.commit();
                sqlSession.close();
            }
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

    /**
     * 增删改要提交事务
     **/
    @Test
    public void delete_User() {

        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = MybatisUtils.getSqlSession();
            /**方式一**/
            /**通过映射器获取对象*/
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            /**执行sql并返回 */
            int number = mapper.delete_User(1);
            System.out.println(number);
            if (number > 0) {
                System.out.println("删除成功");
                /**上面代码正常运行就提交*/
                sqlSession.commit();
                sqlSession.close();
            }
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


}
