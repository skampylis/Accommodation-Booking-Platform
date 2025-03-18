package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private  User user1;
    @BeforeEach
    void setUp() {
        user1 = new User();
        user = new User("tester","password","@gmail.com");
    }

    @Test
    void getNumber() {
        user.setNumber(1);
        assertEquals(1,user.getNumber());
    }


    @Test
    void getName1() {
        String result = user.getName();
        assertEquals("tester",result);
    }

    @Test
    void getName2() {
        String result = user1.getName();
        assertNull(result);
    }

    @Test
    void getPassword() {
        String result = user.getPassword();
        assertEquals("password",result);
    }

    @Test
    void getAddress() {
        String result = user.getAddress();
        assertEquals("@gmail.com",result);
    }

    @Test
    void getMessages() {
        user.addMessage("hello");
        user.addMessage("hi");
        ArrayList<String> result = user.getMessages();
        ArrayList<String> expected =new ArrayList<>();
        expected.add("hello");
        expected.add("hi");
        assertEquals(expected,result);
    }

    @Test
    void setNumber() {
        user.setNumber(1);
        assertEquals(1,user.getNumber());
    }

    @Test
    void setName() {
        user.setName("Haris");
        assertEquals("Haris",user.getName());
    }

    @Test
    void setPassword() {
        user.setPassword("secret");
        assertEquals("secret",user.getPassword());
    }

    @Test
    void setAddress() {
        user.setAddress("@yahoo.com");
        assertEquals("@yahoo.com",user.getAddress());
    }

    @Test
    void addMessage(){
        boolean result = user.addMessage("hello");
        assertTrue(result);
    }

}