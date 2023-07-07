package vip.tao.A02_SpringApi面向切面编程.Log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
/**AfterReturningAdvice执行后的切面*/
public class afterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(returnValue+":"+ target.getClass().getName()+":"+method.getName());
    }
}
