package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccommodationsListTest {

    private AccommodationsList accommodationsList;
    private  Apartment acc1 ;
    private HotelRoom acc2 ;
    private Maisonette acc3;
    @BeforeEach
    void setUp() {
        accommodationsList = new AccommodationsList();
        acc1 = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
        acc2 = new HotelRoom(2341,"25","30","Thessaloniki",3,3,3);
        acc3 = new Maisonette(2423,"200","120","Thessaloniki",6,true,8,2);
        accommodationsList.addAccommodation(acc1);
        accommodationsList.addAccommodation(acc2);
        accommodationsList.addAccommodation(acc3);
    }

    @Test
    void getAccommodationsList() {
        ArrayList<Accommodation> result = accommodationsList.getAccommodationsList();
        ArrayList<Accommodation> expected = new ArrayList<>();
        expected.add(acc1);
        expected.add(acc2);
        expected.add(acc3);
        assertEquals(expected,result);
    }

    @Test
    void addAccommodation() {
        Apartment acc4 = new Apartment(1262,"50","80","Thessaloniki",4,5,5);
        boolean result = accommodationsList.addAccommodation(acc4);
        assertTrue(result);
    }

    @Test
    void setAccommodationsList() {
        ArrayList<Accommodation> accommodations1 = new ArrayList<>();
        ArrayList<Accommodation> accommodations2 = new ArrayList<>();
        accommodationsList.setAccommodationsList(accommodations1);
        assertEquals(accommodationsList.getAccommodationsList(),accommodations2);

    }

    @Test
    void findAccommodation() {
        Accommodation expected = acc1;
        Accommodation result = accommodationsList.findAccommodation(1222);
        assertEquals(expected,result);
    }
}