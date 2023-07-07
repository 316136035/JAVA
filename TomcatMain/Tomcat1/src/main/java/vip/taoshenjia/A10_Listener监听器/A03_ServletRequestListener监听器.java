package vip.taoshenjia.A10_Listener监听器;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


public class A03_ServletRequestListener监听器 implements ServletRequestListener, ServletRequestAttributeListener {


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
      //  System.out.println("客户端请求调用requestInitialized方法");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
      //  System.out.println("客户端结束请求调用requestDestroyed方法");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
      //  System.out.println("Request添加属性请求调用attributeAdded方法");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
      //  System.out.println("Request删除属性请求调用attributeRemoved方法");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
      //  System.out.println("Request删改属性请求调用attributeReplaced方法");
    }


}
