package base.jvm.AOP;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建一个原始的GunDog作为target
		Dog target = new GunDog();
		Dog dog = (Dog) MyProxyFactory.getProxy(target);
		dog.info();
		dog.run();
	}

}
