package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingClassTest {

    private CheckingClass checkingClass;
    @BeforeEach
    void setUp() {
        checkingClass = new CheckingClass();
    }

    @Test
    void checkDigitsOfCodeName1() {
        boolean result = checkingClass.checkDigitsOfCodeName(12452);
        assertFalse(result);
    }

    @Test
    void checkDigitsOfCodeName2() {
        boolean result = checkingClass.checkDigitsOfCodeName(1245);
        assertTrue(result);
    }

    @Test
    void checkPrice1() {
        boolean result = checkingClass.checkPrice("25.5");
        assertTrue(result);
    }

    @Test
    void checkPrice2() {
        boolean result = checkingClass.checkPrice("Hello");
        assertFalse(result);
    }

    @Test
    void checkSqMeters1() {
        boolean result = checkingClass.checkSqMeters("35");
        assertTrue(result);
    }

    @Test
    void checkSqMeters2() {
        boolean result = checkingClass.checkSqMeters("Hi");
        assertFalse(result);
    }

    @Test
    void checkCode1(){
        boolean result = checkingClass.checkCode("1234");
        assertTrue(result);
    }

    @Test
    void checkCode2(){
        boolean result = checkingClass.checkCode("fagag");
        assertFalse(result);
    }

    @Test
    void checkDay1(){
        boolean result = checkingClass.checkDay(15,3);
        assertTrue(result);
    }

    @Test
    void checkDay2(){
        boolean result = checkingClass.checkDay(-4,2);
        assertFalse(result);
    }

    @Test
    void checkMonth1(){
        boolean result = checkingClass.checkMonth(5);
        assertTrue(result);
    }

    @Test
    void checkMonth2(){
        boolean result = checkingClass.checkMonth(15);
        assertFalse(result);
    }
}