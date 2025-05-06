//Flight Booking Manager (Queue, Map)
//
//        Use a Queue for booking requests and a Map for confirmed bookings.
//
//        Process bookings FIFO and update map with seat numbers.

package javaCollectionFramework.Assignment13;
import java.util.*;

class BookingRequest {
    private final String passengerName;

    public BookingRequest(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerName() {
        return passengerName;
    }
}

public class FlightBookingManager {
    private final Queue<BookingRequest> bookingQueue = new LinkedList<>();
    private final Map<String, Integer> confirmedBookings = new HashMap<>();
    private int nextSeatNumber = 1;

    // Add a booking request to the queue
    public void addBookingRequest(String passengerName) {
        bookingQueue.add(new BookingRequest(passengerName));
        System.out.println("Booking request added for: " + passengerName);
    }

    // Process all booking requests in FIFO order
    public void processBookings() {
        while (!bookingQueue.isEmpty()) {
            BookingRequest request = bookingQueue.poll();
            confirmedBookings.put(request.getPassengerName(), nextSeatNumber);
            System.out.println("Confirmed booking for " + request.getPassengerName() +
                    " with Seat No: " + nextSeatNumber);
            nextSeatNumber++;
        }
    }

    // Print confirmed bookings
    public void printConfirmedBookings() {
        System.out.println("\nConfirmed Bookings:");
        for (Map.Entry<String, Integer> entry : confirmedBookings.entrySet()) {
            System.out.println(entry.getKey() + " -> Seat No: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        FlightBookingManager manager = new FlightBookingManager();

        // Simulated booking requests
        manager.addBookingRequest("Alice");
        manager.addBookingRequest("Bob");
        manager.addBookingRequest("Charlie");

        // Process requests
        manager.processBookings();

        // Print confirmed bookings
        manager.printConfirmedBookings();
    }
}
