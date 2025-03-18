package Logic;
import java.io.Serializable;

/**
 * This class represents the user Logic.HotelRoom, that extends the class Accommodation. From this class it will be created
 * the entity of the Logic.HotelRoom, which represents the type of Accommodation (HotelRoom).
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class HotelRoom extends Accommodation implements Serializable {

    /**
     * the floors a hotel room can have
     */
    private int floor;

    /**
     * Constructor of the class hotel room, that accepts seven parameters fields (codeName, pricePerNight, squareMeters,
     * seat, beds, floor and rooms) which inherits the six fields (codeName, pricePerNight, squareMeters, seat, beds and
     * rooms) and the method setType from the class Logic.Accommodation, initializing the private field floor of the class.
     *
     * @param codeName the code of the hotel room
     * @param pricePerNight the price of the hotel room every night
     * @param squareMeters the square meters of the hotel room
     * @param seat the seat of the hotel room
     * @param beds the beds of the hotel room
     * @param floor the floors a hotel room can have
     * @param rooms the rooms of the hotel room
     */
    public HotelRoom(int codeName, String pricePerNight, String squareMeters, String seat,int beds, int floor, int rooms) {
        super(codeName, pricePerNight, squareMeters, seat, beds, rooms);
        super.setType("Hotel Room");
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
