package lmc.entity;
public class Person {
	private int id = -1;
	private String name = null;
	private int age = 0;
	public Person() {}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id="+id+",name="+name+",age="+age+"]";
	}
}