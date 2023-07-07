package Listener监听器;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*监听Request创建和销毁*/
public class MyServletRequestListener监听器 implements ServletRequestListener {
   // 开始请求和结束请求时调用下面两个方法
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequestEvent---请求对象被销毁前后调用");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequestEvent---请求对象创建前调用");
    }
}
