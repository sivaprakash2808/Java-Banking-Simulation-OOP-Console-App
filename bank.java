package pkg2;
import java.util.Scanner;

class Account {
    private String password;
    private double balance;

    public void setPwd(String password) {
        this.password = password;
    }

    public void setBal(double balance) {
        this.balance = balance;
    }

    public String getPwd() {
        return password;
    }

    public double getBal() {
        return balance;
    }

    void deposit(double deposit) {
        if (deposit > 0) {
            balance += deposit;
            System.out.println("Your Deposit Amount Is: " + deposit);
        } else {
            System.out.println("Enter Valid Amount!");
        }
    }

    void withdraw(double withdraw) {
        if (withdraw <= balance) {
            balance -= withdraw;
            System.out.println("Your Withdrawal Amount Is: " + withdraw);
        } else {
            System.out.println("SORRY! You don’t have enough balance!");
        }
    }

    void checkBal() {
        System.out.println("Your Balance Is: " + balance);
    }
}

class Bank {
    public static void main(String args[]) {
        Account obj = new Account();
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String name = scan.nextLine();

        System.out.print("Set Your Password: ");
        obj.setPwd(scan.nextLine());

        System.out.print("Enter Initial Balance: ");
        obj.setBal(scan.nextDouble());

        System.out.println("\nHi " + name + "!");
        System.out.println("Welcome To Our Bank Simulation!!!");

        int choice;
        double deposit, withdraw;

        do {
            System.out.println("\n-------------------------------");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Your Deposit Amount: ");
                    deposit = scan.nextDouble();
                    obj.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter Your Withdraw Amount: ");
                    withdraw = scan.nextDouble();
                    obj.withdraw(withdraw);
                    break;

                case 3:
                    obj.checkBal();
                    break;

                case 4:
                    System.out.println("Thank You For Using Our Bank! Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 4);

        scan.close();
    }
}
