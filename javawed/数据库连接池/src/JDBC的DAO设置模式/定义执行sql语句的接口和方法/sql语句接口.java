package JDBC的DAO设置模式.定义执行sql语句的接口和方法;

import JDBC的DAO设置模式.model对应数据库的实体类.JD;

import java.util.List;


public interface sql语句接口 {
    public void  insert插入(JD jd);
    public void  update修改(JD jd);
    public void  delete删除(long id);
    public List<JD>  关键字查询(String str);
    public void  select查询(long id);
    public List<JD> select查询全部();
}
