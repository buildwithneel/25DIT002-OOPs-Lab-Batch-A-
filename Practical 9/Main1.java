class SeatBookingRace extends Thread {
    static int seatsLeft = 5;
    static int success = 0;
    boolean useSync;

    SeatBookingRace(boolean useSync) {
        this.useSync = useSync;
    }

    void bookWithoutSync() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }

            seatsLeft--;
            success++;
            System.out.println("Seat booked");
        } else {
            System.out.println("No seat available");
        }
    }

    static synchronized void bookWithSync() {
        if (seatsLeft > 0) {
            seatsLeft--;
            success++;
            System.out.println("Seat booked");
        } else {
            System.out.println("No seat available");
        }
    }

    public void run() {
        if (useSync) {
            bookWithSync();
        } else {
            bookWithoutSync();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("WITHOUT SYNCHRONIZATION");

        seatsLeft = 5;
        success = 0;

        SeatBookingRace[] t1 = new SeatBookingRace[10];

        for (int i = 0; i < 10; i++) {
            t1[i] = new SeatBookingRace(false);
            t1[i].start();
        }

        for (int i = 0; i < 10; i++) {
            t1[i].join();
        }

        System.out.println("Successful bookings = " + success);
        System.out.println("Seats left = " + seatsLeft);

        System.out.println("\nWITH SYNCHRONIZATION");

        seatsLeft = 5;
        success = 0;

        SeatBookingRace[] t2 = new SeatBookingRace[10];

        for (int i = 0; i < 10; i++) {
            t2[i] = new SeatBookingRace(true);
            t2[i].start();
        }

        for (int i = 0; i < 10; i++) {
            t2[i].join();
        }

        System.out.println("Successful bookings = " + success);
        System.out.println("Seats left = " + seatsLeft);
    }
}

