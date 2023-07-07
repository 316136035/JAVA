package A03_Service业务层;

import A04_实体类.Jd;

import java.util.List;

public interface JdServiceinterface {
    /**获取京东集合数量*/
    public List<Jd> GetUserList( String text, int currentPageNo, int pageSize);


}
