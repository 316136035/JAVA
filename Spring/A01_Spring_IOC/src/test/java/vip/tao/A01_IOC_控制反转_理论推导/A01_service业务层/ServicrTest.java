package vip.tao.A01_IOC_控制反转_理论推导.A01_service业务层;

import org.junit.Test;
import vip.tao.A01_IOC_控制反转_理论推导.A01_mapper数据库持久层.A01_IUserMapperMysqlImp;

public class ServicrTest {
    @Test
    public   void  testmain() {
        /**创建业务层*/
        A01_IUserServiceImp userService = new A01_IUserServiceImp();
        /**业务层传入数据库持久层的实现类作为动作实现**/
        //userService.setUserMapper(new A01_IUserMapperOracleImp());
        userService.setUserMapper(new A01_IUserMapperMysqlImp());

        /**调用业务层的方法*/
        userService.getUser();



    }

}
