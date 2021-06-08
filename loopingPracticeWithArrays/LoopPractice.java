import java.util.ArrayList;
import java.util.Arrays;


public class LoopPractice {
    public static void printNegative23To77(){
        for(int i = -23; i<=77; i++ ){
            System.out.println(i);
        }
    }

    public static void printEvenNumsFrom0ToNum(int num){
        for(int i = 0; i<=num; i+=2){
            System.out.println(i);
        }
    }

    public static int summItUp(int num){
        int sum = 0;
        for(int i = 0; i<= num; i++){
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static void iterateArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    public static void iterateArray2(int[] arr){
        for(int somenum: arr){
            System.out.println(somenum);
        }
    }

    public static int findMin(int[] arr){
        int minval = arr[0];
        for(int someNum: arr){
            if(someNum < minval){
                minval= someNum;
            }
        }
        return minval;
    }

    public static double findAvg(int[] arr){
        int sum = 0;
        for(int val: arr){
            sum += val;
        }
        double avg = (double)sum/arr.length;
        return avg;
    }

    public static ArrayList<Integer> createEvenArray(int num){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 0; i<= num; i+=2){
            // System.out.println(i);
            y.add(i);
        }
        // System.out.println(y);
        return y;
    }

    public static int lessThanX(int[] arr, int x){
        int count = 0;
        for(int num: arr){
            if(num<x){
                count++;
            }
        }
        System.out.println(count);
        return count;

    }

    public static void noPositivityAllowed(Object[] arr){
        for(int i = 0; i< arr.length; i++){
            if((int)arr[i] >0){
                arr[i] = "ugh";
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void minAndAvg(int[] arr){
        //create an array to store the min and avg in --> since min will be an integer and avg will be a double, this array will be mixed 
        ArrayList<Object> result = new ArrayList<Object>();
        int minval = LoopPractice.findMin(arr);
        double avgVal = LoopPractice.findAvg(arr);
        result.add(minval);
        result.add(avgVal);
        System.out.println(result);
        

    }


    public static void main(String[] args){
        // System.out.println("waazzaaa loop practice");
        // LoopPractice.printNegative23To77();
        // LoopPractice.printEvenNumsFrom0ToNum(500);
        // LoopPractice.summItUp(32);
        int[] someArray = {4, -8, 18, -5, 9};
        Object[] anothaOne = {4, -8, 18, -5, 9};

        // LoopPractice.iterateArray2(someArray);
        // System.out.println(LoopPractice.findMin(someArray));
        // System.out.println(LoopPractice.findAvg(someArray));
        // System.out.println(LoopPractice.createEvenArray(24)); //[0,2,4,6,8,10...num]
        // LoopPractice.lessThanX(someArray, 9); //3
        // LoopPractice.noPositivityAllowed(anothaOne);  //["ugh", -8, "ugh", -5, "ugh"]
        // LoopPractice.minAndAvg(someArray); //[-8, avg]

        
    }
    
}
