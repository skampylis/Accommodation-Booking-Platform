package Logic;

import java.io.Serializable;

/**
 * This class represents the user Logic.Administrator, that inherits from the class Logic.User. From this class it will
 * be created the entity of the Logic.Administrator, which represents the Administrator.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class Administrator extends User implements Serializable {

    /**
     * Constructor of the class Logic.Administrator that accepts three parameters (name, password and address).
     *
     * @param name the username of the administrator in the app
     * @param password the password of the administrator in the app
     * @param address the email of the administrator
     */
    public Administrator(String name, String password, String address) {
        super(name,password,address);
        super.setNumber(3);
    }

    /**
     * Method that finds the specific user (by its name) in the users list.
     *
     * @param name the name of the specific user
     * @param allUsers the list with all the users of the app
     * @return if the name exists return the specific user, else return null
     */
    public User findUser(String name, UsersList allUsers) {
        for (User user : allUsers.getUsers()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Method that sends a message to the specified user.
     *
     * @param message the message the administrator wants to send
     * @param user the user that receives the message
     * @return true if all worked correctly, else return false
     */
    public boolean sendMessage(String message,User user) {
            return user.addMessage(message);
    }

}
