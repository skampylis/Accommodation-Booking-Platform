package Logic;

import java.io.Serializable;

/**
 * This class represents the Logic.Accommodation. From this class it will be created the entity of the Logic.Accommodation,
 * which represents the Accommodation.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class Accommodation implements Serializable {

    /**
     * the code of the accommodation
     */
    private int code;

    /**
     * the price of the accommodation every night
     */
    private String pricePerNight;

    /**
     * the reservation of the accommodation
     */
    private boolean booked;

    /**
     * the square meters of the accommodation
     */
    private String squareMeters;

    /**
     * the seat of the accommodation
     */
    private final String seat;

    /**
     * the type of the accommodation(apartment or hotel room)
     */
    private String type;

    /**
     * the beds of the accommodation
     */
    private int beds;

    /**
     * the rooms of the accommodation
     */
    private int rooms;

    /** Constructor of the class Logic.Accommodation, that accepts no parameters and initialize the fields of the class
     * in the right values.
     */
    public Accommodation() {
        this.code = 0;
        this.pricePerNight = null;
        this.booked = false;
        this.squareMeters = null;
        this.seat = null;
        this.beds = 0;
        this.rooms = 0;
    }

    /**
     * Constructor of the class Logic.Accommodation, that accepts six parameters of fields (codeName, pricePerNight,
     * squareMeters, seat, beds and rooms) and initialize the fields of the class in the right values.
     *
     * @param code the code of the accommodation
     * @param pricePerNight the price of the accommodation every night
     * @param squareMeters the square meters of the accommodation
     * @param seat the seat of the accommodation
     * @param beds the beds of the accommodation
     * @param rooms the rooms of the accommodation
     */
    public Accommodation(int code, String pricePerNight, String squareMeters, String seat, int beds, int rooms) {
        this.code = code;
        this.pricePerNight = pricePerNight;
        this.booked = false;
        this.squareMeters = squareMeters;
        this.seat = seat;
        this.beds = beds;
        this.rooms = rooms;
    }

    /**
     * Method that checks if the accommodation is reserved.
     *
     * @return true if the accommodation is reserved and false if it is not
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * Method that gives access to the private field pricePerNight.
     *
     * @return the private field pricePerNight
     */
    public String getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Method that gives access to the private field squareMeters.
     *
     * @return the private field squareMeters
     */
    public String getSquareMeters() {
        return squareMeters;
    }

    /**
     * Method that gives access to the private field codeName.
     *
     * @return the private field codeName
     */
    public int getCode() {
        return code;
    }

    /**
     * Method that gives access to the seat of the accommodation.
     *
     * @return the seat of accommodation
     */
    public String getSeat() {
        return seat;
    }

    /**
     * Method that gives access to the type of the accommodation.
     *
     * @return the type of the accommodation
     */
    public String getType() {
        return type;
    }

    /**
     * Method that gives access to the beds of the accommodation.
     *
     * @return the beds of the accommodation
     */
    public int getBeds() {
        return beds;
    }

    /**
     * Method that gives access to the rooms of the accommodation.
     *
     * @return the rooms of the accommodation
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * Method that changes the price of the private field booked.
     *
     * @param booked the reservation of the accommodation
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * Method that changes the price of the private field code.
     *
     * @param code the code of the accommodation
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Method that changes the price of the private field pricePerNight.
     *
     * @param pricePerNight the price Per Night of the accommodation
     */
    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    /**
     * Method that changes the price of the private field squareMeters.
     *
     * @param squareMeters the squareMeters of the accommodation
     */
    public void setSquareMeters(String squareMeters) {
        this.squareMeters = squareMeters;
    }

    /**
     * Method that changes the price of the private field type.
     *
     * @param type the type of the accommodation
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method that changes the price of the private field beds.
     *
     * @param beds the beds of the accommodation
     */
    public void setBeds(int beds) {
        this.beds = beds;
    }

    /**
     * Method that changes the price of the private field rooms.
     *
     * @param rooms the rooms of the accommodation
     */
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

}
