import java.util.Scanner;

record BankInfo(String name, String branch) {}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class Minibank {

    public static void main(String[] args) {

        BankInfo bank = new BankInfo("MiniBank", "Vadodara");
        System.out.println(bank);

        Account account1 = new Account("Rahul", 5000);
        Account account2 = new Account("Neel", 3000);

        System.out.println("\nAccount Details");
        System.out.println(account1.toString());
        System.out.println(account2.toString());

        System.out.println("\nEquals Test");
        System.out.println("account1 equals account2: " + account1.equals(account2));

        Account account3 = account1;

        System.out.println("account1 equals account3: " + account1.equals(account3));

        System.out.println("\ninstanceof Test");

        Object obj = account1;

        if (obj instanceof Account) {
            System.out.println("Object is an Account");
        }

        Customer.Address address =
                new Customer.Address(
                        "123 Main Road",
                        "Vadodara",
                        "390001"
                );

        Customer customer =
                new Customer(
                        "Vaidehi",
                        "vaidehi@gmail.com",
                        "1234567890",
                        address
                );

        Customer clonedCustomer = customer.clone();

        System.out.println("\nCustomer Address");
        System.out.println("Line: " + customer.getAddress().getLine());
        System.out.println("City: " + customer.getAddress().getCity());
        System.out.println("Pincode: " + customer.getAddress().getPincode());

        System.out.println("\nCustomer Clone");
        System.out.println("Original Customer: " + customer.getName());
        System.out.println("Cloned Customer: " + clonedCustomer.getName());

        Scanner s = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMINIBANK MENU");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = s.nextInt();

            MenuOption option;

            switch (choice) {
                case 1:
                    option = MenuOption.OPEN_ACCOUNT;
                    break;
                case 2:
                    option = MenuOption.DEPOSIT;
                    break;
                case 3:
                    option = MenuOption.WITHDRAW;
                    break;
                case 4:
                    option = MenuOption.TRANSFER;
                    break;
                case 5:
                    option = MenuOption.EXIT;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

            String message = switch (option) {
                case OPEN_ACCOUNT -> "Open Account - to be implemented in a later lab.";
                case DEPOSIT -> "Deposit - to be implemented in a later lab.";
                case WITHDRAW -> "Withdraw - to be implemented in a later lab.";
                case TRANSFER -> "Transfer - to be implemented in a later lab.";
                case EXIT -> "Exit";
            };

            System.out.println(message);

        } while (choice != 5);

        System.out.println("Goodbye!");
        s.close();
    }
}