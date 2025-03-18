package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginTest {

    private UserLogin userLogin;
    private Client a1;

    @BeforeEach
    void setUp() {
        UsersList usersList = new UsersList();
        a1 = new Client("Dimitris","games345","dim@gmail.com");
        Client a2 = new Client("John", "party54", "john@gmail.com");
        AccommodationProvider b1 = new AccommodationProvider("George", "secret", "georg@gmail.com", "Thessaloniki");
        usersList.addUser(a1);
        usersList.addUser(a2);
        usersList.addUser(b1);
        userLogin = new UserLogin(usersList);
    }

    @Test
    void userLoginVerification1() {
        User result = userLogin.userLoginVerification("Dimitris","games345",2);
        User expected = a1;
        assertEquals(expected,result);
    }

    @Test
    void userLoginVerification2() {
        User result = userLogin.userLoginVerification("John","games345",2);
        assertNull(result);
    }

    @Test
    void userLoginVerification3() {
        User result = userLogin.userLoginVerification("Dimitris","games",2);
        assertNull(result);
    }
}