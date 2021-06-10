package PhonePackage;

public class PhoneTestWhoDis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Iphone robsPhone = new Iphone("X", 100, "At&t", "Sleigh Ride");
		robsPhone.displayInfo();
		System.out.println(robsPhone.unlock());
		
		System.out.println(robsPhone.ring());
		
		
		System.out.println("MAKING A GALAXY PHONE NOW BELOW!!!");
		
		Galaxy KatyaPhone = new Galaxy("Milky way", 100, "T mobile", "Rudolph the red nose raindeer" );
		KatyaPhone.displayInfo();
		System.out.println(KatyaPhone.unlock());
		
		System.out.println(KatyaPhone.ring());
		
	}

}
