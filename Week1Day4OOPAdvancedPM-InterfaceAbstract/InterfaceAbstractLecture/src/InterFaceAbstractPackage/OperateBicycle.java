package InterFaceAbstractPackage;

public interface OperateBicycle {
	// constant that is public, static, and final
    double myConstant = 3.0;
	// default method that does not need implementation
    default void sayHello() {
        System.out.println("Hello everybody");
    }
    
    // static method that does not need implementation
    public static void staticMethod() {
        System.out.println("Hello from the static method of the interface");
    }
    
    //ABSTRACT INTERFACE METHODS
    public void speedUp(int increment);
    public void applyBrakes(int decrement);

}
