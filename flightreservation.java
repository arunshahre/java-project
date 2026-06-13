import java.util.Scanner;
// Passenger.java
class Passenger {
    private String name;
    private int id;

    public Passenger(String name,int id){
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
    public boolean bookSeat(Passenger p) {
        for (Passenger seat : seats) {
            if (seat != null && seat.getId() == p.getId()) {
                System.out.println("Booking failed! Passenger "+p.getName()+"already booked.");
                return false;
            }
        }
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] == null) {
                seats[i] = p;
                System.out.println("Passenger " + p.getName() + " booked successfully.");
                return true;
            }
        }
        System.out.println("Flight Full! Booking failed for Passenger: " + p.getName());
        return false;
    }

    // Display seat status
    public void displaySeats() {
        System.out.println("\nSeat Status:");
        for (int i = 0; i < MAX_SEATS; i++) {
            if (seats[i] != null) {
                System.out.println("Seat " + (i + 1) + ": " + seats[i].getName());
            } else {
                System.out.println("Seat " + (i + 1) + ": Empty");
            }
        }
    }
}

// Main class
public class flightreservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats in flight: ");
        int capacity = sc.nextInt();
        Flight flight = new Flight(capacity);

        // Input passengers
        System.out.print("Enter number of passengers to book: ");
        int numPassengers = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numPassengers; i++) {
            System.out.print("\nEnter Passenger Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Passenger ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Passenger p = new Passenger(name, id);
            flight.bookSeat(p);
        }

        // Display final seat status
        flight.displaySeats();
        sc.close();
    }
}
