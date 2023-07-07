package vip.tao.Mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import vip.tao.MyBatisUtils.MybatisUtils_sql;
import vip.tao.Oom.User_sql;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;


public class mapper_sql_Test {
    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils_sql.getSqlSession();
        mapper_sql mapper = sqlSession.getMapper(mapper_sql.class);
        for (int i = 1; i <= 100; i++) {
            if (i%2!=0) {
                mapper.insertUser(   new User_sql(i, "周先生", "123", (int) (4.0 * Math.random()), new Date(System.currentTimeMillis()), null, null));
                sqlSession.commit();
            }
            if (i%2==0) {
                mapper.insertUser(   new User_sql(i, "黄先生", "123", (int) (4.0 * Math.random()), new Date(System.currentTimeMillis()), null, null));
                sqlSession.commit();
            }

        }
    }



    @Test
    public void selectUser_Iftest(){
        SqlSession sqlSession = MybatisUtils_sql.getSqlSession();
        mapper_sql mapper = sqlSession.getMapper(vip.tao.Mapper.mapper_sql.class );
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("depId",1);
        hashMap.put("userName","黄先生");
        List<User_sql> user_sqls = mapper.selectUser_If(hashMap);
        user_sqls.forEach(new Consumer<User_sql>() {
            @Override
            public void accept(User_sql user_sql) {
                System.out.println(user_sql.toString());
            }
        });


    }


    @Test
    public void  selectUser_choose_when_otherwise(){
        SqlSession sqlSession = MybatisUtils_sql.getSqlSession();
        mapper_sql mapper = sqlSession.getMapper(mapper_sql.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("depId",1);
        hashMap.put("userName","黄先生");

        List<User_sql> user_sqls = mapper.selectUser_choose_when_otherwise(hashMap);
        user_sqls.forEach(new Consumer<User_sql>() {
            @Override
            public void accept(User_sql user_sql) {
                System.out.println(user_sql.toString());
            }
        });


    }


    @Test
    public void   updateUser_set_where(){
        SqlSession sqlSession = MybatisUtils_sql.getSqlSession();
        mapper_sql mapper = sqlSession.getMapper(mapper_sql.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId",1);
        hashMap.put("userName","和风雨");
        hashMap.put("userPassword","8888");
        int i = mapper.updateUser_set_where(hashMap);
        System.out.println(i);
        sqlSession.commit();


    }
    @Test
    public void    selectUser_foreach(){
        SqlSession sqlSession = MybatisUtils_sql.getSqlSession();
        mapper_sql mapper = sqlSession.getMapper(mapper_sql.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userName","周先生");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        hashMap.put("lists",list );
        List<User_sql> user_sqls = mapper.selectUser_foreach(hashMap);
        user_sqls.forEach(new Consumer<User_sql>() {
            @Override
            public void accept(User_sql user_sql) {
                System.out.println(user_sql);
            }
        });


    }






}
