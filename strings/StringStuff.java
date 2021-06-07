public class StringStuff {
    public static void main(String[] args){
        System.out.println("wazzaaap");
        String firstName = "     Luka";
        //THE VALUE OF A METHOD/FUNCTION CALL IS WHATEVER THAT METHOD/FUNCTION CALL RETURNS
        String fullName = firstName.concat(" Doncic         ");
        System.out.println(fullName);
        System.out.println(fullName.toUpperCase());
        String trimmedName = fullName.trim();

        String name = "Lebron";
        int championships = 4;
        System.out.println(String.format("The player named %s has %d championships", name, championships ));
        
        // System.out.println(trimmedName.charAt(2));


    }
}

// name = "Lebron"
// championships = 4;
// print(f"The player named {name} has {championships} championships");
