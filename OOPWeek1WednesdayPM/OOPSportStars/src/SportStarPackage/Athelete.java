package SportStarPackage;

public class Athelete {
	//member variables
	protected int stamina;
	protected int speed;
	protected int strength;
	protected String firstName;
	protected String lastName;
	
	
	//constructor
	public Athelete(String firstNameInput, String lastNameInput) {
		this.firstName = firstNameInput;
		this.lastName = lastNameInput;
		this.stamina = 10;
		this.speed = 10;
		this.strength = 10;
	}
	
	
	public String displayStats() {
		String result = String.format("This Athelete's stats are: \n Strength: %d, Speed: %d, Stamina: %d, First Name: %s, Last Name: %s", this.strength, this.speed, this.stamina, this.firstName, this.lastName );
		
		return result;
		
	}
	
	
	
	
	//getters and setters below
	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	
	
	
	
	
	
	
	
	
	

}
