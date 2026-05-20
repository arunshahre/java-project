// Passenger.java
class Passenger {
    private String name;
    private int id;

    public Passenger(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
}
// Flight.java
class Flight {
    private final int MAX_SEATS;
    private Passenger[] seats;
    // Constructor
    public Flight(int capacity) {
        this.MAX_SEATS = capacity;
        seats = new Passenger[MAX_SEATS];
        System.out.println("Flight Created with " + MAX_SEATS + " seats.");
    }
    // Method to book seat
    public boolean bookSeat(Passenger p) {
        // Prevent duplicate booking
        for (Passenger seat : seats) {
            if (seat != null && seat.getId() == p.getId()) {
                System.out.println("Booking failed! Passenger " + p.getName() + " already booked.");
                return false;
            }
        }
        // Find first empty seat
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }
        // If no seats available
        System.out.println("Flight Full! Booking failed for Passenger: "+p.getName());
        return false;
    }
    // Display seat status
    public void displaySeats() {
        System.out.println("\nSeat Status:");
        for (int i=0;i<MAX_SEATS;i++) {
            if (seats[i]!=null) {
                System.out.println("Seat"+(i+1)+":"+seats[i].getName());
            } else {
                System.out.println("Seat "+(i+1)+":Empty");
            }
        }
      }
}
public class flightreservation {
    public static void main(String[] args) {
        // Create flight with 5 seats
        Flight flight = new Flight(5);

        // Create passengers
        Passenger p1 = new Passenger("Aman",101);
        Passenger p2 = new Passenger("Rahul",102);
        Passenger p3 = new Passenger("Riya",103);

        // Book seats
        flight.bookSeat(p1);
        flight.bookSeat(p2);
        flight.bookSeat(p3);
        flight.bookSeat(p1);
        flight.displaySeats();
    }
}
