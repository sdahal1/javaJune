package CarPackage;
import java.util.Random;

public class Car {
	//member variables
	private int mileage;
	private String licenceplateNum;
	private double gallonsLeft;
	private int milesPerGallon;
	private String model;
	
	public static int totalCarsCreated= 0;
	public static int totalMileageForAllCars = 0;
	
	//constructor
	public Car(int mileageInput, int milesPerGallonInput,  String modelInput) {
		this.mileage = mileageInput;
		this.milesPerGallon = milesPerGallonInput;
		this.model = modelInput;
		this.gallonsLeft = 35.0;
		this.licenceplateNum = this.generateLicencePlateNumber();
		
		totalCarsCreated++;
		totalMileageForAllCars += this.mileage;
		
	}
	
	public void drive(int numMilesDriven) {
		if(this.milesPerGallon*this.gallonsLeft> numMilesDriven) {
			this.mileage += numMilesDriven;
			double numGallonsUsedUp= numMilesDriven/this.milesPerGallon;
			System.out.println(numGallonsUsedUp);
			double gallonsLeft = this.gallonsLeft - numGallonsUsedUp;
			this.setGallonsLeft(gallonsLeft);
			
			totalMileageForAllCars += numMilesDriven;
			
		}else {
			System.out.println("Better call that gieco roadside assistancee now");
		}
		
		
	}
	
	
	public String generateLicencePlateNumber() {
		//figure out how to generate a random number between 0-9;
		Random rand = new Random();
		int rand_int;
		String result = "";
		
		for(int i = 0; i<6; i++) {
			rand_int = rand.nextInt(10);
			result+=rand_int;
			
		}
		System.out.println("Random licenceplate number: " + result);
		
		//each time, add that number to an empty string
		//results in a string with 6 random numbers
  
		    
		
		
		return result;
	}
	
	
	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getLicenceplateNum() {
		return licenceplateNum;
	}

	public void setLicenceplateNum(String licenceplateNum) {
		this.licenceplateNum = licenceplateNum;
	}

	public double getGallonsLeft() {
		return gallonsLeft;
	}

	public void setGallonsLeft(double gallonsLeft) {
		this.gallonsLeft = gallonsLeft;
	}

	public int getMilesPerGallon() {
		return milesPerGallon;
	}

	public void setMilesPerGallon(int milesPerGallon) {
		this.milesPerGallon = milesPerGallon;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	
	

}
