package Logic;

import java.io.Serializable;

/**
 * This class represents the user Logic.Maisonette, that extends the class Accommodation. From this class it will be created
 * the entity of the Logic.Maisonette, which represents the type of Accommodation (Maisonette).
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class Maisonette extends Accommodation implements Serializable {

    /**
     * the private field pool represents if the maisonette has pool or not
     */
    private boolean pool;

    /**
     * the number of floors a maisonette can have
     */
    private int numbersOfFloors;

    /**
     * Constructor of the class maisonette, that accepts eight parameters fields (codeName, pricePerNight, squareMeters,
     * seat, beds, pool floor and rooms) which inherits the six fields (codeName, pricePerNight, squareMeters, seat, beds
     * and rooms) and the method setType from the class Logic.Accommodation, initializing the private fields (pool and
     * numbersOfFloors) of the class.
     *
     * @param codeName the codeName of the maisonette
     * @param pricePerNight the price of the maisonette every night
     * @param squareMeters the square meters of the maisonette
     * @param seat the seat of the maisonette
     * @param beds the beds of the maisonette
     * @param pool the private field pool represents if the maisonette has pool or not
     * @param rooms the rooms of the maisonette
     * @param numbersOfFloors the number of floors a maisonette can have
     */
    public Maisonette(int codeName, String pricePerNight, String squareMeters, String seat,int beds, boolean pool, int rooms, int numbersOfFloors) {
        super(codeName,pricePerNight,squareMeters,seat,beds,rooms);
        super.setType("Maisonette");
        this.pool = pool;
        this.numbersOfFloors = numbersOfFloors;
    }

    /**
     * Method that gives access to the private field pool.
     *
     * @return true if the maisonette has pool and false if it has not
     */
    public boolean getPool() {
        return pool;
    }

    /**
     * Method that gives access to the private field numbersOfFloors.
     *
     * @return the private field numbersOfFloors
     */
    public int getNumbersOfFloors() {
        return numbersOfFloors;
    }

    /**
     * Method that changes the price of the private field pool.
     *
     * @param pool the private field pool represents if the maisonette has pool or not
     */
    public void setPool(boolean pool) {
        this.pool = pool;
    }

    /**
     * Method that changes the price of the private field numbersOfFloors.
     *
     * @param numbersOfFloors the numbers of floors a maisonette can have
     */
    public void setNumbersOfFloors(int numbersOfFloors) {
        this.numbersOfFloors = numbersOfFloors;
    }

}
