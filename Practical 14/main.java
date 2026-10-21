import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskService service = new TaskService();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Show Count");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            try {
                service.performAction(ch);

                if (ch == 1) {
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    service.addTask(name);
                    System.out.println("Task added");
                } else if (ch == 2) {
                    System.out.println("Total tasks: " + service.getCount());
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}