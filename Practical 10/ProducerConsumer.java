class Buffer {
    int number;
    boolean available = false;

    synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        number = value;
        available = true;

        System.out.println("Produced: " + number);
        notify();
    }

    synchronized int consume() {
        while (!available) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        available = false;

        System.out.println("Consumed: " + number);
        notify();

        return number;
    }
}

class Producer extends Thread {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume();

            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws Exception {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("All items produced and consumed.");
    }
}
