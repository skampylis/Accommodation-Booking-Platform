package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        UsersList usersList = new UsersList();
        Client a1 = new Client("John", "party54", "john@gmail.com");
        AccommodationProvider b1 = new AccommodationProvider("Christina", "chris123", "chris@gmail.com", "Athens");
        usersList.addUser(a1);
        usersList.addUser(b1);
        userRegistration = new UserRegistration(usersList);
    }

    @Test
    void userCreatesAccommodationProvider1() {
        boolean result = userRegistration.userCreatesAccommodationProvider("George","secret","georg@gmail.com","Thessaloniki");
        assertTrue(result);
    }

    @Test
    void userCreatesAccommodationProvider2() {
        boolean result = userRegistration.userCreatesAccommodationProvider("Christina","chris123","chris@gmail.com","Athens");
        assertFalse(result);
    }

    @Test
    void userCreatesClient1() {
        boolean result = userRegistration.userCreatesClient("Haris","party54","john@gmail.com");
        assertTrue(result);
    }

    @Test
    void userCreatesClient2() {
        boolean result = userRegistration.userCreatesClient("John","party54","john@gmail.com");
        assertFalse(result);
    }
}