
public class BankAccountTest {

    public static void main(String[] args){
        BankAccount jeffBezosAccount = new BankAccount("Jeff", "Bezos");
        BankAccount LilWayneAccount = new BankAccount("Wayne", "Carter");
        BankAccount jcoleAccount = new BankAccount("Jermaine", "Cole");
        BankAccount untitledBankAccount = new BankAccount();
        BankAccount bobMarleyAccount = new BankAccount("Bob", "Marley", 420.00);

        System.out.println(jeffBezosAccount.getAccountBalance());
        jeffBezosAccount.deposit(10000000.00);
        System.out.println(jeffBezosAccount.getAccountBalance());
        System.out.println(jcoleAccount.getAccountBalance());

        jcoleAccount.deposit();
        System.out.println(jcoleAccount.getAccountBalance());
        jcoleAccount.deposit(500.00);
        System.out.println(jcoleAccount.getAccountBalance());
        jeffBezosAccount.transferMoney(jcoleAccount, 500000.00);
        System.out.println("J cole has this much after jeff bezos transferred mula " + jcoleAccount.getAccountBalance());

        System.out.println(jeffBezosAccount.displayAccountInfo());

        System.out.println(untitledBankAccount.displayAccountInfo());
        System.out.println(bobMarleyAccount.displayAccountInfo());





    
        
    }
    
}
