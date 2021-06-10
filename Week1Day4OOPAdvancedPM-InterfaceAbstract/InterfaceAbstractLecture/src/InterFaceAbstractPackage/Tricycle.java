package InterFaceAbstractPackage;

public class Tricycle implements OperateBicycle {
	private int speed;
    public Tricycle() {
        this.speed = 0;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public void speedUp(int increment) {
    	if(this.speed + increment >5) {
    		System.out.println("woahhh there young blood, thats too fast on a tricycle!");
    	}else {
    		this.speed += increment;
    	}
    }
    
    public void applyBrakes(int decrement) {
        this.speed -= decrement;
    }
    
    
}
