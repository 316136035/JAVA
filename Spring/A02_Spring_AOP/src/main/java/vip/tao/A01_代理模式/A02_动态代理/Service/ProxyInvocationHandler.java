package vip.tao.A01_代理模式.A02_动态代理.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/***动态代理要实现调用处理程序接口*/
public class ProxyInvocationHandler implements InvocationHandler {
    /**被代理的接口*/
    Object target;
    /**set方法注入*/
    public void setObject(Object target) {
        this.target= target;
    }

    public Object getProxyInstance() {
        /**创建代理实例（获取类的类加载器（），获取类的的接口，直接的本事this）*/

        return   Proxy.newProxyInstance(this.getClass().getClassLoader(),
                  target.getClass().getInterfaces(),
                this);

    }

    /**实现处理代理实例，瓶返回结果*/
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        /**动态代理的本质，就是通过反射来实现的* */
        long begin = begin();
        System.out.println(method.getName()); //反射获取方法名
        sleep();
        /**真实调用方法就是invoke方法*/
        Object invoke = method.invoke(target, objects);
        long end = end();
        System.out.println("程序运行时间："+(end-begin)+"毫秒");
        return invoke;

    }
    protected long begin (){


        return System.currentTimeMillis();

    }
    protected long end (){
        return System.currentTimeMillis();

    }

    protected void sleep(){
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
