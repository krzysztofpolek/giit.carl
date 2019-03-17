package giit.carl.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String name;
	private String password;
	private String email;
	private String phoneNumber;
	private static User instance;
	
	public User() {}
	
	public User(String name, String password, String email, String phoneNumber) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public static User getInstance() {
		
		if(instance == null) {
			synchronized (User.class) {
				if (instance == null) {
					instance = new User();
				}
			}
		}
		
		return instance;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}	
	
}
