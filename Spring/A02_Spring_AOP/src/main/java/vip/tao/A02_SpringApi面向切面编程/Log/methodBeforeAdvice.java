package vip.tao.A02_SpringApi面向切面编程.Log;

import java.lang.reflect.Method;

/**MethodBeforeAdvice执行前的切面*/
public class methodBeforeAdvice implements org.springframework.aop.MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        System.out.println( target.getClass().getName()+":"+method.getName());
    }
}
