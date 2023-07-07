package tao.shen.jia.Mapper数据库持久层;

import tao.shen.jia.Pojo.Log4jUser;

import java.util.List;
import java.util.Map;

public interface Log4jUserMapper {
    /**查询全部用户**/
    List<Log4jUser> getUserList();
    /**通过结果集(当数据库字段和实体类字段不同的时候使用) 查询全部用户**/
    List<Log4jUser> getUserList_resultMap();
    /**模糊查询全部用户**/
    List<Log4jUser> getUserList_like(Map<String, Object> map);
    /**查询全部用户总数**/
    int getCount();
    /**通过id查询用户**/
    Log4jUser getid_User(int userId);
    /**插入用户数据**/
    int  insert_User(Log4jUser user);
    /**修改用户数据**/
    int  update_User(Log4jUser user);
    /**删除用户数据**/
    int  delete_User(int userid);



}
