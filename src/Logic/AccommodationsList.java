package Logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a List with All the Accommodations of the platform. From this class it will be created the entity
 * of the Logic.Accommodation List that are registered by the accommodation provider.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class AccommodationsList implements Serializable {

    /**
     * list with all the accommodations that are registered by the accommodations providers
     */
    private ArrayList<Accommodation> accommodationsList;

    /**
     * Constructor of the accommodation lists that are registered by the accommodation provider.
     */
    public AccommodationsList() {
        this.accommodationsList = new ArrayList<>();
    }

    /**
     * Method that gives access to all the accommodations that are registered by the accommodation provider.
     *
     * @return the list with all the accommodations that are registered by the accommodation provider
     */
    public ArrayList<Accommodation> getAccommodationsList() {
        return accommodationsList;
    }

    /**
     * Method that adds new accommodation in the list of the accommodations.
     *
     * @param accommodation the new accommodation, which will be added to the list of the accommodations
     * @return the updated list of the accommodations, which contains the new accommodation
     */
    public boolean addAccommodation(Accommodation accommodation) {
        return accommodationsList.add(accommodation);
    }

    /**
     * Method that changes the accommodations list of the accommodations.
     *
     * @param accommodationsList accommodations list of the accommodations, which it will be changed
     */
    public void setAccommodationsList(ArrayList<Accommodation> accommodationsList) {
        this.accommodationsList = accommodationsList;
    }

    /**
     * Method that finds the specific accommodation (by its code) in the accommodations list of the accommodations.
     *
     * @param code the code of the specific accommodation, which it will be searched in the list of the accommodations
     * @return if the code exists return the specific accommodation, else return null
     */
    public Accommodation findAccommodation(int code) {
        for (Accommodation acc : accommodationsList) {
            if (acc.getCode() == code) {
                return acc;
            }
        }
        return null;
    }

}
