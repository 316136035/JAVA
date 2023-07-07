package A02_Dao操作数据库;


import A04_实体类.Emp;
import A04_实体类.Emprole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoimplements implements EmpDaointerface{
    @Override
    public int addEmp(Connection connection, int id, String name, int age, int sex, Date date, int deptid) {
        int i=-1;
        String  sql="INSERT INTO `layui`.`Emp` (`empid`, `empname`, `age`, `gender`, `hireDate`, `depid`) VALUES (?, ?, ?,?, ?, ?)";
        PreparedStatement  preparedStatement=null;
        Object[] params={id,name, age,sex,date,deptid};

        try {
           i = MysqlUtils.executeUpdate(connection, sql, params, preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                MysqlUtils.close(null, preparedStatement, null);
            }
        }

        return i;
    }

    @Override
    public int deleteEmp(Connection connection, int id) {
        int anInt=-1;
        String sql = "Delete from Emp where empid=?;";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = new Object[]{id};
        try {
            anInt = MysqlUtils.executeUpdate(connection, sql, params, preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                MysqlUtils.close(null, preparedStatement, resultSet);
            }
        }

        return  anInt;
    }

    @Override
    public int upDateEmp(Connection connection, int id, String name, int age, int sex, Date date, int deptid) {
        int anInt=-1;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = new Object[]{name,age, sex,date,deptid,id};
        String  sql="UPDATE Emp SET `empname`=?,`age`=?,`gender`=?,`hireDate`=?,`depid`=?  WHERE `empid` = ?;";
        try {
            anInt = MysqlUtils.executeUpdate(connection, sql, params, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                MysqlUtils.close(null, preparedStatement, resultSet);
            }
        }


        System.out.println(" upDateEmp"+anInt);


        return anInt;



    }


    @Override
    public List<Emp> getEmp(Connection connection, int page, int limit) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        /**创建可变字符串*/
        StringBuffer stringBuffer = new StringBuffer();
        /**创建list集合用于存放前台传参的数据*/
        List<Object> list = new ArrayList<>();
        /**用户存放返回的emp对象*/
        List<Emp> lisremp=new ArrayList<>();
        /**sql语句*/
        stringBuffer.append("SELECT  *    FROM Emp e,Emprole er WHERE e.depid=er.deptid  ");

        /**分页查询的sql语句*/
        stringBuffer.append(" ORDER BY empid  LIMIT ?,? ;");
        String sql = stringBuffer.toString();

        page = ( page - 1) * limit;
        if (page<0){
            page=0;
        }
        list.add( page);
        list.add( limit);
        Object[] params = list.toArray();

        try {
          resultSet = MysqlUtils.executeQuery(connection,sql,params ,preparedStatement,resultSet );
          while (resultSet.next()){

              Emp emp = new Emp(resultSet.getInt(1),
                      resultSet.getString(2),
                      resultSet.getInt(3),
                      resultSet.getInt(4),
                      resultSet.getDate(5),
                      resultSet.getInt(6),
                      new Emprole( resultSet.getInt(7),resultSet.getString(8)));

             // System.out.println(emp.toString());

              lisremp.add(emp);
          }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                MysqlUtils.close(null, preparedStatement, resultSet);
            }
        }


        return lisremp;
    }

    @Override
    public int Getcount(Connection connection) {
        int anInt=0;
        String sql = "SELECT  COUNT(*) FROM Emp e, Emprole er WHERE e.`depid`=er.`deptid`";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = new Object[]{};
        if (connection!=null){
            try {
               resultSet = MysqlUtils.executeQuery(connection, sql, params, preparedStatement, resultSet);
                if ( resultSet.next())
                {
                   anInt = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (connection != null) {
                    MysqlUtils.close(null, preparedStatement, resultSet);
                }
            }


        }

        System.out.println("Getcount:"+anInt);
        return anInt ;
    }

    @Override
    public List<Emprole> GetEmprole(Connection connection) {
        String sql = "SELECT  * FROM Emprole";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = new Object[]{};
        List<Emprole> emproles = new ArrayList<>();
        if (connection!=null){
            try {
                resultSet = MysqlUtils.executeQuery(connection, sql, params, preparedStatement, resultSet);
          while (resultSet.next()){
              emproles.add(new Emprole(resultSet.getInt(1), resultSet.getString(2)));
          }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if (connection != null) {
                    MysqlUtils.close(null, preparedStatement, resultSet);
                }
            }

        }


        return emproles ;
    }


}
