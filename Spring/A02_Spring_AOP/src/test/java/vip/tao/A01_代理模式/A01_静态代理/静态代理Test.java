package vip.tao.A01_代理模式.A01_静态代理;

import org.junit.Test;
import vip.tao.A01_代理模式.A01_静态代理.mapper.A01_UserImpl;
import vip.tao.A01_代理模式.A01_静态代理.service.A01_Proxy;

public class 静态代理Test {
    @Test
    public  void 静态代理Test(){
        A01_UserImpl user = new A01_UserImpl();
        A01_Proxy proxy = new A01_Proxy();
        proxy.setUserimpl(user);
        proxy.Insret();


    }
}
