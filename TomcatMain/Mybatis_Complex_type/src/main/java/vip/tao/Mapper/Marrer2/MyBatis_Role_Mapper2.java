package vip.tao.Mapper.Marrer2;

import vip.tao.Oom.Oom2.Mybatis_Role2;

public interface MyBatis_Role_Mapper2 {
    /**一对多 子查询(执行两次sql语句)全部用户,以及对于的部门信息*/
    Mybatis_Role2 getMybatis_Role2_List(int id);
    /**一对多 链表查询用户*/
 Mybatis_Role2  getMybatis_Linked_Role2_List(int id);

}
