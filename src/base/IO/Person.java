/**
 * 用于实例化的Person对象
 */
package base.IO;

public class Person implements java.io.Serializable {
	private String name;
	private int age;
	// 此处提供带参数的构造器
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("走带参数的构造器");
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
			System.out.println("输入年龄数据有误");
		}
		this.age = age;
	}

}
