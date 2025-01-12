package gym;

import java.util.Map;
import java.util.Scanner;

public abstract class GymUser {
	private static int nextId = 1;
	protected int userId;
	protected String email;
	protected String password;
	
	//constructor
	public GymUser(String email, String password) {
		this.userId = nextId++;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public boolean checkPassword(String inputPassword) {
		return this.password.equals(inputPassword);
	}

	public abstract GymUserService createService(Scanner sc, Map<String, GymUser> users);

}
