package vip.tao.A01_代理模式.A01_静态代理.service;

import vip.tao.A01_代理模式.A01_静态代理.mapper.A01_UserImpl;
import vip.tao.A01_代理模式.A01_静态代理.mapper.A01_UserInte;

import java.util.concurrent.TimeUnit;

/**代理 实现实体类的接口（使用代理可以附加好多方法）*/
public class A01_Proxy implements A01_UserInte {
    /**注入实现实体类接口的对象*/
    private A01_UserImpl userimpl;
    public void setUserimpl(A01_UserImpl userimpl) {
        this.userimpl = userimpl;
    }
    @Override
    public void Insret() {
        long begin = begin();
        userimpl.Insret();
        sleep();
        long end = end();
        System.out.println("程序运行时间："+(end-begin)+"毫秒");
    }

    @Override
    public void Delete() {
        userimpl.Delete();
    }

    @Override
    public void Update() {
        userimpl.Update();
    }

    @Override
    public void SelectUser() {
        userimpl.SelectUser();
    }

   protected long begin (){


        return System.currentTimeMillis();

    }
    protected long end (){
        return System.currentTimeMillis();

    }

    protected void sleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
