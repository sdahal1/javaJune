package InterFaceAbstractPackage;

public class BicycleTest {
	public static void main(String[] args) {
        Bicycle b = new Bicycle();
        // print constant
        System.out.println(Bicycle.myConstant);
        b.sayHello();
        Bicycle.staticMethod();
        b.speedUp(300);
        b.applyBrakes(2);
        System.out.println(b.getSpeed());
        Tricycle t = new Tricycle();
        t.speedUp(3);
        System.out.println(t.getSpeed());
        t.speedUp(4);
    }

}
