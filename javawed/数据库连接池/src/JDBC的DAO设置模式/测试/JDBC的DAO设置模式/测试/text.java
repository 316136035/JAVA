package JDBC的DAO设置模式.测试;

import JDBC的DAO设置模式.model对应数据库的实体类.JD;
import JDBC的DAO设置模式.定义执行sql语句的接口和方法.实现sql语句接口.实现sql语句接口;

import java.sql.Timestamp;
import java.util.List;

public class text {
    public static void main(String[] args) {

        实现sql语句接口 实现sql语句接口 = new 实现sql语句接口();
        JD jd = new JD(5,"安慰色2",44,44,new Timestamp(System.currentTimeMillis()));
      // 实现sql语句接口.insert插入(jd);
       // 实现sql语句接口.update修改(jd );
       // 实现sql语句接口.delete删除(jd .getSku());
        //实现sql语句接口.select查询(1);
        //List<JD> jds = 实现sql语句接口.select查询全部();
        List<JD> jds = 实现sql语句接口.关键字查询("慰");

        for (JD jd1 : jds) {
            System.out.println(jd1.toString());
        }
    }
}
