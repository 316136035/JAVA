package vip.taoshenjia.A10_Listener监听器;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class A01_HttpSessionListener监听Session开始会话和结束会话和Session属性修改 implements HttpSessionListener, HttpSessionAttributeListener {
    //开始会话和结束会话时调用下面两个方法(一个页面对应一个session创建)
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated开始会话对象被创建后调用");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
       System.out.println("sessionCreated结束会话对象被销毁调用");

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionAttributeListener:"+"添加的属性后调用");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionAttributeListener:"+"删除的属性后调用");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("HttpSessionAttributeListener:"+"修改的属性后调用");
    }
}
