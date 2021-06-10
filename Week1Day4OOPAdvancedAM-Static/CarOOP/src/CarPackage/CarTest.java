package CarPackage;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car(10, 1, "BooGatti");
//		System.out.println(c1.getModel());
		
		Car c2 = new Car(1000, 30, "Camry");
		c1.drive(34);
		
		
		System.out.println(Car.totalCarsCreated);
		System.out.println("Total number of mileage for all cars: " + Car.totalMileageForAllCars );
		
		System.out.println(c1.getLicenceplateNum());
		System.out.println(c2.getLicenceplateNum());
		
		
		
		

	}

}
