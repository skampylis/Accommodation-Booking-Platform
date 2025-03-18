package Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents the Logic.User of the App (any role of the platform). From this class it will be created the entity of
 * the Logic.User, which it will be inherited to the roles of the app.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class User implements Serializable {

    /**
     * protected String name the username of the user in the app
     */
    protected String name;

    /**
     * protected String address the email of the user
     */
    protected String address;

    /**
     * protected String password the password of the user in the app
     */
    protected String password;

    /**
     * protected Logic.IncomingMessages messages,the incoming messages that a user can receive in the app
     */
    protected IncomingMessages messages;

    /**
     * protected int number the number that represents a specific user for his login to the platform
     */
    protected int number;

    /**
     * Empty Constructor of the class Logic.User, that initializes the protected fields of the class with null (name, address and password)
     * and it creates a new object, which represents the incoming messages that a user can be received.
     */
    public User() {
        this.name = null;
        this.address = null;
        this.password = null;
        this.messages = new IncomingMessages();
    }

    /**
     * Constructor of the class Logic.User, that accepts three parameters (name, password and address) and initializes them. Also,
     * it creates a new object, which represents the incoming messages that a user can be received.
     *
     * @param name the username of the user in the app
     * @param password the password of the user in the app
     * @param address the email of the user
     */
    public User(String name,String password,String address) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.messages = new IncomingMessages();
    }

    /**
     * Method that gives access to the number that represents a specific user for his login to the platform.
     *
     * @return the number that represents a specific user for his login to the platform
     */
    public int getNumber() {
        return number;
    }

    /**
     * Method that gives access to the username that represents a user in the app.
     *
     * @return the username that represents a user in the app
     */
    public String getName() {
        return name;
    }

    /**
     * Method that gives access to the password of a user in the app.
     *
     * @return the password of a user in the app
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method that gives access to the email of a user in the app.
     *
     * @return the email of a user in the app
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method that gives access to the incoming messages that a user can receive in the app.
     *
     * @return the incoming messages that a user can receive in the app
     */
    public ArrayList<String> getMessages() {
        return messages.getMessages();
    }

    /**
     * Method that changes the number that represents a specific user for his login to the platform.
     *
     * @param number the number that represents a specific user for his login to the platform.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Method that gives access to the username that represents a user in the app.
     *
     * @param name the username that represents a user in the app
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that changes the password of a user in the app.
     *
     * @param password the password of a user in the app
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method that changes the email of a user in the app.
     *
     * @param address the email of a user in the app
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method that adds a message to the list of messages.
     *
     * @param message the message to add
     * @return true if the message added correctly, else return false
     */
    public boolean addMessage(String message) {
        return messages.addMessage(message);
    }

}
