package base.jvm.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvokationHandler implements InvocationHandler {
	// ��Ҫ������Ķ���
	private Object target;
	public void setTarget(Object target) {
		this.target = target;
	}
	// ִ�д����������з���ʱ�����ᱻ�滻��ִ�����µ�invoke����
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		DogUtil du = new DogUtil();
		// ִ��DogUtil�е�method1����
		du.method1();
		// ��target��Ϊ������ִ��method�ŷ�
		Object result = arg1.invoke(target, arg2);
		du.method2();
		return result;
	}

}
