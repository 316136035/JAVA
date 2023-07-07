package vip.tao.cache.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import vip.tao.cache.myBatisUtiles.mybatisUtils;
import vip.tao.cache.oom.User_Cache;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class User_Cache_mapper_Test {
/**这个方法测试mybatis一级缓存
 * 一级缓存作用域是sqlsession级别的，同一个sqlsession中执行相同的sql查询（相同的sql和参数），第一次会去查询数据库并写到缓存中，第二次从一级缓存中取。
 * 如果中间sqlSession去执行commit操作（执行插入、更新、删除），则会清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
 * MyBatis在开启一个数据库会话时，会创建一个新的SqlSession对象，SqlSession对象中会有一个Executor对象，Executor对象中持有一个PerpetualCache对象，
 * 见下面代码。当会话结束时，SqlSession对象及其内部的Executor对象还有PerpetualCache对象也一并释放掉。
 */
    @Test
    public void selectUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();  /**获取sql会话*/
        User_Cache_mapper mapper = sqlSession.getMapper(User_Cache_mapper.class); /**通过映射器获取对象*/
        System.out.println(mapper.selectUser(1).toString()); /**第一次执行sql（默认是开启的）*/
       // sqlSession.clearCache();/**手动清理缓存就会发生执行两次sql*/
        User_Cache_mapper mapper1 = sqlSession.getMapper(User_Cache_mapper.class); /**通过映射器获取对象*/
        System.out.println(mapper1.selectUser(1).toString());/**第二次执行sql并不会在执行sql 是在mybatis一级缓存获取数据*/
        sqlSession.close();/**当关闭链接就会释放一级缓存*/

    }

 /**开启mybatis二级缓存
  * 通过MyBatis配置文件开启二级缓存【在MyBatis-config.xml 文件中添加如下代码】
  *映射语句文件中的所有 select 语句的结果将会被缓存。
  * 映射语句文件中的所有 insert、update 和 delete 语句会刷新缓存。
  * 缓存会使用最近最少使用算法（LRU, Least Recently Used）算法来清除不需要的缓存。
  * 缓存不会定时进行刷新（也就是说，没有刷新间隔）。
  * 缓存会保存列表或对象（无论查询方法返回哪种）的 1024 个引用。
  * */
 @Test
    public void  selectUser_Cache() throws InterruptedException {
        SqlSession sqlSession = mybatisUtils.getSqlSession();  /**获取sql会话*/
        User_Cache_mapper mapper = sqlSession.getMapper(User_Cache_mapper.class); /**通过映射器获取对象*/
        System.out.println(mapper.selectUser(1).toString()); /**第一次执行sql（二级缓存是开启的）*/
        sqlSession.close();/**当关闭链接就会存放在二级缓存*/
        TimeUnit.SECONDS.sleep(1);
        selectUser_Cache();/**再次调用的时候会在二级缓存中获取*/

    }

/**自定义缓存《请在User_Cache_mapper.xml启用,在ehcache.xml中配置》**/
    @Test
    public void  customsSelectUserList_CustomCache() throws InterruptedException {
        SqlSession sqlSession = mybatisUtils.getSqlSession();  /**获取sql会话*/
        User_Cache_mapper mapper = sqlSession.getMapper(User_Cache_mapper.class); /**通过映射器获取对象*/
        forEach(mapper.customsSelectUserList_CustomCache());//执行第1次会在数据库中找查找
        forEach(mapper.customsSelectUserList_CustomCache());//执行第2次会在缓存中找查找
        sqlSession.close();
        SqlSession sqlSession1= mybatisUtils.getSqlSession();  /**获取sql会话*/
        User_Cache_mapper mapper1 = sqlSession1.getMapper(User_Cache_mapper.class); /**通过映射器获取对象*/
        forEach(mapper1.customsSelectUserList_CustomCache());//执行第3次会在缓存中找查找

    }

    public  void forEach( List<User_Cache> list) {
     list.forEach(new Consumer<User_Cache>() {
         @Override
         public void accept(User_Cache user_cache) {
             System.out.print(user_cache);
         }

     });
        System.out.println();

    }

}
