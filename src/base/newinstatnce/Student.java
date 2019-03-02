package base.newinstatnce;

import java.io.Serializable;

public class Student implements Cloneable,Serializable {
	private int id;
	private String name;
	public Student() {
		this.id = 22;
		this.name = "无参构造器手提袋std2";
	}
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Student clone() throws CloneNotSupportedException {
		return (Student)super.clone();
	}
}
