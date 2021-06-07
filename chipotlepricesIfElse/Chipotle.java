public class Chipotle {

    //create a function that will take a number. 
    //if number is divisible by only 5, then it will say "queso and chips". If the number is divisible by ONLY 7, it will say "Chipotle burrito bowl(except in NYC where its like 15 bucks for nothing". If the number is divisible by BOTH 5 and 7, THEN it will say "you get XL burrito and queso and chips". For everything else, it will say "California Tortilla Doe"
    public static void welcomeToChipotle(int num){
        if(num%5 ==0 && num%7 ==0){
            System.out.println("you get XL burrito and queso and chips");
        }else if(num%5==0){
            System.out.println("queso and chips");
        }else if(num%7==0){
            System.out.println("Chipotle burrito bowl(except in NYC where its like 15 bucks for nothing");
        }else{
            System.out.println("California torilla doe");
        }
    }



    public static void main(String[] args){
        System.out.println("testinggggg");
        Chipotle.welcomeToChipotle(35);
        Chipotle.welcomeToChipotle(10);
        Chipotle.welcomeToChipotle(21);
        Chipotle.welcomeToChipotle(23);

    }
}
