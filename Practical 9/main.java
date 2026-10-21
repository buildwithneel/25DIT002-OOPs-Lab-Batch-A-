class CounterRace {
    static class Counter {
        int count = 0;

        void incrementWithoutSync() {
            count++;
        }

        synchronized void incrementWithSync() {
            count++;
        }
    }

    static class MyThread extends Thread {
        Counter counter;
        boolean useSync;

        MyThread(Counter counter, boolean useSync) {
            this.counter = counter;
            this.useSync = useSync;
        }

        public void run() {
            for (int i = 0; i < 100000; i++) {
                if (useSync) {
                    counter.incrementWithSync();
                } else {
                    counter.incrementWithoutSync();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 5;
        int incrementsPerThread = 100000;
        int expectedValue = numberOfThreads * incrementsPerThread;

        Counter counter1 = new Counter();
        Thread[] threads1 = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i] = new MyThread(counter1, false);
            threads1[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i].join();
        }

        System.out.println("Without synchronized:");
        System.out.println("Expected count = " + expectedValue);
        System.out.println("Actual count   = " + counter1.count);

        Counter counter2 = new Counter();
        Thread[] threads2 = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i] = new MyThread(counter2, true);
            threads2[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i].join();
        }

        System.out.println("\nWith synchronized:");
        System.out.println("Expected count = " + expectedValue);
        System.out.println("Actual count   = " + counter2.count);
    }
}
