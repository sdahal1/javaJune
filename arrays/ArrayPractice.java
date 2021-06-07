import java.util.Arrays;
import java.util.ArrayList;

public class ArrayPractice {
    public static void main(String[] args){
        // x = [5,8,3,2];
        // int[] x = new int[4];
        // x[0] = 5;
        // x[1] = 8;
        // x[2] = 3;
        // x[3] = 2;
        int[] x = {5,8,3,2};
        System.out.println(Arrays.toString(x));




        //using ArrayList to create an array of integers
        ArrayList<Integer> y = new ArrayList<Integer>();
        y.add(23);
        y.add(3);
        y.add(13);
        y.add(45);
        y.add(23);
        y.add(20);
        y.remove(y.size()-1);
        System.out.println(y);


        // List<String> x = new ArrayList<>(Arrays.asList("xyz", "abc"));
        //creating an arraylist with values all at once
        ArrayList<Integer> anothaOne = new ArrayList<Integer>(Arrays.asList(23,5,7,81,45));
        System.out.println(anothaOne);


        ArrayList<Object> mixedbag = new ArrayList<Object>(Arrays.asList(23,"Jordan",true,'a',32.9));
        System.out.println(mixedbag);
        



        
        
        
    }
}
