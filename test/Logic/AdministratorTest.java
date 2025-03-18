package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministratorTest {

    private Administrator administrator;
    private UsersList usersList;
    private AccommodationProvider accommodationProvider;
    private Client a1 ;
    private Client a2 ;
    @BeforeEach
    void setUp() {
        administrator = new Administrator("Haris","password","@gmail.com");
        accommodationProvider = new AccommodationProvider("George","secret","@yahoo.com","Athens");
        a1 =  new Client("Dimitris","games345","dim@gmail.com");
        a2 = new Client("John","party54","john@gmail.com");
        usersList = new UsersList();
        usersList.addUser(accommodationProvider);
        usersList.addUser(administrator);
        usersList.addUser(a1);
        usersList.addUser(a2);
    }

    @Test
    void findUser1() {
        User newUser = administrator.findUser("John",usersList);
        assertEquals(a2,newUser);
    }

    @Test
    void findUser2() {
        User newUser = administrator.findUser("Dimitris",usersList);
        assertEquals(a1,newUser);
    }

    @Test
    void findUser3() {
        User newUser = administrator.findUser("George",usersList);
        assertEquals(accommodationProvider,newUser);
    }

    @Test
    void sendMessage() {
        boolean result = administrator.sendMessage("hello",accommodationProvider);
        assertTrue(result);
    }
}