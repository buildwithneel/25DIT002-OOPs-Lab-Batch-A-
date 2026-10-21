@FunctionalInterface
interface Notifier {
   void send(String message);
}
interface Urgent
{
}
class EmailNotifier implements Notifier, Urgent
{
   @Override
   public void send(String msg) {
       System.out.println("Sending Email: " + msg);
   }
}
public class Main1{
   public static void main(String[] args) {
       Notifier smsNotifier = msg -> System.out.println("Sending SMS: " + msg); 
       Notifier emailNotifier = new EmailNotifier();
       Notifier pushNotifier = msg -> System.out.println("Sending Push: " + msg);
       Notifier[] notifiers = { emailNotifier, smsNotifier, pushNotifier };
       String alert = "Server downtime scheduled at midnight.";
       for (Notifier notifier : notifiers) {
           notifier.send(alert);
           if (notifier instanceof Urgent) {
               notifier.send(alert);
           }
       }
   }
}
 
 