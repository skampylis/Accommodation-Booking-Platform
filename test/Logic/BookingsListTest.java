package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class BookingsListTest {

    private BookingsList bookingsList;
    private AccommodationBooking booking1;
    private Accommodation accommodation1;
    private Calendar date5;
    private Calendar date6;
    @BeforeEach
    void setUp() {
        bookingsList = new BookingsList();
        Calendar date1 = new GregorianCalendar();
        Calendar date2 = new GregorianCalendar();
        date5 = new GregorianCalendar();
        date6 = new GregorianCalendar();
        date1.set(2022,1,20);
        date2.set(2022,1,25);
        accommodation1 = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
        booking1 = new AccommodationBooking(accommodation1, date1, date2);
    }

    @Test
    void getBookings() {
        ArrayList<AccommodationBooking> result = bookingsList.getBookings();
        ArrayList<AccommodationBooking> expected = new ArrayList<>();
        assertEquals(expected,result);
    }

    @Test
    void addBooking() {
        boolean result = bookingsList.addBooking(booking1);
        assertTrue(result);
    }

    @Test
    void checkDatesInBookingsList1() {
        Calendar date3 = new GregorianCalendar();
        Calendar date4 = new GregorianCalendar();
        date3.set(2022,1,18);
        date4.set(2022,1,22);
        AccommodationBooking booking2 = new AccommodationBooking(accommodation1,date3,date4);
        bookingsList.addBooking(booking1);
        boolean result = bookingsList.checkDatesInBookingsList(booking2);
        assertFalse(result);
    }

    @Test
    void checkDatesInBookingsList2() {
        date5 = new GregorianCalendar();
        date6 = new GregorianCalendar();
        date5.set(2022,1,11);
        date6.set(2022,1,15);
        bookingsList.addBooking(booking1);
        AccommodationBooking booking3 = new AccommodationBooking(accommodation1,date5,date6);
        boolean result = bookingsList.checkDatesInBookingsList(booking3);
        assertTrue(result);
    }
}