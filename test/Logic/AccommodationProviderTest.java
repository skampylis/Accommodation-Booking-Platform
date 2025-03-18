package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccommodationProviderTest {

    private AccommodationProvider accommodationProvider;
    private  Apartment acc1 ;
    private HotelRoom acc2 ;
    private Maisonette acc3;
    private AccommodationsList accommodationsList;
    @BeforeEach
    void setUp() {
        accommodationProvider = new AccommodationProvider("Haris","password","@gmail.com","Athens");
        acc1 = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
        acc2 = new HotelRoom(2341,"25","30","Thessaloniki",3,3,3);
        acc3 = new Maisonette(2423,"200","120","Thessaloniki",6,true,8,2);
        accommodationProvider.addNewAccommodation(acc1);
        accommodationProvider.addNewAccommodation(acc2);
        accommodationProvider.addNewAccommodation(acc3);
        accommodationsList = new AccommodationsList();
        accommodationsList.addAccommodation(acc1);
        accommodationsList.addAccommodation(acc2);
        accommodationsList.addAccommodation(acc3);
    }

    @Test
    void addNewAccommodation1() {
        Apartment acc4 = new Apartment(1262,"50","80","Thessaloniki",4,5,5);
        boolean result = accommodationProvider.addNewAccommodation(acc4);
        assertTrue(result);
    }

    @Test
    void addNewAccommodation2() {
        HotelRoom acc2 = new HotelRoom(7321,"25","30","Thessaloniki",3,3,3);
        boolean result = accommodationProvider.addNewAccommodation(acc2);
        assertTrue(result);
    }

    @Test
    void addNewAccommodation3() {
        Maisonette acc3 = new Maisonette(2633,"200","120","Thessaloniki",6,true,8,2);
        boolean result = accommodationProvider.addNewAccommodation(acc3);
        assertTrue(result);
    }

    @Test
    void getSeat() {
        String result = accommodationProvider.getSeat();
        assertEquals("Athens",result);
    }

    @Test
    void removeAccommodation() {
        ArrayList<Accommodation> expected = new ArrayList<>();
        expected.add(acc2);
        expected.add(acc3);
        accommodationProvider.removeAccommodation(1222,accommodationsList);
        ArrayList<Accommodation> result = accommodationProvider.getAccommodationList();
        assertEquals(expected,result);
    }

    @Test
    void getAccommodationList() {
        ArrayList<Accommodation> expected = new ArrayList<>();
        expected.add(acc1);
        expected.add(acc2);
        expected.add(acc3);
        assertEquals(expected,accommodationProvider.getAccommodationList());
    }

    @Test
    void setAccommodationList() {
        AccommodationsList accommodationsList1 = new AccommodationsList();
        accommodationProvider.setAccommodationsList(accommodationsList1);
        assertEquals(accommodationProvider.getAccommodationList(),accommodationsList1.getAccommodationsList());
    }
}