package vip.tao.A01_代理模式.A02_动态代理;

import org.junit.Test;
import vip.tao.A01_代理模式.A02_动态代理.Service.ProxyInvocationHandler;
import vip.tao.A01_代理模式.A02_动态代理.mapper.A02_UserImpl;
import vip.tao.A01_代理模式.A02_动态代理.mapper.A02_UserInte;



public class 动态代理 {
    @Test
    public  void A02_动态代理(){
        /**真实角色*/
        A02_UserInte user = new A02_UserImpl();
        /**创建调用处理程序*/
        ProxyInvocationHandler proxy = new ProxyInvocationHandler();
        /**设置要代理的对象 **/
        proxy.setObject(user);
        /**动态生成代理类*/
        A02_UserInte proxyInstance = (A02_UserInte) proxy.getProxyInstance();
        proxyInstance.InsretUser();
        proxyInstance.DeleteUser();
        proxyInstance.UpdateUser();
        proxyInstance.SelectUser();

        /**动态代理的好处:
         * 可以使真实角色的操作更加纯粹!不用去关注一些公共的业务
         * 公共也就就交给代理角色!实现了业务的分工!
         * 公共业务发生扩展的时候，方便集中管理!
         * 一个动态代理类代理的是一个接口，
         * 一个动态代理类可以代理多个类，只要是实现了同一个接口即可!*/


    }
}
