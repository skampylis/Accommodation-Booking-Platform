package Logic;

/**
 * This class represents the Registration of a new Logic.User and verifies the validness of his data. From this class it will be
 * created the entity of the sign-up of a user and the program will run smoothly without confuse users data.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class UserRegistration {

    /**
     * the list with all the users (and the new users)
     */
    private final UsersList usersRegistry;

    /**
     * Constructor of the UserRegistration that initiate the new users
     *
     * @param users the list of the users of the platform
     */
    public UserRegistration(UsersList users) {
        this.usersRegistry = users;
    }

    /**
     * Method that adds a new AccommodationProvider in the list of users if the criteria are satisfied.
     *
     * @param name the name of the new provider
     * @param password the password of the new provider
     * @param address the email address of the new provider
     * @param seat the seat of the new provider
     * @return true if the criteria are satisfied, else return false
     */
    public boolean userCreatesAccommodationProvider(String name, String password, String address,String seat) {
        if(usersRegistry.checkForSameName(name) &&  !name.equals("") && !password.equals("")  && address.contains("@gmail.com")) {
            AccommodationProvider newAccommodationProvider = new AccommodationProvider(name, password, address, seat);
            return usersRegistry.addUser(newAccommodationProvider);
        }
        return false;
    }

    /**
     * Method that adds a new Client in the list of users if the criteria are satisfied.
     *
     * @param name the name of the new client
     * @param password the password of the new client
     * @param address the email address of the new client
     * @return true if the user is added to the list and false if he does not
     */
    public boolean userCreatesClient(String name, String password, String address) {
        if(usersRegistry.checkForSameName(name) && !name.equals("") && !password.equals("")  && address.contains("@gmail.com")) {
            Client newClient = new Client(name, password, address);
            return usersRegistry.addUser(newClient);
        }
        return false;
    }

}
