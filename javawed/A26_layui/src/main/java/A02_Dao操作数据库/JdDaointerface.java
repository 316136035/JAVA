package A02_Dao操作数据库;

import A04_实体类.Jd;

import java.sql.Connection;
import java.util.List;

public interface JdDaointerface {
    /**获取京东集合数量*/
    public List<Jd>  GetUserList(Connection connection, String text,int currentPageNo, int pageSize);






}
