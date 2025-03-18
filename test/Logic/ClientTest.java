package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client client;
    private AccommodationBooking booking;
    private Accommodation accommodation;
    private BookingsList allBookings;
    @BeforeEach
    void setUp() {
        Calendar  date1 = new GregorianCalendar();
        Calendar  date2 = new GregorianCalendar();
        date1.set(2022,1,20);
        date2.set(2022,1,25);
        allBookings = new BookingsList();
        client = new Client("Dimitris","games345","dim@gmail.com");
        accommodation = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
        booking = new AccommodationBooking(accommodation,date1,date2);
        allBookings.addBooking(booking);
    }

    @Test
    void getBookings() {
        client.bookAccommodation(booking);
        ArrayList<AccommodationBooking> expected = new ArrayList<>();
        expected.add(booking);
        ArrayList<AccommodationBooking> result = client.getBookings();
        assertEquals(expected,result);
    }

    @Test
    void getCancellations() {
        client.bookAccommodation(booking);
        client.cancelBooking(1222,allBookings);
        ArrayList<AccommodationBooking> expected = new ArrayList<>();
        expected.add(booking);
        ArrayList<AccommodationBooking> result = client.getCancellations();
        assertEquals(expected,result);
    }

    @Test
    void bookAccommodation() {
        boolean result = client.bookAccommodation(booking);
        assertTrue(result);
    }

    @Test
    void cancelBooking() {
        client.bookAccommodation(booking);
        Accommodation accommodation = new HotelRoom(2341,"25","30","Thessaloniki",3,3,3);
        Calendar date3 = new GregorianCalendar();
        Calendar date4 = new GregorianCalendar();
        date3.set(2022,1,15);
        date4.set(2022,1,18);
        AccommodationBooking accommodationBooking = new AccommodationBooking(accommodation,date3,date4);
        client.bookAccommodation(accommodationBooking);
        ArrayList<AccommodationBooking> expected = new ArrayList<>();
        expected.add(accommodationBooking);
        client.cancelBooking(1222,allBookings);
        ArrayList<AccommodationBooking> result = client.getBookings();
        assertEquals(expected,result);
    }

    @Test
    void checkAccommodationCriteria1() {
        boolean result = client.checkAccommodationCriteria(50,"Thessaloniki","Apartment",4,accommodation);
        assertTrue(result);
    }

    @Test
    void checkAccommodationCriteria2() {
        Accommodation accommodation1 = new Apartment(3245,"15","25","Athens",2,2,2);
        Calendar date5 = new GregorianCalendar();
        Calendar date6 = new GregorianCalendar();
        date5.set(2022,1,10);
        date6.set(2022,1,14);
        AccommodationBooking accommodationBooking = new AccommodationBooking(accommodation,date5,date6);
        allBookings.addBooking(accommodationBooking);
        boolean result = client.checkAccommodationCriteria(20,"Athens","Apartment",2,accommodation1);
        assertTrue(result);
    }
}