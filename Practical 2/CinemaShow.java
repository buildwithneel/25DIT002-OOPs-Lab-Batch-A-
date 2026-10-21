public class Cinemashow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;
    public Cinemashow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;}
    public Cinemashow(String title) {
        this(title, 100);}
    public boolean book(int n) {
        if (n <= 0 || n > seatsAvailable) {
            return false;}

        seatsAvailable -= n;
        totalBooked += n;
        return true;
    }

    public boolean cancel(int n) {
        if (n <= 0 || n > capacity - seatsAvailable) {
            return false;
        }

        seatsAvailable += n;
        totalBooked -= n;
        return true;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTitle() {
        return title;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {
        Cinemashow show1 = new Cinemashow("Avengers", 150);
        Cinemashow show2 = new Cinemashow("Interstellar");

        System.out.println(show1.getTitle());
        System.out.println(show1.getSeatsAvailable());

        System.out.println(show1.book(50));
        System.out.println(show1.getSeatsAvailable());

        System.out.println(show2.getTitle());
        System.out.println(show2.getSeatsAvailable());

        System.out.println(show2.book(30));
        System.out.println(show2.getSeatsAvailable());

        System.out.println(show1.cancel(10));
        System.out.println(show1.getSeatsAvailable());

        System.out.println(Cinemashow.getTotalBooked());
    }
}