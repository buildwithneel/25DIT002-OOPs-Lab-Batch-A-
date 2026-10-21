import java.util.ArrayList;

public class TaskService {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task name");
        }
        tasks.add(new Task(name));
    }

    public int getCount() {
        return tasks.size();
    }

    public void performAction(int action) {
        if (action < 1 || action > 3) {
            throw new IllegalArgumentException("Invalid action");
        }
    }
}