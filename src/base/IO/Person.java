/**
 * ����ʵ������Person����
 */
package base.IO;

public class Person implements java.io.Serializable {
	private String name;
	private int age;
	// �˴��ṩ�������Ĺ�����
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("�ߴ������Ĺ�����");
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		if (age < 1) {
			System.out.println("����������������");
		}
		this.age = age;
	}

}
