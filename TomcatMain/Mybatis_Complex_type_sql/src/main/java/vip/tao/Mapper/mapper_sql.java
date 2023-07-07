package vip.tao.Mapper;


import vip.tao.Oom.User_sql;

import java.util.List;
import java.util.Map;

public interface mapper_sql {
  /**插入用户*/
  int  insertUser(User_sql user_sql);
  /**使用if判断条件执行动态SQL查询用户（用于多个条件）*/
  List<User_sql> selectUser_If(Map map);
  /**使用choose_when_otherwise判断执行动态SQL查询用户（用于单个条件）*/
  List<User_sql> selectUser_choose_when_otherwise(Map map);
  /**使用update_set_where判断执行动态SQL修改用户（where放在最后）*/
  int updateUser_set_where(Map map);
  /**foreach使用场景是对集合进行遍历（尤其是在构建 IN 与and与 or条件语句的时候）。*/
  List<User_sql> selectUser_foreach(Map map);






}
