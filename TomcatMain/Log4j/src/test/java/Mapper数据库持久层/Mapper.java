package Mapper数据库持久层;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;
import tao.shen.jia.Mapper数据库持久层.Log4jUserMapper;
import tao.shen.jia.Pojo.Log4jUser;
import tao.shen.jia.Utils.Log4jMybatisUtils;

import java.util.List;
import java.util.function.Consumer;

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
        /**开启log4j日志信息*/
        LogLog.setInternalDebugging(true);

        Logger logger = Logger.getLogger(this.getClass());
        logger.info("日志信息:进入getUserList()方法" );
        logger.error("错误信息");



        SqlSession sqlSession = null;
        try {
            /**获取sql会话*/
            sqlSession = Log4jMybatisUtils.getSqlSession();

            /**方式一**/
            /**通过映射器获取对象*/
            Log4jUserMapper mapper = sqlSession.getMapper(Log4jUserMapper.class);
            /**执行sql并返回 */
            List<Log4jUser> userList = mapper.getUserList();

            userList.forEach(new Consumer<Log4jUser>() {
                @Override
                public void accept(Log4jUser user) {
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

}