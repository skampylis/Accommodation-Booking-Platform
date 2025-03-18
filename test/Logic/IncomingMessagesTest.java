package Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IncomingMessagesTest {

    private IncomingMessages messages;
    String message1;
    String message2;
    String message3;

    @BeforeEach
    void setUp() {
        messages = new IncomingMessages();
        message1 = "Hello";
        message2 = "Hi";
        message3 = "Hallo";
        messages.addMessage(message1);
        messages.addMessage(message2);
        messages.addMessage(message3);
    }

    @Test
    void getMessages() {
        ArrayList<String> result = messages.getMessages();
        ArrayList<String> expected = new ArrayList<>();
        expected.add(message1);
        expected.add(message2);
        expected.add(message3);
        assertEquals(expected,result);
    }

    @Test
    void addMessage() {
        String newMessage = "Good Morning";
        boolean result = messages.addMessage(newMessage);
        assertTrue(result);
    }
}