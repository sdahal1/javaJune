package PhonePackage;

public class Iphone extends Phone implements Ringable {

	public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	public String ring() {
        // your code here
		System.out.println("Siri is listening to see who be calling you tho");
		return "Iphone " + this.getVersionNumber() + " says " + this.getRingTone();
    }
	
	
	public String unlock() {
		return "Unlocking via facial recognition";
	}
	
	
	public void displayInfo() {
		String info = String.format("This Iphone's info: \n Version Number: %s, Battery Percentage: %d, Carrier %s, Ringtone: %s  ", this.getVersionNumber(), this.getBatteryPercentage(), this.getCarrier(), this.getRingTone() );
		
		System.out.println(info);
	}
	
}
