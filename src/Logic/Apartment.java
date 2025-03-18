package Logic;

import java.io.Serializable;

/**
 * This class represents the user Logic.Apartment, that extends the class Accommodation. From this class it will be created
 * the entity of the Logic.Apartment, which represents the type of Accommodation (Apartment).
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class Apartment extends Accommodation implements Serializable {

    /**
     * the floors an apartment can have
     */
    private int floor;

    /**
     * Constructor of the class apartment, that accepts seven parameters fields (codeName, pricePerNight, squareMeters,
     * seat, beds, floor and rooms) which inherits the six fields (codeName, pricePerNight, squareMeters, seat, beds and
     * rooms) and the method setType from the class Logic.Accommodation, initializing the private field floor of the class
     * in the right type (Apartment).
     *
     * @param codeName the code of the apartment
     * @param pricePerNight the price of the apartment every night
     * @param squareMeters the square meters of the apartment
     * @param seat the seat of the apartment
     * @param beds the beds of the apartment
     * @param floor the floors an apartment can have
     * @param rooms the rooms of the apartment
     */
    public Apartment(int codeName, String pricePerNight, String squareMeters, String seat,int beds,int floor, int rooms) {
        super(codeName, pricePerNight, squareMeters, seat , beds, rooms);
        super.setType("Apartment");
        this.floor = floor;
    }

    /**
     * Method that gives access to the private field floor.
     *
     * @return the private field floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Method that changes the price of the private field floor.
     *
     * @param floor the floors an apartment can have
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

}
