package A03_Service业务层;

import A02_Dao操作数据库.JdDaoimplements;
import A02_Dao操作数据库.MysqlUtils;
import A04_实体类.Jd;

import java.sql.Connection;
import java.util.List;

public class JdServiceimplements implements JdServiceinterface{
    JdDaoimplements jdDaoimplements=null;

    public JdServiceimplements() {
       jdDaoimplements = new JdDaoimplements();
    }

    @Override

    public List<Jd> GetUserList(String text, int currentPageNo, int pageSize) {
        Connection connection=null;
       connection = MysqlUtils.getConnection();


       List<Jd> jds = jdDaoimplements.GetUserList( connection, text,currentPageNo,pageSize);



        return jds;
    }

}
