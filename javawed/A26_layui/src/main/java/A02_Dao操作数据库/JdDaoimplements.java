package A02_Dao操作数据库;

import A04_实体类.Jd;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdDaoimplements implements JdDaointerface {

    @Override
    public List<Jd> GetUserList(Connection connection, String text,  int currentPageNo, int pageSize) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        /**存放查询数据库数据*/
        List<Jd> jdlist = new ArrayList<>();
      if ( connection!=null){
          /**创建可变字符串*/
          StringBuffer stringBuffer = new StringBuffer();
          /**创建list集合用于存放前台传参的数据*/
          List<Object> list = new ArrayList<>();
          /**sql语句*/
          stringBuffer.append("SELECT  *  FROM jd  ");
          /**判断是否关键字查询*/
          if (!StringUtils.isNullOrEmpty(text)) {
              /**添加关键字查询*/
              stringBuffer.append(" AND name LIKE ?");
              list.add("%"+text+"%");

          }

          /**分页查询*/
          stringBuffer.append(" ORDER BY name  LIMIT ?,? ;");
          currentPageNo = (currentPageNo - 1) * pageSize;

          if (currentPageNo<0){
              currentPageNo=0;
          }
          list.add(currentPageNo);
          list.add(pageSize);

          /**可变字符串转成字符串**/
          String sql =  stringBuffer.toString();
          /**集合转成数组**/
          Object[] params = list.toArray();
          try {
              resultSet = MysqlUtils.executeQuery(connection, sql, params, preparedStatement, resultSet);
              while (resultSet.next()){


                  Jd jd = new Jd(resultSet.getLong(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4),resultSet.getInt(5));
                jdlist.add(jd);

              }


          } catch (SQLException e) {
              e.printStackTrace();
          }finally {
              try {
                  if (resultSet != null){resultSet.close();}
                  if (preparedStatement != null){preparedStatement.close();}
              } catch (SQLException e) {
                  e.printStackTrace();
              }

          }

      }



        return  jdlist;
    }


}
