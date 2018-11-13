package base.jvm.AOP;

import java.lang.reflect.Proxy;

public class MyProxyFactory {
	// Ϊָ����target���ɶ�̬�������
	public static Object getProxy(Object target) {
		// ����һ��MyInvokationHandler����
		MyInvokationHandler handler = new MyInvokationHandler();
		handler.setTarget(target);
		// ����������һ����̬����
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
