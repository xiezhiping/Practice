package base.jvm.AOP;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ��ԭʼ��GunDog��Ϊtarget
		Dog target = new GunDog();
		Dog dog = (Dog) MyProxyFactory.getProxy(target);
		dog.info();
		dog.run();
	}

}
