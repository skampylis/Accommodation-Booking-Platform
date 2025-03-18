package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class AccommodationBookingTest {

    private AccommodationBooking booking;
    private Accommodation accommodation;
    private Calendar date1;
    private Calendar date2;
    @BeforeEach
    void setUp() {
        date1 = new GregorianCalendar();
        date2 = new GregorianCalendar();
        date1.set(2022,1,20);
        date2.set(2022,1,25);
        accommodation = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
        booking = new AccommodationBooking(accommodation,date1,date2);
    }

    @Test
    void getBookedAccommodation() {
        Accommodation result = booking.getBookedAccommodation();
        Accommodation expected = accommodation;
        assertEquals(expected,result);
    }

    @Test
    void getDateFrom() {
        Calendar result = booking.getDateFrom();
        Calendar expected = date1;
        assertEquals(expected,result);
    }

    @Test
    void getDateUntil() {
        Calendar result = booking.getDateUntil();
        Calendar expected = date2;
        assertEquals(expected,result);
    }

    @Test
    void getDatesDifferenceInDays() {
        long result = booking.getDatesDifferenceInDays(date1,date2);
        assertEquals(5,result);
    }

    @Test
    void getPriceOfBookedAccommodation() {
        double result = booking.getPriceOfBookedAccommodation(accommodation);
        assertEquals(250,result);
    }
}