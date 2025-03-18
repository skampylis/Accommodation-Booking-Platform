package Logic;

/**
 * This class represents the Login of an Existed Logic.User and verifies the validness of his data. From this class it will be
 * created the entity of the valid connection and the program will run smoothly without confuse users data.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class UserLogin {

    /**
     * private UsersList users List the list with all the users that can connect to the app
     */
    private final UsersList usersList;

    /**
     * Constructor of the class UserLogin, which it accepts one parameter (usersList) and it initializes the object usersList.
     *
     * @param usersList the list with all the users that can connect to the app
     */
    public UserLogin(UsersList usersList) {
        this.usersList = usersList;
    }

    /**
     * Method that checks the validness of the data that are given from the user during the login in the app. It accepts
     * three parameters (name, pass and number) and with the list that contains the true data verifies the data that are
     * given.
     *
     * @param name the username that is given for the user in the app
     * @param pass the password that is given for the user in the app
     * @param number the number that represents a specific user for his login to the platform
     * @return true if the data are valid and false if the data are given wrong during the login
     */
    public User userLoginVerification(String name,String pass,int number) {
        for(User user : usersList.getUsers()) {
            if(user.getName().equals(name) && user.getPassword().equals(pass) && user.getNumber() == number) {
                return user;
            }
        }
        return null;
    }

}
