package cn.itcast.ioc;

public class User {
	
	private String username;
	
	public User(String username) {
		this.username = username;
	}

	public User() {
		
	}

	public void add() {
		System.out.println("add..........");
	}
	
	public static void main(String[] args) {
		//原始做法
//		User user = new User();
//		user.add();
		System.out.println("aaa");
	}
}
