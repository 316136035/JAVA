package vip.tao.A04_Spring注解_面向切面编程.Log;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class A04_Log {
    /**切面执行前before */
    @Before("execution(* vip.tao.A04_Spring注解_面向切面编程.Srevive.A04_UserImpl.*(..))")
    public void  begin(){
        System.out.println("开始执行");
    }
    /**切面执行后After */
    @After("execution(* vip.tao.A04_Spring注解_面向切面编程.Srevive.A04_UserImpl.*(..))")
    public void  end(){
        System.out.println("执行完毕");
    }
    /**过滤器*/
    @Around("execution(* vip.tao.A04_Spring注解_面向切面编程.Srevive.A04_UserImpl.*(..))")
    public  void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("切面方法直接前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("切面方法直接后");
    }


}
