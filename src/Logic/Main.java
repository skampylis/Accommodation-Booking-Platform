package Logic;

import GUI.StartMenuGUI;

/**
 * The class Logic.Main that represents the Booking Logic.Accommodation Platform (WARNING: This is the final edition of
 * the Booking Accommodation Platform, so it supports all the basic functions that are expected to be used). Initially,
 * it creates three lists of objects (from the constructors of the corresponding classes) which contains: the UsersList,
 * the BookingsList and the AccommodationsList. Later, it creates five objects of users that represents: two users with
 * the role of the Client, two users with roles of the Accommodation Provider and a user with the role of the Administrator.
 * After, it creates six objects of Accommodations (two of every type) from which: They are added to the list with all
 * the Accommodations of the platform. Actually, all five users are added to the list that contains all the users. Eventually,
 * a new object is being created from which the app will start and the Starting menu will run.
 *
 * @author Charalampos Stefanidis - AEM:3246
 * @author Sotirios Loukas Kampylis - AEM:3805
 */
public class Main {

    /**
     * The Logic.Main function that represents the Platform.
     *
     * @param args the args given to the program
     */
    public static void main(String[] args) {
        UsersList users = new UsersList();
        BookingsList bookings = new BookingsList();
        AccommodationsList accommodations = new AccommodationsList();

        Client a1 = new Client("Dimitris","games345","dim@gmail.com");
        Client a2 = new Client("John","party54","john@gmail.com");
        AccommodationProvider b1 = new AccommodationProvider("George","secret","georg@gmail.com","Thessaloniki");
        AccommodationProvider b2 = new AccommodationProvider("Christina","chris123","chris@gmail.com","Athens");
        Administrator c = new Administrator("Haris","mrAdminHimself","haris@gmail.com");

        Apartment acc1 = new Apartment(1222,"50","80","Thessaloniki",4,5,5);
        HotelRoom acc2 = new HotelRoom(2341,"25","30","Thessaloniki",3,3,3);
        Maisonette acc3 = new Maisonette(2423,"200","120","Thessaloniki",6,true,8,2);

        HotelRoom acc4 = new HotelRoom(6587,"10","20","Athens",2,3,2);
        Maisonette acc5 = new Maisonette(4566,"250","120","Athens",5,true,8,2);
        Apartment acc6 = new Apartment(3245,"20","25","Athens",2,2,3);

        b1.addNewAccommodation(acc1);
        b1.addNewAccommodation(acc2);
        b1.addNewAccommodation(acc3);
        b2.addNewAccommodation(acc4);
        b2.addNewAccommodation(acc5);
        b2.addNewAccommodation(acc6);

        accommodations.getAccommodationsList().add(acc1);
        accommodations.getAccommodationsList().add(acc2);
        accommodations.getAccommodationsList().add(acc3);
        accommodations.getAccommodationsList().add(acc4);
        accommodations.getAccommodationsList().add(acc5);
        accommodations.getAccommodationsList().add(acc6);

        users.getUsers().add(a1);
        users.getUsers().add(a2);
        users.getUsers().add(b1);
        users.getUsers().add(b2);
        users.getUsers().add(c);

        new StartMenuGUI(users, bookings, accommodations);

    }

}
