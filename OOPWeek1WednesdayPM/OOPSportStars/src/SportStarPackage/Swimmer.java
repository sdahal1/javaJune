package SportStarPackage;

public class Swimmer extends Athelete {
	private int lungCapacity;
	
	public Swimmer(String firstNameInput, String lastNameInput, int lungCapacityInput) {
		super(firstNameInput, lastNameInput);
		this.lungCapacity = lungCapacityInput;
		
	}
	
	public Swimmer(String firstNameInput, String lastNameInput) {
		super(firstNameInput, lastNameInput);
		this.lungCapacity = 50;
	}
	
	public String displayStats() {
		String result = String.format("This Swimmer's stats are: \n Lung Capacity: %d, Strength: %d, Speed: %d, Stamina: %d, First Name: %s, Last Name: %s", this.lungCapacity, this.strength, this.speed, this.stamina, this.firstName, this.lastName );
		
		return result;
		
	}
	
	public void swim() {
		System.out.println("Swimming in salt water tho");
		this.stamina -=5;
		this.lungCapacity += 2;
		
	}
	

}
