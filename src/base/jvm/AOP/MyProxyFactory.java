package base.jvm.AOP;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
	// 为指定的target生成动态代理对象
	public static Object getProxy(Object target) {
		// 创建一个MyInvokationHandler对象
		MyInvokationHandler handler = new MyInvokationHandler();
		handler.setTarget(target);
		// 创建并返回一个动态代理
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
