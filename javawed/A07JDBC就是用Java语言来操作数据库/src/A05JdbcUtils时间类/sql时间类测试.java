package A05JdbcUtils时间类;

public class sql时间类测试 {
    public static void main(String[] args) {
       String sql="insert into  times values (?,?,?);";

        for (int i = 0; i <10000 ; i++) {
            sql插入时间类.获取执行SQL语句的对象prepareStatement插入(sql);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//      String sql=  "select * from times;";
//        sql获取时间类.获取执行SQL语句的对象prepareStatement获取( sql);
//
//

    }
}
