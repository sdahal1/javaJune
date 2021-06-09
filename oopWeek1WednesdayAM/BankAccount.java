
public class BankAccount {
    private String firstName;
    private String lastName;
    private Double accountBalance;

    //constructor overloading with three different constructors
    public BankAccount(){
        //the three attributes (or member variables) below
        this.firstName= "Untitled firstname";
        this.lastName= "Untitled lastname";
        this.accountBalance= 0.00;

    }
    
    //this is my constructor (similar to the def __init__() method in python)
    public BankAccount(String firstNameInput, String lastNameInput){
        this.firstName = firstNameInput;
        this.lastName = lastNameInput;
        this.accountBalance = 0.00;
    }

    //this is the third constructor
    public BankAccount(String firstNameInput, String lastNameInput, Double initialAmount){
        this.firstName = firstNameInput;
        this.lastName = lastNameInput;
        this.accountBalance = initialAmount;
    }


    public Double deposit(){
        this.accountBalance += 10;
        return this.accountBalance;
    }
    
    public Double deposit(Double amount){
        this.accountBalance += amount;
        return this.accountBalance;
    }

    //a getter to get the accountbalance
    public Double getAccountBalance(){
        return this.accountBalance;
    }

    //a setter allows us to modify privae variables
    public void setAccountBalance(Double newBalance){
        this.accountBalance = newBalance;
    }

    //who to send money to (which account)
    //the amount you want to send
    public void transferMoney(BankAccount otherAccount,Double amountToSend){
        //the object that called the transferMoney method is referred to with the keyword "this"
        this.accountBalance -= amountToSend;
        otherAccount.accountBalance += amountToSend;

    }

    public String displayAccountInfo(){
        return String.format("Account Balance: %g, First Name: %s , Last Name: %s", this.accountBalance, this.firstName, this.lastName);
        // return "Account Balance: " + this.accountBalance + " First Name: " + this.firstName;
    }



}
