interface Switchable 
{
   void on();
   void off();
   default void toggle() 
   { 
      on(); 
   }
}
@FunctionalInterface
interface PowerRule
{
   boolean canTurnOn(Switchable device, int hour);
}
class Fan implements Switchable {
   public void on() { 
      System.out.println("Fan ON"); 
   }
   public void off() { 
      System.out.println("Fan OFF"); 
   }
}
class Light implements Switchable {
   public void on() { 
      System.out.println("Light ON"); 
   }
   public void off() { 
      System.out.println("Light OFF"); 
   }
}
public class Main {
   public static void main(String[] args) {
       Switchable[] devices = { 
         new Fan(), 
         new Light() 
      };
      for (Switchable s : devices) 
      {
         s.toggle(); 
      }
       PowerRule nightRule = new PowerRule() {
           public boolean canTurnOn(Switchable device, int hour) {
               return hour >= 18 && hour <= 23;
           }
       };
        PowerRule dayRule = (device, hour) -> hour >= 6 && hour < 18;
        System.out.println("Night rule (20h): " + nightRule.canTurnOn(devices[0], 20));
        System.out.println("Day rule (20h): " + dayRule.canTurnOn(devices[1], 20));
   }
}