package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelRoomTest {

    private HotelRoom hotelRoom;
    @BeforeEach
    void setUp() {
        hotelRoom = new HotelRoom(2341,"25","30","Thessaloniki",3,3,3);
    }

    @Test
    void getFloor() {
        int result = hotelRoom.getFloor();
        assertEquals(3,result);
    }

    @Test
    void setFloor() {
        hotelRoom.setFloor(4);
        int result = hotelRoom.getFloor();
        assertEquals(4,result);
    }
}