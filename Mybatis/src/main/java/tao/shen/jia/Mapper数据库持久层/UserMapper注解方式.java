package tao.shen.jia.Mapper数据库持久层;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tao.shen.jia.Pojo.User;

/**通过注解方式
 *xml核心配置要映射器绑定UserMapper类
 * */
public interface UserMapper注解方式 {

    /**通过注解方式 id查询用户
     * 方法存在多个参数，有的参数前而必须加 l: @Param("id”)注解**/
    @Select(" select * from MyBatis.user where User_id = #{userId}")
    User getid_User注解方式(@Param("userId") int userId);

    /**插入用户数据**/
    @Insert(" insert into MyBatis.user(user_id, user_name, user_password, dep_id, creation_time, updated_by, update_time) values (#{userId}, #{userName}, #{userPassword}, #{depId}, #{creationTime}, #{updatedBy}, #{updateTime})")
    int  insert_User注解方式(User user);



}
