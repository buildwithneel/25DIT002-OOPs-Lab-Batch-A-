import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    int id;

    Task(int id) {
        this.id = id;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println("Task " + id + " started by " + threadName);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }

        System.out.println("Task " + id + " finished by " + threadName);
    }
}

public class ThreadPoolRunner {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            pool.submit(new Task(i));
        }

        pool.shutdown();

        pool.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("All tasks completed");
    }
}
