package gym;

import java.util.Map;
import java.util.Scanner;

public class FitnessCoach extends GymUser{
	public FitnessCoach(String email, String password) {
        super(email, password);
    }

    @Override
    public GymUserService createService(Scanner sc, Map<String, GymUser> users) {
        return new TrainerService(users, sc);
    }
}


