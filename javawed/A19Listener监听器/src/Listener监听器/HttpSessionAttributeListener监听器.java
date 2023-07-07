package Listener监听器;


import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionListener;

/*监听Attribute添加属性和删除属性和修改属性*/
public class HttpSessionAttributeListener监听器 implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

        //监听添加属性
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("sessionCreated添加属性的时候调用");
    }
        //监听删除属性
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("sessionCreated删除属性的时候调用");
    }
        //监听修改属性
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("sessionCreated修改属性的时候调用");
    }
}
