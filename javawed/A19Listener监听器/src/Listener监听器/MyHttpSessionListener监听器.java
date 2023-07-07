package Listener监听器;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/*监听Session创建和销毁*/
public class MyHttpSessionListener监听器 implements HttpSessionListener {

    //开始会话和结束会话时调用下面两个方法(一个页面对应一个session创建)
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated开始会话对象被创建后调用；");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }


}
