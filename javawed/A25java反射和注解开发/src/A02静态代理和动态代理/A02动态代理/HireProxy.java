package A02静态代理和动态代理.A02动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HireProxy implements InvocationHandler {

	//被代理的真实角色
	private Object obj;
	
	
	
	public HireProxy(Object obj) {
		super();
		this.obj = obj;
	}


	/**
	 * jdk的动态代理，被代理的对象必须实现接口
	 * 第二个参数method是被代理对象的接口方法
	 * 第三个参数method是被代理对象的接口方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("前置工作");
		System.out.println("------参数--------");
		for(Object obj1 : args){
			System.out.println(obj1);
		}
		System.out.println("------参数--------");
		Object invoke = method.invoke(obj, args);
		System.out.println("后置工作");
		return invoke;
	}

	
	
	
	
	


	

}
