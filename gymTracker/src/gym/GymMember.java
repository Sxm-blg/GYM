package gym;

import java.util.Map;
import java.util.Scanner;

public class GymMember extends GymUser{
		private static int nextId = 1;
	    private int userId;
		private int memberId;
		private String goal;
	    private double weight;
	    private double height;
	    private int age;
	    private double targetWeight;
	    private double previousWeight;
	    private TrainingPlan trainingPlan = new TrainingPlan();

	    public GymMember(String email, String password, String goal, double weight, double height, int age, double targetWeight) {
	        super(email, password);
	        this.memberId = nextId++;
	        this.goal = goal;
	        this.weight = weight;
	        this.previousWeight = weight;
	        this.height = height;
	        this.age = age;
	        this.targetWeight = targetWeight;
	        this.trainingPlan = new TrainingPlan();
	    }

	    public void updateData(double weight, double height, int age, double targetWeight) {
	        this.previousWeight = this.weight;
	        this.weight = weight;
	        this.height = height;
	        this.age = age;
	        this.targetWeight = targetWeight;
	    }

	    public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getGoal() {
			return goal;
		}

		public void setGoal(String goal) {
			this.goal = goal;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getTargetWeight() {
			return targetWeight;
		}

		public void setTargetWeight(double targetWeight) {
			this.targetWeight = targetWeight;
		}

		public double getPreviousWeight() {
			return previousWeight;
		}

		public void setPreviousWeight(double previousWeight) {
			this.previousWeight = previousWeight;
		}

		public void setMemberId(int memberId) {
			this.memberId = memberId;
		}

		public void setTrainingPlan(TrainingPlan trainingPlan) {
			this.trainingPlan = trainingPlan;
		}

		public TrainingPlan getTrainingPlan() {
	        return trainingPlan;
	    }

	    @Override
	    public GymUserService createService(Scanner sc, Map<String, GymUser> users) {
	        return new MemberService(this, sc);
	    }

		public int getMemberId() {
			// TODO Auto-generated method stub
			return memberId;
		}
	}

