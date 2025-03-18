package GUI;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class AdministratorGUI {

    private void printAccommodationsBookings(ArrayList<AccommodationBooking> list) {

        JFrame printAccommodation = new JFrame("Administrator's Menu");
        printAccommodation.setSize(1000, 500);
        printAccommodation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        printAccommodation.setLayout(new GridLayout(0,1,20,20));
        int counter = 1;
        for(AccommodationBooking acc : list) {
            JLabel label = new JLabel(counter + ": " + "code:" + acc.getBookedAccommodation().getCode() + " " + " ,square meters:" + acc.getBookedAccommodation().getSquareMeters() + " " +
                    " ,price/night:" + acc.getBookedAccommodation().getPricePerNight() + " " + ",Number of beds:" + " " + acc.getBookedAccommodation().getBeds() + " " + ",Number of rooms:" + " " +
                    acc.getBookedAccommodation().getRooms() + " " + " ,Type:" + acc.getBookedAccommodation().getType() + " " + " ,Seat:" + acc.getBookedAccommodation().getSeat());
            JLabel label1 = new JLabel("From: " + acc.getDateFrom().get(Calendar.DATE) + "/" + acc.getDateFrom().get(Calendar.MONTH) + "/" + acc.getDateFrom().get(Calendar.YEAR));
            JLabel label2 = new JLabel("Until: " + acc.getDateUntil().get(Calendar.DATE) + "/" + acc.getDateUntil().get(Calendar.MONTH) + "/" + acc.getDateUntil().get(Calendar.YEAR));
            printAccommodation.add(label);
            printAccommodation.add(label1);
            printAccommodation.add(label2);
            printAccommodation.pack();
            printAccommodation.setLocationRelativeTo(null);
            printAccommodation.setVisible(true);
            counter++;
        }
    }

    private void printUsers(ArrayList<User> list) {
        JFrame printUsers = new JFrame("Administrator's Menu");
        printUsers.setSize(1000, 500);
        printUsers.setLocationRelativeTo(null);
        printUsers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        printUsers.setLayout(new GridLayout(0,1,20,20));
        int counter = 1;
        for(User user : list){
            JLabel label = new JLabel(counter + ": " + "UserName: " + user.getName());
            printUsers.add(label);
            printUsers.pack();
            printUsers.setLocationRelativeTo(null);
            printUsers.setVisible(true);
            counter++;
            }
        }

    public AdministratorGUI(Administrator administrator, UsersList allUsers, AccommodationsList allAccommodations ,BookingsList allBookings) {
        JButton button1 = new JButton("Show Booked Accommodations");
        JButton button2 = new JButton("Show Users");
        JButton button3 = new JButton("Send message to user");
        JButton button4 = new JButton("Sign Out");
        JLabel label3 =new JLabel();
        JFrame administratorMenu = new JFrame("Administrator's Menu");
        administratorMenu.setSize(1000, 500);
        administratorMenu.setLocationRelativeTo(null);
        administratorMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        administratorMenu.setLayout(new GridLayout(0,1,10,20));

        button1.addActionListener(e -> printAccommodationsBookings(allBookings.getBookings()));

        button2.addActionListener(e -> printUsers(allUsers.getUsers()));

        button3.addActionListener(e -> {
            JLabel label1 = new JLabel("Send message to(UserName): ");
            JTextField textField1 = new JTextField(20);
            JLabel label2 = new JLabel("Message: ");
            JTextField textField2 = new JTextField(30);
            JButton send = new JButton("Send");

            JFrame sendMessage = new JFrame("Administrator's Menu");
            sendMessage.setSize(500, 150);
            sendMessage.setLocationRelativeTo(null);
            sendMessage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            sendMessage.setLayout(new GridLayout(0,2,20,20));

            send.addActionListener(e1 -> {
                User user = administrator.findUser(textField1.getText(),allUsers);
                if(user != null){
                    administrator.sendMessage(textField2.getText(),user);
                    label3.setText("Message send!");
                    sendMessage.dispose();
                    new WriteObjectsInFiles(allUsers,allAccommodations,allBookings);
                }
                else{
                    label3.setText("The user you try to send does not exist.Please try again!");
                }
            });

            sendMessage.add(label1);
            sendMessage.add(textField1);
            sendMessage.add(label2);
            sendMessage.add(textField2);
            sendMessage.add(send);
            sendMessage.pack();
            sendMessage.setLocationRelativeTo(null);
            sendMessage.setVisible(true);
        });

        button4.addActionListener(e -> administratorMenu.dispose());

        administratorMenu.add(button1);
        administratorMenu.add(button2);
        administratorMenu.add(button3);
        administratorMenu.add(button4);
        administratorMenu.add(label3);
        administratorMenu.setLocationRelativeTo(null);
        administratorMenu.setVisible(true);
    }

}
