package vip.tao.cache.myBatisUtiles;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class mybatisUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        /**通过反射获取地址mybatis-config.xml配置文件*/
        InputStream inputStream = mybatisUtils.class.getResourceAsStream("/mybatis-config.xml");
        /**创建会话工厂生成器(创建后就不再使用)*/
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        /**获取数据库会话工厂读取配置文件 (和数据库链接池一样 一直存在  使用单例模式)*/
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);


    }

    /**
     * 获取执行SQL的对象
     */
    public static SqlSession getSqlSession() {
        /**执行SQL的对象(不是线程安全的) 用完就手动关闭归还给会话工厂**/
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


}
