package website;

public class Member {
	private String id, pass, name, address;
	private int age;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String id, String pass, String name, int age, String address) {
		this.id =id;
		this.pass = pass;
		this.name =name;
		this.age =age;
		this.address= address;
	}
	
	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
