package h1java;

public class Mahasiswa {
	protected int age;
	protected String name;
	
	public Mahasiswa() {
		// TODO Auto-generated constructor stub
		age = 0;
		name = "";
	}
	
	public int getAge() {
		return age;
	}
	public void birthdays(int age) {
		age++;
	}
	public String getName() {
		return name;
	}
	public boolean setName(String name) {
		if(name.length() < 1) return false;
		this.name = name;
		return true;
	}
	
	
	
}
