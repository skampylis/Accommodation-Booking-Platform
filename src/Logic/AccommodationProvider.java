package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the user Logic.Accommodation Provider, that inherits from the class Logic.User. From this class
 * it will be created the entity of the Logic.Accommodation Provider, which represents the Accommodation Provider.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class AccommodationProvider extends User implements Serializable {

    /**
     * the seat of a specific accommodation
     */
    private final String seat;

    /**
     * the accommodation list with all the accommodations of the specific accommodation provider
     */
    private AccommodationsList accommodationsList;

    /**
     * Constructor of the class accommodation provider, that accepts three parameters fields (name, password, address and
     * seat) which inherits the three fields (name, password and address) from the class Logic.User initializing the private
     * field seat of the class in the right value. Also, it creates a new object that is the tab with the basic data of
     * the accommodation provider (name, address and seat).
     *
     * @param name the username of the accommodation provider in the app
     * @param password the password of the accommodation provider in the app
     * @param address the email of the accommodation provider
     * @param seat the seat that the accommodation provider has the accommodations
     */
    public AccommodationProvider(String name,String password,String address,String seat) {
        super(name,password,address);
        super.setNumber(1);
        this.seat = seat;
        accommodationsList = new AccommodationsList();
    }

    /**
     * Method that gives access to the seat of the accommodation provider.
     *
     * @return the seat of the accommodation provider
     */
    public String getSeat() {
        return this.seat;
    }

    /**
     * Method that gives access to the accommodations list of the accommodations of the accommodation provider
     *
     * @return the list of the accommodations of the accommodation provider
     */
    public ArrayList<Accommodation> getAccommodationList() {
        return accommodationsList.getAccommodationsList();
    }

    /**
     * Method that changes the accommodations list of the accommodations of the accommodation provider
     *
     * @param accommodationsList the accommodations list of the accommodations of the accommodation provider
     */
    public void setAccommodationsList(AccommodationsList accommodationsList) {
        this.accommodationsList = accommodationsList;
    }

    /**
     * Method that adds new accommodation in the list of the accommodation provider.
     *
     * @param accommodation the accommodation to be added
     * @return true if the accommodation added to the list, else return false
     */
    public boolean addNewAccommodation(Accommodation accommodation) {
        return accommodationsList.addAccommodation(accommodation);
    }

    /**
     * Method that removes accommodation from the list of the accommodations of the accommodation provider.
     *
     * @param codeName the codename of the accommodation to be removed
     * @param allAccommodations all the accommodations of the accommodation provider in the platform
     */
    public void removeAccommodation(int codeName, AccommodationsList allAccommodations) {
        Iterator<Accommodation> it1 = this.getAccommodationList().iterator();
        Iterator<Accommodation> it2 = allAccommodations.getAccommodationsList().iterator();
        while (it1.hasNext()) {
            Accommodation accommodation = it1.next();
            if (accommodation.getCode() == codeName) {
                it1.remove();
            }
        }
        while (it2.hasNext()) {
            Accommodation accommodation = it2.next();
            if (accommodation.getCode() == codeName) {
                it2.remove();
            }
        }
    }

}
