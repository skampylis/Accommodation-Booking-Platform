package Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a list with All the Users of the platform. From this class a list will be created that contains
 * all the users that can log in to the app.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class UsersList implements Serializable {

    /**
     * the list with all the users that should be login to the app
     */
    private final ArrayList<User> users;

    /**
     * Constructor of the list UsersList.
     */
    public UsersList() {
        this.users = new ArrayList<>();
    }

    /**
     * Method that gives access to the list with all the users that should be login to the app.
     *
     * @return a specific user from the list with all the users that should be login to the app
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Method that checks if a user is added to the list
     *
     * @param user the user that will be added to the list
     * @return true if the user added to the list and false if it is not
     */
    public boolean addUser(User user) {
        return users.add(user);
    }

    /**
     * Method that checks if a user is already with the same name in the list
     *
     * @param name the name of the user
     * @return true if the name is already int the list of users and false if it is not
     */
    public boolean checkForSameName(String name) {
        for (User user :users) {
            if (user.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

}
