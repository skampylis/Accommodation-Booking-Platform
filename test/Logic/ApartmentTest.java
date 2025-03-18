package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentTest {

    private Apartment apartment;
    @BeforeEach
    void setUp() {
        apartment = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
    }

    @Test
    void getFloor() {
        int result = apartment.getFloor();
        assertEquals(5,result);
    }

    @Test
    void setFloor() {
        apartment.setFloor(6);
        int result = apartment.getFloor();
        assertEquals(6,result);
    }
}