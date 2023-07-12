import java.util.*;

class atm {
    public static void main(String args[]) {

        int balance = 50000;
        int withdraw, deposit, transfer ;
        long num;

        Scanner sc = new Scanner(System.in);
        List<String> transactionHistory = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to MY ATM... ");
            System.out.println("Select 1 for Withdraw");
            System.out.println("Select 2 for Deposit");
            System.out.println("Select 3 for Transfer");
            System.out.println("Select 4 for Check Balance");
            System.out.println("Select 5 for Transaction History");
            System.out.println("Select 6 for Quit");
            System.out.print("Select the appropriate option you want to perform: ");

            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.print("Enter the amount to be withdrawn: ");
                    withdraw = sc.nextInt();
                    balance = withdraw(balance, withdraw);
                    transactionHistory.add("Withdrawal: -" + withdraw);
                    break;
                case 2:
                    System.out.print("Enter the amount to be deposited: ");
                    deposit = sc.nextInt();
                    balance = deposit(balance, deposit);
                    transactionHistory.add("Deposit: +" + deposit);
                    break;
                case 3:
                    System.out.print("Enter the account number to be transferred: ");
                    num=sc.nextLong();
                    System.out.print("Enter the amount to be transferred: ");
                    transfer = sc.nextInt();
                    balance = transfer(balance, transfer ,num);
                    transactionHistory.add("Transfer: -" + transfer);
                    break;
                case 4:
                    printBalance(balance);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Transaction History:");
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        int startIndex = Math.max(transactionHistory.size() - 3, 0);
                        for (int i = startIndex; i < transactionHistory.size(); i++) {
                            System.out.println(transactionHistory.get(i));
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Thanks For Visiting MY ATM");
                    System.exit(0);
            }
        }
    }

    public static void printBalance(int balance) {
        System.out.println("The Current Balance: " + balance);
        System.out.println();
    }

    public static int withdraw(int balance, int withdrawAmount) {
        System.out.println("Withdrawal Operation:");
        System.out.println("The withdrawal Amount is: " + withdrawAmount);
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            System.out.println("Please collect your money and remove the card");
            printBalance(balance);
        } else {
            System.out.println("Sorry! The balance is insufficient.");
            System.out.println();
        }
        return balance;
    }

    public static int transfer(int balance, int transferAmount ,long num) {
        System.out.println("Transfer Operation:");
        System.out.println("The Transfer Account Number is: " + num);
        System.out.println("The Transfer Amount is: " + transferAmount);
        
        if (balance >= transferAmount) {
            balance -= transferAmount;
            System.out.println("Your transaction is successful. Thanks for using MY ATM");
            printBalance(balance);
        } else {
            System.out.println("Sorry! The balance is insufficient.");
            System.out.println();
        }
        return balance;
    }

    public static int deposit(int balance, int depositAmount) {
        System.out.println("Deposit Operation:");
        System.out.println("The deposit amount is: " + depositAmount);
        balance += depositAmount;
        System.out.println("Your money has been successfully deposited");
        printBalance(balance);
        return balance;
    }
}
