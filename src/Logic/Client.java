package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the user Logic.Client, that inherits from the class Logic.User. From this class it will be created
 * the entity of the Logic.Client, which represents the Client.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class Client extends User implements Serializable {

    /**
     * the reserved accommodations that have been booked by the specific client
     */
    private final BookingsList bookings;

    /**
     * the reserved accommodations that have been canceled by the specific client
     */
    private final BookingsList cancellations;

    /**
     * Constructor of the class Logic.Client that accepts three parameters (name, password and address) and sets the two
     * lists (bookings, cancellations).
     *
     * @param name the username of the client in the app
     * @param password the password of the client in the app
     * @param address the email of the client
     */
    public Client(String name,String password,String address) {
        super(name,password,address);
        super.setNumber(2);
        this.bookings = new BookingsList();
        this.cancellations = new BookingsList();
    }

    /**
     * Method that gives access to the tab with the basic profile data of the user client and returns the reserved accommodations
     * that have been booked by the specific client.
     *
     * @return the reserved accommodations that have been booked by the specific client
     */
    public ArrayList<AccommodationBooking> getBookings() {
       return this.bookings.getBookings();
    }

    /**
     * Method that gives access to the tab with the basic profile data of the user client and returns the reserved accommodations
     * that have been canceled by the specific client.
     *
     * @return the reserved accommodations that have been canceled by the specific client.
     */
    public ArrayList<AccommodationBooking> getCancellations() {
        return this.cancellations.getBookings();
    }

    /**
     * Method that adds a booking to the bookings list of the client.
     *
     * @param accommodationBooking the booking the client wants to make
     * @return true if the booking done correctly, else return false
     */
    public boolean bookAccommodation(AccommodationBooking accommodationBooking) {
        return bookings.addBooking(accommodationBooking);
    }

    /**
     * Method that cancels a booking from the bookings list of the client.
     *
     * @param code the codename of the accommodation to be booked
     * @param allBookings the list with all the bookings that have been made
     */
    public void cancelBooking(int code,BookingsList allBookings) {
        Iterator<AccommodationBooking> it1 = this.getBookings().iterator();
        Iterator<AccommodationBooking> it2 = allBookings.getBookings().iterator();
        while (it1.hasNext()) {
            AccommodationBooking accommodationBooking = it1.next();
            if(accommodationBooking.getBookedAccommodation().getCode() == code) {
                it1.remove();
                this.getCancellations().add(accommodationBooking);
            }
        }
        while(it2.hasNext()) {
            AccommodationBooking accommodationBooking = it2.next();
            if (accommodationBooking.getBookedAccommodation().getCode() == code) {
                it2.remove();
            }
        }
    }

    /**
     * Method that checks if the criteria that the client sets for the booking are valid and can be happened.
     *
     * @param maxPrice the price that the client gives to find the booking
     * @param location the location of the accommodation that the client is interested
     * @param type the type of the accommodation (Apartment, HotelRoom and Maisonette) that the client is interested
     * @param numberOfPeople the number of people that the client wants to make the booking
     * @param accommodation the accommodation that the client is interested
     * @return true if the criteria can be satisfied or false if they cannot be satisfied to make a booking
     */
    public boolean checkAccommodationCriteria(double maxPrice,String location,String type,int numberOfPeople,Accommodation accommodation) {
        return maxPrice >= Double.parseDouble(accommodation.getPricePerNight()) && location.equals(accommodation.getSeat()) && type.equals(accommodation.getType()) && numberOfPeople <= accommodation.getBeds();
    }

}
