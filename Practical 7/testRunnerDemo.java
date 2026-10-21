import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTestCase {
    @Run
    public void testLogin() {
        System.out.println("-> Executing: testLogin passed!");
    }

    public void normalHelperMethod() {
        System.out.println("-> Executing: normalHelperMethod (Should not see this!)");
    }

    @Run
    public void testLogout() {
        System.out.println("-> Executing: testLogout passed!");
    }
}

public class testRunnerDemo {
    public static void main(String[] args) {
        int passedCount = 0;
        MyTestCase testObj = new MyTestCase();
        Method[] methods = testObj.getClass().getDeclaredMethods();

        System.out.println("--- Starting Mini Test Runner ---");

        for (Method method : methods) {
            if (method.isAnnotationPresent(Run.class)) {
                try {
                    method.invoke(testObj);
                    passedCount++;
                } catch (Exception e) {
                    System.out.println("Error executing method: " + method.getName());
                }
            }
        }

        System.out.println();
        System.out.println("Total tests executed successfully: " + passedCount);
    }
}
