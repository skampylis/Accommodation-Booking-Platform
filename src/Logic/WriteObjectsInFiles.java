package Logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class that opens binary files and writes the lists with the users, accommodations and the bookings of the platform. It
 * also uses exceptions so the files can be caught if they have never been existed before.
 */
public class WriteObjectsInFiles {

    /**
     * Constructor that finds the binary files and writes the lists with the users, accommodations and the bookings of the
     * platform. If the files are created for the first time it catches the exceptions so the next time the lists can have the
     * data from the files
     *
     * @param allUsers the list with all the users that should be login to the app
     * @param allAccommodations the list with all the accommodations that are registered by the accommodations providers
     * @param allBookings the list with all the reserved accommodations that have been reserved from the clients in the platform
     */
    public WriteObjectsInFiles(UsersList allUsers, AccommodationsList allAccommodations, BookingsList allBookings) {
        try(ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("usersList.dat"))) {
            out1.writeObject(allUsers);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("accommodationsList.dat"))) {
            out2.writeObject(allAccommodations);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("bookingsList.dat"))) {
            out3.writeObject(allBookings);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
