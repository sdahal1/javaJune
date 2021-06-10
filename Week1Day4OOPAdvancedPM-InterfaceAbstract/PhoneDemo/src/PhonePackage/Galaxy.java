package PhonePackage;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	public String ring() {
        // your code here
		System.out.println("We are not tracking you with siri, syke naw, everybody eats");
		return "Galaxy " + this.getVersionNumber() + " says " + this.getRingTone();
    }
	
	public String unlock() {
		return "Unlocking via fingerprint";
	}
	
	public void displayInfo() {
		String info = String.format("This Galaxy's info: \n Version Number: %s, Battery Percentage: %d, Carrier %s, Ringtone: %s  ", this.getVersionNumber(), this.getBatteryPercentage(), this.getCarrier(), this.getRingTone() );
		
		System.out.println(info);
	}
}
