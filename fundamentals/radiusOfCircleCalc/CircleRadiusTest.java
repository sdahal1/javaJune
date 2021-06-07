import java.util.Date;


public class CircleRadiusTest {
    public static void main(String[] args){
        System.out.println("hi running from main");

        //creating an instance of circleradius class using variable "x"
        CircleRadius x = new CircleRadius();
        System.out.println(x.calculateRadius(23.0));
        System.out.println(x.calculateRadius(25.0));
        System.out.println(x.calculateRadius(100.0));


        Date today = new Date();
        System.out.println(today);
    }
}