package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UsersListTest {

    private UsersList usersList;
    private Client a1;
    private Client a2;
    private AccommodationProvider b1;
    @BeforeEach
    void setUp() {
        usersList = new UsersList();
        a1 = new Client("Dimitris","games345","dim@gmail.com");
        a2 = new Client("John","party54","john@gmail.com");
        b1 = new AccommodationProvider("George","secret","georg@gmail.com","Thessaloniki");
        usersList.addUser(a1);
        usersList.addUser(a2);
        usersList.addUser(b1);
    }

    @Test
    void getUsers() {
        ArrayList<User> result = usersList.getUsers();
        ArrayList<User> expected = new ArrayList<>();
        expected.add(a1);
        expected.add(a2);
        expected.add(b1);
        assertEquals(expected,result);
    }

    @Test
    void addUser() {
        User user = new User("Miles","secret123","@gmail.com");
        boolean result = usersList.addUser(user);
        assertTrue(result);
    }

    @Test
    void checkForSameName1() {
        boolean result = usersList.checkForSameName("Dimitris");
        assertFalse(result);
    }

    @Test
    void checkForSameName2() {
        boolean result = usersList.checkForSameName("Christina");
        assertTrue(result);
    }
}