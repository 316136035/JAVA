package vip.tao.Mapper.Mapper1;


import vip.tao.Oom.Oom1.Mybatis_User1;

import java.util.List;

public interface MyBatis_User_Mapper1 {
    /**
     * 多对一 子查询(执行两次sql语句)全部用户,以及对于的部门信息
     */
    public List<Mybatis_User1> getSonUserRole_List();

    /**多对一 通过链表查询查询用户和对应的部门*/

    public List<Mybatis_User1> getLinkedUserRole_List();

}
