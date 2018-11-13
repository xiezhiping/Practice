package base.jvm.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvokationHandler implements InvocationHandler {
	// 需要被代理的对象
	private Object target;
	public void setTarget(Object target) {
		this.target = target;
	}
	// 执行代理对象的所有方法时，都会被替换成执行如下的invoke方法
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		DogUtil du = new DogUtil();
		// 执行DogUtil中的method1方法
		du.method1();
		// 以target作为主调来执行method放法
		Object result = arg1.invoke(target, arg2);
		du.method2();
		return result;
	}

}
