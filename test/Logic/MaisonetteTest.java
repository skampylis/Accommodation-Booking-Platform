package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaisonetteTest {

    private Maisonette maisonette;
    @BeforeEach
    void setUp() {
        maisonette = new Maisonette(2423,"200","120","Thessaloniki",6,true,8,2);
    }

    @Test
    void getPool() {
        boolean result = maisonette.getPool();
        assertTrue(result);
    }

    @Test
    void getNumbersOfFloors() {
        int result = maisonette.getNumbersOfFloors();
        assertEquals(2,result);
    }

    @Test
    void setPool() {
        maisonette.setPool(false);
        boolean result = maisonette.getPool();
        assertFalse(result);
    }

    @Test
    void setNumbersOfFloors() {
        maisonette.setNumbersOfFloors(3);
        int result = maisonette.getNumbersOfFloors();
        assertEquals(3,result);
    }
}