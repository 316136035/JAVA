package tao.shen.jia.Mapper数据库持久层;

import tao.shen.jia.Pojo.User;

import java.util.List;
import java.util.Map;

/**通过xml配置文件方式
 * 配置UserMapper.xml映射器要接口
 * xml核心配置要映射器绑定UserMapper.xml
 * */
public interface UserMapper {
    /**查询全部用户**/
    List<User> getUserList();
    /**通过结果集(当数据库字段和实体类字段不同的时候使用) 查询全部用户**/
    List<User> getUserList_resultMap();
    /**模糊+分页查询全部用户**/
    List<User> getUserList_like_limit(Map<String,Object> map);
    /**查询全部用户总数**/
    int getCount();
    /**通过id查询用户**/
    User getid_User(int userId);
    /**插入用户数据**/
    int  insert_User(User user);
    /**修改用户数据**/
    int  update_User(User user);
    /**删除用户数据**/
    int  delete_User(int  userid);




}
