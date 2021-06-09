package SportStarPackage;

public class BasketballPlayer extends Athelete{ //extends keyword allows for inheritance from Athelete class
	//member variable unique to BasketballPlayer class
	private int shootingSkillLevel;
	
	//constructor
	public BasketballPlayer(String firstNameInput, String lastNameInput, int shootingLevelInput) {
		//super is used to say "do whatever you are doing for the constructor of the parent class"
		super(firstNameInput, lastNameInput);
		this.shootingSkillLevel = shootingLevelInput;
		this.stamina = 25;
	}
	
	public String displayStats() {
		String result = String.format("This Basketball Player's stats are: \n Strength: %d, Speed: %d, Stamina: %d, Shooting Skill: %d,  First Name: %s, Last Name: %s", this.strength, this.speed, this.stamina, this.shootingSkillLevel, this.firstName, this.lastName );
		
		return result;
		
	}
	
	//methods only a basketball player can do
	public void shootBall() {
		this.stamina-= 5;
		if(this.shootingSkillLevel > 50) {
			System.out.println("BAAAANGGGGGGG");
		}else {
			System.out.println("Brick City tho");
		}
		
	}
	
	
	public int getShootingSkillLevel() {
		return shootingSkillLevel;
	}

	public void setShootingSkillLevel(int shootingSkillLevel) {
		this.shootingSkillLevel = shootingSkillLevel;
	}


}
