package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccommodationTest {

    private Accommodation accommodation;
    private Accommodation acc;
    @BeforeEach
    void setUp() {
        acc = new Accommodation();
        accommodation = new Accommodation(1234,"15","30","Athens",3,3);
    }

    @Test
    void isBooked() {
        boolean result = accommodation.isBooked();
        assertFalse(result);
    }

    @Test
    void getPricePerNight1() {
        String result = accommodation.getPricePerNight();
        assertEquals("15",result);
    }

    @Test
    void getPricePerNight2() {
        String result = acc.getPricePerNight();
        assertNull(result);
    }

    @Test
    void getSquareMeters() {
        String result = accommodation.getSquareMeters();
        assertEquals("30",result);
    }

    @Test
    void getCode() {
        int result = accommodation.getCode();
        assertEquals(1234,result);
    }

    @Test
    void getSeat() {
        String result = accommodation.getSeat();
        assertEquals("Athens",result);
    }

    @Test
    void getType() {
        accommodation.setType("Apartment");
        String result = accommodation.getType();
        assertEquals("Apartment",result);
    }

    @Test
    void getBeds() {
        int result = accommodation.getBeds();
        assertEquals(3,result);
    }

    @Test
    void getRooms() {
        int result = accommodation.getRooms();
        assertEquals(3,result);
    }

    @Test
    void setBooked() {
        accommodation.setBooked(true);
        boolean result = accommodation.isBooked();
        assertTrue(result);
    }

    @Test
    void setCode() {
        accommodation.setCode(4321);
        int result = accommodation.getCode();
        assertEquals(4321,result);
    }

    @Test
    void setPricePerNight() {
        accommodation.setPricePerNight("20");
        String result = accommodation.getPricePerNight();
        assertEquals("20",result);
    }

    @Test
    void setSquareMeters() {
        accommodation.setSquareMeters("35");
        String result = accommodation.getSquareMeters();
        assertEquals("35",result);
    }

    @Test
    void setType() {
        accommodation.setType("Hotel Room");
        String result = accommodation.getType();
        assertEquals("Hotel Room",result);
    }

    @Test
    void setBeds() {
        accommodation.setBeds(4);
        int result = accommodation.getBeds();
        assertEquals(4,result);
    }

    @Test
    void setRooms() {
        accommodation.setRooms(4);
        int result = accommodation.getRooms();
        assertEquals(4,result);
    }
}