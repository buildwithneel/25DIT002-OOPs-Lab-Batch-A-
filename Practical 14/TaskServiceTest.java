import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskServiceTest {
    @Test
    public void testAddTask() {
        TaskService s = new TaskService();
        s.addTask("Study Java");
        assertEquals(1, s.getCount());
    }
    @Test
    public void testInvalidTask() {
        TaskService s = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> s.addTask(""));
    }
    @Test
    public void testInvalidAction() {
        TaskService s = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> s.performAction(5));
    }
}