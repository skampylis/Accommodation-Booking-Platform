package Logic;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * This class represents the Logic.AccommodationBooking. From this class it will be created the entity of the
 * Logic.AccommodationBooking, which represents the bookings of specific accommodations.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class AccommodationBooking implements Serializable {

    /**
     * the object that represents a booked accommodation
     */
    private final Accommodation bookedAccommodation;

    /**
     * the object that represents the date that the booking has been made from
     */
    private final Calendar dateFrom;

    /**
     * the object that represents the date that the booking has been made until
     */
    private final Calendar dateUntil;

    /**
     * Constructor of the class Logic.AccommodationBooking, that accepts three parameters of objects (bookedAccommodation,
     * dateFrom and dateUntil) and initialize the objects of the class in the right values.
     *
     * @param bookedAccommodation the object that represents a booked accommodation
     * @param dateFrom the object that represents the date that the booking has been made from
     * @param dateUntil the object that represents the date that the booking has been made until
     */
    public AccommodationBooking(Accommodation bookedAccommodation, Calendar dateFrom, Calendar dateUntil) {
        this.bookedAccommodation = bookedAccommodation;
        this.dateFrom = dateFrom;
        this.dateUntil = dateUntil;
    }

    /**
     * Method that gives access to the private final object bookedAccommodation.
     *
     * @return the private final object bookedAccommodation
     */
    public Accommodation getBookedAccommodation() {
        return bookedAccommodation;
    }

    /**
     * Method that gives access to the private final object dateFrom.
     *
     * @return the private final object dateFrom
     */
    public Calendar getDateFrom() {
        return dateFrom;
    }

    /**
     * Method that gives access to the private final object dateUntil.
     *
     * @return the private final object dateUntil
     */
    public Calendar getDateUntil() {
        return dateUntil;
    }

    /**
     * Method that gets the date for the booking of specific accommodations. It accepts two parameters of objects (date1
     * and date2) and returns the difference in time between the two dates.
     *
     * @param date1 the object of the date which the booking starts
     * @param date2 the object of the date which the booking ends
     * @return the difference in time between the two dates
     */
    public long getDatesDifferenceInDays(Calendar date1,Calendar date2) {
        Date date_1 = date1.getTime();
        long date1InMs = date_1.getTime();
        Date date_2 = date2.getTime();
        long date2InMs = date_2.getTime();
        long differenceInTime = Math.abs(date1InMs - date2InMs);
        return  (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
    }

    /**
     * Method that gets the price of specific booked accommodations. It accepts one parameter of object (accommodation) and
     * returns the price per night from the number of dates the booking is active.
     *
     * @param accommodation the object of the accommodation
     * @return the price per night from the number of dates the booking is active
     */
    public double getPriceOfBookedAccommodation(Accommodation accommodation) {
        return this.getDatesDifferenceInDays(this.dateFrom,this.dateUntil) * Double.parseDouble(accommodation.getPricePerNight());
    }

}
