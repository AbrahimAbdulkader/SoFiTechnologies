import java.util.Scanner;
public class Account {


    //Class Variables
    int balance;
    int previousTransactions;
    String customerName;
    String customerID;


    //Class Constructor
    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    //Function for Depositing Money
    public void deposit(int amount) {
        if(amount != 0) { //If are amount is a valid number (above 0)...
            balance = balance + amount;  //We'll add the amount to the balance and store it in the class variable 'balance'
            previousTransactions = amount; //We set our previous transaction to the amount for each time we make a deposit
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    //Function for Withdrawing money
    public void withdraw(int amount) {
        if(amount != 0) { //If are amount is a valid number (above 0)...
            balance = balance - amount; //We'll subtract the amount from the balance and store it in the class variable 'balance'
            previousTransactions = -amount; //For our previous transaction, when we withdrawing, we want the UI to show us a negative number, hence the '-amount'.
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    //Function showing the previous transaction
    public void getPreviousTransaction() {

        if(previousTransactions > 0) { //Means that we've made a deposit
            System.out.println("Deposited: " + previousTransactions);
        }
        else if(previousTransactions < 0) { //Means that we've withdrawn in our previous transaction
            System.out.println("Withdrawn: " + Math.abs(previousTransactions));
        }
        else {
            System.out.println("No transaction occured");
        }
    }


    //Function calculating the interest of our current funds after a number of years
    public void calculateInterest(int years) {
        double interestRate = 0.1954;
        double newBalance = (balance * interestRate * years) + balance; //Formula used to calculate new balance given our interest rate and the years inputted
        System.out.println("The current interest rate is " + (100 * interestRate) + "%"); //Formula used to calculate the interest rate
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Function showing the main menue
    public void showMenu() {
        char option = '\0';
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to SoFiTechnologies, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transactions");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do { //Basically execute through this code while...
            System.out.println();
            System.out.println("Enter an option:");
            char option1 = scnr.next().charAt(0); //Only takes in the first character no matter what
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("================================");
                    System.out.println();
                    break;

                //Case 'B' allows the user to deposit money into their account
                case 'B':
                    System.out.println("Enter an amount to deposit");
                    int amount = scnr.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;


                //Case 'C' allows the user to withdraw money from their account
                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = scnr.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;


                //Allows the user to view their most recent transaction
                case 'D':
                    System.out.println("================================");
                    getPreviousTransaction();
                    System.out.println("================================");
                    break;

                //Calculates the accrued interest on the account
                case 'E':
                    System.out.println("Enter how many years of accrued interst: ");
                    int years = scnr.nextInt();
                    calculateInterest(years);
                    break;


                //Case 'F' exits the user from their account
                case 'F':
                    System.out.println("================================");
                    break;


                //The default case let's users know that they entered an invalid character
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E");
                    break;
            }
        }


            while (option != 'F') ;
            System.out.println("Thank you for banking with SoFiTechnologies, we hope to see you again");

} }
