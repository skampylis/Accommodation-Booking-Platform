package Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a List with All the Reserved Accommodations of the platform. From this class it will be created
 * the entity of the list with all the reserved accommodations that have been reserved from a client in the platform, and
 * they cannot been reserved from another client.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class BookingsList implements Serializable {

    /**
     * list with all the reserved accommodations that have been reserved from the clients in the platform
     */
    private final ArrayList<AccommodationBooking> accommodationBookings;

    /**
     * Constructor of the list with all the reserved accommodations that have been reserved from a client in the platform.
     */
    public BookingsList() {
        this.accommodationBookings = new ArrayList<>();
    }

    /**
     * Method that gives access to specific reserved accommodations that have been reserved from a client in the platform.
     *
     * @return a specific reserved accommodation that has been reserved from a client in the platform
     */
    public ArrayList<AccommodationBooking> getBookings() {
        return accommodationBookings;
    }

    /**
     * Method that adds a booking accommodation to the list of booking accommodations.
     *
     * @param accommodationBooking the booking that will be added to the list
     * @return if the booking has been added to the list returns true, else returns false
     */
    public boolean addBooking(AccommodationBooking accommodationBooking) {
       return accommodationBookings.add(accommodationBooking);
    }

    /**
     * Method that checks the dates in booking list, which prevents two bookings of a specific accommodation been made
     * in the same date.
     *
     * @param booking the booking that the client is trying to do
     * @return if the dates of the booking that the client has been reserved has not been int booking list returns true,
     * else returns false
     */
    public boolean checkDatesInBookingsList(AccommodationBooking booking) {
        for (AccommodationBooking acc : accommodationBookings) {
            if ((booking.getDateFrom().before(acc.getDateUntil()) && booking.getDateUntil().after(acc.getDateFrom())) ||
                (booking.getDateFrom().before(acc.getDateFrom()) && booking.getDateUntil().after(acc.getDateFrom())) ||
                (booking.getDateFrom().after(acc.getDateFrom()) && booking.getDateUntil().before(acc.getDateUntil()))) {
                return false;
            }
        }
        return true;
    }

}
