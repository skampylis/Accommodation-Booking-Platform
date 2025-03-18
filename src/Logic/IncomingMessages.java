package Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents the Incoming Messages which can be received by a user (except the administrator) of the app. From
 * this class it wil be created the entity of the incoming messages in the app.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class IncomingMessages implements Serializable {

    /**
     * private ArrayList messages the list with all the incoming messages that a user can be received
     */
    private final ArrayList<String> messages;

    /**
     * Constructor of the class incoming messages, that creates an object of a list with all the incoming messages which
     * can be received by a user (except the administrator) of the app.
     */
    public IncomingMessages() {
        this.messages = new ArrayList<>();
    }

    /**
     * Method that gives access to a list with all the incoming messages that a user can receive.
     *
     * @return a specific message from the list with all the incoming messages that a user can be received
     */
    public ArrayList<String> getMessages() {
        return messages;
    }

    /**
     * Method that adds a specific message to the list with the messages.
     *
     * @param message the specific message that will be added to the message list
     * @return true if the specific message added to the list with the messages, else return false
     */
    public boolean addMessage(String message) {
        return messages.add(message);
    }

}
